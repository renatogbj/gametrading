angular.module('gametradingApp')
	.service('loginService', LoginService);

LoginService.$inject = ['$http', '$q'];

function LoginService($http, $q) {
	
	// return public API for this service
	return ({
		loginFacebook: loginFacebook
	});
	
	function loginFacebook() {
		var request = $http({
			method: "POST",
			url: "/connect/facebook",
//			data: scope,
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