(function() {
	"use strict";

	angular.module("app").controller("HomeController",
			["$scope", "$location", "AuthService", homeController]);

	function homeController($scope, $location, AuthService) {
	    $scope.formData = {username: "", password: ""};
	    $scope.unauth = false;
	    $scope.signIn = function (formData) {
	    	var queryParams = $location.search();
	    	AuthService.get({client_id: queryParams.client_id, response_type: queryParams.response_type, callback_uri: queryParams.callback_uri, username: formData.username, password: formData.password}, function(response){
	    		console.log(response)
	    	});
	    };
	    
	    $scope.$on('401-unauthorized', function(event, args) {
	    	$scope.unauth = true;
	    });
	    
	    $scope.showLogin = function() {
	    	$scope.unauth = false;
	    	$scope.formData = {username: "", password: ""};
	    }
	}
}());