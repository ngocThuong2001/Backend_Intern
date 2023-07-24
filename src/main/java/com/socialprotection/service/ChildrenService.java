package com.socialprotection.service;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.TypeOfOrphan;

public interface ChildrenService {
	public Children save(Children children);
	public TypeOfOrphan saveTypeOrphan(TypeOfOrphan typeOfOrphan);
	public ChildrenStatus saveChildrenStatus(ChildrenStatus childrenStatus);
}
