package com.jsp.EmployeeCRUDPractice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.EmployeeCRUDPractice.entity.Employee;
import com.jsp.EmployeeCRUDPractice.repository.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public List<Employee> saveListEmployee(List<Employee> employees){
		return employeeRepo.saveAll(employees);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
	
	public Optional<Employee> getEmplById(int id) {
		return employeeRepo.findById(id);
	}
	public Optional<Employee> updateEmployee(Employee employee) {
		return employeeRepo.findById(employee.getId());
	}
	
	public void deleteEmployee(int id) {
		 employeeRepo.deleteById(id);
	}
	
	public List<Employee> getEmpByDept(String dept){
		return employeeRepo.findByDept(dept);
	}
	
}
