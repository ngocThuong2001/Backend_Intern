package com.socialprotection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.services.drive.model.File;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.CitizenIdentification;
import com.socialprotection.entity.Employee;
import com.socialprotection.entity.Image;
import com.socialprotection.entity.Job;
import com.socialprotection.entity.Person;
import com.socialprotection.entity.Shift;
import com.socialprotection.googledrivestore.GoogleDriveService;
import com.socialprotection.repository.EmployeeRepository;
import com.socialprotection.request.ChildrenRequest;
import com.socialprotection.request.EmployeeRequest;
import com.socialprotection.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private GoogleDriveService googleDriveService;

	@GetMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAll(@PathVariable("id") long id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}

	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(employeeService.findAll());
	}

//	@PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
//		return ResponseEntity.ok(employeeService.save(employee));
//	}
	
	@PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveEmployee(@RequestPart("employee") EmployeeRequest employeeRequest,
			@RequestPart("image") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(employeeRequest.toString());
		try {
			Employee employee = new Employee();
			File googleFile = googleDriveService.uploadFile(file);
			String imageUrl = googleFile.getWebContentLink();
			Image image = new Image(imageUrl);
			employee.setImage(image);
			
			employee.setFirstName(employeeRequest.getFirstName());
			employee.setLastName(employeeRequest.getLastName());
			employee.setFullName(employeeRequest.getLastName() + " " + employeeRequest.getFirstName());
			
			employee.setBirthDay(employeeRequest.getBirthDay());
			employee.setAddressPermanent(employeeRequest.getAddressPermanent());
			employee.setAddressTemporary(employeeRequest.getAddressTemporary());
			employee.setGender(employeeRequest.getGender());
			employee.setNationality(employeeRequest.getNationality());
			employee.setEmail(employeeRequest.getEmail());
			employee.setPhoneNumber(employeeRequest.getPhoneNumber());
			employee.setJob(employeeRequest.getJob());
			employee.setShift(employeeRequest.getShift());
			employee.setFromDate(employeeRequest.getFromDate());
			employee.setSalary(Float.valueOf(employeeRequest.getSalary()));
			
			return ResponseEntity.ok(employeeService.save(employee));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				return ResponseEntity.ok(employeeRequest);
//		return ResponseEntity.ok(employeeService.save(employee));
	}
	
	@PostMapping("employees/{id}/citizenid")
	public ResponseEntity<HttpStatus> saveEmployeeCitizenId(@PathVariable("id") long id,
			@RequestBody CitizenIdentification citizenId) {
		try {
			System.out.println(employeeService.saveCitizenIdForEmployee(id, citizenId));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") long id) {
		try {
			employeeService.deleteEmployeeById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Job>> getAllJobs() {
		return ResponseEntity.ok(employeeService.findAllJobs());
	}
	
	@GetMapping(value = "/shifts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Shift>> getAllShifts() {
		return ResponseEntity.ok(employeeService.findAllShifts());
	}
	
//	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam("fullName") String fullName){
////		Person person = new Person();
////		person.setFullName(fullName);
//		return ResponseEntity.ok(employeeService.findByKeywords(fullName));
//	}
	
}
