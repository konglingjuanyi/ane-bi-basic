(function() {
    'use strict';

    angular.module('app.dailymodel').factory('DailymodelService', DailymodelService);
 
    DailymodelService.$inject = ['restfulHelper', 'SERVER_API_URL'];
    function DailymodelService(restfulHelper, SERVER_API_URL) {
        var service = {
        		queryDataByPage : queryDataByPage,
        		addData : addData,
        		updateData : updateData,
        		deleteData : deleteData,
        		getParentModle : getParentModle
        };
        return service;
        function queryDataByPage(jsonData){
        	var result = restfulHelper.post(SERVER_API_URL + "module/queryDataByPage",jsonData);
        	return result;
        }
        function addData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "module/add",jsonData);
        }
        
        function updateData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "module/update/",jsonData);
        }
        function getParentModle(){
        	return restfulHelper.post(SERVER_API_URL + "module/query");
        }
        function deleteData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "module/delete/",jsonData);
        }      
        function getCodesByType(codeType){
        	return restfulHelper.get(SERVER_API_URL + "module/getCodesByType?codeType=" + codeType);
        }
    }
})();
