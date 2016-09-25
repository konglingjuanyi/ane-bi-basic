(function() {
    'use strict';

    angular.module('app.targetval').factory('TargetvalService', TargetvalService);
 
    TargetvalService.$inject = ['restfulHelper', 'SERVER_API_URL'];
    function TargetvalService(restfulHelper, SERVER_API_URL) {
        var service = {
        		queryDataByPage : queryDataByPage,
        		addData : addData,
        		updateData : updateData,
        		deleteData : deleteData
        };
        return service;
        function queryDataByPage(jsonData){
        	var result = restfulHelper.post(SERVER_API_URL + "target/queryDataByPage",jsonData);
        	return result;
        }
        function addData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "target/add",jsonData);
        }
        
        function updateData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "target/update/",jsonData);
        }
        function deleteData(jsonData){
        	return restfulHelper.post(SERVER_API_URL + "target/delete/",jsonData);
        }      
    }
})();
