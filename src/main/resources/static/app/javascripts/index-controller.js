/**
 * Created by Renato Borges on 19/08/2015.
 */
angular.module('gametradingApp')
    .controller('IndexController', IndexController);

IndexController.$inject = ['$scope', 'loginService', '$location', '$location', '$http'];

function IndexController($scope, loginService, $location, $location, $http) {
	
	$scope.credentials = {};
	
	var authenticate = function(credentials) {

		var headers = credentials ? {authorization : "Basic "
	        + btoa(credentials.username + ":" + credentials.password)
	    } : {};

	    $http.get('user', {headers : headers}).success(function(data) {
    		$scope.user = data.credentials;
    		$scope.authenticated = data.authenticated;
	    	console.log($scope.user);
	    }).error(function() {
	    	$scope.authenticated = false;
	    });
	    
	}
	
	authenticate();
	
	$scope.isActive = function(route) {
        return route === $location.path();
    }
}