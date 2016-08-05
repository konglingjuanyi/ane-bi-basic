var args = require('yargs').argv;
var browserSync = require('browser-sync');
var config = require('./gulp.config')();
var del = require('del');
var glob = require('glob');
var mergeStream = require('merge-stream');
// var assetpaths = require('./gulp-assetpaths');
var assetpaths = require('gulp-assetpaths');
var gulp = require('gulp');
var path = require('path');
var fs = require('fs');
var ejs = require('ejs');
var htmlmin = require('gulp-minify-html');
var _ = require('lodash');
var $ = require('gulp-load-plugins')({
    lazy: true
});

var through = require('through2');
var colors = $.util.colors;
var envenv = $.util.env;
var port = process.env.PORT || config.defaultPort;

/**
 * yargs variables can be passed in to alter the behavior, when present.
 * Example: gulp serve-dev
 * 
 * --verbose : Various tasks will produce more output to the console. --nosync :
 * Don't launch the browser with browser-sync when serving code. --debug :
 * Launch debugger with node-inspector. --debug-brk: Launch debugger and break
 * on 1st line with node-inspector. --startServers: Will start servers for
 * midway tests on the test task.
 */

/**
 * List the available gulp tasks
 */
gulp.task('help', $.taskListing);
gulp.task('default', ['help']);


/**
 * Compile less to css
 * 
 * @return {Stream}
 */
gulp.task('styles', ['clean-styles'], function() {
    log('Compiling Less --> CSS');

    var merged = mergeStream();

    var lessTask = gulp
        .src(config.less) // styles/styles.less
        .pipe($.plumber()) // exit gracefully if something fails after this
        .pipe($.less())
        // .on('error', errorLogger) // more verbose and dupe output. requires emit.
        .pipe($.autoprefixer({
            browsers: ['last 2 version', '> 5%']
        }))
        .pipe(gulp.dest(config.temp));

    var cssTask = gulp
        .src(config.css) // styles/styles.less
        .pipe(gulp.dest(config.temp));

    merged.add(lessTask);
    merged.add(cssTask);
    return merged;
});


/**
 * Copy fonts
 * 
 * @return {Stream}
 */
gulp.task('fonts', ['clean-fonts'], function() {
    log('Copying fonts');

    return gulp
        .src(config.fonts) // bower.directory + 'font-awesome/fonts/**/*.*',
        .pipe(gulp.dest(config.build + 'fonts'));
});

/**
 * Compress images
 * 
 * @return {Stream}
 */
gulp.task('images', ['clean-images'], function() {
    log('Compressing and copying images');

    return gulp
        .src(config.images)
        // .pipe($.imagemin({
        // optimizationLevel: 4
        // }))
        .pipe(gulp.dest(config.build + 'images'));
});


/**
 * Compress images
 * 
 * @return {Stream}
 */
gulp.task('sound', ['clean-sound'], function() {
    log('Compressing and copying sound');

    return gulp
        .src(config.sound)
        // .pipe($.imagemin({
        // optimizationLevel: 4
        // }))
        .pipe(gulp.dest(config.build + 'sound'));
});


/**
 * watcher the less file, if the less file modified it will run the style task.
 */
gulp.task('less-watcher', function() {
    gulp.watch([config.less], ['styles']);
});


/**
 * Create $templateCache from the html templates
 * 
 * @return {Stream}
 */
gulp.task('templatecache', ['clean-code'], function() {
    var templateCacheTasks = [];

    var merged = mergeStream();

    config.allApps().forEach(function(module) {
        var stream = buildModuleTemplateCache(module);

        if (stream) {
            merged.add(stream);
        }
    });

    return merged;
});


/**
 * Wire-up the bower js dependencies in to the html file with inject plugin 1.
 * use wiredep to inject all brower dependency to index.html 2. inject all
 * application js files to index.html
 * 
 * @return {Stream}
 */
gulp.task('wiredep', function() {
    log('Wiring the bower dependencies into the all html');

    var merged = mergeStream();

    config.allApps().forEach(function(module) {
        merged.add(buildAppWireDep(module));
    });

    return merged;
});

