angular.module('market', []).controller('indexController', function ($scope, $http) {

    $scope.loadUsers = function () {
        $http.get('http://localhost:8080/api/v1/users').then(function (response) {
            $scope.usersList = response.data;
            console.log(response);
        })
    }
    $scope.loadUsers();
});