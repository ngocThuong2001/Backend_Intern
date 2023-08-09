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
	Employee save(Employee employee);

	List<Employee> findAll();

	Employee findById(long id);

	void deleteEmployeeById(long id);

	List<Job> findAllJobs();

	List<Shift> findAllShifts();

	Employee saveCitizenIdForEmployee(long id, CitizenIdentification citizenId);
}
