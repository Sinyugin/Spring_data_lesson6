angular.module('market', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {

    $scope.tryToAuth = function () {
        $http.post('http://localhost:5555/auth/auth', $scope.user)
            .then(function successCallback(response) {
                // console.log(response.data.token);
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.MarketUser = {username: $scope.user.username, token: response.data.token};

                    // $scope.user.username = null;
                    // $scope.user.password = null;
                    // console.log($scope.user.username);
                }
            }, function errorCallback(response) {
            });
    };

$scope.tryToLogout = function () {
    $scope.clearUser();
    $scope.user = null;
};

$scope.clearUser = function () {
    delete $localStorage.MarketUser;
    $http.defaults.headers.common.Authorization = '';
};

$scope.isUserLoggedIn = function () {
    if ($localStorage.MarketUser) {
        return true;
    } else {
        return false;
    }
};

if ($localStorage.MarketUser) {
    try {
        let jwt = $localStorage.MarketUser.token;
        let payload = JSON.parse(atob(jwt.split('.')[1]));
        let currentTime = parseInt(new Date().getTime() / 1000);
        if (currentTime > payload.exp) {
            console.log("Token is expired!!!");
            delete $localStorage.MarketUser;
            $http.defaults.headers.common.Authorization = '';
        }
    } catch (e) {
    }
    $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.MarketUser.token;
}

$scope.loadProducts = function () {
    // $http.get('http://localhost:8080/api/v1/app/products')

    $http({
        url: 'http://localhost:5555/core/api/v1/products',
        method: 'GET',
        params: {
            min_price: $scope.filter ? $scope.filter.min_price : null,
            max_price: $scope.filter ? $scope.filter.max_price : null,
            title_part: $scope.filter ? $scope.filter.title_part : null,
            p: $scope.filter ? $scope.filter.p : null
        }
    })

        .then(function (response) {
            $scope.productsList = response.data.content;
            console.log(response);
        });
}

$scope.createOrder = function () {
    const headers = ({ 'username': $localStorage.MarketUser ? $localStorage.MarketUser.username : $scope.user.username });
    $http.post('http://localhost:5555/core/api/v1/orders',{}, { headers }).then(function (response) {
        alert('Заказ оформлен');
        $scope.loadCart();
    });
}

$scope.deleteProductById = function (productId) {
    $http.delete('http://localhost:5555/core/api/v1/products/' + productId).then(function (response) {
        $scope.loadProducts();
    })
}

$scope.addToCart = function (productId) {
    $http.get('http://localhost:5555/cart/api/v1/cart/add/' + productId).then(function (response) {
        $scope.loadCart();
    })
}

$scope.loadCart = function () {
    $http.get('http://localhost:5555/cart/api/v1/cart').then(function (response) {
        $scope.cart = response.data;
    });
}

$scope.cleanCart = function () {
    $http.get('http://localhost:5555/cart/api/v1/cart/clean').then(function (response) {
        $scope.cart = response.data;
    });
}

$scope.deleteProductInCart = function (productId) {
    $http.get('http://localhost:5555/cart/api/v1/cart/delete/' + productId).then(function (response) {
        $scope.loadCart();
    });
}

$scope.loadProducts();
$scope.loadCart();

})
;