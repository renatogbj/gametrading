/**
 * Created by Renato Borges.
 */
(function() {
	'use strict';
	
	angular
		.module('gametradingApp')
		.factory('MyOffersService', MyOffersService);

	MyOffersService.$inject = ['$http', '$q'];
	
	function MyOffersService($http, $q) {
		// return public API for this service
		return {
			findSellAnnouncements: findSellAnnouncements,
			findBuyAnnouncements: findBuyAnnouncements,
			findTradeAnnouncements: findTradeAnnouncements,
			addSellOfferAnswer: addSellOfferAnswer,
			addBuyOfferAnswer: addBuyOfferAnswer,
			addTradeOfferAnswer: addTradeOfferAnswer
		};
		
		function findSellAnnouncements(email) {
			var request = $http({
				method: 'GET',
				url: '/myoffers/sell',
				params: {
					userEmail: email
				}
			});
			
			return request.then(onSuccess, onError);
		}
		
		function findBuyAnnouncements(email) {
			var request = $http({
				method: 'GET',
				url: '/myoffers/buy',
				params: {
					userEmail: email
				}
			});
			
			return request.then(onSuccess, onError);
		}
		
		function findTradeAnnouncements(email) {
			var request = $http({
				method: 'GET',
				url: '/myoffers/trade',
				params: {
					userEmail: email
				}
			});
			
			return request.then(onSuccess, onError);
		}
		
		function addSellOfferAnswer(answer) {
			return $http.post('/myoffers/sell/answer/add', answer).then(onSuccess, onError);
		}
		
		function addBuyOfferAnswer(answer) {
			return $http.post('/myoffers/buy/answer/add', answer).then(onSuccess, onError);
		}
		
		function addTradeOfferAnswer(answer) {
			return $http.post('/myoffers/trade/answer/add', answer).then(onSuccess, onError);
		}
		
		function onSuccess(response) {
			// returns the data from the server
			return response.data;
		}
		
		function onError(response) {
			// ensures that AngularJS executes the error handling functions in the promise chain
			console.log("An error ocurred! " + response);
			return $q.reject(response);
		}
		
	}

})();