angular.module('gametradingApp')
	.service('mygamesService', MyGamesService);

MyGamesService.$inject = ['$http', '$q'];

function MyGamesService($http, $q) {
	
	// return public API for this service
	return ({
		findMySellAnnouncements: findMySellAnnouncements,
		findMyBuyAnnouncements: findMyBuyAnnouncements,
		removeMySellAnnouncement: removeMySellAnnouncement,
		removeMyBuyAnnouncement: removeMyBuyAnnouncement,
		setSold: setSold,
		setBought: setBought
	});
	
	function findMySellAnnouncements() {
		var request = $http({
			method: "GET",
			url: "/mygames/sell"
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function findMyBuyAnnouncements() {
		var request = $http({
			method: "GET",
			url: "/mygames/buy"
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function removeMySellAnnouncement(sell) {
		var request = $http({
			method: "POST",
			url: "/mygames/sell/remove",
			data: sell,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function removeMyBuyAnnouncement(buy) {
		var request = $http({
			method: "POST",
			url: "/mygames/buy/remove",
			data: buy,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function setSold(sell) {
		var request = $http({
			method: "POST",
			url: "/mygames/sell/sold",
			data: sell,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function setBought(bought) {
		var request = $http({
			method: "POST",
			url: "/mygames/buy/bought",
			data: bought,
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