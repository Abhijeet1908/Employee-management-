package com.ty.service;

import java.util.List;

import com.ty.dao.SalaryDao;
import com.ty.dto.SalaryDto;

public class SalaryService {
	SalaryDao dao = new SalaryDao();

	public boolean paySal(SalaryDto dto) {
		return dao.paySal(dto);
	}

	public List<SalaryDto> getListByEmpId(int empid) {
		return dao.getListByEmpId(empid);
	}

	public List<SalaryDto> getList() {
		return dao.getList();
	}
}
