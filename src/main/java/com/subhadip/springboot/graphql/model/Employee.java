package com.subhadip.springboot.graphql.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.jetbrains.annotations.Nullable;

import lombok.Data;

@Entity
@Embeddable
@Data
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String email;
	
	@Embedded
	@ManyToOne
	@Nullable
	private Department department;
}
