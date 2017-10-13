package com.subhadip.springboot.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.subhadip.springboot.graphql.model.Employee;
import com.subhadip.springboot.graphql.service.EmployeeService;

@Component
public class Mutation implements GraphQLMutationResolver {

	private EmployeeService empService;
	
	@Autowired
	public Mutation(EmployeeService empService) {
		this.empService = empService;
	}
	
	public Employee addEmployee(String name, String email) {
		Employee empToAdd = new Employee();		
		empToAdd.setName(name);
		empToAdd.setEmail(email);
		return empService.save(empToAdd);
	}
	
	public Employee updateEmployee(int id, String name, String email) {
		Employee existingEmp = empService.findById(id);
		existingEmp.setName(name);
		existingEmp.setEmail(email);
		return empService.save(existingEmp);		
	}
}
