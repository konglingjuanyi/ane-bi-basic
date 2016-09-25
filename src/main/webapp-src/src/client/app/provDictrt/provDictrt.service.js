(function() {
    'use strict';

    angular.module('app.provDictrt').factory('ProvDictrtService', ProvDictrtService);

    ProvDictrtService.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function ProvDictrtService(restfulHelper, SERVER_API_URL) {
        var service = {
            	getWithPage:getWithPage,
            	add:add,
            	update:update,
            	changeStatus:changeStatus,
            	getProvinceAll:getProvinceAll,
            	getAreaAll:getAreaAll,
            };
            return service;
            
            function getWithPage(p,s,lvl,name){
            	return restfulHelper.get(SERVER_API_URL + "api/provDistrt/getWithPage?p=" + p + "&s=" + s 
            			+ "&lvl=" + lvl + "&name=" + name);
            }
            
            function add(provDistrt){
            	return restfulHelper.post(SERVER_API_URL + "api/provDistrt/add", provDistrt);
            }
            
            function update(provDistrt){
            	return restfulHelper.put(SERVER_API_URL + "api/provDistrt/update",provDistrt);
            }
            
            function changeStatus(provDistrt){
            	return restfulHelper.put(SERVER_API_URL + "api/provDistrt/changeStatus",provDistrt);
            }
            
            function getProvinceAll(){
            	return restfulHelper.get(SERVER_API_URL + "api/provDistrt/getProvinceAll");
            }
            
            function getAreaAll(){
            	return restfulHelper.get(SERVER_API_URL + "api/provDistrt/getAreaAll");
            }
            
        }
})();
