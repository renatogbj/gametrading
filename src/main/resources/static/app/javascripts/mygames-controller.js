angular.module('gametradingApp')
	.controller('MyGamesController', MyGamesController);

MyGamesController.$inject = ['$scope', 'mygamesService', '$growl'];

function MyGamesController($scope, mygamesService, $growl) {
	
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