(function() {
    'use strict';

    angular.module('app.file').factory("FileService", FileServiceFactory);

    FileServiceFactory.$inject = ['LocalFileService'];

    function FileServiceFactory(LocalFileService) {
        var service = {
            upload : upload,
        };
        return service;

    
        function upload(file){
            return LocalFileService.uploadFile(file);
        }
    }

})();
