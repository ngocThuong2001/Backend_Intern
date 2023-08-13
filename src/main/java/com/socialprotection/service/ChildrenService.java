package com.socialprotection.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.CitizenIdentification;
import com.socialprotection.entity.Guardian;
import com.socialprotection.entity.TypeOfOrphan;

public interface ChildrenService {
//	Select
	List<Children> findAll();

	List<Children> findByEmployee(long id);

	Page<Children> findByStatus(String status, Integer limit,  Integer page, String sortBy, String sortDirec);
	Page<Children> findByName(String name, Integer limit,  Integer page, String sortBy, String sortDirec);

	Children findById(long id);

	List<TypeOfOrphan> findAllTypeOrphan();

	List<ChildrenStatus> findAllChildrenStatus();

	long countChildren( String status);
	
	Page<Children> getAllChildrenPagin(Integer limit,  Integer page, String sortBy, String sortDirec);

//	Save
	Children save(Children children);
	Children update(Children children);

	TypeOfOrphan saveTypeOrphan(TypeOfOrphan typeOfOrphan);

	ChildrenStatus saveChildrenStatus(ChildrenStatus childrenStatus);

	Children saveCitizenIdForChild(long id, CitizenIdentification citizenId);

	Children saveGuardianForChild(long id, Guardian guardian);

	Children saveEmployeeForChild(long childId, long employeeId);
	
	Children saveStatusForChild(long childId, long statusId);

//	Delete
	void deleteChildrenById(long id);
}
