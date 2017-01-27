(function() {
	"use strict";

	angular.module("app").controller("HomeController",
			[ "$scope", "$http", "ResourceService", homeController ]);

	function homeController($scope, $http, ResourceService) {
	    $scope.loading = true;
		$scope.getData = function() {
			$scope.data = {};
			
			ResourceService.get(function(response) {
			    console.log(response);
			    $scope.loading = false;
			});
		}
//	    var url = "http://localhost:8090/app/profile/picture";
//	    $http({
//	        method: 'JSONP',
//	        url: url
//	    }).
//	    success(function(status) {
//	        console.log(status)
//	    }).
//	    error(function(status) {
//	        console.log(status);
//	    });
		//	$scope.loading = false;
	}
}());