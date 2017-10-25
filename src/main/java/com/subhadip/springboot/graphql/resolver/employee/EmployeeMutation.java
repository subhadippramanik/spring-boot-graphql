package com.subhadip.springboot.graphql.resolver.employee;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.subhadip.springboot.graphql.model.Department;
import com.subhadip.springboot.graphql.model.Employee;
import com.subhadip.springboot.graphql.service.DepartmentService;
import com.subhadip.springboot.graphql.service.EmployeeService;

@Component
public class EmployeeMutation implements GraphQLMutationResolver {

	private final EmployeeService empService;

	private final DepartmentService deptService;

	@Autowired
	public EmployeeMutation(EmployeeService empService, DepartmentService deptService) {
		this.empService = empService;
		this.deptService = deptService;
	}

	public Employee addEmployee(String name, String email, Optional<Integer> departmentId) {
		Employee empToAdd = new Employee();
		empToAdd.setName(name);
		empToAdd.setEmail(email);
		empToAdd.setDepartment(deptService.findById(departmentId.orElse(0)));
		return empService.save(empToAdd);
	}

	public Employee updateEmployee(int id, Optional<String> name, Optional<String> email,
			Optional<Integer> departmentId) {
		Employee existingEmp = empService.findById(id);
		Function<Employee, Optional<Department>> getDepartmentIfPresent = emp -> Optional.ofNullable(emp.getDepartment());
		Function<Optional<Department>, Integer> getDeptartmentIdOrZero = dept -> dept.isPresent() ? dept.get().getId() : 0;
		existingEmp.setName(name.orElse(existingEmp.getName()));
		existingEmp.setEmail(email.orElse(existingEmp.getEmail()));
		existingEmp.setDepartment(deptService
				.findById(departmentId.orElseGet(() -> getDeptartmentIdOrZero.apply(getDepartmentIfPresent.apply(existingEmp)))));
		return empService.save(existingEmp);
	}
}
