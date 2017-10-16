package com.subhadip.springboot.graphql.resolver.department;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.subhadip.springboot.graphql.model.Department;
import com.subhadip.springboot.graphql.service.DepartmentService;
import com.subhadip.springboot.graphql.service.EmployeeService;

@Component
public class DepartmentMutation implements GraphQLMutationResolver {

	private final EmployeeService empService;
	
	private final DepartmentService deptService;
	
	@Autowired
	public DepartmentMutation(EmployeeService empService, DepartmentService deptService) {
		this.empService = empService;
		this.deptService = deptService;
	}
		
	public Department addDepartment(String name, String code, Optional<Integer> managerId) {
		Department deptToAdd = new Department();
		deptToAdd.setName(name);
		deptToAdd.setCode(code);
		deptToAdd.setManager(empService.findById(managerId.orElse(0)));
		return deptService.save(deptToAdd);
	}
}
