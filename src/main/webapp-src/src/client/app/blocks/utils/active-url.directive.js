(function() {
    'use strict';

    angular.module('blocks.utils').directive('activeUrl', ['$parse', '$location', 'SERVER_API_URL', function($parse, $location, SERVER_API_URL) {
        return {
            restrict: 'A',
            link: function(scope, elem, attrs) {
                var activeUrl = attrs.activeUrl;
                var urls = activeUrl.split(",");
                if (urls && urls.length > 0) {
                    var currentUrl = $location.absUrl();
                    if (currentUrl.indexOf("?") > -1) {
                        currentUrl = currentUrl.substring(0, currentUrl.indexOf("?"));
                    } else if (currentUrl.indexOf("#") > -1) {
                        currentUrl = currentUrl.substring(0, currentUrl.indexOf("#"));
                    }
                    for (var i = 0; i < urls.length; i++) {
                        if ((urls[i] == currentUrl) || (SERVER_API_URL + urls[i] == currentUrl) || buildUrl(urls[i]) == currentUrl) {
                            elem.addClass("active");
                            activeNav(elem);
                            break;
                        }
                    }
                }

                function buildUrl(url) {
                    return $location.protocol() + "://" + $location.host() + ":" + $location.port() + SERVER_API_URL + url;
                }

                function activeNav(elem) {
                    $this = $(elem);
                    $this.parents("ul").slideDown(0);
                    $this.parents("ul").parent("li").find("b:first").html('<em class="fa fa-minus-square-o"></em>');
                    $this.parents("ul").parent("li").addClass("open");
                }
            }
        };
    }]);
})();
