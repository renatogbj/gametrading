/**
 * Created by Renato Borges on 18/08/2015.
 */
angular.module('gametradingApp', ['ngMaterial', 'ui.router', 'ui.growl'])
	.config(config);

config.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider'];

function config($stateProvider, $urlRouterProvider, $locationProvider) {
	'use strict';
	
	$locationProvider.html5Mode(true);
	
	var login = {
		url: '/login',
		templateUrl: 'views/login.html'
	}
	
	var announcements = {
		url: '/announcements',
		templateUrl: 'views/announcements.html'
	};
	
	var mygames = {
		url: '/mygames',
		templateUrl: 'views/mygames.html'
	};
	
	var announce = {
		url: '/announce',
		templateUrl: 'views/announce.html'
	};
	
	var myoffers = {
		url: '/myoffers',
		templateUrl: 'views/myoffers.html'
	};
	
	$stateProvider
		.state('announcements', announcements)
		.state('mygames', mygames)
		.state('announce', announce)
		.state('myoffers', myoffers);

	$urlRouterProvider.otherwise("/");
	
}