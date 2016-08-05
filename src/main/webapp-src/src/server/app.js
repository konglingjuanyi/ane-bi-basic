/*jshint node:true*/
'use strict';

var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var favicon = require('serve-favicon');
var logger = require('morgan');
var port = process.env.PORT || 8001;
var path = require('path');
var four0four = require('./route/404')();
var cookieParser = require('cookie-parser')
var argv = require('optimist').argv;
var environment = process.env.NODE_ENV;
// var ejs = require('ejs');

port = argv.port || port;
environment = argv.env || environment;

app.use(cookieParser());
// app.use(favicon(__dirname + '/favicon.ico'));
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json());
app.use(logger('dev'));

app.engine('html', require('ejs').renderFile);
app.set('view engine', 'html');

// app.use('/t/:talkingId', require('./utils/cookie'));
// app.use('/admin', require('./utils/guest-security'));
app.use(require('./route/router'));

console.log('PORT=' + port);
console.log('NODE_ENV=' + environment);

switch (environment) {
    case 'build':
        console.log('** BUILD **');
        // app.use(express.static('./build/'));
        app.use(express.static(path.join(__dirname, '../../dist/public/')));
        app.set('views', path.join(__dirname, '../../dist/views'));
        // Any invalid calls for templateUrls are under app/* and should return 404
        app.use('/app/*', function(req, res, next) {
            four0four.send404(req, res);
        });
        // Any deep link calls should return index.html
        // app.use('/*', express.static('./build/index.html'));
        break;
    default:
        console.log('** DEV **');
        app.use(express.static('./src/client/'));
        app.use(express.static('./'));
        app.use(express.static('./tmp'));

        app.set('views', path.join(__dirname, '../../src/client'));
        // Any invalid calls for templateUrls are under app/* and should return 404
        app.use('/app/*', function(req, res, next) {
            four0four.send404(req, res);
        });    
        break;
}

app.listen(port, function() {
    console.log('Express server listening on port ' + port);
    console.log('env = ' + app.get('env') +
        '\n__dirname = ' + __dirname +
        '\nprocess.cwd = ' + process.cwd());
});
