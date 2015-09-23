angular.module('gametradingApp')
	.service('myoffersService', MyOffersService);

MyOffersService.$inject = ['$http', '$q'];

function MyOffersService($http, $q) {
	
	// return public API for this service
	return ({
		findSellAnnouncements: findSellAnnouncements,
		findBuyAnnouncements: findBuyAnnouncements,
		findTradeAnnouncements: findTradeAnnouncements,
		addSellOfferAnswer: addSellOfferAnswer,
		addBuyOfferAnswer: addBuyOfferAnswer,
		addTradeOfferAnswer: addTradeOfferAnswer
	});
	
	function findSellAnnouncements(userEmail) {
		var request = $http({
			method: "GET",
			url: "/myoffers/sell",
			params: {userEmail: userEmail}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function findBuyAnnouncements(userEmail) {
		var request = $http({
			method: "GET",
			url: "/myoffers/buy",
			params: {userEmail: userEmail}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function findTradeAnnouncements(userEmail) {
		var request = $http({
			method: "GET",
			url: "/myoffers/trade",
			params: {userEmail: userEmail}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function addSellOfferAnswer(answer) {
		var request = $http({
			method: "POST",
			url: "/myoffers/sell/answer/add",
			data: answer,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function addBuyOfferAnswer(answer) {
		var request = $http({
			method: "POST",
			url: "/myoffers/buy/answer/add",
			data: answer,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function addTradeOfferAnswer(answer) {
		var request = $http({
			method: "POST",
			url: "/myoffers/trade/answer/add",
			data: answer,
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