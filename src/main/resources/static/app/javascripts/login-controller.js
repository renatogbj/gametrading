/**
 * Created by Renato Borges on 19/08/2015.
 */
angular.module('gametradingApp')
    .controller('LoginController', LoginController);

LoginController.$inject = ['$scope', 'loginService', '$location'];

function LoginController($scope, loginService, $location) {
	
	$scope.isActive = function(route) {
        return route === $location.path();
    }
	
//    loginService.login().then(
//		function(userItem) {
//			$scope.user = userItem;
//		}
//	);
    
}