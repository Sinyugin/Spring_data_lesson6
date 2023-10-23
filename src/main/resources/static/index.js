angular.module('market', []).controller('indexController', function ($scope, $http) {

    $scope.loadProducts = function () {
        // $http.get('http://localhost:8080/api/v1/app/products')

        $http({
            url: 'http://localhost:8080/api/v1/products',
            method: 'GET',
            params: {
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null,
                title_part: $scope.filter ? $scope.filter.title_part : null,
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

    $scope.addToCart = function (productId) {
        $http.get('http://localhost:8080/api/v1/cart/add/' + productId).then(function (responce){
            $scope.loadCart();
        })
    }

    $scope.loadCart = function(){
        $http.get('http://localhost:8080/api/v1/cart').then(function(response){
            $scope.cart = response.data;
        });
    }

    $scope.cleanCart = function(){
        $http.get('http://localhost:8080/api/v1/cart/clean').then(function(response){
            $scope.cart = response.data;
        });
    }

    $scope.deleteProductInCart = function(productId){
        $http.get('http://localhost:8080/api/v1/cart/delete/' + productId).then(function(response){
            $scope.loadCart();
        });
    }

    $scope.loadProducts();
    $scope.loadCart();

});