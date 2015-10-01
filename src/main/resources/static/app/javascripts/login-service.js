angular.module('gametradingApp')
	.service('loginService', LoginService);

LoginService.$inject = ['$http', '$q'];

function LoginService($http, $q) {
	
	// return public API for this service
	return ({
		authenticate: authenticate
	});
	
	function authenticate() {
		var request = $http({
			method: "GET",
			url: "/user"
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