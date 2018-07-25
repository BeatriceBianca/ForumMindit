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

                 })
        }

    }

})();