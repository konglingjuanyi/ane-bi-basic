(function() {
    'use strict';

    angular.module('app.siteTypeManager').factory('SiteTypeManagerService', SiteTypeManagerService);

    SiteTypeManagerService.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function SiteTypeManagerService(restfulHelper, SERVER_API_URL) {
        var service = {
    		getDataWithPage : getDataWithPage,
    		updateOrgBrnchClfc : updateOrgBrnchClfc,
    		getCodesByType : getCodesByType,
        };
        return service;
        
        function getDataWithPage(p,s,siteName,statFlag){
        	return restfulHelper.get(SERVER_API_URL + "api/getOrgBrnchClfc?p=" + p + "&s=" + s 
        			+ "&siteName=" + siteName + "&statFlag=" + statFlag);
        }
        
        function updateOrgBrnchClfc(orgBrnchClfc){
        	return restfulHelper.put(SERVER_API_URL + "api/updateOrgBrnchClfc", orgBrnchClfc);
        }
        
        function getCodesByType(codeType){
        	return restfulHelper.get(SERVER_API_URL + "api/getCodesByType?codeType=" + codeType);
        }
    }
})();
