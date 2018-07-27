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

            LogRegService.register(user)
                .then(function(value){
                    alert("User added");
                    $state.go('authentication',true);
                }, function (reason) {
                    alert("Nu merge");
                });
        }

        vm.login = function(){
            var user = {
                userName: vm.luserName,
                password: vm.lpassword
            };
            LogRegService
                .login(user)
                .then(function(response){
                    alert("Login succeded");
                    $rootScope.usr = vm.luserName;
                    $rootScope.dsp = true;
                    $('#myModal').modal('toggle');
                    $state.go("home",true);

                }, function () {
                    alert("Gresit!")
                    vm.luserName = "";
                    vm.lpassword = "";
                });

        }


    }

})();