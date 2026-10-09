package com.jsp.EmployeeCRUDPractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.EmployeeCRUDPractice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	List<Employee> findByDept(String dept);
}
