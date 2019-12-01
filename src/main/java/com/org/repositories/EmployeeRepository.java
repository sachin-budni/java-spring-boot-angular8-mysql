package com.org.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
