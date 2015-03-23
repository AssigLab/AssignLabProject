$(document).ready(function () {
    $("a.new_window").attr("target", "_blank");
});

mainApp.controller('logincontroller', function ($scope, $http, $location, authentication) {
    var url = "contact.txt";
    $http.get(url).success(function (response) {
        $scope.contacts = response;
    });
    $scope.login = function () {
        for (var i = 0; i < contacts.lenght; i++) {
            if ($scope.mail === $scope.contacts.email && $scope.password === $scope.contacts.password) {
                console.log('successful')
                authentication.isAuthenticated = true;
                authentication.user = {name: $scope.username};
                $location.url("/");
            } else {
                $scope.loginError = "Invalid username/password combination";
                console.log('Login failed..');
            }
            ;
        }
        ;
    }
});


