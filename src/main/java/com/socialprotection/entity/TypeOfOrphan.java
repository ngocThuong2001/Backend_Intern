package com.socialprotection.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type_of_orphans")
public class TypeOfOrphan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orphan_type_id")
	private long orphanTypeId;
	@Column(name = "orphan_type_name")
	private String orphanTypeName;

	@OneToMany(mappedBy = "typeOfOrphans")
	private List<Children> children = new ArrayList<>();

	public long getOrphanTypeId() {
		return orphanTypeId;
	}

//	public void setOrphanTypeId(long orphanTypeId) {
//		this.orphanTypeId = orphanTypeId;
//	}

	public String getOrphanTypeName() {
		return orphanTypeName;
	}

	public void setOrphanTypeName(String orphanTypeName) {
		this.orphanTypeName = orphanTypeName;
	}

	public List<Children> getChildren() {
		return children;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
	}

	public TypeOfOrphan(String orphanTypeName, List<Children> children) {
		super();
		this.orphanTypeName = orphanTypeName;
		this.children = children;
	}

	public TypeOfOrphan() {
		super();
	}

	

	
	
	
	
}