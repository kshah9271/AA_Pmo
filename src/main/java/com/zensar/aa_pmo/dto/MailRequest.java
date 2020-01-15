package com.zensar.aa_pmo.dto;

public class MailRequest {

	private String username;
	private String to;
	private String from;
	private String subject;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public MailRequest() {
		super();
	}

	public MailRequest(String username, String to, String from, String subject) {
		super();
		this.username = username;
		this.to = to;
		this.from = from;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "MailResponse [username=" + username + ", to=" + to + ", from=" + from + ", subject=" + subject + "]";
	}

}
