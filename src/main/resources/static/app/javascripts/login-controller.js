/**
 * Created by Renato Borges on 19/08/2015.
 */
angular.module('gametradingApp')
    .controller('LoginController', LoginController);

LoginController.$inject = ['$rootScope', '$scope', 'loginService', '$location', '$http'];

function LoginController($rootScope, $scope, loginService, $location, $http) {
	
	var authenticate = function(credentials, callback) {

		var headers = credentials ? {authorization : "Basic "
	        + btoa(credentials.username + ":" + credentials.password)
	    } : {};

	    $http.get('user', {headers : headers}).success(function(data) {
	    	if (data.name) {
	    		console.log(data);
	    		$rootScope.user = data.principal;
	    		console.log($rootScope.user);
	    		$rootScope.authenticated = true;
	    	} else {
	    		$rootScope.authenticated = false;
	    	}
	    	callback && callback();
	    }).error(function() {
	    	$rootScope.authenticated = false;
	    	callback && callback();
	    });
	    
	}
	
	authenticate();
	
	$scope.credentials = {};
	
	$scope.login = function() {
		console.log("tried to login");
		authenticate($scope.credentials, function() {
			if ($rootScope.authenticated) {
				$location.path("/");
				$scope.error = false;
			} else {
				$location.path("/login");
				$scope.error = true;
			}
		});
	};
	
}