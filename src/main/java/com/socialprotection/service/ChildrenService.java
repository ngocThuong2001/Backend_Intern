package com.socialprotection.service;

import java.util.List;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.CitizenIdentification;
import com.socialprotection.entity.Employee;
import com.socialprotection.entity.Guardian;
import com.socialprotection.entity.TypeOfOrphan;

public interface ChildrenService {
//	Save children
	public Children save(Children children);

	public TypeOfOrphan saveTypeOrphan(TypeOfOrphan typeOfOrphan);

	public ChildrenStatus saveChildrenStatus(ChildrenStatus childrenStatus);

//	Select children
	public List<Children> findAll();

	public List<Children> findByEmployee(long id);

	public Children findById(long id);

	public void deleteChildrenById(long id);

	List<TypeOfOrphan> findAllTypeOrphan();

	List<ChildrenStatus> findAllChildrenStatus();

	Children saveCitizenIdForChild(long id, CitizenIdentification citizenId);

	Children saveGuardianForChild(long id, Guardian guardian);

	Children saveEmployeeForChild(long childId, long employeeId);

	List<Children> findByStatus(String status);
}
