package com.zensar.aa_pmo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.aa_pmo.model.AAID;
import com.zensar.aa_pmo.model.Employee;

@Service
public interface RestService {

	public boolean addEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public boolean deleteEmployee(int id);

	public List<Employee> retrieve();

	boolean findEmployee(int empId);

	// boolean sendEmail(Mail mail);

	boolean RegistrationEmail(Employee employee);

	boolean ProfileUpdationEmail(Employee employee);

	boolean profileDeletionEmail(Employee employee);

	boolean approveAAIDEmail(AAID aaid);
	//boolean approveAAIDEmail(String employeeName, String lineManager, String lineManagerEmail, String AAManager,
		//	String workLocation, String startDate, String endDate);

	//boolean revokeAAIDEmail(String employeeName, String lineManager, String lineManagerEmail, String AAManager,
			//String workLocation, String startDate, String endDate);

	// boolean revokeDoorAccessEmail(Employee employee);

	// boolean grantDoorAccessEmial(Employee employee);

	// boolean sendAttachmentEmail(Mail mail);

}
