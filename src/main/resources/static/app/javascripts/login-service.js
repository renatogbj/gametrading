/**
 * Created by Renato Borges.
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
			
		};
		
	}

})();