package com.subhadip.springboot.graphql.resolver;

import java.util.Optional;

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
	
	public Employee updateEmployee(int id, Optional<String> name, Optional<String> email) {
		Employee existingEmp = empService.findById(id);
		existingEmp.setName(name.orElse(existingEmp.getName()));
		existingEmp.setEmail(email.orElse(existingEmp.getEmail()));
		return empService.save(existingEmp);		
	}
}
