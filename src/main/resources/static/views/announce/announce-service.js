/**
 * Created by Renato Borges.
 */
(function() {
	'use strict';
	
	angular
		.module('gametradingApp')
		.factory('AnnounceService', AnnounceService);

	AnnounceService.$inject = ['$http', '$q'];
	
	function AnnounceService($http, $q) {
		// return public API for this service
		return {
			findGames: findGames,
			saveSell: saveSell,
			saveBuy: saveBuy,
			saveTrade: saveTrade
		};
		
		function findGames() {
			return $http.get('/announce/games').then(onSuccess, onError);
		}
		
		function saveSell(announcement) {
			return $http.post('/announce/sell/save', announcement).then(onSuccess, onError);
		}
		
		function saveBuy(announcement) {
			return $http.post('/announce/buy/save', announcement).then(onSuccess, onError);
		}
		
		function saveTrade(announcement) {
			return $http.post('/announce/trade/save', announcement).then(onSuccess, onError);
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