/**
 * Created by Renato Borges on 19/08/2015.
 */
angular.module('gametradingApp')
    .controller('IndexController', IndexController);

IndexController.$inject = ['$scope', 'loginService'];

function IndexController($scope, loginService) {
    loginService.login().then(
		function(name) {
			$scope.username = name;
		}
	);
}