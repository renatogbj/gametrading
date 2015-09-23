angular.module('gametradingApp')
	.controller('MyOffersController', MyOffersController);

MyOffersController.$inject = ['$scope', 'myoffersService', '$growl'];

function MyOffersController($scope, myoffersService, $growl) {

	if ($scope.user) {
		myoffersService.findSellAnnouncements($scope.user.email).then(
			function(sellList) {
				$scope.sellAnnouncements = sellList;
			}
		);
	}
	
	if ($scope.user) {
		myoffersService.findBuyAnnouncements($scope.user.email).then(
			function(buyList) {
				$scope.buyAnnouncements = buyList;
			}
		);
	}
	
	if ($scope.user) {
		myoffersService.findTradeAnnouncements($scope.user.email).then(
			function(tradeList) {
				$scope.tradeAnnouncements = tradeList;
			}
		);
	}
	
	$scope.setCurrentAnnouncement = function(type, announcement) {
		$scope.currentAnnouncement = announcement;
		$scope.type = type;
	};
	
	$scope.answerOffer = false;
	
	$scope.showAnswerField = function() {
		$scope.answerOffer = true;
	};
	
	$scope.sendAnswer = function(idOffer, offer, answerText) {
		var answer = {
			author: $scope.user,
			description: answerText,
			offer: offer
		};
		
		if ($scope.type == 'sell') {
			myoffersService.addSellOfferAnswer(answer).then(
				// success response from server
				function(response) {
					// avoids JSON circular reference
					answer.offer = '';
					
					// add object to update the display without a new find request
					if ($scope.currentAnnouncement.offers[idOffer].answers) {
						$scope.currentAnnouncement.offers[idOffer].answers.push(answer);
					} else {
						$scope.currentAnnouncement.offers[idOffer].answers = [answer];
					}
				},
				// error response from server
				function(response) {
					errorAlert();
				}
			);
		} else if ($scope.type == 'buy') {
			myoffersService.addBuyOfferAnswer(answer).then(
				// success response from server
				function(response) {
					// avoids JSON circular reference
					answer.offer = '';
					
					// add object to update the display without a new find request
					if ($scope.currentAnnouncement.offers[idOffer].answers) {
						$scope.currentAnnouncement.offers[idOffer].answers.push(answer);
					} else {
						$scope.currentAnnouncement.offers[idOffer].answers = [answer];
					}
				},
				// error response from server
				function(response) {
					errorAlert();
				}
			);
		} else if ($scope.type == 'trade') {
			myoffersService.addTradeOfferAnswer(answer).then(
				// success response from server
				function(response) {
					// avoids JSON circular reference
					answer.offer = '';
					
					// add object to update the display without a new find request
					if ($scope.currentAnnouncement.offers[idOffer].answers) {
						$scope.currentAnnouncement.offers[idOffer].answers.push(answer);
					} else {
						$scope.currentAnnouncement.offers[idOffer].answers = [answer];
					}
				},
				// error response from server
				function(response) {
					errorAlert();
				}
			);
		}
		
		// hide the text input
		$scope.answerOffer = false;
	};
	
}