(function () {
    "use strict";

    angular.module("app", [
            "ngRoute",
            "ngSanitize",
            "ngResource",
            "ngAnimate",
            "ngCookies",
            "ui.bootstrap",
            "directivesTheme",
            "services"
        ]).config(['$locationProvider', function($locationProvider) {
        	$locationProvider.html5Mode({
        		  enabled: true,
        		  requireBase: false
        		});
        }]).service('authInterceptor', function($q, $rootScope) {
            var service = this;

            service.responseError = function(response) {
                if (response.status == 401){
                	 $rootScope.$broadcast('401-unauthorized');
                }
                return $q.reject(response);
            };
        })
        .config(['$httpProvider', function($httpProvider) {
            $httpProvider.interceptors.push('authInterceptor');
        }]);
})();