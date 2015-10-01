/**
 * Created by Renato Borges on 19/08/2015.
 */
angular.module('gametradingApp')
    .controller('LoginController', LoginController);

LoginController.$inject = ['$rootScope', '$scope', 'loginService', '$location'];

function LoginController($rootScope, $scope, loginService, $location) {
	
//	var authenticate = function(credentials, callback) {
//
//		var headers = credentials ? {authorization : "Basic "
//	        + btoa(credentials.username + ":" + credentials.password)
//	    } : {};
//
//	    $http.get('user', {headers : headers}).success(function(data) {
//	    	if (data.name) {
//	    		$rootScope.authenticated = true;
//	    	} else {
//	    		$rootScope.authenticated = false;
//	    	}
//	    	callback && callback();
//	    }).error(function() {
//	    	$rootScope.authenticated = false;
//	    	callback && callback();
//	    });
//	    
//	}
//	
//	authenticate();
//	
//	$scope.credentials = {};
//	
//	$scope.login = function() {
//		authenticate($scope.credentials, function() {
//			if ($rootScope.authenticated) {
//				$location.path("/");
//				$scope.error = false;
//			} else {
//				$location.path("/login");
//				$scope.error = true;
//			}
//		});
//	};
	
}