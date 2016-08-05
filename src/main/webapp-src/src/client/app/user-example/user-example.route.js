(function() {
    'use strict';

    angular.module('app.user-example').run(appRun);

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
                    controller: 'UserExampleListController',
                    controllerAs: 'vm',
                }
            }, {
                state: 'edit',
                config: {
                    url: '/edit/:userId',
                    templateUrl: getTemplateUrl('/edit.html'),
                    controller: 'UserExampleController',
                    controllerAs: 'vm',
                }
            }, {
                state: 'new',
                config: {
                    url: '/new',
                    templateUrl: getTemplateUrl('/edit.html'),
                    controller: 'UserExampleController',
                    controllerAs: 'vm',
                }
            }];
        }


        function getTemplateUrl(url) {
            return SERVER_API_URL + 'public/user-example' + url;
        }

    }
    
})();
