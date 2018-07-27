(function() {

    'use strict';

    angular
        .module('minditForum')
        .factory('SharedService', ['$http', '$location', function($http, $location) {
            function addQuest(question){
                return $http.put("/question",question);
            }

            function addAns(answer){
                return $http.put("/answer",answer);
            }

            return {
                addQuest: addQuest,
                addAns: addAns
            };

        }]);

})();