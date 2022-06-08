package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.EmployeeDto;
import com.ty.service.EmployeeService;

@WebServlet(value = "/search")
public class SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("search");
		
		EmployeeService employeeService=new EmployeeService();
		List<EmployeeDto> list=employeeService.searchEmployeeByFname(name);
		
		if(list!=null)
		{
			req.setAttribute("list", list);
			RequestDispatcher dispatcher =  req.getRequestDispatcher("search.jsp") ;
			dispatcher.forward(req, resp);
		}else {
			PrintWriter printWriter  = resp.getWriter() ;
			printWriter.write("<html><body> <h1> no employee found with given name </h1></body></head>");
			RequestDispatcher dispatcher =  req.getRequestDispatcher("view.jsp") ;
			dispatcher.include(req, resp);
		}
		}
		
	
}
