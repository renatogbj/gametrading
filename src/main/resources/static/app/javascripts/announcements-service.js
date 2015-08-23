angular.module('gametradingApp')
	.service('announcementsService', AnnouncementsService);

AnnouncementsService.$inject = ['$http', '$q'];

function AnnouncementsService($http, $q) {
	
	// return public API for this service
	return ({
		findBuyAnnouncements: findBuyAnnouncements,
		findSellAnnouncements: findSellAnnouncements,
		findTradeAnnouncements: findTradeAnnouncements
	});
	
	function findSellAnnouncements() {
		var request = $http({
			method: "GET",
			url: "/announcements/sell"
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function findBuyAnnouncements() {
		var request = $http({
			method: "GET",
			url: "/announcements/buy"
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function findTradeAnnouncements() {
		var request = $http({
			method: "GET",
			url: "/announcements/trade"
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function handleError(response) {
		return ($q.reject("An error ocurred!" + response));
	}
	
	function handleSuccess(response) {
		return (response.data);
	}
}
