package com.subhadip.springboot.graphql.resolver;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.subhadip.springboot.graphql.model.Department;
import com.subhadip.springboot.graphql.model.Employee;
import com.subhadip.springboot.graphql.service.DepartmentService;
import com.subhadip.springboot.graphql.service.EmployeeService;

@Component
public class Query implements GraphQLQueryResolver {

	private final EmployeeService empService;
	
	private final DepartmentService deptService;

	@Autowired
	public Query(EmployeeService empService, DepartmentService deptService) {
		this.empService = empService;
		this.deptService = deptService;
	}
	
	public Employee employee(int id) {
		return empService.findById(id);
	}
	
	public List<Employee> employees(Optional<String> name, Optional<String> email) {
		return empService.findByNameAndOrEmail(name.orElse(StringUtils.EMPTY), email.orElse(StringUtils.EMPTY));
	}
	
	public Department department(int id) {
		return deptService.findById(id);
	}

}
