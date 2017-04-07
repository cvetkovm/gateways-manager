myApp.directive('devices', ['$log', '$routeParams', '$http', '$location', 'deviceService',
	function($log, $routeParams, $http, $location, deviceService) {
	return {
		link: function(scope, element, attrs) {
			scope.statusOptions = [
				{ name: 'Online', value: 'Online' }, 
				{ name: 'Offline', value: 'Offline' }
				];

			var getDevices = function(serialNumber){
				var promise = deviceService.getDevices(serialNumber);
				promise.then(function(result) {
					scope.gateway = result.gateway;
				}, function(result) {
					if(result.response.status === 404) {
						$location.url('/404');
					}
				});
			}

			if(angular.isUndefined(scope.gateway)) {
				getDevices($routeParams.gatewaySerialNumber);
			} else if (scope.gateway.serialNumber != $routeParams.gatewaySerialNumber) {
				getDevices($routeParams.gatewaySerialNumber);
			}

			scope.dateCreated = new Date();

			scope.deleteDevice = function(device){
				var promise = deviceService.deleteDevice(device);
				promise.then(function(result) {
					getDevices(scope.gateway.serialNumber);
				}, function(result) {
					getDevices(scope.gateway.serialNumber);
				});
			}

			scope.addDevice = function(uid, vendor, dateCreated, status, serialNumber){
				var promise = deviceService.addDevice(uid, vendor, dateCreated, status, serialNumber);
				promise.then(function(result) {
					scope.uid = '';
					scope.vendor = '';
					scope.dateCreated = new Date();
					scope.status = 'Online';
					getDevices(scope.gateway.serialNumber);
				}, function(result) {
					alert('Insertion failed. Server message:' + result.response.data.message);
					getDevices(scope.gateway.serialNumber);
				});
			}

			scope.populateData = function(device) {
				scope.newDevice = angular.copy(device);
			};

			scope.updateDevice = function(device){
				var promise = deviceService.updateDevice(scope.newDevice);
				promise.then(function(result) {
					device.vendor = scope.newDevice.vendor;
					device.dateCreated = scope.newDevice.dateCreated;
					device.status = scope.newDevice.status;
				}, function(result) {
					alert('Update failed. Server message:' + result.response.data.message);
				});

			};

			scope.opened = {};
			scope.open = function($event, elementOpened, device) {
				console.log("ovdeka");
				event.preventDefault();
				event.stopPropagation();
				scope.populateData(device);
				scope.opened[elementOpened] = !scope.opened[elementOpened];
			};

		},
		scope: {}, 
		templateUrl: '/pages/devices-directive.html'
	};
}]);