gulp.task('clean-wiredep', function() {
    log('Wiring the bower dependencies into the all html');

    var merged = mergeStream();

    config.allApps().forEach(function(module) {
        merged.add(cleanAppWireDep(module));
    });

    return merged;
});



/**
 * Wire up css into the html, which will invoke threw task: 1. wiredep: inject
 * brew dependency(js/css), inject all app js files 2. styles: build the less
 * file to css 3. templatecache: package all template html files to an angularjs
 * template js file. 4. inject file css and tempalteCache js files generated in
 * step 2&3 to index.html
 */
gulp.task('inject', ['wiredep', 'styles', 'templatecache'], function() {
    log('Wire up css into the html, after files are ready');

    var merged = mergeStream();

    config.allApps().forEach(function(module) {
        merged.add(buildInjectTasks(module));
    });

    return merged;
});


gulp.task('clean-inject', ['clean-wiredep'], function() {
    log('Wire up css into the html, after files are ready');

    var merged = mergeStream();

    config.allApps().forEach(function(module) {
        merged.add(cleanInjectTasks(module));
    });

    return merged;
});




function isExistedFile(file) {

    return fs.existsSync(file);
}


gulp.task('create-module', function() {

    var moduleName = args.name;
    log(' Starting Create module [' + moduleName + ']');
    var merged = mergeStream();
    var createModuleTask = createModule(moduleName, false);
    if (createModuleTask) {
        merged.add(createModuleTask);
    }
    return merged;
});

function createModule(moduleName, forced) {
    var module = config.clientApp + moduleName;
    if (!forced && isExistedFile(module)) {
        return false;
    } else {
        var files = ['controller' , 'module' , 'route' , 'service'];
        var angularModuleName = moduleName.substring(0 , 1).toUpperCase() + moduleName.substring(1);
        var options = {
            controller : angularModuleName + "Controller" ,
            service :  angularModuleName + "Service" ,
            module : "app." + moduleName ,
            name : moduleName 
        };

        var merged = mergeStream();
        files.forEach(function(name){
            var template = config.scaffoldDir + 'module.'+ name+'.js';
            log(" Create module ["+ moduleName +"] angularjs " + name);
            merged.add( gulp.src(template)
                .pipe($.rename( moduleName + '.'+name+'.js'))
                .pipe($.ejs( options  ) )
                .pipe(gulp.dest(module)));
        });
        return merged;
    }
}




/**
 * Optimize all files, move to a build folder, and inject them into the new
 * index.html
 * 
 * @return {Stream}
 */
gulp.task('create-apps', function() {
    log('Optimizing the js, css, and html');

    // var forcedApp = args.force ? args.force : undefined;
    // log(forcedApp);

    // //log("=====: " + forced);

    // var appName = 'test111';

    var merged = mergeStream();

    config.allApps().forEach(function(appName) {
        var createHtmltTask = createAppHtml(appName, false);
        var createJsTask = createAppJS(appName, false);
        var createLessTask = createAppLess(appName, false);

        if (createHtmltTask) {
            merged.add(createHtmltTask);
        }

        if (createJsTask) {
            merged.add(createJsTask);
        }

        if (createLessTask) {
            merged.add(createLessTask);
        }
    });

    return merged;
});


function createAppJS(appName, forced) {
    var appJs = config.clientApp + 'app.' + appName + '.module.js';


    if (!forced && isExistedFile(appJs)) {
        return false;
    } else {
        log("create js file for app [" + appName + "]");

        var jsTemplate = config.scaffoldDir + 'app_template.js';

        return gulp.src(jsTemplate)
            .pipe($.rename('app.' + appName + '.module.js'))
            .pipe(gulp.dest(config.clientApp));
    }
}

function createAppHtml(appName, forced) {
    var appHtml = config.client + appName + '.html';

    if (!forced && isExistedFile(appHtml)) {
        return false;
    } else {
        log("create html file [" + appHtml + "] for app [" + appName + "]");

        var htmlTemplate = config.scaffoldDir + 'app_template.html';

        return gulp.src(htmlTemplate)
            .pipe($.rename(appName + '.html'))
            .pipe(gulp.dest(config.client));
    }
}

