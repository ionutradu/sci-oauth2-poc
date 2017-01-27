(function() {
	"use strict";

	angular.module("app").controller("HomeController",
			["$scope", "AuthService", homeController]);

	function homeController($scope, AuthService) {
	    $scope.formData = {username: "", password: ""};
	    $scope.signIn = function (formData) {
	        console.log("aici");
	    }
	}
}());