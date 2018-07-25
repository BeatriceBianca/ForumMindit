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

                }
            })
            .state('authentication', {
                url: '/authentication',
                parent: 'main',
                templateUrl: './components/LogReg/views/logreg.html',
                controller: 'LogRegController as lrCtrl',
                params: {

                }
            })
            .state('profilepage', {
                url: '/profilepage',
                parent: 'main',
                templateUrl: './components/profilepage/views/profilepage.html',
                controller: 'ProfilePageController as ppCtrl',
                params: {

                }
            })


    }

})();