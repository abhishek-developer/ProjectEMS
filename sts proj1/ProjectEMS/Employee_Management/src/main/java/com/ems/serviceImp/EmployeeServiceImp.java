package com.ems.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepo;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		
		 Employee emp =employeeRepo.save(employee);
		return emp;
	}
	
	@Override
	public String removeEmployee(int id) {
		
		employeeRepo.deleteById(id);
		
		return "Delete Data Successfully";
	}
	
	@Override
	public Optional<Employee> findEmpById(int id) {
		
	    Optional<Employee> emp = employeeRepo.findById(id);
		
		if(emp.isPresent()) {
			return emp;
		}else {
			return null;
		}
		
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee> empList = employeeRepo.findAll();
		
		return empList ;
	}
	
	@Override
	public String updateEmployee(int id) {
		
		Optional<Employee> emp = employeeRepo.findById(id);
		
		if(emp.isPresent()) {
			Employee emps = new Employee();
			employeeRepo.save(emps);
			
			return "Updated Successfully" ;
		}else {
			return "Employee Not Found" ;
		}
	
	}
       
}
