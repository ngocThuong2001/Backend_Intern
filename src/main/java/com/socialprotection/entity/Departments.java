package com.socialprotection.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Departments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int department_id;
	
	private String department_name;
	
	@OneToMany(mappedBy = "departments")
	private List<Employees> employees = new ArrayList<>();
	

	public int getDepartment_id() {
		return department_id;
	}

	

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
	

	public List<Employees> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	
	
	
	

}
