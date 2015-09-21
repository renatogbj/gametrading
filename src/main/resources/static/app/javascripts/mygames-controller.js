angular.module('gametradingApp')
	.controller('MyGamesController', MyGamesController);

MyGamesController.$inject = ['$scope', 'mygamesService', '$growl'];

function MyGamesController($scope, mygamesService, $growl) {
	
	$scope.answerOffer = false;
	
	$scope.setCurrentAnnouncement = function(announcement) {
		$scope.currentAnnouncement = announcement;
	};
	
	mygamesService.findMySellAnnouncements().then(
		function(mySellList) {
			$scope.mySellAnnouncements = mySellList;
		}
	);
	
	mygamesService.findMyBuyAnnouncements().then(
		function(myBuyList) {
			$scope.myBuyAnnouncements = myBuyList;
		}
	);
	
	mygamesService.findMyTradeAnnouncements().then(
		function(myTradeList) {
			$scope.myTradeAnnouncements = myTradeList;
		}
	);
	
	$scope.setSold = function(announcement) {
		announcement.sold = !announcement.sold;
		mygamesService.setSold(announcement).then(
			// success response from server
			function(response) {
				
			},
			// error response from server
			function(response) {
				errorAlert();
			}
		);
	};
	
	$scope.setBought = function(announcement) {
		announcement.bought = !announcement.bought;
		mygamesService.setBought(announcement).then(
			// success response from server
			function(response) {
				
			},
			// error response from server
			function(response) {
				errorAlert();
			}
		);
	};
	
	$scope.setTraded = function(announcement) {
		announcement.traded = !announcement.traded;
		mygamesService.setTraded(announcement).then(
			// success response from server
			function(response) {
				
			},
			// error response from server
			function(response) {
				errorAlert();
			}
		);
	};
	
	$scope.removeMySell = function(announcement, idx) {
		mygamesService.removeMySellAnnouncement(announcement).then(
			// success response from server
			function(response) {
				$scope.mySellAnnouncements.splice(idx, 1);
			},
			// error response from server
			function(response) {
				errorAlert();
			}
		);
	};
	
	$scope.removeMyBuy = function(announcement, idx) {
		mygamesService.removeMyBuyAnnouncement(announcement).then(
			// success response from server
			function(response) {
				$scope.myBuyAnnouncements.splice(idx, 1);
			},
			// error response from server
			function(response) {
				errorAlert();
			}
		);
	};
	
	$scope.removeMyTrade = function(announcement, idx) {
		mygamesService.removeMyTradeAnnouncement(announcement).then(
			// success response from server
			function(response) {
				$scope.myTradeAnnouncements.splice(idx, 1);
			},
			// error response from server
			function(response) {
				errorAlert();
			}
		);
	};
	
	$scope.sendAnswer = function(idOffer, announcement, answerText) {
		var answer = {
			bidder: $scope.user,
			description: answerText
		};
		
		if (announcement.offers[idOffer].answers) {
			announcement.offers[idOffer].answers.push(answer);
		} else {
			announcement.offers[idOffer].answers = [answer];
		}
		announcement.offers[idOffer].offerAnswer = answer;
		
		mygamesService.updateMySellAnnouncement(announcement).then(
			// success response from server
			function(response) {
				
			},
			// error response from server
			function(response) {
				errorAlert();
			}
		);
		
		$scope.answerOffer = false;
	};
	
	$scope.showAnswerField = function() {
		$scope.answerOffer = true;
	};
	
	var successAlert = function() {
		$growl.box('Sucesso', 'Oferta enviada com sucesso!', {
            class: 'success',
            timeout: 2500,
            sticky: false
        }).open();
	};
	
	var errorAlert = function() {
		$growl.box('Erro', 'Erro ao excluir a venda!', {
            class: 'danger',
            timeout: 2500,
            sticky: false
        }).open();
	};
}