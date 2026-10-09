package com.jsp.EmployeeCRUDPractice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.EmployeeCRUDPractice.dao.EmployeeDao;
import com.jsp.EmployeeCRUDPractice.dto.ResponseStructure;
import com.jsp.EmployeeCRUDPractice.entity.Employee;
import com.jsp.EmployeeCRUDPractice.exception.IdNotFoundException;
import com.jsp.EmployeeCRUDPractice.exception.NoRecordFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee){
		Employee emp=employeeDao.saveEmployee(employee);
		ResponseStructure<Employee> res=new ResponseStructure<>();
		res.setHttpStatusCode(HttpStatus.CREATED.value());
		res.setMessage("data inserted");
		res.setData(emp);
		
		return new ResponseEntity<ResponseStructure<Employee>>(res,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployee(List<Employee> employees){
		List<Employee> emps=employeeDao.saveListEmployee(employees);
		ResponseStructure<List<Employee>> res=new ResponseStructure<>();
		res.setHttpStatusCode(HttpStatus.CREATED.value());
		res.setMessage("All data inserted");
		res.setData(emps);
		return new ResponseEntity<ResponseStructure<List<Employee>>>(res,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getallEmployee(){
		List<Employee> emp=employeeDao.getAllEmployee();
		ResponseStructure<List<Employee>> res=new ResponseStructure<>();
		if (!emp.isEmpty()) {
			res.setHttpStatusCode(HttpStatus.OK.value());
			res.setMessage("all data get");
			res.setData(emp);
			
			return new ResponseEntity<ResponseStructure<List<Employee>>>(res,HttpStatus.OK);
		}else {
			throw new NoRecordFoundException("No record found ");
		}
	}
	
	public ResponseEntity<ResponseStructure<Employee>> getEmpById(int id){
		Optional<Employee> opt=employeeDao.getEmplById(id);
		ResponseStructure<Employee> res=new ResponseStructure<>();
		
		if (!opt.isEmpty()) {
			res.setHttpStatusCode(HttpStatus.ACCEPTED.value());
			res.setMessage("data is found");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Employee>>(res,HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found exception");
		}
	}
	
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id, Employee employee) {

	    Optional<Employee> emp = employeeDao.getEmplById(id);

	    ResponseStructure<Employee> res = new ResponseStructure<>();

	    if (emp.isPresent()) {

	        employee.setId(id);

	        Employee updatedEmployee = employeeDao.saveEmployee(employee);

	        res.setHttpStatusCode(HttpStatus.OK.value());
	        res.setMessage("Data updated successfully");
	        res.setData(updatedEmployee);

	        return new ResponseEntity<ResponseStructure<Employee>>(
	                res, HttpStatus.OK
	        );

	    } else {
	        throw new NoRecordFoundException("Record not found");
	    }
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteEmployee(int id){
		Optional<Employee> emp=employeeDao.getEmplById(id);
		ResponseStructure<String> res=new ResponseStructure<>();
		if (emp.isPresent()) {
			employeeDao.deleteEmployee(id);
			res.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			res.setMessage("data deleted");
			res.setData("data deleted");
			return new ResponseEntity<ResponseStructure<String>>(res,HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByDept(String dept){
		List<Employee> emps=employeeDao.getEmpByDept(dept);
		ResponseStructure<List<Employee>> res=new ResponseStructure<>();
		if (!emps.isEmpty()) {
			res.setHttpStatusCode(HttpStatus.ACCEPTED.value());
			res.setMessage("data are get based on dept");
			res.setData(emps);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(res,HttpStatus.OK);
		}else {
			throw new NoRecordFoundException("record not found");
		}
	}
}










