package com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
