(function() {
	"use strict";

	angular.module("app").controller("HomeController",
			["$scope", "$location", "$cookieStore", "AuthService", homeController]);

	function homeController($scope, $location, $cookieStore, AuthService) {
	    $scope.formData = {username: "", password: ""};
	    $scope.unauth = false;
	    $scope.signIn = function (formData) {
	    	var queryParams = $location.search();
	    	AuthService.get({client_id: queryParams.client_id, response_type: queryParams.response_type, callback_uri: queryParams.callback_uri, username: formData.username, password: formData.password}, function(response){
	    		$cookieStore.put("authorization_code", response.authorization_code);
	    		$cookieStore.put("username", response.username);
	    		location.href = "http://localhost:8090";
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