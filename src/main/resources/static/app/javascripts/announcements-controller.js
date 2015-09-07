angular.module('gametradingApp')
	.controller('AnnouncementsController', AnnouncementsController);

AnnouncementsController.$inject = ['$scope', 'announcementsService', '$growl'];

function AnnouncementsController($scope, announcementsService, $growl) {
	
	$scope.offer = {
		description: '',
		bidder: $scope.user
	}
	
	announcementsService.findSellAnnouncements().then(
		function(sellList) {
			$scope.sellAnnouncements = sellList;
		}
	);
	
	announcementsService.findBuyAnnouncements().then(
		function(buyList) {
			$scope.buyAnnouncements = buyList;
		}
	);
	
	announcementsService.findTradeAnnouncements().then(
		function(tradeList) {
			$scope.tradeAnnouncements = tradeList;
		}
	);
	
	$scope.addOffer = function() {
		$scope.sell.offers.push($scope.offer);
		announcementsService.addOfferToSell($scope.sell).then(
			// success response from server
			function(response) {
				successAlert();
			},
			// error response from server
			function(response) {
				errorAlert();
			}
		);
	};
	
	$scope.setSell = function(sell) {
		$scope.sell = sell;
	};
	
	$scope.forSell = function(input) {
		if (!input.sold) {
    		return true;
    	} else {
    		return false;
    	}
	};
	
	var successAlert = function() {
		$growl.box('Sucesso', 'Oferta enviada com sucesso!', {
            class: 'success',
            timeout: 2500,
            sticky: false
        }).open();
	};
	
	var errorAlert = function() {
		$growl.box('Erro', 'Erro ao enviar oferta!', {
            class: 'danger',
            timeout: 2500,
            sticky: false
        }).open();
	};
	
}