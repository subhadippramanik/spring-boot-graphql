package com.subhadip.springboot.graphql.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.subhadip.springboot.graphql.type.Employee;

@Component
public class Query implements GraphQLQueryResolver{
	
	public List<Employee> allEmployees() {
		Employee emp = new Employee();
		emp.setId(0);
		emp.setName("Bob");
		emp.setEmail("bob@email.demo");
		return Lists.newArrayList(emp);
	}

}
