(function() {
    'use strict';

    angular.module('app.targetval').run(appRun);

    appRun.$inject = ['routerHelper', 'SERVER_API_URL'];

    function appRun(routerHelper, SERVER_API_URL) {
        routerHelper.configureStates(getStates());
        routerHelper.go("list");

        function getStates() {
            return [{
                state: 'list',
                config: {
                    url: '/list',
                    templateUrl: getTemplateUrl('/list.html'),
                    controller: 'TargetvalController',
                    controllerAs: 'vm',
                }
            }];
        }


        function getTemplateUrl(url) {
            return SERVER_API_URL + 'public/targetval' + url;
        }

    }

})();
