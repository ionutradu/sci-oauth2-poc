﻿(function () {
    "use strict";

    var serviceMetods = {
        get: { method: "GET" },
        create: { method: "POST" },
        update: { method: "PUT" },
        patch: { method: "PATCH" },
        remove: { method: "DELETE" }
    };

    angular.module('services', ['ngResource'])
	    .factory('ResourceService', ['$resource', function ($resource) {
	        return $resource('/app/profile/picture', { }, serviceMetods);
	    }]);
}());
