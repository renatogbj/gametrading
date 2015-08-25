angular.module('gametradingApp')
	.service('loginService', LoginService);

LoginService.$inject = ['$http', '$q'];

function LoginService($http, $q) {
	
	// return public API for this service
	return ({
		login: login
	});
	
	function login() {
		var request = $http({
			method: "GET",
			url: "/home/user"
		});
		
		return (request.then(handleSuccess, handleError));
	}
	
	function handleError(response) {
		return ($q.reject("An error ocurred!" + response));
	}
	
	function handleSuccess(response) {
		console.log(response.data);
		return (response.data);
	}
}