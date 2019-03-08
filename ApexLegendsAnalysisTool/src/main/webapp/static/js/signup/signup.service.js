'use strict';

angular
    .module('registerApp')
    .factory('userService', userService);

userService.$inject = ['$http'];

function userService($http) {

    var REST_SERVICE_URI = 'http://localhost:8085/ApexLegendsAnalysisTool/user/';

    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser
    };

    return factory;

    function fetchAllUsers() {
        return $http.get(REST_SERVICE_URI);
    }

    function createUser(user) {
        return $http.post(REST_SERVICE_URI, user);
    }
}