function createAppLess(appName, forced) {
    var appLess = config.client + 'styles/' + appName + '.less';

    if (!forced && isExistedFile(appLess)) {
        return false;
    } else {

        log("create less file for app [" + appName + "]");


        var htmlTemplate = config.scaffoldDir + 'app_template.less';

        return gulp.src(htmlTemplate)
            .pipe($.rename(appName + '.less'))
            .pipe(gulp.dest(config.client + 'styles/'));
    }

}

/**
 * Optimize all files, move to a build folder, and inject them into the new
 * index.html
 * 
 * @return {Stream}
 */
gulp.task('optimize', ['inject'], function() {
    log('Optimizing the js, css, and html');

    var merged = mergeStream();
    var isProd = false;

    if (args.env === 'prod') {
        isProd = true;
    }

    config.allApps().forEach(function(module) {
        merged.add(buildOptimizeTask(module, isProd));
    });

    return merged;
});

/**
 * Build everything This is separate so we can run tests on optimize before
 * handling image or fonts
 */
gulp.task('build', ['optimize', 'images', 'fonts', 'constants' , 'sound' , 'copy-styles-css'], function() {
    log('Building everything');

    var msg = {
        title: 'gulp build',
        subtitle: 'Deployed to the build folder',
        message: 'Running `gulp serve-build`'
    };
    del(config.temp);
    log(msg);
    notify(msg);
});



gulp.task('copy-public-template', function() {
    log('copy html  templates to Webapp build directory');

    return gulp.src(config.htmlpublic)
        .pipe(gulp.dest(config.htmlDeployDir + '/public'));
});

gulp.task('copy-styles-css', function(done) {
    
    log('copy all styles directory css resource to build dir');

    return gulp
        .src(config.css) // styles/styles.less
        .pipe(gulp.dest(config.build + "styles"));
});

gulp.task('copy-resources', function(done) {
    
    log('copy all static resource to deploy dir');

    var files = [].concat(
        config.build + '**/*.*',
        config.build + '**/**/*.*',
        "!" + config.build + '*.html'
    );
    return gulp.src(files)
        .pipe(gulp.dest(config.resourcesDeployDir));
});

gulp.task('copy-to-webapp' , [] , function(done) {

    log('copy all dist resource to webapp dir');

    var files = [].concat(
        config.webappSrcDir + '**/**'
    );

    return gulp.src(files)
        .pipe(gulp.dest(config.webappDir));
});

gulp.task('copy-to-webapp-views', function(done) {
    log('copy all dist html to webapp views');

    var files = [].concat(
        config.webappSrcDir + 'views/**/**'
    );
    return gulp.src(files)
        .pipe(gulp.dest(config.webappViewDir1))
        .pipe(gulp.dest(config.webappViewDir2));
});

/**
 * reaplce html file with new Domain the version --type=dev 开发环境的Domain配置
 * --type=stage 预生产，测试环境的Domain配置 --type=prod 生产环境的Domain配置
 */
gulp.task('replaceHtmlDomain', function() {
    log('replace html  with new domain');

    var env = 'dev';
    if (args.env == 'prod') {
        env = 'prod';
    } else if (args.env == 'stage') {
        env = 'stage';
    }

    var opts = {
        conditionals: true,
        spare: true ,
        quotes : true ,
        preserve : true ,
        empty : true ,
        cdata : true ,
        loose : true ,
        ssi : true
    };

    return gulp.src(config.build + "*.html")
        .pipe(assetpaths({
            newDomain: config.appContext(env),
            oldDomain: 'oldDomain',
            docRoot: 'public_html',
            filetypes: ['js', 'css'],
            templates: false
        }))
        // .pipe( $.minifyHtml(opts))
        // .pipe($.if(env == 'prod', $.minifyHtml(opts)))
        .pipe(gulp.dest(config.htmlDeployDir));
});


gulp.task('deploy', function() {
    log('deploy html to Webapp build directory');

    $.runSequence('build', 'replaceHtmlDomain' , 'copy-resources' , 'copy-public-template');
});

