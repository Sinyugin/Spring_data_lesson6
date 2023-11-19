angular.module('market', []).controller('indexController', function ($scope, $http) {

    $scope.loadProducts = function () {
        $http.get('http://localhost:8080/api/v1/products').then(function (response) {
                $scope.productsList = response.data.content;
                console.log(response);
            })
    }

    $scope.addNewProduct = function () {
        $http.post('http://localhost:8080/api/v1/products', $scope.newProduct)
            .then(function (responce) {
                $scope.loadProducts();
            })
    }
    
    $scope.deleteProductById = function (productId) {
        $http.delete('http://localhost:8080/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        })
    }

    $scope.loadProducts();

});