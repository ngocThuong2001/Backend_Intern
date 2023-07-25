package com.socialprotection.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "medical_record")
@Table(name = "medical_records")
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medical_record_id")
	private long medicalRecordId;

	@Column(name = "medical_title")
	private String medicalTitle;

	@Column(name = "medical_description", columnDefinition = "TEXT")
	private String medicalDescription;

	@Column(name = "record_date")
	private Date recordDate;

	@ManyToOne
	@JoinColumn(name = "child_id", nullable = false)
	private Children child;

	public MedicalRecord() {
		super();
	}

	public MedicalRecord(String medicalTitle, String medicalDescription, Date recordDate, Children child) {
		super();
		this.medicalTitle = medicalTitle;
		this.medicalDescription = medicalDescription;
		this.recordDate = recordDate;
		this.child = child;
	}

	public long getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public String getMedicalTitle() {
		return medicalTitle;
	}

	public void setMedicalTitle(String medicalTitle) {
		this.medicalTitle = medicalTitle;
	}

	public String getMedicalDescription() {
		return medicalDescription;
	}

	public void setMedicalDescription(String medicalDescription) {
		this.medicalDescription = medicalDescription;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Children getChild() {
		return child;
	}

	public void setChild(Children child) {
		this.child = child;
	}

}
