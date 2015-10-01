/**
 * Created by Renato Borges on 19/08/2015.
 */
angular.module('gametradingApp')
    .controller('IndexController', IndexController);

IndexController.$inject = ['$scope', '$location'];

function IndexController($scope, $location) {
	
	$scope.isActive = function(route) {
        return route === $location.path();
    }
    
}