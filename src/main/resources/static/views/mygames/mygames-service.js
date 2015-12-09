/**
 * Created by Renato Borges.
 */
(function() {
	'use strict';
	
	angular
		.module('gametradingApp')
		.factory('MyGamesService', MyGamesService);

	MyGamesService.$inject = ['$http', '$q'];
	
	function MyGamesService($http, $q) {
		// return public API for this service
		return {
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
		};
		
		function findMySellAnnouncements() {
			return $http.get('/mygames/sell').then(onSuccess, onError);
		}
		
		function findMyBuyAnnouncements() {
			return $http.get('/mygames/buy').then(onSuccess, onError);
		}
		
		function findMyTradeAnnouncements() {
			return $http.get('/mygames/trade').then(onSuccess, onError);
		}
		
		function addSellOfferAnswer(answer) {
			return $http.post('/mygames/sell/answer/add', answer).then(onSuccess, onError);
		}
		
		function addBuyOfferAnswer(answer) {
			return $http.post('/mygames/buy/answer/add', answer).then(onSuccess, onError);
		}
		
		function addTradeOfferAnswer(answer) {
			return $http.post('/mygames/trade/answer/add', answer).then(onSuccess, onError);
		}
		
		function removeMySellAnnouncement(announcement) {
			return $http.post('/mygames/sell/remove', announcement).then(onSuccess, onError);
		}
		
		function removeMyBuyAnnouncement(announcement) {
			return $http.post('/mygames/buy/remove', announcement).then(onSuccess, onError);
		}
		
		function removeMyTradeAnnouncement(announcement) {
			return $http.post('/mygames/trade/remove', announcement).then(onSuccess, onError);
		}
		
		function setSold(announcement) {
			return $http.post('/mygames/sell/sold', announcement).then(onSuccess, onError);
		}
		
		function setBought(announcement) {
			return $http.post('/mygames/buy/bought', announcement).then(onSuccess, onError);
		}
		
		function setTraded(announcement) {
			return $http.post('/mygames/trade/traded', announcement).then(onSuccess, onError);
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