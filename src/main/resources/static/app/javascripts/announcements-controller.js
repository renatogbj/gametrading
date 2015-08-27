angular.module('gametradingApp')
	.controller('AnnouncementsController', AnnouncementsController);

AnnouncementsController.$inject = ['$scope', 'announcementsService'];

function AnnouncementsController($scope, announcementsService) {
	
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
}