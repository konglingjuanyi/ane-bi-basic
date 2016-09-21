(function() {
    'use strict';

    angular.module('blocks.utils').directive('ngPagination', [function() {
        return {
            restrict: 'A',
            replace: true,
            scope: {
                query: '=ngPagination'
            },
            template: '<ul class="pagination white-frame">' +
                '<li ng-class="{disabled : isFirst()}"><a  href="javascript:void(0)" ng-click="prev()">上一页</a></li>' +
                '<li ng-repeat="p in getPages()" ng-class="{active:isCureent(p)}"><a href="javascript:void(0)" ng-click="jump(p)">{{p}}</a></li>' +
                '<li ng-class="{disabled : isLast()}"><a href="javascript:void(0)" ng-click="next()">下一页</a></li></ul>',

            link: function(scope, elem, attrs) {
                var currentPage = 1;
                var total = 0;
                scope.getPages = function() {
                    var totalPage = getQuery().totalPage || 0;
                    if (totalPage != total) {
                        currentPage = 1;
                        total = totalPage;
                    }
                    var pages = [];
                    var start = currentPage > 5 ? currentPage - 5 : 1;
                    var end = totalPage - start >= 9 ? start + 9 : totalPage;
                    if (totalPage - start < 10) {
                        start -= 9 - (totalPage - start);
                    }
                    if (start <= 0) {
                        start = 1;
                    }
                    for (var i = start; i <= end; i++) {
                        pages.push(i);
                    }
                    return pages;
                }
                scope.next = function() {
                    if (getQuery().hasNext( currentPage )) {
                        currentPage++;
                        getQuery().jump(currentPage);
                    }
                   
                }
                scope.prev = function() {
                    // getQuery().current(currentPage);
                    if (getQuery().hasPrev(currentPage)) {
                        currentPage--;
                        getQuery().jump(currentPage);
                    }
                   
                }
                scope.jump = function(p) {
                    if (currentPage != p) {
                        currentPage = p;
                        getQuery().jump(p);
                    }
                }
                scope.isCureent = function(p) {
                    return currentPage == p;
                }
                scope.isFirst = function() {
                    return !getQuery().hasPrev(currentPage);
                }
                scope.isLast = function() {
                    return !getQuery().hasNext(currentPage);
                }

                function getQuery() {
                    return scope.query() || {
                        hasNext: function() {
                            return false;
                        },
                        hasPrev: function() {
                            return false;
                        }
                    };
                }

            }
        };
    }]);

    angular.module('blocks.utils').factory('Pagination', PaginationFactory);

    PaginationFactory.$inject = [];

    function PaginationFactory() {
        var service = {
            create: createPagination
        };
        return service;

        function createPagination(data, call) {
            var limit = data.limit;
            var total = data.total;
            var current = data.current;
            var ser = {
                jump: call,
                hasNext: hasNext,
                hasPrev: hasPrev,
                totalPage: totalPage() ,
                current: current
            };
            return ser;

            function totalPage(){
//                var p = total/ limit;
//                if (total % limit != 0 ) {
//                    p++;
//                } 
//                return p;
            	  return Math.ceil(total/limit);
            }

            function hasPrev(aCurrent, aLimit) {
                reset(aCurrent , aLimit);
                return (current - 1) * limit > 0;
            }

            function hasNext(aCurrent, aLimit) {
                reset(aCurrent , aLimit);
                return (current) * limit < total;
            }

            function reset(aCurrent, aLimit) {
                if (aLimit) {
                    limit = aLimit;
                }
                if (aCurrent) {
                    current = aCurrent;
                }
            }
        }
    }

})();
