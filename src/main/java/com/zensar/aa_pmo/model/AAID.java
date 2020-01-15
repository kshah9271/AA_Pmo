package com.zensar.aa_pmo.model;

import org.springframework.stereotype.Component;

@Component
public class AAID {
	String lineManager;
	String lineManagerEmail;
	String workLocation;
	String startDate;
	String endDate;
	String employeeName;
	String AAManager;

	public String getLineManager() {
		return lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}

	public String getLineManagerEmail() {
		return lineManagerEmail;
	}

	public void setLineManagerEmail(String lineManagerEmail) {
		this.lineManagerEmail = lineManagerEmail;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAAManager() {
		return AAManager;
	}

	public void setAAManager(String aAManager) {
		AAManager = aAManager;
	}

	public AAID() {
	}

	public AAID(String lineManager, String lineManagerEmail, String workLocation, String startDate, String endDate,
			String employeeName, String aAManager) {
		super();
		this.lineManager = lineManager;
		this.lineManagerEmail = lineManagerEmail;
		this.workLocation = workLocation;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeName = employeeName;
		AAManager = aAManager;
	}

	@Override
	public String toString() {
		return "AAID [lineManager=" + lineManager + ", lineManagerEmail=" + lineManagerEmail + ", workLocation="
				+ workLocation + ", startDate=" + startDate + ", endDate=" + endDate + ", employeeName=" + employeeName
				+ ", AAManager=" + AAManager + "]";
	}

}
