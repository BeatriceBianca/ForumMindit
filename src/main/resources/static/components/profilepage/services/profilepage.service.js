(function() {

    'use strict';

    angular
        .module('minditForum')
        .factory('ProfilePageService', ['$http', '$location', function($http, $location) {

            function find(){
                return $http.get("/allquest",null);

            }

            function answer(id){
                return $http.get("/getAnswer?questId=" + id, null);
            }

            function question(id){
                return $http.get("/getQuestion?id=" + id, null);
            }

            function myquest(userName){
                return $http.get("/userquest?userName=" + userName, null);
            }

            function deleteQuestion(question){
                return $http.post("/delete",question);
            }

            function deleteAnswer(answer){
                return $http.post("/delete/ans",answer);
            }

            function updateQuestion(question) {
                return $http.post("/updateQuest", question);
            }

            function updateAnswer(answer) {
                return $http.post("/update/ans", answer);
            }



            function myAnsQuest(username){
                return $http.get("/myQuestions?username=" + username , null);
            }

            function searchQuest(input){
                return $http.get("/searchQuest?input=" + input , null);
            }

            function searchAns(input){
                return $http.get("/searchAns?input=" + input , null);
            }

            return {
                find: find,
                answer: answer,
                question: question,
                myquest: myquest,
                deleteQuestion: deleteQuestion,
                deleteAnswer:   deleteAnswer,
                updateQuestion: updateQuestion,
                updateAnswer: updateAnswer,
                myAnsQuest: myAnsQuest,
                searchQuest: searchQuest,
                searchAns: searchAns
            };

        }]);

})();