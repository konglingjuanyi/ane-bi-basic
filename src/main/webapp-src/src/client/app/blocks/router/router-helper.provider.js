(function() {
    'use strict';

    angular
        .module('blocks.router')
        .provider('routerHelper', RouterHelperProvider);

    RouterHelperProvider.$inject = ['$locationProvider', '$stateProvider', '$urlRouterProvider'];

    /* @ngInject */
    function RouterHelperProvider($locationProvider, $stateProvider, $urlRouterProvider) {

        var config = {
            docType: undefined,
            resolveAlways: {}
        };

        $locationProvider.html5Mode(false);

        this.configure = function(cfg) {
            angular.extend(config, cfg);
        };

        this.$get = RouterHelper;
        RouterHelper.$inject = ['$location', '$rootScope', '$state'];

        function RouterHelper($location, $rootScope, $state) {
            var handlingStateChangeError = false;
            var hasOtherwise = false;
            var stateCounts = {
                errors: 0,
                changes: 0
            };

            var service = {
                configureStates: configureStates,
                getStates: getStates,
                go: go,
                stateCounts: stateCounts
            };

            init();

            return service;

            function configureStates(states, otherwisePath) {
                // alert('ddd');
                // alert(JSON.stringify(states));
                states.forEach(function(state) {
                    state.config.resolve =
                        angular.extend(state.config.resolve || {}, config.resolveAlways);
                    $stateProvider.state(state.state, state.config);
                });

                if (otherwisePath && !hasOtherwise) {
                    hasOtherwise = true;
                    $urlRouterProvider.otherwise(otherwisePath);
                }

                $urlRouterProvider.when("", "/");
            }

            function go(stateName, options) {
                $state.go(stateName, options || {});
            }

            function getStates() {
                return $state.get();
            }

            function init() {
                handleRoutingErrors();
                updateDocTitle();
            }


            function handleRoutingErrors() {
                // Route cancellation:
                // Provide an exit clause if it tries to do it twice.
                $rootScope.$on('$stateChangeError',
                    function(event, toState, toParams, fromState, fromParams, error) {
                        if (handlingStateChangeError) {
                            return;
                        }
                        stateCounts.errors++;
                        handlingStateChangeError = true;
                        var destination = (toState &&
                                (toState.title || toState.name || toState.loadedTemplateUrl)) ||
                            'unknown target';
                        var msg = 'Error routing to ' + destination + '. ' +
                            (error.data || '') + '. <br/>' + (error.statusText || '') +
                            ': ' + (error.status || '');



                        $location.path('/');
                    }
                );
            }

            function updateDocTitle() {
                $rootScope.$on('$stateChangeSuccess',
                    function(event, toState, toParams, fromState, fromParams) {
                        stateCounts.changes++;
                        handlingStateChangeError = false;
                        var title = config.docTitle + ' ' + (toState.title || '');
                        $rootScope.title = title; // data bind to <title>
                    }
                );
            }
        }
    }

})();
