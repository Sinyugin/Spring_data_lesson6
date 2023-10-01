angular.module('market', []).controller('indexController', function ($scope, $http) {

    $scope.loadProducts = function () {
        $http.get('http://localhost:8080/api/v1/app/products').then(function (response) {
            $scope.productsList = response.data;
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.get('http://localhost:8080/api/v1/app/products/delete/' + productId).then(function (response) {
            $scope.loadProducts();
        })
    }

    $scope.loadProducts();

});