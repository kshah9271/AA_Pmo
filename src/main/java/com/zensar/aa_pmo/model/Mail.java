package com.zensar.aa_pmo.model;

public class Mail {

	String to;
	String subject;
	String body;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Mail() {
		super();
	}

	public Mail(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	@Override
	public String toString() {
		return "Mail [to=" + to + ", subject=" + subject + ", text=" + body + "]";
	}

}
