package com.subhadip.springboot.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subhadip.springboot.graphql.model.Employee;
import com.subhadip.springboot.graphql.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository repository;

	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}
	
	public Employee save(Employee emp) {		
		return repository.save(emp);
	}
}
