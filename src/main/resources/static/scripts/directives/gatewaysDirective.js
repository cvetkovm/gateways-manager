myApp.directive('gateways', ['$log', '$routeParams', '$http', 'deviceService', '$location', 'gatewayService',
	function($log, $routeParams, $http, deviceService, $location, gatewayService) {
	return {
		link: function(scope, element, attrs) {
			var getGateways = function(){
				var promise = gatewayService.getGateways();
				promise.then(function(result) {
					scope.gateways = result.gateways;
				}, function(result) {
				});
			}

			getGateways();

			scope.goTo = function(gateway){
				deviceService.gateway = gateway;
				$location.url('/' + gateway.serialNumber + '/devices');
			};
			
			scope.populateData = function(gateway) {
				scope.newGateway = angular.copy(gateway);
			};
			
			scope.updateGateway = function(gateway){
				var promise = gatewayService.updateGateway(scope.newGateway);
				promise.then(function(result) {
					gateway.name = scope.newGateway.name;
					gateway.ipAddress = scope.newGateway.ipAddress;
				}, function(result) {
					alert('Update failed. Server message:' + result.response.data.message);
				});

			};

			
			scope.deleteGateway = function(gateway){
				var promise = gatewayService.deleteGateway(gateway);
				promise.then(function(result) {
					getGateways();
				}, function(result) {
					getGateways();
				});
			}
			
			scope.addGateway = function(){
				var promise = gatewayService.addGateway(scope.serialNumber, scope.name, scope.ipAddress);
				promise.then(function(result) {
					scope.serialNumber = '';
					scope.name = '';
					scope.ipAddress = '';
					getGateways();
				}, function(result) {
					alert('Insertion failed. Server message:' + result.response.data.message);
					getGateways();
				});
			}

		},
		scope: {}, 
		templateUrl: '/pages/gateways-directive.html'
	};
}]);