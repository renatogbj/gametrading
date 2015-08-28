angular.module('gametradingApp')
	.controller('AnnouncementsController', AnnouncementsController);

AnnouncementsController.$inject = ['$scope', 'announcementsService', '$growl'];

function AnnouncementsController($scope, announcementsService, $growl) {
	
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
			console.log($scope.tradeAnnouncements[0].wishList[0]);
		}
	);
	
	$scope.offer = {
		description: '',
		bidder: $scope.user
	}
	
	$scope.addOffer = function() {
		$scope.sell.offers.push($scope.offer);
		console.log($scope.sell.offers);
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