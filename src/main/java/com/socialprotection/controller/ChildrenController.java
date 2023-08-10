package com.socialprotection.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;

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
import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.CitizenIdentification;
import com.socialprotection.entity.Guardian;
import com.socialprotection.entity.Image;
import com.socialprotection.entity.TypeOfOrphan;
import com.socialprotection.googledrivestore.GoogleDriveService;
import com.socialprotection.request.ChildrenRequest;
import com.socialprotection.service.ChildrenService;
import com.socialprotection.service.FilesStorageService;

@CrossOrigin
@RestController
@RequestMapping("/api")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ChildrenController {

	@Autowired
	private FilesStorageService storageService;

	@Autowired
	private ChildrenService childrenService;

	@Autowired
	private GoogleDriveService googleDriveService;

	@GetMapping(value = "/children", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Children>> getChildrenByStatus(
			@RequestParam(name = "status", required = false) String status) {
		List<Children> children;
		if (status != null) {
			return ResponseEntity.ok(childrenService.findByStatus(status));
		} else {
			return ResponseEntity.ok(childrenService.findAll());
		}
	}

	@GetMapping(value = "/children/types", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TypeOfOrphan>> getAllTypeOrphan() {
		return ResponseEntity.ok(childrenService.findAllTypeOrphan());
	}

	@GetMapping(value = "/children/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ChildrenStatus>> getAllChildrenStatus() {
		return ResponseEntity.ok(childrenService.findAllChildrenStatus());
	}
	
	@GetMapping(value = "/children/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> countAllChildren(@RequestParam(name = "status", required = false) String status) {
		return ResponseEntity.ok(childrenService.countChildren(status));
	}

	@PostMapping(value = "/children/image", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveImage(@RequestPart("image") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		File googleFile = googleDriveService.uploadFile(file);
		String image_url = googleFile.getWebContentLink();
		System.out.println(image_url);
		return null;
	}

	@PostMapping(value = "/children", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveChildren(@RequestPart("children") ChildrenRequest childrenRequest,
			@RequestPart("image") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		System.out.println(fileName);
		System.out.println(childrenRequest.toString());
		try {
			Children children = new Children();
//			String imageUrl = storageService.save(file);
			File googleFile = googleDriveService.uploadFile(file);
			String imageUrl = googleFile.getWebContentLink();
			Image image = new Image(imageUrl);

			children.setFirstName(childrenRequest.getFirstName());
			children.setLastName(childrenRequest.getLastName());
			children.setFullName(childrenRequest.getLastName() + " " + childrenRequest.getFirstName());
			children.setImage(image);
			children.setBirthDay(childrenRequest.getBirthDay());
			children.setAddressPermanent(childrenRequest.getAddressPermanent());
			children.setAddressTemporary(childrenRequest.getAddressTemporary());
			children.setCircumstance(childrenRequest.getCircumstance());
			children.setDateIn(childrenRequest.getDateIn());
			children.setGender(childrenRequest.getGender());
			children.setTypeOfOrphan(childrenRequest.getTypeOfOrphan());
			children.setChildrenStatus(new ChildrenStatus(1));
			children.setNationality(childrenRequest.getNationality());

			return ResponseEntity.ok(childrenService.save(children));
//			System.out.println(image.getImageUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(null);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Children> getChildrenById(@PathVariable("id") long id) {
		return ResponseEntity.ok(childrenService.findById(id));
	}

	@GetMapping(value = "employee/{id}/children", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Children>> getChildrenByEmployee(@PathVariable("id") long id) {
		return ResponseEntity.ok(childrenService.findByEmployee(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteChildrenById(@PathVariable("id") long id) {
		try {
			childrenService.deleteChildrenById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("children/{id}/citizenid")
	public ResponseEntity<HttpStatus> saveChildCitizenId(@PathVariable("id") long id,
			@RequestBody CitizenIdentification citizenId) {
		try {
			System.out.println(childrenService.saveCitizenIdForChild(id, citizenId));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("children/{id}/guardian")
	public ResponseEntity<HttpStatus> saveChildGuardian(@PathVariable("id") long id, @RequestBody Guardian guardian) {
		try {
			System.out.println(childrenService.saveGuardianForChild(id, guardian));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("children/{childId}/employee/{employeeId}")
	public ResponseEntity<HttpStatus> saveChildEmployee(@PathVariable("childId") long childId,
			@PathVariable("employeeId") long employeeId) {
		try {
			System.out.println(childrenService.saveEmployeeForChild(childId, employeeId));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
