package com.ems.service;



import com.ems.model.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public String removeEmployee(int id);
	
	public Optional<Employee> findEmpById(int id);
	
	public List<Employee> getAllEmployee();
	
	public String updateEmployee(int id);

}
