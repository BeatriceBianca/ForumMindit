(function() {

    'use strict';

    angular
        .module('minditForum')
        .factory('LogRegService', ['$http', '$location', function($http, $location) {
            function register(user){
                return $http.put("/register",user);
            }

            function login(user){
                 return $http.get("/login?userName=" +user.userName+"&password=" + user.password,null);
            }

            return {
                register:register,
                login: login
            };

        }]);

})();