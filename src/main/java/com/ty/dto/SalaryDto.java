package com.ty.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SalaryDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double lop;
	private LocalDate month;
	private double totalSal;
	private double deductedSal;
	private double issuedSal;
	@ManyToOne
	private EmployeeDto dto;
	
	public EmployeeDto getDto() {
		return dto;
	}

	public void setDto(EmployeeDto dto) {
		this.dto = dto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLop() {
		return lop;
	}

	public void setLop(double lop) {
		this.lop = lop;
	}

	public LocalDate getMonth() {
		return month;
	}

	public void setMonth(LocalDate month) {
		this.month = month;
	}

	public double getTotalSal() {
		return totalSal;
	}

	public void setTotalSal(double totalSal) {
		this.totalSal = totalSal;
	}

	public double getDeductedSal() {
		return deductedSal;
	}

	public void setDeductedSal(double deductedSal) {
		this.deductedSal = deductedSal;
	}

	public double getIssuedSal() {
		return issuedSal;
	}

	public void setIssuedSal(double issuedSal) {
		this.issuedSal = issuedSal;
	}

	

}
