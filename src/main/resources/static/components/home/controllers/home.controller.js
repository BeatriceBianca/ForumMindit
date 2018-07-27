(function() {

    'use strict';

    angular
        .module("minditForum")
        .controller("HomeController", Controller);

    Controller.$inject = [
        '$scope',
        '$state',
        '$http',
        'HomeService'
    ];

    function Controller($scope,
                        $state,
                        $http,
                        HomeService) {

        var vm = this;

        function init(){

            HomeService.bringQuestions()
                .then(function(response){
                    vm.Questions = response.data;
            })

        }
        init();



        vm.modal = function (question) {
            vm.selectedQuestion = question;
            HomeService.getAnswers(question.questId)
                .then(function(response){
                    vm.Answers = response.data;
                })

        }

        vm.toLogin = function(){
            $('#myModal').modal('toggle');
            $state.go("authentication",true);
        }

        vm.toLogin1 = function(){
            $state.go("authentication",true);
        }

        vm.toPP = function(){
            $state.go("profilepage",true);
        }

    }

})();