(function() {
    'use strict';

    angular.module('app.file').factory("LocalFileService", LocalFileServiceFactory);

    LocalFileServiceFactory.$inject = ['$http', 'SERVER_API_URL', '$q', 'restfulHelper'];

    function LocalFileServiceFactory($http, SERVER_API_URL, $q, restfulHelper) {
        var service = {
            uploadFile: uploadFile,
        };
        return service;


        function uploadFile(file) {
            var deferred = $q.defer();
            var formData = new FormData();
            formData.append("file", file);
            var options = {
                withCredentials: false,
                headers: {
                    'Content-Type': undefined
                },
                transformRequest: angular.identity
            };

            var promise = restfulHelper.post(SERVER_API_URL + "api/file/upload", formData, {} ,options);
            promise.then(function(url) {
                deferred.resolve(url);
            }, function(error) {
                deferred.reject(error);
            });
            return deferred.promise;
        }

    }

})();
