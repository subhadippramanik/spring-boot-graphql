package com.subhadip.springboot.graphql.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.subhadip.springboot.graphql.model.Department;
import com.subhadip.springboot.graphql.model.Employee;
import com.subhadip.springboot.graphql.service.DepartmentService;
import com.subhadip.springboot.graphql.service.EmployeeService;

@Component
public class Mutation implements GraphQLMutationResolver {

	private final EmployeeService empService;
	
	private final DepartmentService deptService;
	
	@Autowired
	public Mutation(EmployeeService empService, DepartmentService deptService) {
		this.empService = empService;
		this.deptService = deptService;
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
	
	public Department addDepartment(String name, String code, Optional<Integer> managerId) {
		Department deptToAdd = new Department();
		deptToAdd.setName(name);
		deptToAdd.setCode(code);
		deptToAdd.setManager(empService.findById(managerId.orElse(null)));
		return deptService.save(deptToAdd);
	}
}
