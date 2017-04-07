package org.cvetkov.martin.utilities;

public class GatewayResponse {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GatewayResponse(String message) {
		super();
		this.message = message;
	}

}
