package com.zensar.aa_pmo.dto;

public class MailResponse {

	private boolean status;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MailResponse(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public MailResponse() {
		super();
	}

	@Override
	public String toString() {
		return "MailRequest [status=" + status + ", message=" + message + "]";
	}

}
