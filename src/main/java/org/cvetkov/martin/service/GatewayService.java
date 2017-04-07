package org.cvetkov.martin.service;

import java.util.List;

import org.cvetkov.martin.model.Device;
import org.cvetkov.martin.model.DeviceUpdate;
import org.cvetkov.martin.model.Gateway;
import org.cvetkov.martin.model.GatewayUpdate;

public interface GatewayService {

	static final int MAX_NUMBER_OF_DEVICES = 10;

	List<Gateway> getAllGateways();
	Gateway getGateway(String gatewaySerialNumber);
	void addGateway(Gateway gateway);
	void deleteGateway(String serialNumber);
	List<Device> getDevices(String gatewaySerialNumber);
	Device getDevice(String gatewaySerialNumber, int deviceUid);
	void addDevice(String gatewaySerialNumber, Device device);
	void deleteDevice(String gatewaySerialNumber,  int deviceUID);
	void updateGateway(String serialNumber, GatewayUpdate gateway);
	void updateDevice(String serialNumber, int deviceId, DeviceUpdate deviceUpdate);
}
