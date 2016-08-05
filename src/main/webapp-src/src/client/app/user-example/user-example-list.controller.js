(function() {
    'use strict';

    angular
        .module('app.user-example')
        .controller('UserExampleListController', UserExampleListController);


    UserExampleListController.$inject = ['$scope', 'routerHelper', "UserExampleService" , "Pagination"];

    function UserExampleListController($scope, routerHelper, UserExampleService , Pagination) {
        var vm = this;
        vm.users = [];

        init();

        function init() {
            refresh();
        }


        vm.addUser = function() {
            routerHelper.go("new");
        }


        vm.editUser = function(user) {
            routerHelper.go("edit", { userId: user.id });
        }

        vm.deleteUser = function(user) {
            var promise = UserExampleService.remove(user.id);
            promise.then(function() {
                refresh();
            });
        }

        vm.paginationHandler = function(){
            if( vm.users) {
                return Pagination.create( vm.users  , function(index){
                    // console.log(index);
                    refresh(index);
                });
            }
        }

        function refresh( p) {
            // var promise = UserExampleService.getUsers();
            // promise.then(function(users) {
            //     console.log(users);
            //     vm.users = users;
            // });

            var promise2 = UserExampleService.getUsers2( p || 1);
            promise2.then(function(users) {
                console.log(users);
                vm.users = users;

            });
        }
    }
})();
