angular.module('gametradingApp')
	.controller('AnnouncementsController', AnnouncementsController);

AnnouncementsController.$inject = ['$scope', 'announcementsService'];

function AnnouncementsController($scope, announcementsService) {
	
	announcementsService.findSellAnnouncements().then(
		function(sellList) {
			$scope.sellAnnouncements = sellList;
		}
	);
}