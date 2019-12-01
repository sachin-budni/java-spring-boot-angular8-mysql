package com.org.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.models.Employee;
import com.org.models.Skill;
import com.org.services.EmployeeService;
import com.org.services.SkillService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	public SkillService skillservice;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return this.employeeService.getEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable String id){
		return this.employeeService.getEmployee(id);
	}
	
	@PostMapping("/employee")
	public Optional<Employee> addEmployee(@RequestBody Employee emp){
		Optional<Employee> empl = this.employeeService.getEmployee(emp.getId());
		System.out.println(empl);
		if(empl.isPresent()) {
			return null;
		}
		Employee employee = this.employeeService.newEmployee(emp);
		List<Skill> listOfSkills = this.skillservice.addSkill(emp,emp.getSkills());
		return this.employeeService.getEmployee(employee.getId());
	}
	
	@PostMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable String id,@RequestBody Employee emp) {
		return this.employeeService.updateEmployee(id,emp);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		String data = this.employeeService.deleteEmployee(id);
		if(data == "") {
			return "Employe doesn't Exist";
		}else {
			return data;
		}
	}
}
