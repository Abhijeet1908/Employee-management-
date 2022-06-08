package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dto.EmployeeDto;
import com.ty.service.EmployeeService;

@WebServlet(value = "/addemployee")
public class AddEmployee extends HttpServlet {
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

		EmployeeService employeeService = new EmployeeService();
		boolean res=employeeService.saveEmployee(dto);
		PrintWriter printWriter = resp.getWriter();

		HttpSession httpSession = req.getSession();

		if ((httpSession.getAttribute("email") != null)) {
			if(res)
			{
			RequestDispatcher dispatcher = req.getRequestDispatcher("addemployee.jsp");
			dispatcher.forward(req, resp);
			}
			else
			{
				printWriter.write("<html><body><h1>Invalid age</h1></body></html>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("addemployee.jsp");
				dispatcher.include(req, resp);
			}
		} else {
			//printWriter.write("<html><body><h1>Invalid credentials</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminlogin");
			dispatcher.forward(req, resp);
		}

	}
}
