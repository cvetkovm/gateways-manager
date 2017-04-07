package org.cvetkov.martin.model;

import java.util.Date;

import org.cvetkov.martin.utilities.DeviceStatus;

public class DeviceUpdate {
	
	private String vendor;
	private Date dateCreated;
	private DeviceStatus status;
	
	public DeviceUpdate() {}
	
	public DeviceUpdate(String vendor, Date dateCreated, DeviceStatus status) {
		super();
		this.vendor = vendor;
		this.dateCreated = dateCreated;
		this.status = status;
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
}
