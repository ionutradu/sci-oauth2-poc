(function() {
	"use strict";

	angular.module("app").controller("HomeController",
			[ "$scope", "$http", "ResourceService", homeController ]);

	function homeController($scope, $http, ResourceService) {
	    $scope.loading = true;
		$scope.getData = function() {
			$scope.data = {};
			ResourceService.get(function(response) {
			    location.href = "http://localhost:8080" + response.url;
			});
		}
	}
}());