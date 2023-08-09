package com.socialprotection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.CitizenIdentification;
import com.socialprotection.entity.Employee;
import com.socialprotection.entity.Job;
import com.socialprotection.entity.Shift;
import com.socialprotection.repository.EmployeeRepository;

public interface EmployeeService {
	public Employee save(Employee employee);
	public List<Employee> findAll();
	public Employee findById(long id);
	public void deleteEmployeeById(long id);
	
	public List<Job> findAllJobs();
	public List<Shift> findAllShifts();
	
	public Employee saveCitizenIdForEmployee(long id, CitizenIdentification citizenId);
}
