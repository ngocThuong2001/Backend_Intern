package com.socialprotection.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "citizen_identification")
public class CitizenIdentifications {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "citizen_id")
	private long citizenId;
	
	@Column(name = "citizen_ident_number")
	private char citizenIdentNumber;
	
	@Column(name = "issue_date")
	private Date issueDate;
	
	@Column(name = "issue_place")
	private String issuePlace;
	
	@Column(name = "expire_date")
	private Date expireDate;
	
	@OneToOne(mappedBy = "citizenId")
    private Children children;

	public long getCitizenId() {
		return citizenId;
	}

//	public void setCitizenId(long citizenId) {
//		this.citizenId = citizenId;
//	}

	public char getCitizenIdentNumber() {
		return citizenIdentNumber;
	}

	public void setCitizenIdentNumber(char citizenIdentNumber) {
		this.citizenIdentNumber = citizenIdentNumber;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssuePlace() {
		return issuePlace;
	}

	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}
	
	

}
