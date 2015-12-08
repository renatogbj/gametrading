/**
 * Created by Renato Borges on 08/12/2015.
 */
angular
	.module('gametradingApp')
	.config(Config);

Config.$inject = ['$stateProvider', '$urlRouterProvider', '$locationProvider'];

function Config($stateProvider, $urlRouterProvider, $locationProvider) {
	'use strict';
	
	// removes the # (hash) from the URL
	$locationProvider.html5Mode(true);
	
	var login = {
		url: '/login',
		templateUrl: 'views/login.html'
	};
	
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
		.state('login', login)
		.state('announcements', announcements)
		.state('mygames', mygames)
		.state('announce', announce)
		.state('myoffers', myoffers);

	$urlRouterProvider.otherwise("announcements");
	
}