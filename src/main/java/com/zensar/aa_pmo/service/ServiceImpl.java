package com.zensar.aa_pmo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.zensar.aa_pmo.model.AAID;
import com.zensar.aa_pmo.model.Employee;
import com.zensar.aa_pmo.model.Mail;
import com.zensar.aa_pmo.repository.RestRepository;

@Service
public class ServiceImpl implements RestService {

	@Autowired
	RestRepository repository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public boolean addEmployee(Employee employee) {

		Employee save = repository.save(employee);
		if (save != null) {
			System.out.println("Into Insert-Service Successful");
			return true;
		} else {
			System.out.println("Into Insert-Service Failed");
			return false;
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		repository.deleteById(employee.getEmpId());
		Employee save = repository.save(employee);
		if (save != null) {
			System.out.println("Into Update-Service Successful");
			return true;
		} else {
			System.out.println("Into Update-Service Failed");
			return false;
		}
	}

	@Override
	public boolean findEmployee(int empId) {
		// int employeeId = Integer.parseInt(empId);
		System.out.println("EmpId : " + empId);
		Optional<Employee> find = repository.findById(empId);
		System.out.println("Find : " + find);
		Optional<Employee> xyz = Optional.empty();
		if (find == xyz) {
			System.out.println("Into Find-Service Failed");
			return false;
		} else if (find.get().getEmpId() > 0) {
			System.out.println("Into Find-Service Successful");
			return true;
		} else {
			System.out.println("Into Find-Service Successful");
			return true;
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		try {
			repository.deleteById(id);
			System.out.println("Into Delete-Service Successful");
			return true;
		}
		/*
		 * if (save != null) return true; else return false;
		 */
		catch (Exception e) {
			System.out.println("EXCEPTION OCCURED");
			System.out.println("Into Delete-Service Failed");
			return false;
		}
	}

	@Override
	public List<Employee> retrieve() {
		List<Employee> findAll = (List<Employee>) repository.findAll();
		return findAll;
	}

	/*
	 * @Override public boolean sendEmail(Mail mail) { SimpleMailMessage msg = new
	 * SimpleMailMessage(); msg.setTo(mail.getTo());
	 * 
	 * msg.setSubject(mail.getSubject()); msg.setText(mail.getBody());
	 * javaMailSender.send(msg); return false; }
	 */

	/*
	 * @Override public boolean sendAttachmentEmail(Mail mail) { // TODO
	 * Auto-generated method stub return false; }
	 */

	@Override
	public boolean RegistrationEmail(Employee employee) {

		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(employee.getEmail());
			msg.setSubject("Thanks for Registering to AA-Employee Portal");
			msg.setText(
					"You have Registered Successfully !!! \n\nYour Credentials for Logging into the AA Portal are :- \n\nUsername :- "
							+ employee.getEmail() + "\n\npassword :- " + employee.getPassword() + " .");
			javaMailSender.send(msg);
			System.out.println("Registration mail sent Successfully");
			return true;
		} catch (Exception e) {
			System.out.println("Registration mail sent Failed");
			return false;
		}

	}

	@Override
	public boolean ProfileUpdationEmail(Employee employee) {

		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(employee.getEmail());

			msg.setSubject("Thanks for Updating your Profile at AA-Employee Portal");
			msg.setText(
					"We have saved your Profile Details \n\nYour Credentials for Logging into the AA Portal are :- \n\nUsername :- "
							+ employee.getEmail() + "\n\npassword :- " + employee.getPassword() + " .");
			javaMailSender.send(msg);
			System.out.println("Profile Updation mail sent Successfully");
			return true;
		} catch (Exception e) {
			System.out.println("Profile Updation mail sent Failed");
			return false;
		}
	}

	@Override
	public boolean profileDeletionEmail(Employee employee) {

		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(employee.getEmail());

			msg.setSubject("Sorry Your Profile is deleted from the AA-Employee Portal");
			msg.setText(
					"Sorry your Profile was deleted from the AA-Employee Protal by AA PMO \n\nYou will no longer be able to login into the AA-Employee Portal and won't have privilleges for door access and won't be able to login into Horizon using AA ID in future \n\nFor further queries please contact AA PMO Anju Kumari");
			javaMailSender.send(msg);
			System.out.println("Profile Deletion mail sent Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Profile Deletion mail sent Failed");
			return false;
		}
	}

	// public boolean approveAAIDEmail(String employeeName, String lineManager,
	// String lineManagerEmail, String AAManager,
	// String workLocation, String startDate, String endDate) {
	@Override
	public boolean approveAAIDEmail(AAID aaid) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(aaid.getLineManagerEmail());

			msg.setSubject("Approval for AA USER ID");
			msg.setText("Hi" + aaid.getLineManager()
					+ ",\n\nRequest your approval to create AA USER ID for following new resource.\n\nPlease note this resource will be on-boarded under the Zensar MSA and relevant SOW and have both procurement and InfoSec approval.\n\n"
					+ "<html><body><table>" + "<tr><td>Name</td>" + "<td>Work Location</td>" + "<td>AA Manager</td>"
					+ "<td>Start Date</td>" + "<td>End Date</td>" + "</tr>" + "<tr><td>" + aaid.getEmployeeName()
					+ "</td>" + "<td>" + aaid.getWorkLocation() + "</td>" + "<td>" + aaid.getAAManager() + "</td>"
					+ "<td>" + aaid.getStartDate() + "</td>" + "<td>" + aaid.getEndDate() + "</td>" + "</tr></table></body></html>");
			javaMailSender.send(msg);
			System.out.println("Profile AAID mail sent Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Profile AAID mail sent Failed");
			return false;
		}

	}

}
