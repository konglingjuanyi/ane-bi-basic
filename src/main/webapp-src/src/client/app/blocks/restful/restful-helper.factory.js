(function() {
    'use strict';

    angular
        .module('blocks.restful')
        .factory('restfulHelper', restfulHelperFactory);


    restfulHelperFactory.$inject = ['$http', '$q', '$timeout'];

    function restfulHelperFactory($http, $q, $timeout) {

        var service = {
            get: get,
            post: post,
            put: put,
            delete: del,
            jsonp: jsonp
        };

        return service;


        function get(url, params, cached ) {
            var isCached = cached || false;

            var req = {
                method: 'GET',
                url: url,
                params: params || {},
                cache: isCached
            };

            return _callHttpAPI(req);
        }

        function post(url, data, params, options, returnHeaders) {
            data = data || {};
            returnHeaders = returnHeaders || false;

            var req = {
                method: 'POST',
                url: url,
                data: data,
                params: params
            };

            req = angular.extend(req, options || {});

            return _callHttpAPI(req, returnHeaders);
        }

        function put(url, data) {
            data = data || {};
            var req = {
                method: 'PUT',
                url: url,
                data: data
            };

            return _callHttpAPI(req);
        }

        function del(url , params) {
            var req = {
                method: 'DELETE',
                url: url ,
                params: params || {},
            };

            return _callHttpAPI(req);
        }

        function jsonp(url, params) {
            var reqParams = {
                'callback': 'JSON_CALLBACK'
            };

            reqParams = angular.extend(reqParams, params || {});

            var req = {
                method: 'JSONP',
                url: url,
                params: reqParams
            };

            return _callHttpAPI(req);
        }

        function _callHttpAPI(req, returnHeaders) {
            var deferred = $q.defer();
            returnHeaders = returnHeaders || false;

            var responseSuccessed = false;

            $http(req).success(function(data, status, headers) {
                    //console.log(data);
                    responseSuccessed = true;
                    if (data.status == 'SUCCESS') {
                        if(returnHeaders) {
                            var result  = [];
                            result.data = data.result;
                            result.headers = headers;

                            deferred.resolve(result);
                        } else {
                            deferred.resolve(data.result, status, headers());
                        }
                    } else {
                        deferred.reject(formatMessage(data.result.code, data.result.arguments));
                    }
                })
                .error(function(e, status) {
                    responseSuccessed = true;
                    // deferred.reject('远程服务故障，请稍后再试！' + JSON.stringify(status) + JSON.stringify(req));
                    deferred.reject('远程服务故障，请稍后再试！');
                });

            // $timeout(function() {
            //     if(!responseSuccessed) {
            //         deferred.reject('网络连接超时，请稍候再试！')
            //     }
            // }, 5000);

            return deferred.promise;
        }


        function substitute(str, data) {
            var output = str.replace(/%[^%]+%/g, function(match) {
                if (match in data) {
                    return (data[match]);
                } else {
                    return ("");
                }
            });
            return (output);
        }

        function formatMessage(code, args) {
            args = args || [];

            var res = code;
            for (var i = 0; i < args.length; i++) {
                res = res.replace('${' + i + '}', args[i]);
            }

            return res;

        }
    }

})();
