(function() {
    'use strict';

    angular
        .module('blocks.utils')
        .factory('formValidator', formValidatorFactory);

    formValidatorFactory.$inject = [];

    function formValidatorFactory() {

        var service = {
            isValidatedOf: isValidatedOf,
            getValidationClass: getValidationClass,
            getValidationClassIngoreDirtry: getValidationClassIngoreDirtry,
            resetForm: resetForm ,
            adapterValueForm : adapterValueForm
        };

        return service;

        function isValidatedOf(ngModelController, validationTypes, requiredDirty) {
            if (requiredDirty === undefined) {
                requiredDirty = true;
            }

            if(!ngModelController) {
                return ;
            }


            var isDirty = requiredDirty ? ngModelController.$dirty : true;

            if (ngModelController !== undefined && isDirty) {
                validationTypes = validationTypes || [];

                if (typeof validationTypes === 'string') {
                    validationTypes = [validationTypes];
                }

                var invalidated = validationTypes.reduce(function(isInvalidated, type) {
                    if (ngModelController.$error[type] !== undefined) {
                        return isInvalidated || ngModelController.$error[type];
                    } else {
                        return isInvalidated;
                    }

                }, false);

                return invalidated;
            } else {
                return false;
            }
        }

        function getValidationClass(ngModelController, eClass, sClass) {
            if (ngModelController !== undefined && ngModelController.$dirty) {

                var errorClass = eClass || 'has-error';
                var succussClass = sClass || 'has-success';

                return ngModelController.$invalid ? errorClass : succussClass;
            } else {
                return '';
            }
        }

        function getValidationClassIngoreDirtry(ngModelController, eClass, sClass) {
            if (ngModelController !== undefined) {

                var errorClass = eClass || 'state-error';
                var succussClass = sClass || 'state-success';

                return ngModelController.$invalid ? errorClass : succussClass;
            } else {
                return '';
            }
        }

        function resetForm(form) {
            form.$setPristine();
        }

        function adapterValueForm(form){
            var inputs = angular.element("[name=" + form.$name + "]").find(":input");
            var values = {};
            angular.forEach( inputs , function(input){
                var ele = angular.element(input);
                if( ele.attr("name") &&  ele.val()) {
                    values[ele.attr("name")] = ele.val();
                }
            })
            return values;
        }
    }

})();