gulp.task('deploy-webapp', function() {
    log('deploy html to Webapp build directory');
    args.env = "stage";
    $.runSequence('build', 'replaceHtmlDomain', 'copy-resources' , 'copy-public-template' , 'copy-to-webapp');
});

// gulp.task('deploy-webapp-stage', function() {
//     log('deploy html to Webapp build directory');
//     args.env = "stage";
//     $.runSequence('build', 'replaceHtmlDomain', 'copy-resources' , 'copy-public-template' , 'copy-to-webapp');
// });

gulp.task('deploy-stage', function() {
    log('deploy html to Webapp build directory');

    args.env = "stage";

    $.runSequence('constants', 'build', 'replaceHtmlDomain' , 'copy-resources' , 'copy-public-template');
});

gulp.task('deploy-prod', function() {
    log('deploy html to Webapp build directory');

    args.env = "prod";

    $.runSequence('constants', 'build', 'replaceHtmlDomain', 'copy-resources' , 'copy-public-template');
});



/**
 * Remove all files from the build, temp, and reports folders
 * 
 * @param {Function}
 *            done - callback when complete
 */
gulp.task('clean', function(done) {
    var delconfig = [].concat(config.build, config.temp, config.htmlDeployDir);
    log('Cleaning: ' + $.util.colors.blue(delconfig));
    del(delconfig, {
        'force': true
    }, done);
});




/**
 * Remove all fonts from the build folder
 * 
 * @param {Function}
 *            done - callback when complete
 */
gulp.task('clean-fonts', function(done) {
    clean(config.build + 'fonts/**/*.*', done);
});

/**
 * Remove all images from the build folder
 * 
 * @param {Function}
 *            done - callback when complete
 */
gulp.task('clean-images', function(done) {
    clean(config.build + 'images/**/*.*', done);
});


gulp.task('clean-sound', function(done) {
    clean(config.build + 'sound/**/*.*', done);
});


/**
 * Remove all styles from the build and temp folders
 * 
 * @param {Function}
 *            done - callback when complete
 */
gulp.task('clean-styles', function(done) {
    var files = [].concat(
        config.temp + '**/*.css',
        config.build + 'styles/**/*.css'
    );
    clean(files, done);
});

/**
 * Remove all js and html from the build and temp folders
 * 
 * @param {Function}
 *            done - callback when complete
 */
gulp.task('clean-code', function(done) {
    var files = [].concat(
        config.temp + '**/*.js',
        config.build + 'js/**/*.js',
        config.build + '**/*.html',
        config.htmlDeployDir + '**',
        config.resourcesDeployDir + '**/**'
    );

    clean(files, done);
});


/**
 * build the constans according to env
 */
gulp.task('constants', function() {
    var env = 'dev';
    if (args.env == 'prod') {
        env = 'prod';
    } else if (args.env == 'stage') {
        env = 'stage';
    }

    return buildConstants(env);
});


/**
 * reset the constans to local environment
 */
gulp.task('reset-constants', function() {
    return buildConstants('local');
});


function buildConstants(env) {
    var constantsConfig = config.constantsConfig();

    var envConfig = constantsConfig[env];

    return $.ngConstant({
            name: 'app.core',
            templatePath: config.client + "app-scaffold/constants.tpl.ejs",
            constants: envConfig,
            stream: true,
            deps: false
        })
        .pipe(gulp.dest(config.clientApp + 'core/'));
}




/**
 * serve the dev environment --debug-brk or --debug --nosync
 */
gulp.task('serve-dev', ['inject', 'reset-constants'], function() {
    serve(true /* isDev */ );
});

/**
 * vet the code and create coverage report
 * 
 * @return {Stream}
 */
gulp.task('vet', function() {
    log('Analyzing source with JSHint and JSCS');

    return gulp
        .src(config.alljs)
        .pipe($.if(args.verbose, $.print()))
        .pipe($.jshint())
        .pipe($.jshint.reporter('jshint-stylish', {
            verbose: true
        }))
        .pipe($.jshint.reporter('fail'));
    // .pipe($.jscs());
});


