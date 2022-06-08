package com.ty.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import com.ty.dao.EmployeeDao;
import com.ty.dto.EmployeeDto;
import com.ty.helper.AgeHelper;

public class EmployeeService {
	EmployeeDao dao = new EmployeeDao();

	public boolean saveEmployee(EmployeeDto employeeDto) {
		LocalDate dob = LocalDate.parse(employeeDto.getDob());
		int age = AgeHelper.ageCal(dob);
		if (age >= 18 && age <= 58) {
			return dao.saveEmployee(employeeDto);
		} else {
			return false;
		}
	}

	public boolean validateEmployee(int empid, String fname) {
		return dao.validateEmployee(empid, fname);
	}

	public List<EmployeeDto> getAllEmployees() {
		return dao.getAllEmployees();
	}

	public EmployeeDto findByEmployeeById(int empid) {
		return dao.findByEmployeeById(empid);
	}

	public void updateEmployee(EmployeeDto employeeDto) {
		dao.updateEmployee(employeeDto);
	}

	public void deleteEmployee(int empid) {
		dao.deleteEmployee(empid);
	}
	
	public List<EmployeeDto> searchEmployeeByFname(String fname)
	{
		return dao.searchEmployeeByFname(fname);
	}

}
