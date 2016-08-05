(function() {
    'use strict';

    angular.module('<%= module %>').run(appRun);

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
                    controller: '<%= controller %>',
                    controllerAs: 'vm',
                }
            }];
        }


        function getTemplateUrl(url) {
            return SERVER_API_URL + 'public/<%= name %>' + url;
        }

    }

})();
