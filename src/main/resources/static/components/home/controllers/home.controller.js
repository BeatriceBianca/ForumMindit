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
            if($rootScope.flag == null){
                $rootScope.flag = sessionStorage.getItem("flag");
            }

            HomeService.bringQuestions()
                .then(function(response){
                    vm.Questions = response.data;


            })

            if($rootScope.usr == ""){
                sessionStorage.clear();
                window.location.reload();
            }

            var un = sessionStorage.getItem("username");
            var display = sessionStorage.getItem("display");
            if($rootScope.usr == null && $rootScope.flag == 0)
                if(un != null && display != null){
                    $rootScope.dsp = display;
                    $rootScope.usr = un;
                } else {

                }

        }

        init();

        window.onbeforeunload = function (ev) {
            sessionStorage.setItem("flag", $rootScope.flag);
            sessionStorage.setItem("username", $rootScope.usr);
            sessionStorage.setItem("display", $rootScope.dsp);
        }

        vm.modal = function (question) {
            vm.selectedQuestion = question;
            HomeService.getAnswers(question.questId)
                .then(function(response){
                    vm.Answers = response.data;
                }, function (reason) {
                    vm.Answers = "";
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

                        $('#myModal1').modal('toggle');
                        $state.go("authentication", true);

                    }

                    else {

                }

        }

        vm.addQuest = function(){

            var question ={
                userName: $rootScope.usr,
                questText: vm.quest
            }

            SharedService.addQuest(question)
                .then(function (response) {
                    vm.quest = "";

                }, function (reason) {
                    alert("Error");
                });
        }

    }

})();