(function () {
    "use strict";

    var serviceMetods = {
        get: { method: "GET" },
        create: { method: "POST" },
        update: { method: "PUT" },
        patch: { method: "PATCH" },
        remove: { method: "DELETE" }
    };

    angular.module('services', ['ngResource'])
	    .factory('AuthService', ['$resource', function ($resource) {
	        return $resource('/AuthorizationResourceServer/webresources/manage/oauth2/token', {}, serviceMetods);
	    }]);
}());
