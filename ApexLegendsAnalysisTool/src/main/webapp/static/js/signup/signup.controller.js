'use strict';

angular.module('registerApp').controller('signupController', ['$scope', '$window', 'userService', function ($scope, $window, userService) {

    var self = this;
    self.user = {username: '', address: '', email: '', password: '' };
    self.users = [];

    self.fetchAllUsers = fetchAllUsers;
    self.createUser = createUser;
    self.checkUser = checkUser;

    fetchAllUsers();

    function fetchAllUsers() {
        console.log("Grabbing User Data");
        userService.fetchAllUsers()
            .then(
                function (d) {
                    self.users = d.data;
                },
                function (errResponse) {
                    console.error('Error fetching Users');
                }
            );
    }

    function createUser(user) {
        userService.createUser(user)
            .then(
                fetchAllUsers,
                function (errResponse) {
                    console.error('Error creating user');
                }
            );
    }

    function checkUser() {
        var user = self.users.filter(user => user.username === self.user.username)[0];

        if (user != null) {
            $window.alert('USERNAME_ALREADY_INUSE');
        } else {
            self.createUser(self.user);
            reset();
        }
    }

    function reset() {
        self.user = {username: '', address: '', email: '', password: '' };
        $scope.regform.$setPristine();
    }
}]);