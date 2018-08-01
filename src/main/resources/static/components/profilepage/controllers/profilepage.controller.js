(function() {

    'use strict';

    angular
        .module("minditForum")
        .controller("ProfilePageController", Controller);

    Controller.$inject = [
        '$scope',
        '$rootScope',
        '$state',
        'ProfilePageService',
        'SharedService'
    ];

    function Controller($scope,
                        $rootScope,
                        $state,
                        ProfilePageService,
                        SharedService) {

        var vm = this;

        function init(){
            $rootScope.flag = 0;
            vm.editMode = false;
            var un = sessionStorage.getItem("username");
            var display = sessionStorage.getItem("display");

            if(un !=null && display !=null && $rootScope.usr==null){
                $rootScope.dsp = display;
                $rootScope.usr = un;
            } else {

            }
        }
        init();

        window.onbeforeunload = function (ev) {
            sessionStorage.setItem("username", $rootScope.usr);
            sessionStorage.setItem("display", $rootScope.dsp);
        }

        vm.search = function(){
            vm.result1 = "";
            vm.result2 = "";

            ProfilePageService.searchQuest(vm.input)
                .then(function (response) {

                    vm.result1 = response.data;
                    vm.questions = "";
                    vm.myquestions = "";
                    vm.myAnsQuests = "";

                })

            ProfilePageService.searchAns(vm.input)
                .then(function (response2) {

                    vm.result2 = response2.data;
                    vm.questions = "";
                    vm.myquestions = "";
                    vm.myAnsQuests = "";

                })


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

        vm.addAns = function(){

            var answer = {
                qId : vm.selectedQuest.questId,
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

        vm.showAll = function(){
            ProfilePageService.find()
                .then(function (response) {
                    vm.questions = response.data;
                    vm.myquestions = "";
                    vm.shw = false;
                    vm.myAnsQuests = "";
                    vm.result = "";
                    vm.show = true;
                    vm.result1 = "";
                    vm.result2 = "";
                })
        }

        vm.deleteQuestion = function(){
            var question = vm.selectedQuest;
            ProfilePageService.deleteQuestion(question)
                .then(function (response) {
                    alert("Delete");
                }, function (reason) {
                    alert("Error");
                });
        }

        vm.deleteAnswer = function(){
            var answer = vm.selectedAnswer;
            ProfilePageService.deleteAnswer(answer)
                .then(function (response) {
                    alert("Delete");
                }, function (reason) {
                    alert("Error");
                });
        }


        vm.modal = function(quest){
            vm.selectedQuest = quest;
            ProfilePageService.answer(vm.selectedQuest.questId)
                .then(function (response) {
                    vm.answers = response.data;
                })
        }

        vm.modal2 = function(answer){
            vm.selectedAnswer = answer;
        }

        vm.modal3 = function(answer){
            vm.selectedAnswer = answer;
            ProfilePageService.question(vm.selectedAnswer.qId)
                .then(function (response) {
                    vm.quest = response.data;
                    ProfilePageService.answer(vm.quest.questId)
                        .then(function (response) {
                            vm.ans = response.data;
                        })
                })

        }



        $(document).ready(function(){

            $("#myModal1").on('hide.bs.modal', function () {

                vm.answers = "";

            });
        });

        vm.myQuest = function(){
             ProfilePageService.myquest($rootScope.usr)
                 .then(function (response) {
                     vm.myquestions = response.data;
                     vm.questions = "";
                     vm.shw = true;
                     vm.myAnsQuests = "";
                     vm.result = "";
                     vm.show = false;
                     vm.result1 = "";
                     vm.result2 = "";
                 }, function (reason) {
                     vm.questions = "";
                     vm.myAnsQuests = "";
                     vm.result = "";
                     vm.result1 = "";
                     vm.result2 = "";
                 })
        }

        vm.enableEditMode = function(){

            vm.editMode = true;
            alert(vm.editMode);
        }

        vm.update = function () {

            ProfilePageService.updateQuestion(vm.selectedQuest)
                .then(function (response) {
                    vm.editMode = false;
                });

        }

        vm.updateAnswer = function () {

            ProfilePageService.updateAnswer(vm.selectedAnswer)
                .then(function (response) {
                    vm.editMode = false;
                });

        }

        vm.myAnsQuest = function(){
            ProfilePageService.myAnsQuest($rootScope.usr)
                .then(function(response){
                    vm.myAnsQuests = response.data;
                    vm.myquestions = "";
                    vm.questions = "";
                    vm.result = "";
                    vm.show = false;
                    vm.result1 = "";
                    vm.result2 = "";
                }, function (reason) {
                    vm.myquestions = "";
                    vm.questions = "";
                    vm.show = false;
                    vm.result1 = "";
                    vm.result2 = "";
                })
        }

        vm.LogOut = function () {

            $rootScope.dsp = null;
            $rootScope.flag = 1;
            $rootScope.usr = "";
            sessionStorage.removeItem("username");
            sessionStorage.removeItem("display");
            sessionStorage.clear();
            $state.go("home", true);

        }


    }

})();