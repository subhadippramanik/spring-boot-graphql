package com.subhadip.springboot.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subhadip.springboot.graphql.model.Department;
import com.subhadip.springboot.graphql.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository repository;

	@Autowired
	public DepartmentService(DepartmentRepository repository) {
		this.repository = repository;
	}

	public List<Department> getAllEmployee() {
		return repository.findAll();
	}

	public Department save(Department dept) {
		return repository.save(dept);
	}

	public Department findById(int id) {
		return repository.findOne(id);
	}

}
