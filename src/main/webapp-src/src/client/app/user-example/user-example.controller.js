(function() {
    'use strict';

    angular
        .module('app.user-example')
        .controller('UserExampleController', UserExampleController);


    UserExampleController.$inject = ['$scope' , '$stateParams' , 'routerHelper', "UserExampleService" , "formValidator"];

    function UserExampleController($scope, $stateParams , routerHelper, UserExampleService , formValidator) {
        var vm = this;
        vm.formValidator = formValidator;
        vm.user = {};

        init();

        function init() {
            if( $stateParams.userId) {
                var promise = UserExampleService.getUser($stateParams.userId);
                promise.then(function(user){
                    vm.user = user;
                });
            }
        }


        vm.saveOrUpdate = function() {
            
            console.log(vm.user);

            if (vm.user.id) {
                var promise = UserExampleService.update(vm.user);
            } else {
                var promise = UserExampleService.add(vm.user);
            }

            promise.then(function() {


                $.smallBox({
                    title : "提示" ,
                    content : "操作成功."  ,
                    timeout : 1000 ,
                } , function(){
                    routerHelper.go("list");
                });
            });

        }


        vm.returnList = function() {
            routerHelper.go("list");
        }

    }
})();
