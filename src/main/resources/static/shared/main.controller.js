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

        $state.go('authentication', true);
    }

})();