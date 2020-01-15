package com.zensar.aa_pmo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zensar.aa_pmo.dto.MailRequest;
import com.zensar.aa_pmo.dto.MailResponse;
import com.zensar.aa_pmo.model.Employee;

@Service
public interface RestService {

	public boolean addEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public boolean deleteEmployee(int id);

	public List<Employee> retrieve();

	boolean findEmployee(int empId);

	public Employee retrieveEmployee(int empId);

	// boolean sendEmail(Mail mail);

//	boolean RegistrationEmail(Employee employee);

//	boolean ProfileUpdationEmail(Employee employee);

//	boolean profileDeletionEmail(Employee employee);

//	boolean approveAAIDEmail(AAID aaid);
	// boolean approveAAIDEmail(String employeeName, String lineManager, String
	// lineManagerEmail, String AAManager,
	// String workLocation, String startDate, String endDate);

	// boolean revokeAAIDEmail(String employeeName, String lineManager, String
	// lineManagerEmail, String AAManager,
	// String workLocation, String startDate, String endDate);

	// boolean revokeDoorAccessEmail(Employee employee);

	// boolean grantDoorAccessEmial(Employee employee);

	// boolean sendAttachmentEmail(Mail mail);

	public MailResponse sendEmail(MailRequest request, Map<String, Object> model, String template);
}
