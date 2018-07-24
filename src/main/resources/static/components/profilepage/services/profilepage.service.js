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

            return {
                addQuest: addQuest,
                find: find
            };

        }]);

})();