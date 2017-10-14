package com.subhadip.springboot.graphql.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subhadip.springboot.graphql.model.Employee;
import com.subhadip.springboot.graphql.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository repository;

	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	public Employee save(Employee emp) {
		return repository.save(emp);
	}

	public Employee findById(int id) {
		return repository.findOne(id);
	}

	public List<Employee> findByNameAndOrEmail(String name, String email) {		
		return getAllEmployee().stream()//
				.filter(filterByNameIfSupplied(name))//
				.filter(filterByEmailIfSupplied(email))//
				.collect(Collectors.toList());
	}

	private static Predicate<Employee> filterByEmailIfSupplied(String email) {
		Predicate<Employee> filterByEmailIfSupplied = emp -> StringUtils.isNotBlank(email) ? email.equalsIgnoreCase(emp.getEmail()) : Boolean.TRUE;
		return filterByEmailIfSupplied;
	}

	private static Predicate<Employee> filterByNameIfSupplied(String name) {
		Predicate<Employee> filterByNameIfSupplied = emp -> StringUtils.isNotBlank(name) ? name.equalsIgnoreCase(emp.getName()) : Boolean.TRUE;
		return filterByNameIfSupplied;
	}
}
