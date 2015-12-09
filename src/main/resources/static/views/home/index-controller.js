/**
 * Created by Renato Borges on 19/08/2015.
 */
(function() {
	'use strict';
	
	angular
		.module('gametradingApp')
	    .controller('IndexController', IndexController);

	IndexController.$inject = ['$scope', '$location', 'LoginService'];
	
	function IndexController($scope, $location, LoginService) {
		
		LoginService.authenticate().then(
			function(auth) {
				$scope.user = auth.credentials;
				$scope.authenticated = auth.authenticated;
			},
			function(error) {
				$scope.authenticated = false;
			}
		);
		
		$scope.isActive = function(route) {
	        return route === $location.path();
	    }
		
	}
	
})();