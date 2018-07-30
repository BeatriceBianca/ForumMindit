(function() {

    'use strict';

    angular
        .module("minditForum")
        .controller("LogRegController", Controller);

    Controller.$inject = [
        '$scope',
        '$rootScope',
        '$state',
        'LogRegService'
    ];

    function Controller($scope,
                        $rootScope,
                        $state, LogRegService) {

         var vm = this;

        vm.register = function(){
            var user = {
                firstName: vm.firstName,
                lastName: vm.lastName,
                userName: vm.userName,
                password: vm.password
            }

            if(vm.password != vm.rpassword){
                $scope.info = "Please retype your password."
                vm.password = "";
                vm.rpassword = "";
                return;
            }

            LogRegService
                .verifyUser(user)
                .then(function (value) {
                    $scope.info = "Username already taken. Please choose another one.";
                    vm.userName = "";
                },function (reason) {
                    LogRegService.register(user)
                        .then(function(value){
                            $scope.info = "";
                            alert("User added");
                            $state.go('authentication',true);
                        }, function (reason) {
                            alert("Nu merge");
                        });
                })

        }

        vm.login = function(){
            var user = {
                userName: vm.luserName,
                password: vm.lpassword
            };

            LogRegService
                .login(user)
                .then(function(response){
                    $rootScope.usr = vm.luserName;
                    $rootScope.dsp = true;
                    $('#myModal').modal('toggle');
                    $state.go("home",true);

                }, function () {
                    $scope.fail = "Username or passsword is incorrect!"
                    vm.luserName = "";
                    vm.lpassword = "";
                });

        }


    }

})();