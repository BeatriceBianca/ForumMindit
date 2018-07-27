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

            function myquest(userName){
                return $http.get("/userquest?userName=" + userName, null);
            }

            function deleteQuestion(question){
                return $http.post("/delete",question);
            }

            function updateQuestion(question){
                return $http.post("/updateQuest", question);
            }

            return {
                find: find,
                answer: answer,
                myquest: myquest,
                deleteQuestion: deleteQuestion,
                updateQuestion: updateQuestion
            };

        }]);

})();