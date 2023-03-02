package com.ems.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ems.model.Employee;

import com.ems.serviceImp.EmployeeServiceImp;



@RestController
@RequestMapping("/emp")

public class EmployeeController {
	
	
	
	@Autowired
	private EmployeeServiceImp empService;
	
    @GetMapping("/home")  
	public String homepage() {
		return "welcome to Employee Management" ;
	}
    
    @PostMapping("/addEmp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    	
    	Employee emp = empService.addEmployee(employee);
    	
    	return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
    	
    }
    @DeleteMapping("/removeEmp(id)")
    public ResponseEntity<String> removeEmployee(@PathVariable int id){
    	
    	empService.removeEmployee(id);
    	
    	return new ResponseEntity<String>("Removed Successfully", HttpStatus.ACCEPTED);
    }
    @GetMapping("/findEmp(id)")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id){
    	Optional<Employee> emps = empService.findEmpById(id);
    	
    	return new ResponseEntity<Optional<Employee>>(emps, HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> ListOfEmployees(){
    	List<Employee> lEmp = empService.getAllEmployee();
    	
    	return new ResponseEntity<List<Employee>>(lEmp, HttpStatus.ACCEPTED);
    }
}
