package com.socialprotection.utils;

import lombok.Data;

@Data
public class StatusResponse {
	private boolean status;
	private String message;

	public StatusResponse() {
		super();
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusResponse(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}
