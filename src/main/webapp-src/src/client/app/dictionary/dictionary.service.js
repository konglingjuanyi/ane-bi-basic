(function() {
    'use strict';

    angular.module('app.dictionary').factory('DictionaryService', DictionaryService);

    DictionaryService.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function DictionaryService(restfulHelper, SERVER_API_URL) {
        var service = {
        		getCodesWithPage : getCodesWithPage,
        		addCodes : addCodes,
        		updateCodes : updateCodes,
        		delCodes : delCodes,
        		getCodesByType : getCodesByType,
        };
        return service;
        
        function getCodesWithPage(p,s,codeType,description,codeName){
        	return restfulHelper.get(SERVER_API_URL + "api/getCodesWithPage?p=" + p + "&s=" + s
        			+ "&codeType=" + codeType + "&description=" + description + "&codeName=" + codeName);
        }
        
        function addCodes(code){
        	return restfulHelper.post(SERVER_API_URL + "api/addCodes", code);
        }
        
        function updateCodes(code){
        	return restfulHelper.put(SERVER_API_URL + "api/updateCodes/" + code.id,code);
        }
        
        function delCodes(id){
        	return restfulHelper.delete(SERVER_API_URL + "api/delCodes/" + id);
        }
        
        function getCodesByType(codeType){
        	return restfulHelper.get(SERVER_API_URL + "api/getCodesByType?codeType=" + codeType);
        }
        
    }
})();
