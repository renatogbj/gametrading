/**
 * Created by Renato Borges on 20/08/2015.
 */
angular.module('gametradingApp')
    .controller('AnnounceController', AnnounceController);

AnnounceController.$inject = ['$scope', '$growl', 'announceService'];

function AnnounceController($scope, $growl, announceService) {
    
	announceService.findGames().then(
		function(gamesList) {
			$scope.gameSelected = gamesList[0];
			$scope.games = gamesList;
		}
	);

	$scope.type = 'sell';
	
	$scope.announce = {
		game: $scope.gameSelected,
		description: '',
		price: 0.0,
		wishList: []
	};
	
	$scope.setGame = function(gameItem) {
		$scope.gameSelected = gameItem;
	};
	
	// saving functions
	$scope.saveAnnounce = function(formItem) {
		
		// set the user
		formItem.owner = $scope.user;
		
		if ($scope.type == 'sell') {
			
			announceService.saveSell(formItem).then(
				// success response from server
				function(response) {
					successAlert();
				},
				// error response from server
				function(response) {
					errorAlert();
				}
			);
		} else if ($scope.type == 'buy') {
			announceService.saveBuy(formItem).then(
				// success response from server
				function(response) {
					successAlert();
				},
				// error response from server
				function(response) {
					errorAlert();
				}
			);
		} else if ($scope.type == 'trade') {
			announceService.saveTrade(formItem).then(
				// success response from server
				function(response) {
					successAlert();
				},
				// error response from server
				function(response) {
					errorAlert();
				}
			);
		}
	};
	
	var successAlert = function() {
		$growl.box('Sucesso', 'Anuncio criado com sucesso!', {
            class: 'success',
            timeout: 2500,
            sticky: false
        }).open();
	};
	
	var errorAlert = function() {
		$growl.box('Erro', 'Erro ao criar anuncio!', {
            class: 'danger',
            timeout: 2500,
            sticky: false
        }).open();
	};
	
}