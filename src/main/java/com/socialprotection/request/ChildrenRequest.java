package com.socialprotection.request;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialprotection.entity.TypeOfOrphan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChildrenRequest {
	private String firstName;
	private String lastName;
	private String gender;
	private String nationality;
	private String addressPermanent;
	private String addressTemporary;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date birthDay;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateIn;
	private String circumstance;
	private TypeOfOrphan typeOfOrphan;

	public ChildrenRequest() {
		super();
	}

	public ChildrenRequest(String firstName, String lastName, String gender, String nationality,
			String addressPermanent, String addressTemporary, Date birthDay, Date dateIn, String circumstance,
			TypeOfOrphan typeOfOrphan) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.nationality = nationality;
		this.addressPermanent = addressPermanent;
		this.addressTemporary = addressTemporary;
		this.birthDay = birthDay;
		this.dateIn = dateIn;
		this.circumstance = circumstance;
		this.typeOfOrphan = typeOfOrphan;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddressPermanent() {
		return addressPermanent;
	}

	public void setAddressPermanent(String addressPermanent) {
		this.addressPermanent = addressPermanent;
	}

	public String getAddressTemporary() {
		return addressTemporary;
	}

	public void setAddressTemporary(String addressTemporary) {
		this.addressTemporary = addressTemporary;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public String getCircumstance() {
		return circumstance;
	}

	public void setCircumstance(String circumstance) {
		this.circumstance = circumstance;
	}

	public TypeOfOrphan getTypeOfOrphan() {
		return typeOfOrphan;
	}

	public void setTypeOfOrphan(TypeOfOrphan typeOfOrphan) {
		this.typeOfOrphan = typeOfOrphan;
	}

	@Override
	public String toString() {
		return "ChildrenRequest [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", nationality=" + nationality + ", addressPermanent=" + addressPermanent + ", addressTemporary="
				+ addressTemporary + ", birthDay=" + birthDay + ", dateIn=" + dateIn + ", circumstance=" + circumstance
				+ ", typeOfOrphan=" + typeOfOrphan + "]";
	}

}
