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

            function verifyUser(user){
                return $http.get("/verifyuser?userName=" + user.userName, null);
            }

            return {
                register:register,
                login: login,
                verifyUser: verifyUser
            };

        }]);

})();