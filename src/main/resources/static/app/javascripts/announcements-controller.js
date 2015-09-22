angular.module('gametradingApp')
	.controller('AnnouncementsController', AnnouncementsController);

AnnouncementsController.$inject = ['$scope', 'announcementsService', '$growl'];

function AnnouncementsController($scope, announcementsService, $growl) {
	
	$scope.offer = {
		description: '',
		bidder: $scope.user
	}
	
	announcementsService.findSellAnnouncements().then(
		function(sellList) {
			$scope.sellAnnouncements = sellList;
		}
	);
	
	announcementsService.findBuyAnnouncements().then(
		function(buyList) {
			$scope.buyAnnouncements = buyList;
		}
	);
	
	announcementsService.findTradeAnnouncements().then(
		function(tradeList) {
			$scope.tradeAnnouncements = tradeList;
		}
	);
	
	$scope.addOffer = function() {
		$scope.offer.bidder = $scope.user;
		if ($scope.type == 'sell') {
			$scope.offer.sell = $scope.sell;
			announcementsService.addSellOffer($scope.offer).then(
				// success response from server
				function(response) {
					successAlert();
				},
				// error response from server
				function(response) {
					errorAlert();
				}
			);
		} else if ($scope.type == 'buy') {
			$scope.offer.buy = $scope.buy;
			announcementsService.addBuyOffer($scope.offer).then(
				// success response from server
				function(response) {
					successAlert();
				},
				// error response from server
				function(response) {
					errorAlert();
				}
			);
		} else if ($scope.type == 'trade') {
			$scope.offer.trade = $scope.trade;
			announcementsService.addTradeOffer($scope.offer).then(
				// success response from server
				function(response) {
					successAlert();
				},
				// error response from server
				function(response) {
					errorAlert();
				}
			);
		}
	};
	
	$scope.setType = function(type, announcement) {
		$scope.type = type;
		switch (type) {
		case 'sell':
			$scope.sell = announcement;
			break;
		case 'buy':
			$scope.buy = announcement;
			break;
		case 'trade':
			$scope.trade = announcement;
			break;
		}
	};
	
	$scope.forSell = function(input) {
		if (!input.sold) {
    		return true;
    	} else {
    		return false;
    	}
	};
	
	$scope.forBuy = function(input) {
		if (!input.bought) {
    		return true;
    	} else {
    		return false;
    	}
	};
	
	$scope.forTrade = function(input) {
		if (!input.traded) {
    		return true;
    	} else {
    		return false;
    	}
	};
	
	$scope.filterGame = function(input) {
		if ($scope.searchGame) {
			if (input.game.name.toLowerCase().indexOf($scope.searchGame.toLowerCase()) > -1) {
	    		return true;
	    	} else {
	    		return false;
	    	}
		}
		return true;
	};
	
	$scope.filterMinPrice = function(input) {
		if ($scope.searchMinPrice) {
			if (input.price >= $scope.searchMinPrice) {
	    		return true;
	    	} else {
	    		return false;
	    	}
		}
		return true;
	};
	
	$scope.filterMaxPrice = function(input) {
		if ($scope.searchMaxPrice) {
			if (input.price <= $scope.searchMaxPrice) {
	    		return true;
	    	} else {
	    		return false;
	    	}
		}
		return true;
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