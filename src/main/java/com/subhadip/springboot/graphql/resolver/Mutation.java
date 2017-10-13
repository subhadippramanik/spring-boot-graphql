package com.subhadip.springboot.graphql.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.subhadip.springboot.graphql.type.Employee;

@Component
public class Mutation implements GraphQLMutationResolver {

	public Employee addEmployee(int id, String name, String email) {
		Employee empToAdd = new Employee();
		empToAdd.setId(id);
		empToAdd.setName(name);
		empToAdd.setEmail(email);
		return empToAdd;
	}
}
