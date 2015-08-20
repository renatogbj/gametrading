/**
 * Created by Renato Borges on 18/08/2015.
 */
angular.module('gametradingApp', ['ngMaterial', 'ui.router'])
	.config(config);

config.$inject = ['$stateProvider', '$urlRouterProvider', '$mdThemingProvider'];

function config($stateProvider, $urlRouterProvider, $mdThemingProvider) {
	
	var offers = {
		url: '/offers',
		templateUrl: 'views/offers.html'
	};
	
	var mygames = {
		url: '/mygames',
		templateUrl: 'views/mygames.html'
	};
	
	var newoffer = {
		url: '/newoffer',
		templateUrl: 'views/newoffer.html'
	};
	
	$stateProvider
		.state('offers', offers)
		.state('mygames', mygames)
		.state('newoffer', newoffer);

	$urlRouterProvider.otherwise("/");
}