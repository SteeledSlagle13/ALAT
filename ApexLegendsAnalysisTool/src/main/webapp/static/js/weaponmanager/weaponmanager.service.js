'use strict';

angular.module('weaponManagerApp').factory('WeaponService', ['$http', function($http){

    var REST_SERVICE_URI = 'http://localhost:8085/ApexLegendsAnalysisTool/weapon/';

    var factory = {
        fetchAllWeapons: fetchAllWeapons,
        createWeapon: createWeapon,
        updateWeapon:updateWeapon,
        deleteWeapon:deleteWeapon
    };

    return factory;

    function fetchAllWeapons() {
        return $http.get(REST_SERVICE_URI);
    }

    function createWeapon(weapon) {
        return $http.post(REST_SERVICE_URI, weapon);
    }


    function updateWeapon(weapon, id) {
        return $http.put(REST_SERVICE_URI+id, weapon);
    }

    function deleteWeapon(id) {
        return $http.delete(REST_SERVICE_URI+id);
    }

}]);