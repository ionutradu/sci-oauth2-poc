(function() {
	"use strict";

	angular.module('app', 
			[ 'routes' ]).config([ "$routeProvider", "$locationProvider", function($routeProvider, $locationProvider) {
				$routeProvider.when('/home', {
					templateUrl : './Home/home.html',
					controller : 'HomeController'
				}).otherwise({
					redirectTo : '/home'
				});
			} ]);
}());
