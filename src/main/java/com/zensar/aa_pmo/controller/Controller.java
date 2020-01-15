package com.zensar.aa_pmo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.zensar.aa_pmo.model.AAID;
import com.zensar.aa_pmo.model.Employee;
import com.zensar.aa_pmo.model.Mail;
import com.zensar.aa_pmo.service.RestService;

@RestController
@EnableWebMvc
@RequestMapping("/AA")
public class Controller {

	@Autowired
	RestService service;

	@GetMapping(value = "/")
	public String Hello() {
		System.out.println("INTO HELLO USER");
		return "hello user";
	}

	@PostMapping(value = "/AddEmployee", consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		boolean findEmployee = service.findEmployee(employee.getEmpId());
		boolean addEmployee;
		if (findEmployee == false) {
			addEmployee = service.addEmployee(employee);
			System.out.println("Employee is : " + employee);
			if (addEmployee = true) {
				System.out.println("Find Employee = false Employee Insertion Successful");
				System.out.println(addEmployee);

				System.out.println("Sending mail to ...... " + employee.getEmail());
				service.RegistrationEmail(employee);
				return employee;
			} else {
				System.err.println("Find Employee = false Employee Insertion Failed");
				return employee;
			}
		} else {
			System.err.println("Find Employee = true Employee Insertion Failed");
			return null;
		}
	}

	@PutMapping(value = "/UpdateEmployee", consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public Employee updateEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		boolean findEmployee = service.findEmployee(employee.getEmpId());
		boolean updateEmployee;
		if (findEmployee == true) {
			updateEmployee = service.addEmployee(employee);
			System.out.println("Employee is : " + employee);
			if (updateEmployee = true) {
				System.out.println("Find Employee = true Employee Updation Successful");
				System.out.println(updateEmployee);
				System.out.println("Sending mail to ...... " + employee.getEmail());
				service.ProfileUpdationEmail(employee);
				return employee;
				// return "Employee Insertion Successful";
			} else {
				System.err.println("Find Employee = true Employee Updation Failed");
				return employee;
				// return "Employee Insertion Failed";
			}
		} else {
			System.err.println("Find Employee = false Employee Updation Failed");
			return null;
		}
	}

	@DeleteMapping(value = "/DeleteEmployee/{id}", consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public String deleteEmployee(@PathVariable("id") int id) {

		boolean findEmployee = service.findEmployee(id);
		List<Employee> employees = new ArrayList<Employee>();
		employees = service.retrieve();
		Employee employee = new Employee();
		// boolean updateEmployee;
		Iterator<Employee> employeesIterator = employees.iterator();

		for (Employee temp : employees) {
			if (temp.getEmpId() == id) {
				employee = temp;
				break;
			}
		}

		System.out.println("Employee Deletion : " + employee);
		try {
			if (findEmployee == true) {
				service.profileDeletionEmail(employee);
				System.out.println("Employee is : " + id);
				System.out.println("Employee Deletion Successful");
				System.out.println("Sending mail to ...... " + employee.getEmail());
				service.deleteEmployee(id);
				return "Employee Deletion Successful";
			} else {
				System.err.println("Find Employee = false Employee Deletion Failed");
				return "Employee Deletion Failed";
			}

		} catch (Exception e) {
			System.err.println("Exception occured while deleteing the employee");
			System.err.println(e);
			return "Exception : " + e;
		}

	}

	@GetMapping(value = "/RetrieveEmployee", consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public List<Employee> retriveEmployee() {
		List<Employee> retrieve = service.retrieve();
		System.out.println("Employee Retrieval Successful");
		return retrieve;
	}

	@PostMapping(value = "/test")
	public AAID testAAid(@RequestBody AAID aaid) {
		System.out.println("Into Test AAID");
		System.out.println(aaid);
		service.approveAAIDEmail(aaid);
		System.out.println("Mail sent for approval");
		return aaid;
	}
}

/*
 * Testing JSON Format { "srNo":"0", "empId":"10000", "empName":"something",
 * "empDesignation":"something", "empNumber":"1234567890",
 * "email":"something@gmail.com", "password":"password", "status":"Verified"
 * }
 */

/*
 * Testing XML Format <Employee> <empId>11100</empId> <empName>something</empName>
 * <empDesignation>something</empDesignation> <empNumber>1234567890</empNumber>
 * <email>something@gmail.com</email> <password>password</password>
 * <status>Verified</status> </Employee>
 */

/*
 * Testing For AAID <AAID> <lineManager>something</lineManager>
 * <lineManagerEmail>something@gmail.com</lineManagerEmail>
 * <AAManager>xyz</AAManager> <employeeName>something</employeeName>
 * <workLocation>Pune</workLocation> <startDate>10/12/19</startDate>
 * <endDate>10/1/2020</endDate> </AAID>
 */