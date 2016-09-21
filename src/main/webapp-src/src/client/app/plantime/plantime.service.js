(function() {
    'use strict';

    angular.module('app.plantime').factory('PlantimeService', PlantimeService);
 
    PlantimeService.$inject = ['restfulHelper', 'SERVER_API_URL'];
    function PlantimeService(restfulHelper, SERVER_API_URL) {
        var service = {
        		queryDataByPage : queryDataByPage,
        		addData : addData,
        		updateData : updateData,
        		deleteData : deleteData,
        		getCodesByType : getCodesByType
        };
        return service;
        function queryDataByPage(jsonData){
        	var result = restfulHelper.post(SERVER_API_URL + "plan/queryDataByPage",jsonData);
        	return result;
        }
        function addData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "plan/add",jsonData);
        }
        
        function updateData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "plan/update/",jsonData);
        }
        
        function deleteData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "plan/delete/",jsonData);
        }      
        function getCodesByType(codeType){
        	return restfulHelper.get(SERVER_API_URL + "api/getCodesByType?codeType=" + codeType);
        }
    }
})();
