(function() {
    'use strict';

    angular.module('app.schedule').factory('ScheduleService', ScheduleService);

    ScheduleService.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function ScheduleService(restfulHelper, SERVER_API_URL) {
        var service = {
        		getPlanschedulesWithPage : getPlanschedulesWithPage
        };
        return service;
        
        function getPlanschedulesWithPage(p,s,schedule){
        	return restfulHelper.get(SERVER_API_URL + "api/planschedulesWithPage?p=" + p + "&s=" + s, schedule);
        }
    }
})();
