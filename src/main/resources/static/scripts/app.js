var myApp = angular.module('myApp', ['ngRoute','xeditable', 'ui.bootstrap']);

myApp.config(function ($routeProvider) {

	$routeProvider
	.when('/', {
		templateUrl: 'pages/gateways.html',
		controller: 'gatewaysListController'
	})

	.when('/:gatewaySerialNumber/devices', {
		templateUrl: 'pages/devices.html',
		controller: 'devicesController'
	})

	.when('/404', {
		templateUrl: 'pages/not_found.html',
	})

});


