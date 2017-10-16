package com.subhadip.springboot.graphql.resolver.employee;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.subhadip.springboot.graphql.model.Employee;
import com.subhadip.springboot.graphql.service.EmployeeService;

@Component
public class EmployeeQuery implements GraphQLQueryResolver {

	private final EmployeeService empService;

	@Autowired
	public EmployeeQuery(EmployeeService empService) {
		this.empService = empService;
	}
	
	public Employee employee(int id) {
		return empService.findById(id);
	}
	
	public List<Employee> employees(Optional<String> name, Optional<String> email) {
		return empService.findByNameAndOrEmail(name.orElse(StringUtils.EMPTY), email.orElse(StringUtils.EMPTY));
	}

}
