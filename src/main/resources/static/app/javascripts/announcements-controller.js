angular
	.module('gametradingApp')
	.controller('AnnouncementsController',
		['$scope', 'AnnouncementsService', '$growl', AnnouncementsController]);

function AnnouncementsController($scope, AnnouncementsService, $growl) {
	
	$scope.offer = {
		description: '',
		bidder: $scope.user
	}
	
	var originatorEv;
	$scope.openMenu = function($mdOpenMenu, ev) {
		originatorEv = ev;
		$mdOpenMenu(ev);
	};
	
	AnnouncementsService.findSellAnnouncements().then(
		function(data) {
			$scope.sellAnnouncements = data;
		}
	);
	
	AnnouncementsService.findBuyAnnouncements().then(
		function(buyList) {
			$scope.buyAnnouncements = buyList;
		}
	);
	
	AnnouncementsService.findTradeAnnouncements().then(
		function(tradeList) {
			$scope.tradeAnnouncements = tradeList;
		}
	);
	
	$scope.addOffer = function() {
		$scope.offer.bidder = $scope.user;
		if ($scope.type == 'sell') {
			$scope.offer.sell = $scope.sell;
			AnnouncementsService.addSellOffer($scope.offer).then(
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
			AnnouncementsService.addBuyOffer($scope.offer).then(
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
			AnnouncementsService.addTradeOffer($scope.offer).then(
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
	
	$scope.filterPlatform = function(input) {
		if ($scope.searchPlatform) {
			if (input.game.platform === $scope.searchPlatform.id) {
				console.log("returning true");
				return true;
			} else {
				return false;
			}
		}
		return true;
	};
	
	$scope.platforms = [
	    {
	    	id: 'PS4',
	    	name: 'PlayStation 4'
	    },
	    {
	    	id: 'XBOX_ONE',
	    	name: 'XBox One'
	    }
	];
	
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