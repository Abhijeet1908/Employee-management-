package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.SalaryDto;

public class SalaryDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean paySal(SalaryDto dto) {
		entityTransaction.begin();
		entityManager.persist(dto);
		entityTransaction.commit();

		SalaryDto find = entityManager.find(SalaryDto.class, dto.getId());
		if (find != null) {
			return true;
		} else {
			return false;
		}

	}

	public List<SalaryDto> getListByEmpId(int empid) {
		String sql = "Select s from SalaryDto s where s.dto.empid=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, empid);
		List<SalaryDto> list = query.getResultList();
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	
	public List<SalaryDto> getList() {
		String sql = "Select s from SalaryDto s";
		Query query = entityManager.createQuery(sql);
		List<SalaryDto> list = query.getResultList();
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

}
