package com.subhadip.springboot.graphql.resolver.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.subhadip.springboot.graphql.model.Department;
import com.subhadip.springboot.graphql.service.DepartmentService;

@Component
public class DepartmentQuery implements GraphQLQueryResolver {
	
	private final DepartmentService deptService;

	@Autowired
	public DepartmentQuery(DepartmentService deptService) {
		this.deptService = deptService;
	}
		
	public Department department(int id) {
		return deptService.findById(id);
	}

}
