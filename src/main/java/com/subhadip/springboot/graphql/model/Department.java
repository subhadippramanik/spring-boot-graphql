package com.subhadip.springboot.graphql.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Embeddable
@Data
public class Department {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String code;
	
	@Embedded
	@OneToOne
	private Employee manager;
}
