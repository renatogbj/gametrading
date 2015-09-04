angular.module('gametradingApp')
	.service('mygamesService', MyGamesService);

MyGamesService.$inject = ['$http', '$q'];

function MyGamesService($http, $q) {
	
	// return public API for this service
	return ({
		findMySellAnnouncements: findMySellAnnouncements
	});
	
	function findMySellAnnouncements() {
		var request = $http({
			method: "GET",
			url: "/mygames/sell"
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