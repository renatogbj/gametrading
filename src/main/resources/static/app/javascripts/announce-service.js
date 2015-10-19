angular.module('gametradingApp')
	.service('announceService', AnnounceService);

AnnounceService.$inject = ['$http', '$q'];

function AnnounceService($http, $q) {
	
	// return public API for this service
	return ({
		saveSell: saveSell,
		saveBuy: saveBuy,
		saveTrade: saveTrade,
		findGames: findGames
	});
	
	function saveSell(announce) {
		console.log(announce);
		
		var request = $http({
			method: "POST",
			url: "/announce/sell/save",
			data: announce,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function saveBuy(announce) {
		var request = $http({
			method: "POST",
			url: "/announce/buy/save",
			data: announce,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function saveTrade(announce) {
		var request = $http({
			method: "POST",
			url: "/announce/trade/save",
			data: announce,
			headers: {
				"Content-Type": "application/json"
			}
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function findGames() {
		var request = $http({
			method: "GET",
			url: "/announce/games"
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