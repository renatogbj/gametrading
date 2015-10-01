/**
 * Created by Renato Borges on 19/08/2015.
 */
angular.module('gametradingApp')
    .controller('IndexController', IndexController);

IndexController.$inject = ['$scope', 'loginService', '$location', '$location', '$http'];

function IndexController($scope, loginService, $location, $location, $http) {
	
	$scope.isActive = function(route) {
        return route === $location.path();
    }
	
	var authenticate = function(credentials, callback) {

		var headers = credentials ? {authorization : "Basic "
	        + btoa(credentials.username + ":" + credentials.password)
	    } : {};

	    console.log(headers);
	    $http.get('user', {headers : headers}).success(function(data) {
	    	if (data.name) {
	    		console.log("success login");
	    		$scope.user = data.principal;
	    		$scope.authenticated = true;
	    	} else {
	    		console.log("failed login");
	    		$scope.authenticated = false;
	    	}
	    	callback && callback();
	    }).error(function() {
	    	console.log("error login");
	    	$scope.authenticated = false;
	    	callback && callback();
	    });
	    
	}
	
	authenticate();
	
	$scope.credentials = {};
	
	$scope.login = function() {
		authenticate($scope.credentials, function() {
			if ($scope.authenticated) {
				$location.path("/");
				$scope.error = false;
			} else {
				$location.path("/login");
				$scope.error = true;
			}
		});
	};
	
	$scope.isAuthenticated = function() {
		return $scope.authenticated;
	};
	
	$scope.logout = function() {
		$http.post('logout', {}).success(function() {
			$scope.authenticated = false;
			$location.path("/");
		}).error(function(data) {
			$scope.authenticated = false;
		});
	};
	
	$scope.loginFacebook = function() {
		loginService.loginFacebook().then(
			// success response from server
			function(response) {
//				successAlert();
				console.log(response);
			},
			// error response from server
			function(response) {
//				errorAlert();
				console.log(response);
			}
		);
	};
    
}