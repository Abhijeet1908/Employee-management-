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

import com.ty.service.EmployeeService;

@WebServlet(value = "/employeelogin")
public class EmployeeLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empid = Integer.parseInt(req.getParameter("empid"));
		String fname = req.getParameter("fname");
		PrintWriter printWriter = resp.getWriter();
		EmployeeService employeeService = new EmployeeService();
		boolean res = employeeService.validateEmployee(empid, fname);
		if (res) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("empid", empid);

			RequestDispatcher dispatcher = req.getRequestDispatcher("empmenu.jsp");
			dispatcher.forward(req, resp);
		} else {
			
			printWriter.write("<html><body><h1>WRONG ID OR NAME</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("employeelogin.jsp");
			dispatcher.include(req, resp);
		}
	}
}
