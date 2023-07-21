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
	private long orphan_type_id;
	@Column
	private String orphan_type_name;

	@OneToMany(mappedBy = "typeOfOrphans")
	private List<Children> children = new ArrayList<>();

	

	public long getOrphan_type_id() {
		return orphan_type_id;
	}

	public void setOrphan_type_id(int orphan_type_id) {
		this.orphan_type_id = orphan_type_id;
	}

	public String getOrphan_type_name() {
		return orphan_type_name;
	}

	public void setOrphan_type_name(String orphan_type_name) {
		this.orphan_type_name = orphan_type_name;
	}

	public List<Children> getChildren() {
		return children;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
	}
	
	
	
}
