package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.AdminDto;
import com.ty.service.AdminService;

@WebServlet(value = "/createadmin")
public class CreateAdmin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		AdminDto adminDto=new AdminDto();
		adminDto.setEmail(email);
		adminDto.setPassword(password);
		
		AdminService adminService=new AdminService();
		boolean res=adminService.createAdmin(adminDto);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("createadmin.jsp");
		dispatcher.include(req, resp);
		
		
	}
}
