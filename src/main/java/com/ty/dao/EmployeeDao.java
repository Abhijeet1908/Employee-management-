package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.EmployeeDto;

public class EmployeeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveEmployee(EmployeeDto employeeDto) {
		entityTransaction.begin();
		entityManager.persist(employeeDto);
		entityTransaction.commit();

		EmployeeDto find = entityManager.find(EmployeeDto.class, employeeDto.getEmpid());
		if (find != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateEmployee(int empid, String fname) {
		String sql = "Select e from EmployeeDto e where e.empid=?1 and e.fname=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, empid);
		query.setParameter(2, fname);
		List<EmployeeDto> employee = query.getResultList();
		if (employee.size()>0) {
			return true;
		} else {
			return false;
		}
	}

	public List<EmployeeDto> getAllEmployees() {
		String sql = "Select e from EmployeeDto e";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

	public EmployeeDto findByEmployeeById(int empid) {
		EmployeeDto dto = entityManager.find(EmployeeDto.class, empid);
		return dto;
	}

	public void updateEmployee(EmployeeDto employeeDto) {
		entityTransaction.begin();
		entityManager.merge(employeeDto);
		entityTransaction.commit();
	}
	
	public List<EmployeeDto> searchEmployeeByFname(String fname){
		String sql = "Select e from EmployeeDto e WHERE e.fname like:code";
		Query query = entityManager.createQuery(sql);
		query.setParameter("code", "%"+fname+"%");
		return query.getResultList();
	}

	public void deleteEmployee(int empid) {
		EmployeeDto dto = entityManager.find(EmployeeDto.class, empid);
		entityTransaction.begin();
		entityManager.remove(dto);
		entityTransaction.commit();
	}
}
