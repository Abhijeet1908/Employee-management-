package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.EmployeeDto;
import com.ty.service.EmployeeService;

@WebServlet(value = "/update")
public class UpdateEmpServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empid = Integer.parseInt(req.getParameter("empid"));
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String doj = req.getParameter("doj");
		String dob = req.getParameter("dob");
		String deptname = req.getParameter("deptname");
		String grade = req.getParameter("grade");
		String designation = req.getParameter("designation");
		String gender = req.getParameter("gender");
		String status = req.getParameter("status");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		
		EmployeeDto dto = new EmployeeDto();
		dto.setEmpid(empid);
		dto.setFname(fname);
		dto.setLname(lname);
		dto.setDoj(doj);
		dto.setDob(dob);
		dto.setDeptname(deptname);
		dto.setGrade(grade);
		dto.setDesignation(designation);
		dto.setGender(gender);
		dto.setStatus(status);
		dto.setAddress(address);
		dto.setPhone(phone);
		dto.setSal(dto.getGrade());
		
		EmployeeService employeeService=new EmployeeService();
		employeeService.updateEmployee(dto);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("view.jsp");
		dispatcher.forward(req, resp);
		
	}
}
