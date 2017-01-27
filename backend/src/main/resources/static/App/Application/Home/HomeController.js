(function() {
	"use strict";

	angular.module("app").controller("HomeController",
			[ "$scope", "$http", "$cookieStore","ResourceService", homeController ]);

	function homeController($scope, $http, $cookieStore, ResourceService) {
	    $scope.loading = true;
	    $scope.resourceUrl = "";
		$scope.getData = function(req) {
			$scope.data = {};
			if($scope.authCode && $scope.user) {
				ResourceService.get({authorization_code: $scope.authCode}, function(response) {
				    $scope.resourceUrl = response.url;
				    $scope.loading = false;
				});
			} else if (req) {
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
		
		$scope.logOut = function() {
			$cookieStore.remove("authorization_code");
			$cookieStore.remove("username");
			
			$scope.checkAuth();
		}
		
		$scope.checkAuth();
	}
}());