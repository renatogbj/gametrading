(function() {
	'use strict';
	
	angular
		.module('gametradingApp')
		.directive('offerModal', OfferModal);
	
	function OfferModal() {
		var directive = {
			templateUrl: 'app/directives/offer-modal/offer-modal.html',
			restrict: 'E',
			transclude: true,
			scope: {
				offer: '=',
				saveOffer: '&'
			}
		};
		
		return directive;
	}
	
})();