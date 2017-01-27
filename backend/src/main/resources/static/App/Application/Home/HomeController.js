(function() {
	"use strict";

	angular.module("app").controller("HomeController",
			[ "$scope", "ResourceService", homeController ]);

	function homeController($scope, ResourceService) {
	    $scope.loading = true;
		$scope.getData = function() {
			$scope.data = {};
			
			ResourceService.get(function(response) {
			    console.log(response);
			    $scope.loading = false;
			});
		//	$scope.loading = false;
		};
	}
}());