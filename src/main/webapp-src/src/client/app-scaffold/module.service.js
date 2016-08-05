(function() {
    'use strict';

    angular.module('<%= module %>').factory('<%= service %>', <%= service %>);

    <%= service %>.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function <%= service %>(restfulHelper, SERVER_API_URL) {
        var service = {
        };
        return service;
    }
})();
