(function() {
    'use strict';

    angular.module('blocks.utils').directive('fileInput', ['$parse', function($parse) {
        return {
            restrict: 'A',
            link: function(scope, elem, attrs) {
                elem.bind("change", function() {
                    $parse(attrs.fileInput).assign(scope, elem[0].files[0]);
                    scope.$apply();
                });
            }
        };
    }]);

})();

