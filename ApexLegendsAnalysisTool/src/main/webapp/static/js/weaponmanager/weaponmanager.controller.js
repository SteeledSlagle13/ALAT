'use strict';

angular.module('weaponManagerApp').controller('WeaponController', ['$scope', 'WeaponService', function($scope, WeaponService) {
    var self = this;
    
    self.weapon={
        id:null,
        name:'',
        type:'',
        imageSource:'',
        lowDPS:'',
        highDPS:'',
    };
    
    self.weapons=[];

    $scope.weapons = [];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllWeapons();

    function fetchAllWeapons(){
        WeaponService.fetchAllWeapons()
            .then(
            function(d) {
                self.weapons = d.data;
                $scope.weapons=self.weapons;
            },
            function(errResponse){
                console.error('Error fetching weapons');
            }
        );
    }

    function createWeapon(weapon){
        weapon.imageSource = 'static/images/ar/ar.png';
        WeaponService.createWeapon(weapon)
            .then(
            fetchAllWeapons,
            function(errResponse){
                console.error('Error creating weapon');
            }
        );
    }

    function updateWeapon(weapon, id){
        WeaponService.updateWeapon(weapon, id)
            .then(
            fetchAllWeapons,
            function(errResponse){
                console.error('Error updating weapon');
            }
        );
    }

    function deleteWeapon(id){
        WeaponService.deleteWeapon(id)
            .then(
            fetchAllWeapons,
            function(errResponse){
                console.error('Error deleting Weapon');
            }
        );
    }

    function submit() {
        if(self.weapon.id===null){
            console.log('New Weapon', self.weapon);
            createWeapon(self.weapon);
        }else{
            updateWeapon(self.weapon, self.weapon.id);
            console.log('update weapon', self.weapon.id);
        }
        reset();
    }

    function edit(id){
        console.log('weapon : ' + id + ' request edit.');
        for(var i = 0; i < self.weapons.length; i++){
            if(self.weapons[i].id === id) {
                self.weapon = angular.copy(self.weapons[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('delete : ', id);
        if(self.weapon.id === id) {
            reset();
        }
        deleteWeapon(id);
    }


    function reset(){
        self.weapon={id:null,name:'',type:'',imageSource:'',lowDPS:'',highDPS:''};
        $scope.weaponForm.$setPristine(); //reset Form
    }

}]);
