(function() {
    'use strict';

    angular.module('<%= module %>').controller('<%= controller %>', <%= controller %>);

    <%= controller %>.$inject = ['$scope' ,  "formValidator"];

    function <%= controller %>($scope , formValidator) {
        var vm = this;
        vm.formValidator = formValidator;

        init();

        function init() {
        }
    }
})();
