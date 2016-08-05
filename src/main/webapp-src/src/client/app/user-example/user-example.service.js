(function() {
    'use strict';

    angular
        .module('app.user-example')
        .factory('UserExampleService', UserExampleService);


    UserExampleService.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function UserExampleService(restfulHelper, SERVER_API_URL) {
        var service = {
            getUsers: getUsers,
            getUsers2: getUsers2,
            getUser: getUser,
            update: update,
            remove: remove,
            add: add
        };
        return service;


        function getUsers() {
            return restfulHelper.get(SERVER_API_URL + "api/users");
        }

        function getUsers2(p) {


            return restfulHelper.get(SERVER_API_URL + "api/users2?p=" + p );
        }

        function getUser(userId) {
            return restfulHelper.get(SERVER_API_URL + "api/user/" + userId);
        }

        function update(user) {
            return restfulHelper.put(SERVER_API_URL + "api/user/" + user.id, user);
        }

        function remove(user) {
            return restfulHelper.delete(SERVER_API_URL + "api/user/" + user.id);
        }

        function add(user) {
            return restfulHelper.post(SERVER_API_URL + "api/user", user);
        }

    }
})();
