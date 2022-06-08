package com.ty.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDto {
	@Id
	private int empid;
	@Column(nullable = false)
	private String fname;
	@Column(nullable = false)
	private String lname;
	@Column(nullable = false)
	private String doj;
	@Column(nullable = false)
	private String dob;
	@Column(nullable = false)
	private String deptname;
	@Column(nullable = false)
	private String grade;
	@Column(nullable = false)
	private String designation;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String phone;
	private double sal;
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
		setSal(grade);
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(String grade) {
		if(grade.equalsIgnoreCase("m1"))
		{
			this.sal =15000;
		}
		else if (grade.equalsIgnoreCase("m2")) {
			this.sal=17000;
		}
		else if (grade.equalsIgnoreCase("m3")) {
			this.sal=19000;
		}
		else if (grade.equalsIgnoreCase("m4")) {
			this.sal=21000;
		}
		else if (grade.equalsIgnoreCase("m5")) {
			this.sal=23000;
		}
		else if (grade.equalsIgnoreCase("m6")) {
			this.sal=25000;
		}
		else if (grade.equalsIgnoreCase("m7")){
			this.sal=27000;
		}
		
	}
	
	
}
