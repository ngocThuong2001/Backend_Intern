package com.socialprotection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.CitizenIdentification;
import com.socialprotection.entity.Employee;
import com.socialprotection.entity.Guardian;
import com.socialprotection.entity.TypeOfOrphan;
import com.socialprotection.repository.ChildrenRepository;
import com.socialprotection.repository.ChildrenStatusRepository;
import com.socialprotection.repository.CitizenIdentificationRepository;
import com.socialprotection.repository.GuardianRepository;
import com.socialprotection.repository.ImageRepository;
import com.socialprotection.repository.TypeOfOrphanRepopsitory;
import com.socialprotection.service.ChildrenService;

@Service
public class ChildrenServiceImpl implements ChildrenService {
	@Autowired
	private ChildrenRepository childrenRepository;

	@Autowired
	private ChildrenStatusRepository childrenStatusRepository;

	@Autowired
	private TypeOfOrphanRepopsitory typeOfOrphanRepopsitory;

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private GuardianRepository guardianRepository;
	
	@Autowired
	private CitizenIdentificationRepository citizenIdRepository;

	@Override
	public Children save(Children children) {
		imageRepository.save(children.getImage());
		return childrenRepository.save(children);
	}

	@Override
	public TypeOfOrphan saveTypeOrphan(TypeOfOrphan typeOfOrphan) {
		return typeOfOrphanRepopsitory.save(typeOfOrphan);
	}

	@Override
	public ChildrenStatus saveChildrenStatus(ChildrenStatus childrenStatus) {
		return childrenStatusRepository.save(childrenStatus);
	}

	@Override
	public List<Children> findAll() {
		return childrenRepository.findAll();
	}

	@Override
	public Children findById(long id) {
		return childrenRepository.findOne(id);
	}

	@Override
	public void deleteChildrenById(long id) {
		childrenRepository.delete(id);
	}

	@Override
	public List<TypeOfOrphan> findAllTypeOrphan() {
		// TODO Auto-generated method stub
		return typeOfOrphanRepopsitory.findAll();
	}

	@Override
	public Children saveCitizenIdForChild(long id, CitizenIdentification citizenId) {
		CitizenIdentification citizenIdSaved = citizenIdRepository.save(citizenId);
		Children child = childrenRepository.findOne(id);
		child.setCitizenId(citizenIdSaved);
		return childrenRepository.save(child);
	}

	@Override
	public Children saveGuardianForChild(long id, Guardian guardian) {
		Guardian guardianSaved = guardianRepository.save(guardian);
		Children child = childrenRepository.findOne(id);
		child.setGuardian(guardianSaved);
		return childrenRepository.save(child);
	}

	@Override
	public Children saveEmployeeForChild(long childId, long employeeId) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		
		Children child = childrenRepository.findOne(childId);
		child.setEmployee(employee);
		return childrenRepository.save(child);
	}

	@Override
	public List<Children> findByEmployee(long id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setEmployeeId(id);
		return childrenRepository.findByEmployee(employee);
	}

	@Override
	public List<Children> findByStatus(String status) {
		ChildrenStatus childrenStatus = childrenStatusRepository.findByStatus(status).get(0);
		return childrenRepository.findByChildrenStatus(childrenStatus);
	}

	@Override
	public List<ChildrenStatus> findAllChildrenStatus() {
		// TODO Auto-generated method stub
		return childrenStatusRepository.findAll();
	}
}
