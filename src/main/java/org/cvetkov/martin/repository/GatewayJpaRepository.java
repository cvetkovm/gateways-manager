package org.cvetkov.martin.repository;

import javax.transaction.Transactional;

import org.cvetkov.martin.model.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayJpaRepository extends JpaRepository<Gateway, Long> {
	Gateway findBySerialNumber(String gatewaySerialNumber);

	@Transactional
	@Modifying
	@Query("update Gateway g set g.name = ?2, g.ipAddress = ?3 where g.serialNumber = ?1")
	void updateGateway(String serialNumber, String gatewayName, String ipAddress);
}
