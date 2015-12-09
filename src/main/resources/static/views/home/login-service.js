/**
 * Created by Renato Borges on 09/12/2015.
 */
(function() {
	'use strict';
	
	angular
		.module('gametradingApp')
		.factory('LoginService', LoginService);

	LoginService.$inject = ['$http', '$q'];
	
	function LoginService($http, $q) {
		// return public API for this service
		return {
			authenticate: authenticate
		};
		
		function authenticate() {
			return $http.get('/user').then(onSuccess, onError);
		}
		
		function onSuccess(response) {
			// returns the data from the server
			return response.data;
		}
		
		function onError(response) {
			// ensures that AngularJS executes the error handling functions in the promise chain
			console.log("An error ocurred! " + response);
			return $q.reject(response);
		}
		
	}

})();