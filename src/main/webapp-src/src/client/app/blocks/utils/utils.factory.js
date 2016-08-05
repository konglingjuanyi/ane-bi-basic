(function() {
    'use strict';


    Date.prototype.format = function(fmt) { //author: meizz 
        var o = {
            "M+": this.getMonth() + 1, //月份 
            "d+": this.getDate(), //日 
            "h+": this.getHours(), //小时 
            "m+": this.getMinutes(), //分 
            "s+": this.getSeconds(), //秒 
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
            "S": this.getMilliseconds() //毫秒 
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };


    angular
        .module('blocks.utils')
        .factory('FormatUtils', FormatUtilsFactory);

    FormatUtilsFactory.$inject = [];

    function FormatUtilsFactory() {
        var set = {
            format: format,
            formatChina: formatChinaTime,
            formatDate: formatDate,
            fromNow: fromNow
        };
        return set;

        function format( time , pattern ){

            if( !time ) {
                return "";
            }
            return new Date(time).format(pattern);
        }

        function formatChinaTime(times) {
            var days = Math.floor(times / (24 * 3600 * 1000));
            var hours = Math.floor(times % (24 * 3600 * 1000) / (3600 * 1000));
            var minutes = Math.floor(times % (3600 * 1000) / (60 * 1000));
            var seconds = Math.floor(times % (60 * 1000) / 1000);
            if (seconds == 0) {
                return days + "天" + hours + "小时" + minutes + "分钟";
            }
            return days + "天" + hours + "小时" + minutes + "分钟" + seconds + "秒";
        }

        function formatDate(time, format) {
            if (!time) {
                return "";
            }
            return moment(time).format(format);
        }

        function fromNow(time) {
            if (!time) {
                return "";
            }
            var text = moment(time).fromNow();
            return text.replace(/\s/ig, '');
        }
    }


    angular
        .module('blocks.utils')
        .factory('Set', ArraySetFactory);

    ArraySetFactory.$inject = [];

    function ArraySetFactory() {
        var set = {
            create: createHashSet
        };
        return set;

        function createHashSet() {
            var _values = [];
            var set = {
                add: add,
                remove: remove,
                values: values,
                size: size,
                contains: contains
            };

            return set;

            function add(value) {
                if (!contains(value)) {
                    _values.push(value);
                }
            }

            function remove(value) {
                if (contains(value)) {
                    for (var i = 0; i < _values.length; i++) {
                        if (_values[i] == value) {
                            _values.splice(i, 1);
                            break;
                        }
                    }
                }
            }

            function contains(value) {
                for (var i = 0; i < _values.length; i++) {
                    if (_values[i] == value) {
                        return true;
                    }
                }
                return false;
            }

            function values() {
                return _values;
            }

            function size() {
                return _values.length;
            }
        }
    }

    angular
        .module('blocks.utils')
        .factory('Queue', QueueFactory);

    QueueFactory.$inject = [];

    function QueueFactory() {
        var que = {
            create: ArrayQueue
        }
        return que;


        function ArrayQueue() {
            var _data = [];
            var service = {
                isEmpty: isEmpty,
                size: size,
                add: add,
                pop: pop
            }
            return service;

            function isEmpty() {
                return _data == null || _data.length == 0;
            }

            function size() {
                return _data.length;
            }

            function add(ele) {
                _data.push(ele);
            }

            function pop() {
                if (isEmpty()) {
                    return null;
                } else {
                    return _data.shift();
                }
            }
        }
    }

    angular
        .module('blocks.utils')
        .factory('Map', MapFactory);

    MapFactory.$inject = [];

    function MapFactory() {
        var m = {
            create: HashMap
        }
        return m;

        function HashMap() {
            var _len = 0;
            var _data = {};
            var service = {
                isEmpty: isEmpty,
                size: size,
                contains: contains,
                put: put,
                get: get,
                remove: remove,
                values: values,
                forEach: forEach
            };
            return service;

            function isEmpty() {
                return _len == 0;
            }

            function size() {
                return _len;
            }

            function contains(key) {
                if (_data[key]) {
                    return true;
                } else {
                    return false;
                }
            }

            function put(key, value) {
                _data[key] = value;
            }

            function get(key) {
                if (contains(key)) {
                    return _data[key];
                } else {
                    return null;
                }
            }

            function remove(key) {
                if (contains(key)) {
                    delete _data[key];
                }
            }

            function values() {
                return _data;
            }

            function forEach(fn) {
                for (var k in _data) {
                    if (fn) {
                        fn(_data[k]);
                    }
                }
            }
        }
    }



    angular
        .module('blocks.utils')
        .factory('LocUtils', LocUtilsFactory);

    LocUtilsFactory.$inject = ['$window', 'SERVER_API_URL', '$location'];

    function LocUtilsFactory($window, SERVER_API_URL, $location) {
        var set = {
            go: go,
            last: last,
            index: index
        };
        return set;

        function go(url) {
            $window.location.href = SERVER_API_URL + url;
        }

        function last() {
            var url = $location.absUrl();

            if (url.substring(url.length - 1, url.length) == '/') {
                url = url.substring(0, url.length - 1);
            }

            var lastIndex = url.indexOf("?");
            if (lastIndex > -1) {
                url = url.substring(0, lastIndex);
            }
            lastIndex = url.indexOf("#");
            if (lastIndex > -1) {
                url = url.substring(0, lastIndex);
            }
            return url.split("/").pop();
        }

        function index(index) {
            var url = $location.absUrl();
            var lastIndex = url.indexOf("?");
            if (lastIndex > -1) {
                url = url.substring(0, lastIndex);
            }

            if (url.substring(url.length - 1, url.length) == '/') {
                url = url.substring(0, url.length - 1);
            }

            lastIndex = url.indexOf("#");
            if (lastIndex > -1) {
                url = url.substring(0, lastIndex);
            }

            var paths = url.split("/");
            return paths[paths.length - index];
        }
    }


})();