/**
 * Bump the version --type=pre will bump the prerelease version *.*.*-x
 * --type=patch or no flag will bump the patch version *.*.x --type=minor will
 * bump the minor version *.x.* --type=major will bump the major version x.*.*
 * --version=1.2.3 will bump to a specific version and ignore other flags
 */
gulp.task('bump', function() {
    var msg = 'Bumping versions';
    var type = args.type;
    var version = args.ver;
    var options = {};
    if (version) {
        options.version = version;
        msg += ' to ' + version;
    } else {
        options.type = type;
        msg += ' for a ' + type;
    }
    log(msg);

    return gulp
        .src(config.packages)
        .pipe($.print())
        .pipe($.bump(options))
        .pipe(gulp.dest(config.root));
});


function getAppModulePath(appName) {

    var subModules = config.modules(appName);

    if (subModules.length === 0) {
        return false;
    }

    if (subModules.length === 1) {
        return config.clientApp + subModules[0] + '/';
    }

    var modulePath = config.clientApp;
    modulePath += '{';

    subModules.forEach(function(module, index) {
        if (index !== 0) {
            modulePath += ',';
        }

        modulePath += module;
    });
    modulePath += '}/';

    return modulePath;
}


function buildAppWireDep(appName) {
    var wiredep = require('wiredep').stream;
    var options = config.getWiredepDefaultOptions();

    var dependencies = config.dependencies(appName);
    options.bowerJson = config.dependencies(appName);

    // options.bowerJson = require('./src/config/' + appName + ".bower.json");

    var js = [
        config.clientApp + 'app.' + appName + '.module.js'
    ];

    var modulePath = getAppModulePath(appName);

    if (modulePath) {
        js.push(modulePath + '**/*.module.js');
        js.push(modulePath + '**/*.js');
        js.push('!' + modulePath + '**/*.spec.js');
    }



    // Only include stubs if flag is enabled
    js = args.stubs ? [].concat(js, config.stubsjs) : js;

    var appHtmlFile = config.client + appName + '.html';
    return gulp
        .src(appHtmlFile)
        .pipe(wiredep(options)) // inject bower css and js dependency to html,
        // which required tag with
        // <!--bower.css--><!--endbower--> and
        // <!--bower.js--><!--endbower-->
        .pipe(inject(js, '', config.jsOrder))
        .pipe(gulp.dest(config.client));
}


function cleanAppWireDep(appName) {
    var wiredep = require('wiredep').stream;
    var options = config.getWiredepDefaultOptions();

    var dependencies = config.dependencies(appName);
    options.bowerJson = {};

    var appHtmlFile = config.client + appName + '.html';
    return gulp
        .src(appHtmlFile)
        .pipe(wiredep(options)) // remote inject bower css and js dependency to html,
        // which required tag with
        // <!--bower.css--><!--endbower--> and
        // <!--bower.js--><!--endbower-->
        .pipe(inject(['empty.js'], '', config.jsOrder))
        .pipe(gulp.dest(config.client));
}


function buildModuleTemplateCache(appName) {

    var subModules = config.modules(appName);

    if (subModules.length === 0) {
        return false;
    }

    var htmltemplates = getAppModulePath(appName) + '**/*.html';

    return gulp
        .src(htmltemplates)
        .pipe($.if(args.verbose, $.bytediff.start()))
        .pipe($.minifyHtml({
            empty: true
        }))
        .pipe($.if(args.verbose, $.bytediff.stop(bytediffFormatter)))
        .pipe($.angularTemplatecache(
            appName + '.' + config.templateCache.file,
            config.templateCache.options
        ))
        .pipe(gulp.dest(config.temp));
}


function buildInjectTasks(appName) {
    var appHtmlFile = config.client + appName + '.html';
    var cssFiles = config.temp + appName + '.css';

    var templateCache = config.temp + appName + '.' + config.templateCache.file;

    return gulp
        .src(appHtmlFile)
        .pipe(inject(cssFiles))
        .pipe(inject(templateCache, 'templates'))
        .pipe(gulp.dest(config.client));
}


function cleanInjectTasks(appName) {
    var appHtmlFile = config.client + appName + '.html';

    return gulp
        .src(appHtmlFile)
        .pipe(inject('empty.css', 'css'))
        .pipe(inject('empty.js', 'templates'))
        .pipe(gulp.dest(config.client));
}




