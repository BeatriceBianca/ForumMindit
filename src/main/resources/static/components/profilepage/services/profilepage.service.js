(function() {

    'use strict';

    angular
        .module('minditForum')
        .factory('ProfilePageService', ['$http', '$location', function($http, $location) {
            function addQuest(question){
                return $http.put("/question",question);
            }

            function find(){
                return $http.get("/allquest",null);

            }

            function addAns(answer){
                return $http.put("/answer",answer);
            }

            function answer(id){
                return $http.get("/getAnswer?questId=" + id, null);
            }

            function myquest(userName){
                return $http.get("/userquest?userName=" + userName, null);
            }

            return {
                addQuest: addQuest,
                find: find,
                addAns: addAns,
                answer: answer,
                myquest: myquest
            };

        }]);

})();