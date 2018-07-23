(function () {

    'use strict';

    angular
        .module('minditForum')
        .config(Config);

    Config.$inject = [
        '$stateProvider'
    ];

    function Config($stateProvider) {

        $stateProvider
            .state('main', {
                abstract: true
            })
            .state('home', {
                url: '/home',
                parent: 'main',
                templateUrl: './components/home/views/home.html',
                controller: 'HomeController as homeCtrl',
                params: {
                    isLogin: true
                }
            })

    }

})();