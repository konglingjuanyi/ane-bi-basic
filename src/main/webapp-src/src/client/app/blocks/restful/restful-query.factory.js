(function() {
    'use strict';

    angular
        .module('blocks.restful')
        .factory('restfulQuery', restfulQueryFactory);


    restfulQueryFactory.$inject = ['$q', 'restfulHelper'];
    // restfulQueryStatusBuilderFactory.$inject = ['restfulQuery'];

    function restfulQueryFactory($q, restfulHelper) {
        var service = {
            query: query,
            createQueryBuilder: create
        };
        return service;

        function query(url, params) {
            var result = null;
            var fnSuccess = null,
                fnError = null,
                fnBegin = null,
                fnEnd = null;
            var q = {
                success: success,
                fail: fail,
                begin: begin,
                end: end,
                last: last,
                next: next,
                first: first,
                prev: prev,
                jump: jump,
                queryInfo: queryInfo
            };
            return q;

            function success(fn) {
                fnSuccess = fn;
            }

            function fail(fn) {
                fnError = fn;
            }

            function begin(fn) {
                fnBegin = fn;
            }

            function end(fn) {
                fnEnd = fn;
            }

            function last() {
                return result && result["linkNext"] == null;
            }

            function first() {
                return result && result["linkPrevious"] == null;
            }

            function prev() {
                if (first()) {
                    return;
                }
                execute(result["linkPrevious"]["href"]);
            }

            function jump(p) {
                if (!result) {
                    return;
                }
                var url = getQueryUrl(result["linkSelf"]["href"]);
                var params = getQueryParams(result["linkSelf"]["href"]);
                var size = params["p_size"];
                var total = result.total;
                var start = (p - 1) * size + 1;
                var end = p * size;
                params["sid"] = start + "," + (end > total ? total : end);
                var queryUrl = buildQueryUrl(url, params);
                execute(queryUrl);
            }

            function queryInfo() {
                if (!result) {
                    return {};
                }

                var url = getQueryUrl(result["linkSelf"]["href"]);
                var params = getQueryParams(result["linkSelf"]["href"]);
                var size = params["p_size"] || 10;
                var total = result.total || 0;
                var totalPage = parseInt(total / size) + (total % size > 0 ? 1 : 0);
                return {
                    total: total,
                    size: size,
                    url: url,
                    totalPage: totalPage
                };
            }

            function execute(url, params) {
                var fnb = fnBegin || angular.noop;
                var fne = fnEnd || angular.noop;
                var errorCallback = fnError || angular.noop;
                fnb.apply();
                var promise = restfulHelper.get(url, params);
                promise.then(function(r) {
                    if (result && result['id'] == r["id"]) {
                        fne.apply();
                        return;
                    }
                    result = r;
                    fnSuccess(result['data']);
                    fne.apply();

                }, function(error) {
                    errorCallback(error);
                    fne.apply();
                });
            }

            function next() {
                if (last()) {
                    return;
                }
                if (result) {
                    execute(result["linkNext"]["href"]);
                } else {
                    execute(url, params);
                }
            }
        }

        function create(url, params, success , norun) {
            var _requesting = false,
                _requesting_fn = angular.noop ,
                _requesting_end_fn = angular.noop ,
                _results = [],
                _query = null,
                _success = success,
                _currentPageData = [],
                _running = !norun;

            _query = query(url, params);
            _query.begin(function() {
                _requesting = true;
                if (_requesting_fn) {
                    _requesting_fn();
                }
            });
            _query.end(function() {
                _requesting = false;
                if (_requesting_end_fn) {
                    _requesting_end_fn();
                }
            });
            _query.success(function(results) {
                _currentPageData = [];
                angular.forEach(results, function(result) {
                    _results.push(result);
                    _currentPageData.push(result);
                });

                if (_success) {
                    _success(results);
                }
            });

            if (_running) {
                _query.next();
            }

            var service2 = {
                hasNext: hasNext,
                hasPrev: hasPrev,
                isEmpty: isEmpty,
                isRequesting: isRequesting,
                setRequest: setRequest,
                next: next,
                prev: prev,
                jump: jump,
                info: queryInfo,
                results: getResult,
                currentResults: getCurrentResults,
                remove: removeResult
            };
            return service2;

            function setRequest(fn1, fn2) {
                if (fn1) {
                    _requesting_fn = fn1;
                }

                if (fn2) {
                    _requesting_end_fn = fn2;
                }
            }

            function hasNext() {
                if (_requesting) {
                    return false;
                }
                return !_query.last();
            }

            function hasPrev() {
                if (_requesting) {
                    return false;
                }
                return !_query.first();
            }

            function isEmpty() {
                if (_requesting) {
                    return false;
                }
                return _results.length == 0;
            }

            function isRequesting() {
                return _requesting;
            }

            function next(success) {
                if (success) {
                    _success = success;
                }
                _query.next();
            }

            function prev(success) {
                if (success) {
                    _success = success;
                }
                _query.prev();
            }

            function jump(p, success) {
                if (success) {
                    _success = success;
                }
                _query.jump(p);
            }

            function queryInfo() {
                return _query.queryInfo();
            }

            function getResult() {
                return _results;
            }

            function getCurrentResults() {
                return _currentPageData;
            }

            function removeResult(callback) {
                _requesting = true;
                callback = callback || angular.noop;
                var len = _results.length;
                var r = false;
                for (var i = 0; i < len; i++) {
                    r = callback(_results[i]);
                    if (r) {
                        _results.splice(i, 1);
                        break;
                    }
                }
                _requesting = false;
            }
        }


        function getQueryUrl(url) {
            return url.indexOf("?") > -1 ? url.substring(0, url.indexOf("?")) : url;
        }

        function getQueryParams(url) {
            var params = {};
            url.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(str, key, value) {
                params[key] = value;
            });
            return params;
        }

        function buildQueryUrl(url, params) {
            var querys = [];
            for (var key in params) {
                querys.push(key + "=" + params[key]);
            }
            return url + (url.indexOf("?") > -1 ? "" : "?") + querys.join("&");
        }
    }
})();
