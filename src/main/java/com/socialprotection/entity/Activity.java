package com.socialprotection.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "activities")
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_id")
	private long activityId;
	
	@Column(name = "activity_name")
	private String activityName;
	
	@Column(name = "activity_description", columnDefinition = "TEXT")
	private String activityDescription;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name = "end_time")
	private Date endTime;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id")
	private Employee empAct;
	
	@ManyToMany(mappedBy = "activities", fetch = FetchType.EAGER)
    private Set<Children> children = new HashSet<>();

	public long getActivityId() {
		return activityId;
	}

//	public void setActivityId(long activityId) {
//		this.activityId = activityId;
//	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Employee getEmpAct() {
		return empAct;
	}

	public void setEmpAct(Employee empAct) {
		this.empAct = empAct;
	}

	public Set<Children> getChildren() {
		return children;
	}

	public void setChildren(Set<Children> children) {
		this.children = children;
	}

	public Activity(String activityName, String activityDescription, Date startTime, Date endTime, Employee empAct,
			Set<Children> children) {
		super();
		this.activityName = activityName;
		this.activityDescription = activityDescription;
		this.startTime = startTime;
		this.endTime = endTime;
		this.empAct = empAct;
		this.children = children;
	}

	public Activity() {
		super();
	}
	
	

}
