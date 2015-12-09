/**
 * Created by Renato Borges on 20/08/2015.
 */
(function() {
	'use strict';
	
	angular
		.module('gametradingApp')
    	.controller('AnnounceController', AnnounceController);

	AnnounceController.$inject = ['$scope', '$growl', 'AnnounceService'];
	
	function AnnounceController($scope, $growl, AnnounceService) {
	    
		AnnounceService.findGames().then(
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
				
				AnnounceService.saveSell(formItem).then(
					function(response) {
						successAlert();
					},
					function(response) {
						errorAlert();
					}
				);
				
			} else if ($scope.type == 'buy') {
				
				AnnounceService.saveBuy(formItem).then(
					function(response) {
						successAlert();
					},
					function(response) {
						errorAlert();
					}
				);
				
			} else if ($scope.type == 'trade') {
				
				AnnounceService.saveTrade(formItem).then(
					function(response) {
						successAlert();
					},
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

})();