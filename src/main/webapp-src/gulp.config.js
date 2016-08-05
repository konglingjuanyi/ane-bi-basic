module.exports = function() {
    var client = './src/client/';
    var server = './src/server/';
    var clientApp = client + 'app/';
    var root = './';
    var htmlDeployDir = "./dist/views/";
    var resourcesDeployDir = "./dist/public/";
    var scaffoldDir = client + 'app-scaffold/';
    var temp = './.tmp/';
    var wiredep = require('wiredep');
    var bowerFiles = wiredep({
        devDependencies: true
    }).js;
    var bower = {
        json: require('./bower.json'),
        directory: './bower_components/',
        ignorePath: '../..'
    };
    var nodeModules = 'node_modules';

    var config = {
        /**
         * File paths
         */
        // all javascript that we want to vet
        alljs: [
            './src/**/*.js',
            './*.js'
        ],
        build: './build/',
        clientApp: clientApp,
        htmlDeployDir: htmlDeployDir,
        resourcesDeployDir: resourcesDeployDir,
        scaffoldDir: scaffoldDir,
        client: client,
        css: [ client + 'styles/*.css' ],
        fonts: [ bower.directory + 'font-awesome/fonts/**/*.*' , bower.directory + 'bootstrap/fonts/**/*.*'  ],
        sound: [ client + 'sound/**/*.*']  ,
        html: client + '**/*.html',
        htmlpublic: client + 'public/**/*.html',
        ejstemplates : client + 'template/**/*.*',
        images: client + 'images/**/*.*',
        index: client + 'index.html',
        // app js, with no specs
        js: [
            clientApp + '**/*.module.js',
            clientApp + '**/*.js',
            '!' + clientApp + '**/*.spec.js'
        ],
        jsOrder: [
            '**/app.module.js',
            '**/*.module.js',
            '**/*.js'
        ],
        less: client + 'styles/*.less',
        lessToBeWatched : client + 'styles/**/*.less',
        root: root,
        server: server,
        source: 'src/',
        stubsjs: [
            bower.directory + 'angular-mocks/angular-mocks.js',
            client + 'stubs/**/*.js'
        ],
        temp: temp,

        /**
         * optimized files
         */
        optimized: {
            app: 'app.js',
            lib: 'lib.js'
        },

        /**
         * plato
         */
        plato: {
            js: clientApp + '**/*.js'
        },

        /**
         * browser sync
         */
        browserReloadDelay: 1000,

        /**
         * template cache
         */
        templateCache: {
            file: 'templates.js',
            options: {
                module: 'app.core',
                root: 'app/',
                standAlone: false
            }
        },

        /**
         * Bower and NPM files
         */
        bower: bower,
        packages: [
            './package.json',
            './bower.json'
        ],


        /**
         * Node settings
         */
        nodeServer: './src/server/app.js',
        defaultPort: '8002',
        webappDir: './../webapp/build/' ,
        webappViewDir: './../webapp/WEB-INF/views/' , 
        webappSrcDir : './dist/' ,
    };

    var apps = require('./app.module.json');

    config.appContext = function(env) {
        env = env || 'DEV';

        return apps.appContext[env];
    };

    config.allApps = function() {
        return Object.keys(apps.apps);
    };

    config.modules = function(modelName) {
        if(modelName in apps.apps) {
            return apps.apps[modelName].modules;
        } else {
            return [];//'blocks', 'chargePoints'];
        }
    };

    config.constantsConfig = function() {
         return apps.constants;
    };

    config.dependencies = function(modelName) {

        //console.log(JSapps);

        if(modelName in apps.apps) {
            var dependencies =  apps.apps[modelName].dependencies;

            return {
                "dependencies" : dependencies
            };
        } else {
            return {
                 "dependencies" : {}
            };
        }
    };




    /**
     * wiredep and bower settings
     */
    config.getWiredepDefaultOptions = function() {
        var options = {
            bowerJson: config.bower.json,
            directory: config.bower.directory,
            ignorePath: config.bower.ignorePath,
        };
        return options;
    };


    return config;
};
