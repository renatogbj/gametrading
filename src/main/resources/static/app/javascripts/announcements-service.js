/**
 * Created by Renato Borges.
 */
(function() {
	'use strict';
	
	angular
		.module('gametradingApp')
		.factory('AnnouncementsService', AnnouncementsService);

	AnnouncementsService.$inject = ['$http', '$q'];

	function AnnouncementsService($http, $q) {
		// return public API for this service
		return {
			findBuyAnnouncements: findBuyAnnouncements,
			findSellAnnouncements: findSellAnnouncements,
			findTradeAnnouncements: findTradeAnnouncements,
			addSellOffer: addSellOffer,
			addBuyOffer: addBuyOffer,
			addTradeOffer: addTradeOffer
		};
		
		function findSellAnnouncements() {
			return $http.get('/announcements/sell').then(onSuccess, onError);
		}
		
		function findBuyAnnouncements() {
			return $http.get('/announcements/buy').then(onSuccess, onError);
		}
		
		function findTradeAnnouncements() {
			return $http.get('/announcements/trade').then(onSuccess, onError);
		}
		
		function addSellOffer(offer) {
			return $http.post('/announcements/sell/offer/add', offer).then(onSuccess, onError);
		}
		
		function addBuyOffer(offer) {
			return $http.post('/announcements/buy/offer/add', offer).then(onSuccess, onError);
		}
		
		function addTradeOffer(offer) {
			return $http.post('/announcements/trade/offer/add', offer).then(onSuccess, onError);
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