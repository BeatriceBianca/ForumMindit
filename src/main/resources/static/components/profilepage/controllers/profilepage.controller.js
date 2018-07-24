(function() {

    'use strict';

    angular
        .module("minditForum")
        .controller("ProfilePageController", Controller);

    Controller.$inject = [
        '$scope',
        '$state',
        'ProfilePageService'
    ];

    function Controller($scope,
                        $state,
                        ProfilePageService) {

        var vm = this;

        vm.addQuest = function(){

            var question ={
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

        vm.showAll = function(){
            ProfilePageService.find()
                .then(function (response) {
                    vm.questions = response.data;
                })
        }

        vm.modal = function(quest){
            vm.selectedQuest = quest;
        }

    }

})();