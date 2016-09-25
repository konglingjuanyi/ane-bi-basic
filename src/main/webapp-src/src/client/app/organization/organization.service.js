(function() {
    'use strict';

    angular.module('app.organization').factory('OrganizationService', OrganizationService);

    OrganizationService.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function OrganizationService(restfulHelper, SERVER_API_URL) {
        var service = {
        	getOrganizations : getOrganizations,
        	getArea : getArea,
        	getProvinceArea : getProvinceArea,
        	getDict : getDict,
        	getSite : getSite,
        	saveOrg : saveOrg,
        };
        return service;
        
        function getOrganizations( p, s,orgBrnchMtopRlQueryVO){
        	return restfulHelper.get(SERVER_API_URL + "api/MtopRl/getOrgBrnchMtopRl?p=" + p + "&s=" + s,orgBrnchMtopRlQueryVO);
        }
        
        function getArea(){
        	return restfulHelper.get(SERVER_API_URL + "api/MtopRl/getArea");
        }
        
        function getProvinceArea(){
        	return restfulHelper.get(SERVER_API_URL + "api/MtopRl/getProvinceArea");
        }
        
        function getDict(){
        	return restfulHelper.get(SERVER_API_URL + "api/MtopRl/getDict");
        }
        
        function getSite(){
        	return restfulHelper.get(SERVER_API_URL + "api/MtopRl/getSite");
        }
        
        function saveOrg(upAreaId,upProvinceId,upDictId,upSiteId,oriData){
        	return restfulHelper.put(SERVER_API_URL + "api/MtopRl/saveOrg/"+upAreaId+"/"+upProvinceId+"/"+upDictId+"/"+upSiteId,oriData);
        }
        
    }
})();
