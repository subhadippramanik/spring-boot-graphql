package com.subhadip.springboot.graphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.subhadip.springboot.graphql.model.Employee;
import com.subhadip.springboot.graphql.service.EmployeeService;

@Component
public class Query implements GraphQLQueryResolver {

	private EmployeeService empService;

	@Autowired
	public Query(EmployeeService empService) {
		this.empService = empService;
	}
	
	public Employee employee(int id) {
		return empService.findById(id);
	}
	
	public List<Employee> employees(String name, String email) {
		return empService.findByNameAndOrEmail(name, email);
	}

}
