(function() {
	"use strict";

	angular.module("app").controller("HomeController",
			[ "$scope", "$http", "$cookieStore","ResourceService", homeController ]);

	function homeController($scope, $http, $cookieStore, ResourceService) {
	    $scope.loading = true;
		$scope.getData = function() {
			$scope.data = {};
			debugger;
			if($scope.authCode && $scope.user) {
				ResourceService.get({authorization_code: $scope.authCode, username: $scope.user}, function(response) {
				    console.log(response);
				});
			} else {
				ResourceService.get(function(response) {
				    location.href = "http://localhost:8080" + response.url;
				});
			}
			
		}
		
		$scope.checkAuth = function() {
			$scope.authCode = $cookieStore.get('authorization_code');
			$scope.user = $cookieStore.get('username');
			
			$scope.getData();
		}
		
		$scope.checkAuth();
	}
}());