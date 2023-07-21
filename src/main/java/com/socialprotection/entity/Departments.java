package com.socialprotection.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
	@Column(name = "department_id")
	private long departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@OneToMany(mappedBy = "departments")
	private List<Employees> employees = new ArrayList<>();
	

	
	
	

	public long getDepartmentId() {
		return departmentId;
	}


//	public void setDepartmentId(long departmentId) {
//		this.departmentId = departmentId;
//	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public List<Employees> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	
	
	
	

}
