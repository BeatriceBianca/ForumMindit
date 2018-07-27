(function() {

    'use strict';

    angular
        .module("minditForum")
        .controller("HomeController", Controller);

    Controller.$inject = [
        '$scope',
        '$rootScope',
        '$state',
        '$http',
        'HomeService',
        'SharedService'
    ];

    function Controller($scope,
                        $rootScope,
                        $state,
                        $http,
                        HomeService,
                        SharedService) {

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

        vm.showAll = function(){
            HomeService.find()
                .then(function (response) {
                    vm.Questions = response.data;
                    vm.myquestions = "";
                })
        }

        vm.toLogin = function (question) {

            if($rootScope.dsp != true)
            {
                $state.go("authentication", true);
                $('#myModal').modal('toggle');
            }
            else{
                var answer = {
                    qId : vm.selectedQuestion.questId,
                    userName: $rootScope.usr,
                    ansText: vm.ans
                }

                SharedService.addAns(answer)
                    .then(function(response){
                        alert("Answer added");
                        vm.ans = "";
                    }, function (reason) {
                        alert("Error");
                    })
            }


        }

        vm.toLogin1 = function () {

            if($rootScope.dsp != true)
                $state.go("authentication", true);
            else
            {

            }


        }

        vm.toPP = function () {

            $state.go("profilepage", true);

        }

        vm.toLogin2 = function () {

            if($rootScope.dsp != true)
                {
                    $state.go("authentication", true);
                    $('#myModal1').modal('toggle');
                }
            else
            {
            }

        }

        vm.addQuest = function(){

            var question ={
                userName: $rootScope.usr,
                questText: vm.quest
            }

            SharedService.addQuest(question)
                .then(function (response) {
                    alert("Question added");
                    vm.quest = "";

                }, function (reason) {
                    alert("Error");
                });
        }



    }

})();