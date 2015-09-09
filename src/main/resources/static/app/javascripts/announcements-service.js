angular.module('gametradingApp')
	.service('announcementsService', AnnouncementsService);

AnnouncementsService.$inject = ['$http', '$q'];

function AnnouncementsService($http, $q) {
	
	// return public API for this service
	return ({
		findBuyAnnouncements: findBuyAnnouncements,
		findSellAnnouncements: findSellAnnouncements,
		findTradeAnnouncements: findTradeAnnouncements,
		addSellOffer: addSellOffer,
		addBuyOffer: addBuyOffer,
		addTradeOffer: addTradeOffer
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
	
	function addSellOffer(sellOffer) {
		var request = $http({
			method: "POST",
			url: "/announcements/sell/offer/add",
			data: sellOffer,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function addBuyOffer(buyOffer) {
		var request = $http({
			method: "POST",
			url: "/announcements/buy/offer/add",
			data: buyOffer,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function addTradeOffer(tradeOffer) {
		var request = $http({
			method: "POST",
			url: "/announcements/trade/offer/add",
			data: tradeOffer,
			headers: {
				"Content-Type": "application/json"
			}
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
