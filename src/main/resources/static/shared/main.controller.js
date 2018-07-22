(function() {

    'use strict';

    angular
        .module("minditForum")
        .controller("MainController", Controller);

    Controller.$inject = [
        '$scope',
        '$rootScope',
        '$transitions',
        '$state'
    ];

    function Controller($scope,
                        $rootScope,
                        $transitions,
                        $state) {

        var vm = this;

        $state.go('home', true);
    }

})();