package com.jsp.EmployeeCRUDPractice.mapper;

import com.jsp.EmployeeCRUDPractice.dto.EmployeeDto;
import com.jsp.EmployeeCRUDPractice.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getEmployeename(),
				employee.getDept(),
				employee.getSalary(),
				employee.getEmail()
				);
	}
	
	public static Employee mapToemployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getEmployeename(),
				employeeDto.getDept(),
				employeeDto.getSalary(),
				employeeDto.getEmail()
				);
	}

}
