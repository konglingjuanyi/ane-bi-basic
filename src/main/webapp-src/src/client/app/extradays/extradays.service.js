(function() {
    'use strict';

    angular.module('app.extradays').factory('ExtradaysService', ExtradaysService);

    ExtradaysService.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function ExtradaysService(restfulHelper, SERVER_API_URL) {
        var service = {
        		getExtradays : getExtradays,
        		addExtradays : addExtradays,
        		updateExtradays : updateExtradays,
        		delExtradays : delExtradays,
        		getCodesByType : getCodesByType,
        		getOrgWithPage : getOrgWithPage,
        };
        return service;
        
        function getExtradays(p,s,siteName,agingType){
        	return restfulHelper.get(SERVER_API_URL + "api/getExtradays?p=" + p + "&s=" + s 
        			+ "&siteName=" + siteName + "&agingType=" + agingType);
        }
        
        function addExtradays(extraDays){
        	return restfulHelper.post(SERVER_API_URL + "api/addExtradays", extraDays);
        }
        
        function updateExtradays(extraDays){
        	return restfulHelper.put(SERVER_API_URL + "api/updateExtradays/" + extraDays.id,extraDays);
        }
        
        function delExtradays(id){
        	return restfulHelper.delete(SERVER_API_URL + "api/delExtradays/" + id);
        }
        
        function getCodesByType(codeType){
        	return restfulHelper.get(SERVER_API_URL + "api/getCodesByType?codeType=" + codeType);
        }
        
        function getOrgWithPage(p,s,siteName,queryType){
        	return restfulHelper.get(SERVER_API_URL + "/api/organization/getOrgWithPage?p=" + p + "&s=" + s 
        			+ "&siteName=" + siteName + "&queryType=" + queryType);
        }
        
    }
})();
