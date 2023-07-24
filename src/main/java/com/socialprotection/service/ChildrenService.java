package com.socialprotection.service;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.TypeOfOrphan;

public interface ChildrenService {
	Children save(Children children);
	TypeOfOrphan saveTypeOrphan(TypeOfOrphan typeOfOrphan);
	ChildrenStatus saveChildrenStatus(ChildrenStatus childrenStatus);
}
