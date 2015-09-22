/**
 * Created by Renato Borges on 19/08/2015.
 */
angular.module('gametradingApp')
    .controller('LoginController', LoginController);

LoginController.$inject = ['$scope', 'loginService'];

function LoginController($scope, loginService) {
	
    loginService.login().then(
		function(userItem) {
			$scope.user = userItem;
		}
	);
    
    $scope.logout = function() {
    	FB.logout();
    }
    
}