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
        ]).config(["$routeProvider", function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : './App/Application/Home/home.html',
				controller : 'HomeController'
			}).otherwise({
				redirectTo : '/'
			});
		} ]);
})();