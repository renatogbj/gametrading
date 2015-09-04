angular.module('gametradingApp')
	.service('mygamesService', MyGamesService);

MyGamesService.$inject = ['$http', '$q'];

function MyGamesService($http, $q) {
	
	// return public API for this service
	return ({
		findMySellAnnouncements: findMySellAnnouncements,
		removeMySellAnnouncement: removeMySellAnnouncement,
		setSold: setSold
	});
	
	function findMySellAnnouncements() {
		var request = $http({
			method: "GET",
			url: "/mygames/sell"
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
	
	function handleError(response) {
		return ($q.reject("An error ocurred!" + response));
	}
	
	function handleSuccess(response) {
		return (response.data);
	}
	
}