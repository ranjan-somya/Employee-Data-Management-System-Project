package com.jsp.EmployeeCRUDPractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.EmployeeCRUDPractice.dto.ResponseStructure;
import com.jsp.EmployeeCRUDPractice.entity.Employee;
import com.jsp.EmployeeCRUDPractice.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping()
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee){
		return employeeService.saveEmployee(employee);
	}
	@PostMapping("/emps")
	public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployee(@RequestBody List<Employee> employees){
		return employeeService.saveAllEmployee(employees);
	}
	
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee(){
		return employeeService.getallEmployee();
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(@PathVariable int id){
		return employeeService.getEmpById(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
		return employeeService.updateEmployee(id,employee);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployee(@PathVariable int id){
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/dept/{dept}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByDept(@PathVariable String dept){
		return employeeService.getEmployeeByDept(dept);
	}
}
