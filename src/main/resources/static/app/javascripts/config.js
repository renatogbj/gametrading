/**
 * Created by Renato Borges on 08/12/2015.
 */
(function() {
	'use strict';
	
	angular
		.module('gametradingApp')
		.config(Config);

	Config.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider'];
	
	function Config($stateProvider, $urlRouterProvider, $locationProvider) {
		
		// removes the # (hash) from the URL
		$locationProvider.html5Mode(true);
		
		var announcements = {
			url: '/announcements',
			templateUrl: 'views/announcements/announcements.html'
		};
		
		var mygames = {
			url: '/mygames',
			templateUrl: 'views/mygames/mygames.html'
		};
		
		var announce = {
			url: '/announce',
			templateUrl: 'views/announce/announce.html'
		};
		
		var myoffers = {
			url: '/myoffers',
			templateUrl: 'views/myoffers/myoffers.html'
		};
		
		$stateProvider
			.state('announcements', announcements)
			.state('mygames', mygames)
			.state('announce', announce)
			.state('myoffers', myoffers);
	
		$urlRouterProvider.otherwise("announcements");
		
	}
	
})();