(function() {
    'use strict';

    angular
        .module('app.role')
        .factory('RoleService', RoleService);


    RoleService.$inject = ['restfulHelper', 'SERVER_API_URL'];

    function RoleService(restfulHelper, SERVER_API_URL) {
        var service = {
        	getRoles: getRoles,
            getRoles2: getRoles2,
            getRole: getRole,
            update: update,
            remove: remove,
            add: add,
            getResource : getResource,
            saveRoleResource:saveRoleResource,
        };
        return service;


        function getRoles() {
            return restfulHelper.get(SERVER_API_URL + "api/roles");
        }

        function getRoles2(p,s,name) {
            return restfulHelper.get(SERVER_API_URL + "api/roles2?p=" + p + "&s=" + s + "&name=" + name );
        }

        function getRole(roleId) {
            return restfulHelper.get(SERVER_API_URL + "api/role/" + roleId);
        }

        function update(role) {
            return restfulHelper.put(SERVER_API_URL + "api/role/" + role.id, role);
        }

        function remove(id) {
            return restfulHelper.delete(SERVER_API_URL + "api/role/" + id);
        }
        function getResource(roleId){
        	
        	return restfulHelper.get(SERVER_API_URL + "api/queryRoleResources/" + roleId);
        }
        function add(role) {
            return restfulHelper.post(SERVER_API_URL + "api/role", role);
        }
        function saveRoleResource(roleId,resourceIds){
            return restfulHelper.post(SERVER_API_URL + "api/saveRoleResource?roleId=" + roleId+ "&resourceIds=" + resourceIds );

        }
        

    }
})();