function buildOptimizeTask(appName, isProd) {
    isProd = isProd || false;

    var appHtmlFile = config.client + appName + '.html';

    var assets = $.useref.assets({
        searchPath: './'
    });
    // Filters are named for the gulp-useref path
    var cssFilter = $.filter('**/*.css');
    var jsAppFilter = $.filter('**/' + config.optimized.app);
    var jslibFilter = $.filter('**/' + config.optimized.lib);


    return gulp
        .src(appHtmlFile)
        .pipe($.plumber())
        .pipe(assets) // Gather all assets from the html with useref
        // Get the css
        .pipe(cssFilter)
        .pipe($.if(isProd, $.csso()))
        .pipe(cssFilter.restore())
        // Get the custom javascript
        .pipe(jsAppFilter)
        .pipe($.ngAnnotate({
            add: true
        }))
        .pipe($.if(isProd, $.uglify()))
        .pipe(getHeader())
        .pipe(jsAppFilter.restore())
        // Get the vendor javascript
        .pipe(jslibFilter)
        .pipe($.if(isProd, $.uglify())) // another option is to override wiredep
        // to use min files
        .pipe(jslibFilter.restore())
        // Take inventory of the file names for future rev numbers
        .pipe($.rev())
        // Apply the concat and file replacement with useref
        .pipe(assets.restore())
        .pipe($.useref())
        // Replace the file names in the html with rev numbers
        .pipe($.revReplace())
        .pipe(gulp.dest(config.build));
}


// //////////////

/**
 * When files change, log it
 * 
 * @param {Object}
 *            event - event that fired
 */

function changeEvent(event) {
    var srcPattern = new RegExp('/.*(?=/' + config.source + ')/');
    log('File ' + event.path.replace(srcPattern, '') + ' ' + event.type);
}

/**
 * Delete all files in a given path
 * 
 * @param {Array}
 *            path - array of paths to delete
 * @param {Function}
 *            done - callback when complete
 */

function clean(path, done) {
    log('Cleaning: ' + $.util.colors.blue(path));
    del(path, {
        'force': true
    }, done);
}

/**
 * Inject files in a sorted sequence at a specified inject label
 * 
 * @param {Array}
 *            src glob pattern for source files
 * @param {String}
 *            label The label name
 * @param {Array}
 *            order glob pattern for sort order of the files
 * @returns {Stream} The stream
 */

function inject(src, label, order) {
    var options = {
        read: false
    };
    if (label) {
        options.name = 'inject:' + label;
    }

    return $.inject(orderSrc(src, order), options);
}

/**
 * Order a stream
 * 
 * @param {Stream}
 *            src The gulp.src stream
 * @param {Array}
 *            order Glob array pattern
 * @returns {Stream} The ordered stream
 */

function orderSrc(src, order) {
    // order = order || ['**/*'];
    return gulp
        .src(src)
        .pipe($.if(order, $.order(order)));
}

/**
 * serve the code --debug-brk or --debug --nosync
 * 
 * @param {Boolean}
 *            isDev - dev or build mode
 */

function serve(isDev) {
    var debug = args.debug || args.debugBrk;
    var debugMode = args.debug ? '--debug' : args.debugBrk ? '--debug-brk' : '';
    var nodeOptions = getNodeOptions(isDev);

    if (debug) {
        runNodeInspector();
        nodeOptions.nodeArgs = [debugMode + '=5858'];
    }


    if (args.verbose) {
        console.log(nodeOptions);
    }

    return $.nodemon(nodeOptions)
        .on('restart', [], function(ev) {
            log('*** nodemon restarted');
            log('files changed:\n' + ev);
            setTimeout(function() {
                browserSync.notify('reloading now ...');
                browserSync.reload({
                    stream: false
                });
            }, config.browserReloadDelay);
        })
        .on('start', function() {
            log('*** nodemon started');
            startBrowserSync(isDev);
        })
        .on('crash', function() {
            log('*** nodemon crashed: script crashed for some reason');
        })
        .on('exit', function() {
            log('*** nodemon exited cleanly');
        });
}

