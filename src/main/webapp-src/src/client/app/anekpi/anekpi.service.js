(function() {
    'use strict';

    angular.module('app.anekpi').factory('AnekpiService', AnekpiService);
 
    AnekpiService.$inject = ['restfulHelper', 'SERVER_API_URL'];
    function AnekpiService(restfulHelper, SERVER_API_URL) {
        var service = {
        		queryDataByPage : queryDataByPage,
        		addData : addData,
        		updateData : updateData,
        		deleteData : deleteData,
        		getCodesByType : getCodesByType
        };
        return service;
        function queryDataByPage(jsonData){
        	var result = restfulHelper.post(SERVER_API_URL + "kpi/queryDataByPage",jsonData);
        	return result;
        }
        function addData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "kpi/add",jsonData);
        }
        
        function updateData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "kpi/update/",jsonData);
        }
        
        function deleteData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "kpi/delete/",jsonData);
        }      
        function getCodesByType(codeType){
        	return restfulHelper.get(SERVER_API_URL + "api/getCodesByType?codeType=" + codeType);
        }
    }
})();
