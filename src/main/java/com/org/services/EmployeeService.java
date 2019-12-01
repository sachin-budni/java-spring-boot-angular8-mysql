package com.org.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.models.Employee;
import com.org.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepo;
	
	public List<Employee> getEmployees(){
		return this.employeeRepo.findAll();
	}

	public Optional<Employee> getEmployee(String id) {
		return this.employeeRepo.findById(id);
	}
	
	public Employee newEmployee(Employee emp) {
		return this.employeeRepo.save(emp);
	}
	
	public Employee updateEmployee(String id,Employee emp) {
		if(this.employeeRepo.existsById(id)) {			
			return this.employeeRepo.save(emp);
		}else {
			return null;
		}
	}
	
	public String deleteEmployee(String id) {
		if(this.employeeRepo.existsById(id)) {			
			this.employeeRepo.deleteById(id);
			return "Delete Successfully";
		}else {
			return "";
		}
	}
}
