(function() {

    'use strict';

    angular
        .module('minditForum')
        .factory('HomeService', ['$http', '$location', function($http, $location) {

            function bringQuestions(){
                return $http.get("/questions",null);
            }

            function getAnswers(id){
                return $http.get('/answers?id=' + id , null);
            }


            return {

                bringQuestions:  bringQuestions,
                getAnswers: getAnswers

            };

        }]);

})();