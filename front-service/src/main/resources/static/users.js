angular.module('market', []).controller('indexController', function ($scope, $http) {

    $scope.loadUsers = function () {
        $http.get('http://localhost:5555/auth/api/v1/users').then(function (response) {
            $scope.usersList = response.data;
            console.log(response);
        })
    }
    $scope.loadUsers();
});