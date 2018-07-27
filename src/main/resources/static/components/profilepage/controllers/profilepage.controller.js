(function() {

    'use strict';

    angular
        .module("minditForum")
        .controller("ProfilePageController", Controller);

    Controller.$inject = [
        '$scope',
        '$rootScope',
        '$state',
        'ProfilePageService'
    ];

    function Controller($scope,
                        $rootScope,
                        $state,
                        ProfilePageService) {

        var vm = this;

        function init(){
            alert($rootScope.usr);

        }
        init();


        vm.search = function(){

            ProfilePageService.search(vm.input)
                .then(function (response) {
                    vm.result = response.data;
                    vm.questions = "";
                    vm.myquestions = "";
                    vm.myAnsQuests = "";

                })


            /*var result = new Array;
            var j = 0;

            for (var i=0; i < questions.length; i++) {
                if( questions.questText.toLowerCase().contains(vm.input.toLowerCase()) ){
                    vm.result[j++] =  quest.questText;
                }
            }

            if( vm.result.size() > 0 ){
                vm.showResult = true;
            }
            else vm.showResult = false;*/

        }

        vm.addQuest = function(){

            var question ={
                userName: $rootScope.usr,
                questText: vm.quest
            }

            ProfilePageService.addQuest(question)
                .then(function (response) {
                    alert("Question added");
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

            ProfilePageService.addAns(answer)
                .then(function(response){
                    alert("Answer added");
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
                    vm.myAnsQuests = "";
                    vm.result = "";
                    vm.show = true;
                })
        }

        vm.modal = function(quest){
            vm.selectedQuest = quest;
            ProfilePageService.answer(vm.selectedQuest.questId)
                .then(function (response) {
                    vm.answers = response.data;
                })
        }

        vm.del = function(){
            vm.answers = "";
        }

        vm.myQuest = function(){
             ProfilePageService.myquest($rootScope.usr)
                 .then(function (response) {
                     vm.myquestions = response.data;
                     vm.questions = "";
                     vm.myAnsQuests = "";
                     vm.result ="";
                     vm.show = false;
                 })
        }


        vm.myAnsQuest = function(){
            ProfilePageService.myAnsQuest($rootScope.usr)
                .then(function(response){
                    vm.myAnsQuests = response.data;
                    vm.myquestions = "";
                    vm.questions = "";
                    vm.result = "";
                    vm.show = false;
                })
        }


    }

})();