package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.service.EmployeeService;

@WebServlet(value = "/deleteemployee")
public class DeleteEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empid = Integer.parseInt(req.getParameter("empid"));
		EmployeeService employeeService = new EmployeeService();
		employeeService.deleteEmployee(empid);
		HttpSession httpSession = req.getSession();
		if (httpSession.getAttribute("email") != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("view.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
