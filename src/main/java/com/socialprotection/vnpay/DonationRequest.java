package com.socialprotection.vnpay;

import com.socialprotection.entity.Donor;

public class DonationRequest {
	private Donor donor;
	private float amount;
	private String urlReturn;
	private String message;

	public DonationRequest() {
		super();
	}

	public DonationRequest(Donor donor, float amount, String urlReturn) {
		super();
		this.donor = donor;
		this.amount = amount;
		this.urlReturn = urlReturn;
	}

	public DonationRequest(Donor donor, float amount, String urlReturn, String message) {
		super();
		this.donor = donor;
		this.amount = amount;
		this.urlReturn = urlReturn;
		this.message = message;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getUrlReturn() {
		return urlReturn;
	}

	public void setUrlReturn(String urlReturn) {
		this.urlReturn = urlReturn;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
