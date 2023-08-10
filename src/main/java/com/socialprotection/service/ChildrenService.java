package com.socialprotection.service;

import java.util.List;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.CitizenIdentification;
import com.socialprotection.entity.Employee;
import com.socialprotection.entity.Guardian;
import com.socialprotection.entity.TypeOfOrphan;

public interface ChildrenService {
//	Select
	List<Children> findAll();

	List<Children> findByEmployee(long id);

	List<Children> findByStatus(String status);

	Children findById(long id);

	List<TypeOfOrphan> findAllTypeOrphan();

	List<ChildrenStatus> findAllChildrenStatus();

	long countChildren( String status);

//	Save
	Children save(Children children);

	TypeOfOrphan saveTypeOrphan(TypeOfOrphan typeOfOrphan);

	ChildrenStatus saveChildrenStatus(ChildrenStatus childrenStatus);

	Children saveCitizenIdForChild(long id, CitizenIdentification citizenId);

	Children saveGuardianForChild(long id, Guardian guardian);

	Children saveEmployeeForChild(long childId, long employeeId);

//	Delete
	void deleteChildrenById(long id);
}
