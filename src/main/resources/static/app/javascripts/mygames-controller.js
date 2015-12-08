angular.module('gametradingApp')
	.controller('MyGamesController', MyGamesController);

MyGamesController.$inject = ['$scope', 'MyGamesService', '$growl', '$mdDialog'];

function MyGamesController($scope, MyGamesService, $growl, $mdDialog) {
	
	$scope.answerOffer = false;
	
	$scope.setCurrentAnnouncement = function(type, announcement) {
		$scope.currentAnnouncement = announcement;
		$scope.type = type;
	};
	
	MyGamesService.findMySellAnnouncements().then(
		function(mySellList) {
			$scope.mySellAnnouncements = mySellList;
		}
	);
	
	MyGamesService.findMyBuyAnnouncements().then(
		function(myBuyList) {
			$scope.myBuyAnnouncements = myBuyList;
		}
	);
	
	MyGamesService.findMyTradeAnnouncements().then(
		function(myTradeList) {
			$scope.myTradeAnnouncements = myTradeList;
		}
	);
	
	$scope.setSold = function(announcement) {
		announcement.sold = !announcement.sold;
		MyGamesService.setSold(announcement).then(
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
		MyGamesService.setBought(announcement).then(
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
		MyGamesService.setTraded(announcement).then(
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
		MyGamesService.removeMySellAnnouncement(announcement).then(
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
		MyGamesService.removeMyBuyAnnouncement(announcement).then(
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
		MyGamesService.removeMyTradeAnnouncement(announcement).then(
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
	
	$scope.sendAnswer = function(idOffer, offer, answerText) {
		var answer = {
			author: $scope.user,
			description: answerText,
			offer: offer
		};
		
		if ($scope.type == 'sell') {
			MyGamesService.addSellOfferAnswer(answer).then(
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
			MyGamesService.addBuyOfferAnswer(answer).then(
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
			MyGamesService.addTradeOfferAnswer(answer).then(
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
	
	$scope.showAnswerField = function() {
		$scope.answerOffer = true;
	};
	
	$scope.hasOffers = false;
	
	$scope.openOfferModal = function(type, announcement) {
		$scope.currentAnnouncement = announcement;
		$scope.type = type;
		
		if (announcement.offers.length <= 0) {
			$scope.hasOffers = false;
			var alert = $mdDialog.alert()
				.title('Sem ofertas')
				.content('Nenhuma oferta foi recebida para este anuncio ainda!')
				.ok('Fechar');
	
			$mdDialog
				.show(alert)
				.finally(function() {
					alert = undefined;
				});
		} else {
			$scope.hasOffers = true;
		}
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
	
	// options menu
	var originatorEv;
	$scope.openMenu = function($mdOpenMenu, ev) {
		originatorEv = ev;
		$mdOpenMenu(ev);
	};
}