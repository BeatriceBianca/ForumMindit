(function () {

    'use strict';

    angular
        .module('minditForum')
        .config(Config);

    Config.$inject = [
        '$stateProvider',
        '$urlRouterProvider',
        '$locationProvider'
    ];

    function Config($stateProvider,
                    $urlRouterProvider,
                    $locationProvider) {

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