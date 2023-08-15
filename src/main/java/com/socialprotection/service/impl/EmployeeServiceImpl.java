package com.socialprotection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.CitizenIdentification;
import com.socialprotection.entity.Employee;
import com.socialprotection.entity.Job;
import com.socialprotection.entity.Person;
import com.socialprotection.entity.Shift;
import com.socialprotection.repository.CitizenIdentificationRepository;
import com.socialprotection.repository.EmployeeRepository;
import com.socialprotection.repository.ImageRepository;
import com.socialprotection.repository.JobRepository;
import com.socialprotection.repository.ShiftRepository;
import com.socialprotection.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private ShiftRepository shiftRepository;

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private CitizenIdentificationRepository citizenIdRepository;
	
	@Override
	public Employee save(Employee employee) {
		imageRepository.save(employee.getImage());
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.delete(id);
	}

	@Override
	public List<Job> findAllJobs() {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
	}

	@Override
	public List<Shift> findAllShifts() {
		// TODO Auto-generated method stub
		return shiftRepository.findAll();
	}

	@Override
	public Employee saveCitizenIdForEmployee(long id, CitizenIdentification citizenId) {
		CitizenIdentification citizenIdSaved = citizenIdRepository.save(citizenId);
		Employee employee = employeeRepository.findOne(id);
		employee.setCitizenId(citizenIdSaved);
		return employeeRepository.save(employee);
	}

<<<<<<< HEAD
//	@Override
//	public List<Employee> findByKeywords(String fullName) {
//		// TODO Auto-generated method stub
//		return employeeRepository.findByKeywords(fullName);
//	}
=======
	@Override
	public List<Employee> findByJob(Job job) {
		// TODO Auto-generated method stub
		return employeeRepository.findByJob(job);
	}

	@Override
	public Job findJobByTitle(String title) {
		// TODO Auto-generated method stub
		return jobRepository.findByJobTitle(title).get(0);
	}
>>>>>>> branch 'master' of https://github.com/Nbtrien/social-protection-center-api.git

}
