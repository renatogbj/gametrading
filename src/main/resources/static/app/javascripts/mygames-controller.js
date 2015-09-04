angular.module('gametradingApp')
	.controller('MyGamesController', MyGamesController);

MyGamesController.$inject = ['$scope', 'mygamesService', '$growl'];

function MyGamesController($scope, mygamesService, $growl) {
	
	mygamesService.findMySellAnnouncements().then(
		function(mySellList) {
			$scope.mySellAnnouncements = mySellList;
		}
	);
	
	$scope.setSold = function(announcement) {
		announcement.sold = true;
	};
	
	$scope.setUnsold = function(announcement) {
		announcement.sold = false;
	};
	
	var successAlert = function() {
		$growl.box('Sucesso', 'Oferta enviada com sucesso!', {
            class: 'success',
            timeout: 2500,
            sticky: false
        }).open();
	};
	
	var errorAlert = function() {
		$growl.box('Erro', 'Erro ao enviar oferta!', {
            class: 'danger',
            timeout: 2500,
            sticky: false
        }).open();
	};
}