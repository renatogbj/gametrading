angular.module('gametradingApp')
	.service('mygamesService', MyGamesService);

MyGamesService.$inject = ['$http', '$q'];

function MyGamesService($http, $q) {
	
	// return public API for this service
	return ({
		findMySellAnnouncements: findMySellAnnouncements,
		findMyBuyAnnouncements: findMyBuyAnnouncements,
		findMyTradeAnnouncements: findMyTradeAnnouncements,
		addSellOfferAnswer: addSellOfferAnswer,
		addBuyOfferAnswer: addBuyOfferAnswer,
		addTradeOfferAnswer: addTradeOfferAnswer,
		removeMySellAnnouncement: removeMySellAnnouncement,
		removeMyBuyAnnouncement: removeMyBuyAnnouncement,
		removeMyTradeAnnouncement: removeMyTradeAnnouncement,
		setSold: setSold,
		setBought: setBought,
		setTraded: setTraded
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
	
	function findMyTradeAnnouncements() {
		var request = $http({
			method: "GET",
			url: "/mygames/trade"
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function addSellOfferAnswer(answer) {
		var request = $http({
			method: "POST",
			url: "/mygames/sell/answer/add",
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
			url: "/mygames/buy/answer/add",
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
			url: "/mygames/trade/answer/add",
			data: answer,
			headers: {
				"Content-Type": "application/json"
			}
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
	
	function removeMyTradeAnnouncement(trade) {
		var request = $http({
			method: "POST",
			url: "/mygames/trade/remove",
			data: trade,
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
	
	function setTraded(traded) {
		var request = $http({
			method: "POST",
			url: "/mygames/trade/traded",
			data: traded,
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