package com.jsp.EmployeeCRUDPractice.dto;

public class EmployeeDto {
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(Integer id, String employeename, String dept, long salary, String email) {
		super();
		this.id = id;
		this.employeename = employeename;
		this.dept = dept;
		this.salary = salary;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Integer id;
	private String employeename;
	private String dept;
	private long salary;
	private String email;

}
