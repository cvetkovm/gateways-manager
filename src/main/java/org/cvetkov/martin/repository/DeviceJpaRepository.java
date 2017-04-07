package org.cvetkov.martin.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.cvetkov.martin.model.Device;
import org.cvetkov.martin.utilities.DeviceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceJpaRepository extends JpaRepository<Device, Long> {
	List<Device> findByGatewaySerialNumber(String gatewaySerialNumber);
	Device findByGatewaySerialNumberAndUid(String gatewaySerialNumber, int deviceUid);
	Device findByUid(int uid);
	
	@Transactional
	@Modifying
	@Query("update Device d set d.vendor = ?3, d.dateCreated = ?4, d.status = ?5 where d.gatewaySerialNumber = ?1 and d.uid = ?2")
	void updateDevice(String serialNumber, int deviceId, String vendor, Date dateCreated, DeviceStatus status);
}
