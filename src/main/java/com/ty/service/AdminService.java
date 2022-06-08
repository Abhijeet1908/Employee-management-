package com.ty.service;

import com.ty.dao.AdminDao;
import com.ty.dto.AdminDto;

public class AdminService {
	AdminDao adminDao=new AdminDao();
	
	public boolean createAdmin(AdminDto adminDto) {
		return adminDao.createAdmin(adminDto);
	}

	public boolean validateAdmin(String email, String password) {
		return adminDao.validateAdmin(email, password);
	}
}
