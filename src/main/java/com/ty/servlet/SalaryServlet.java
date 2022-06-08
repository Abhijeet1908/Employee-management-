package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.EmployeeDto;
import com.ty.dto.SalaryDto;
import com.ty.service.EmployeeService;
import com.ty.service.SalaryService;

@WebServlet(value = "/paysalary")
public class SalaryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("empid"));
		double lop = Double.parseDouble(req.getParameter("lop"));
		LocalDate date = LocalDate.parse(req.getParameter("date"));

		EmployeeService employeeService = new EmployeeService();
		EmployeeDto dto = employeeService.findByEmployeeById(id);
		double totalSal=dto.getSal();
		double sal = ((dto.getSal() / 30) * (30 - lop));
		double dedSal=totalSal-sal;
		SalaryDto salaryDto = new SalaryDto();
		salaryDto.setLop(lop);
		salaryDto.setMonth(date);
		salaryDto.setTotalSal(totalSal);
		salaryDto.setIssuedSal(sal);
		salaryDto.setDeductedSal(dedSal);
		salaryDto.setDto(dto);

		SalaryService salaryService = new SalaryService();
		boolean res = salaryService.paySal(salaryDto);
		if (res) {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>Salary credited successfully</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("view.jsp");
			dispatcher.include(req, resp);
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>Something went wrong</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("view.jsp");
			dispatcher.include(req, resp);
		}

	}
}
