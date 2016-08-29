(function() {
    'use strict';

    angular.module('app.radioStandard').factory('RadioStandardService', RadioStandardService);

    RadioStandardService.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function RadioStandardService(restfulHelper, SERVER_API_URL) {
        var service = {
        		getRadio : getRadio,
        		createRadio : createRadio,
        		updateRadio : updateRadio,
        };
        return service;
        
        function getRadio(){
        	return restfulHelper.get(SERVER_API_URL + "api/getRadio");
        }
        
        function createRadio(radio){
        	return restfulHelper.post(SERVER_API_URL + "api/createRadio/" + radio);
        }
        
        function updateRadio(radio){
        	return restfulHelper.put(SERVER_API_URL + "api/updateRadio/" + radio);
        }
        
    }
})();
