package com.zensar.aa_pmo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Table(name = "Employee")
public class Employee {

	/*
	 * @Column(name = "Sr_No.")
	 * 
	 * @NotNull()
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * @Index(name = "Sr_No") int srNo;
	 */
	@Id
	@Column(name = "empId")
	// @NotEmpty(message = "Employee ID cannot be Empty Please Enter Your EmpId
	// Eg.12345 ")
	// @NotBlank(message = "Employee ID cannot be Blank ")
	// @NotNull()
	// @Pattern(regexp = "\\d{5}")
	// @Size(min=5, max=10 ,message= "Invalid Employee Id \n Your Employee Id must
	// be inserted as Eg. 12345")
	// @Pattern(regexp="(^$|[0-9]{5})")
	// @Digits(integer = 5, fraction = 0)
	// @Length(min = 5, max = 5, message = "Please enter your Employee Id")
	@Min(50000)
	@Max(99999)
	int empId;

//	int employeeId = Integer.parseInt(empId);

	@Column(name = "empName")
	@NotEmpty(message = "Employee Name cannot be Empty ")
	@NotBlank(message = "Employee Name cannot be Blank ")
	@NotNull()
	@Size(min = 2, max = 25, message = "Please Enter Name")
	String empName;

	@Column(name = "empDesigantion")
	@NotEmpty(message = "Employee Designation cannot be Empty ")
	@NotBlank(message = "Employee Designation cannot be Blank ")
	@NotNull()
	@Size(min = 0, max = 15, message = "Please Enter Your Designation")
	String empDesignation;

	@Column(name = "empNumber")
	@NotEmpty(message = "Employee Number cannot be Empty ")
	@NotBlank(message = "Employee Number cannot be Blank ")
	@NotNull()
	// @Size(min = 10, max = 10 )
	@Pattern(regexp = "\\d{10}", message = "Please Enter Mobile number Eg.1234567890 ")
	String empNumber;

	@Column(name = "email")
	@NotEmpty(message = "Employee Email cannot be Empty ")
	@NotBlank(message = "Employee Email cannot be Blank ")
	@NotNull()
	@Email(message = "Please Enter Your Email")
	String email;

	@Column(name = "password")
	@NotEmpty(message = "Employee Password cannot be Empty ")
	@NotBlank(message = "Employee password cannot be Blank ")
	@NotNull()
	@Size(min = 8, max = 10, message = "Please Enter your Password Eg.1234567890 ")
	String password;

	@Column(name = "empRole")
	@NotEmpty(message = "Employee Role cannot be Empty ")
	@NotBlank(message = "Employee Role cannot be Blank ")
	@NotNull()
	@Size(min = 0, max = 10, message = "Please Enter your Access Role Eg.USER_ROLE")
	String role;

	@Column(name = "empStatus")
	@NotEmpty(message = "Employee Status cannot be Empty ")
	@NotBlank(message = "Employee Status cannot be Blank ")
	@NotNull()
	@Size(min = 0, max = 10, message = "Please Enter your Verification Status Eg.VERIFIED")
	String status;

	/*
	 * public int getSrNo() { return srNo; }
	 * 
	 * public void setSrNo(int srNo) { this.srNo = srNo; }
	 */

	/*
	 * public int getEmployeeId() { return employeeId; }
	 * 
	 * public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
	 */

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee() {
		super();
	}

	public Employee(int empId,
			@NotEmpty(message = "Employee Name cannot be Empty ") @NotBlank(message = "Employee Name cannot be Blank ") @Size(min = 2, max = 25, message = "Please Enter Name") String empName,
			@NotEmpty(message = "Employee Designation cannot be Empty ") @NotBlank(message = "Employee Designation cannot be Blank ") @Size(min = 0, max = 15, message = "Please Enter Your Designation") String empDesignation,
			@NotEmpty(message = "Employee Number cannot be Empty ") @NotBlank(message = "Employee Number cannot be Blank ") @Pattern(regexp = "\\d{10}", message = "Please Enter Mobile number Eg.1234567890 ") String empNumber,
			@NotEmpty(message = "Employee Email cannot be Empty ") @NotBlank(message = "Employee Email cannot be Blank ") @Email(message = "Please Enter Your Email") String email,
			@NotEmpty(message = "Employee Password cannot be Empty ") @NotBlank(message = "Employee password cannot be Blank ") @Size(min = 8, max = 10, message = "Please Enter your Password Eg.1234567890 ") String password,
			@NotEmpty(message = "Employee Role cannot be Empty ") @NotBlank(message = "Employee Role cannot be Blank ") @Size(min = 0, max = 10, message = "Please Enter your Access Role Eg.USER_ROLE") String role,
			@NotEmpty(message = "Employee Status cannot be Empty ") @NotBlank(message = "Employee Status cannot be Blank ") @Size(min = 0, max = 10, message = "Please Enter your Verification Status Eg.VERIFIED") String status) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empNumber = empNumber;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesignation=" + empDesignation
				+ ", empNumber=" + empNumber + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", status=" + status + "]";
	}

}