function getNodeOptions(isDev) {
    return {
        script: config.nodeServer,
        delayTime: 1,
        env: {
            'PORT': port,
            'NODE_ENV': isDev ? 'dev' : 'build'
        },
        watch: [config.server]
    };
}

function runNodeInspector() {
    log('Running node-inspector.');
    log('Browse to http://localhost:8080/debug?port=5858');
    var exec = require('child_process').exec;
    exec('node-inspector');
}



/**
 * Start BrowserSync --nosync will avoid browserSync
 */

function startBrowserSync(isDev) {

    if (args.nosync || browserSync.active) {
        return;
    }

    log('Starting BrowserSync on port ' + port);

    // If build: watches the files, builds, and restarts browser-sync.
    // If dev: watches less, compiles it to css, browser-sync handles reload
    if (isDev) {
        gulp.watch([config.lessToBeWatched, config.html], ['styles', 'templatecache', browserSync.reload])
            .on('change', changeEvent);
    } else {
        gulp.watch([config.lessToBeWatched, config.js, config.html], ['optimize', browserSync.reload])
            .on('change', changeEvent);
    }

    var options = {
        proxy: 'localhost:' + port,
        port: 3000,
        files: isDev ? [
            config.client + '**/*.*',
            '!' + config.less,
            config.temp + '**/*.css'
        ] : [],
        ghostMode: { // these are the defaults t,f,t,t
            clicks: true,
            location: false,
            forms: true,
            scroll: true
        },
        injectChanges: true,
        logFileChanges: true,
        logLevel: 'debug',
        logPrefix: 'gulp-patterns',
        notify: true,
        reloadDelay: 1000, // 1000
        tunnel: false
    };


    browserSync(options);
}


/**
 * Formatter for bytediff to display the size changes after processing
 * 
 * @param {Object}
 *            data - byte data
 * @return {String} Difference in bytes, formatted
 */

function bytediffFormatter(data) {
    var difference = (data.savings > 0) ? ' smaller.' : ' larger.';
    return data.fileName + ' went from ' +
        (data.startSize / 1000).toFixed(2) + ' kB to ' +
        (data.endSize / 1000).toFixed(2) + ' kB and is ' +
        formatPercent(1 - data.percent, 2) + '%' + difference;
}

/**
 * Log an error message and emit the end of a task
 */

function errorLogger(error) {
    log('*** Start of Error ***');
    log(error);
    log('*** End of Error ***');
    this.emit('end');
}

/**
 * Format a number as a percentage
 * 
 * @param {Number}
 *            num Number to format as a percent
 * @param {Number}
 *            precision Precision of the decimal
 * @return {String} Formatted perentage
 */

function formatPercent(num, precision) {
    return (num * 100).toFixed(precision);
}

/**
 * Format and return the header for files
 * 
 * @return {String} Formatted file header
 */

function getHeader() {

    var pkg = require('./package.json');
    var template = ['/**',
        ' * <%= pkg.name %> - <%= pkg.description %>',
        ' * @authors David Liu',
        ' * @version v<%= pkg.version %>',
        ' * @link <%= pkg.homepage %>',
        ' * @license <%= pkg.license %>',
        ' */',
        ''
    ].join('\n');
    return $.header(template, {
        pkg: pkg
    });
}

/**
 * Log a message or series of messages using chalk's blue color. Can pass in a
 * string, object or array.
 */

function log(msg) {
    if (typeof(msg) === 'object') {
        for (var item in msg) {
            if (msg.hasOwnProperty(item)) {
                $.util.log($.util.colors.blue(msg[item]));
            }
        }
    } else {
        $.util.log($.util.colors.blue(msg));
    }
}

/**
 * Show OS level notification using node-notifier
 */

function notify(options) {
    var notifier = require('node-notifier');
    var notifyOptions = {
        sound: 'Bottle',
        contentImage: path.join(__dirname, 'gulp.png'),
        icon: path.join(__dirname, 'gulp.png')
    };
    _.assign(notifyOptions, options);
    notifier.notify(notifyOptions);
}

module.exports = gulp;
