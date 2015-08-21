/**
 * Created by Renato Borges on 20/08/2015.
 */
angular.module('gametradingApp')
    .controller('AnnounceController', AnnounceController);

AnnounceController.$inject = ['$scope', 'announceService'];

function AnnounceController($scope, announceService) {
    
	$scope.gameSelected = {
		name: 'Mortal Kombat X',
		image: 'app/images/mkx.jpg',
	};
	
	$scope.announce = {
		type: 'sell',
		game: $scope.gameSelected,
		description: '',
		price: 0.0
	};
	
	announceService.findGames().then(
		function(gamesList) {
			$scope.games = gamesList;
		}
	);
	
	$scope.setGame = function(gameItem) {
		$scope.gameSelected = gameItem;
	};
	
	// saving funcitons
	$scope.saveAnnounce = function(formItem) {
		if (formItem.type == 'sell') {
			announceService.saveSell(formItem).then(
				// success response from server
				function(response) {
					console.warn(response);
				},
				// error response from server
				function(response) {
					console.warn(response);
				}
			);
		} else if (formItem.type == 'buy') {
			announceService.saveBuy(formItem).then(
				// success response from server
				function(response) {
					console.warn(response);
				},
				// error response from server
				function(response) {
					console.warn(response);
				}
			);
		} else if (formItem.type == 'trade') {
			// TODO - implement wishlist
		}
	};
	
}