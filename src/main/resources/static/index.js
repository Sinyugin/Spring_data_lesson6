angular.module('market', []).controller('indexController', function ($scope, $http) {

    $scope.loadProducts = function () {
        // $http.get('http://localhost:8080/api/v1/app/products')

        $http({
            url: 'http://localhost:8080/api/v1/products',
            method: 'GET',
            params: {
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null,
                p: $scope.filter ? $scope.filter.p : null
            }})

        .then(function (response) {
            $scope.productsList = response.data.content;
            console.log(response);
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.delete('http://localhost:8080/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        })
    }

    $scope.loadProducts();

});