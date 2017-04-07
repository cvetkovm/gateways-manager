package org.cvetkov.martin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.cvetkov.martin.utilities.DeviceStatus;

@Entity
@Table(name="devices")
public class Device {
	@Id
	private int uid;
	
	private String vendor;
	
	private Date dateCreated;
	
	@Enumerated(EnumType.STRING)
	private DeviceStatus status;
	
	private String gatewaySerialNumber;
	
	public Device(int uid, String vendor, Date dateCreated, DeviceStatus status, String gatewaySerialNumber) {
		super();
		this.uid = uid;
		this.vendor = vendor;
		this.dateCreated = dateCreated;
		this.status = status;
		this.gatewaySerialNumber = gatewaySerialNumber;
	}
	
	public Device() {}

	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getVendor() {
		return vendor;
	}
	
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public DeviceStatus getStatus() {
		return status;
	}
	
	public void setStatus(DeviceStatus status) {
		this.status = status;
	}
	
	public String getGatewaySerialNumber() {
		return gatewaySerialNumber;
	}
	
	public void setGatewaySerialNumber(String gatewaySerialNumber) {
		this.gatewaySerialNumber = gatewaySerialNumber;
	}

}
