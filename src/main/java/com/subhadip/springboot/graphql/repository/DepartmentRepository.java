package com.subhadip.springboot.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subhadip.springboot.graphql.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
