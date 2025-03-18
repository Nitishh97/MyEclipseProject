package org.rijushree.restapi.enities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	private long id;
	private String name;
	private String job;
	public Employee(long id, String name, String job) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Employee() {
		super();
	
	}
	
	
}
