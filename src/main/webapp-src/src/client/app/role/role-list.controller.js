(function() {
    'use strict';

    angular
        .module('app.role')
        .controller('RoleListController', RoleListController);


    RoleListController.$inject = ['$scope', 'routerHelper', "RoleService" , "Pagination"];

    function RoleListController($scope, routerHelper, RoleService , Pagination) {
        var vm = this;
        vm.roles = [];
        vm.role = {};
        vm.role.name = ""; 
        vm.s = "10";
        vm.delObject = null;

        init();

        function init() {
            refresh();
        }

        vm.addRole = function() {
            routerHelper.go("new");
        }
        vm.editRole = function(role) {
            routerHelper.go("edit", { roleId: role.id });
        }
        vm.deleteModal = function(role) {
        	vm.delObject = role;
        	$('#delModal').modal();  
        }
        vm.deleteRole = function(role) {
            var promise = RoleService.remove(vm.delObject.id);
            promise.then(function() {
                refresh();
            });
        }

        vm.paginationHandler = function(){
            if( vm.roles) {
                return Pagination.create( vm.roles  , function(index){
                    // console.log(index);
                    refresh(index);
                });
            }
        }

        function refresh(p,s,name) {
        	var name = vm.role.name;
            var promise2 = RoleService.getRoles2( p || 1,s || 10,name || "");
            promise2.then(function(roles) {
                console.log(roles);
                vm.roles = roles;

            });
        }
        vm.search = function(){
        	refresh();
        }
        vm.pageNumChange = function(s)  {
        	refresh(1,s);
        	}
        }
})();

