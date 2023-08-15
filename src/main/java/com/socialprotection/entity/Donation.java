package com.socialprotection.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Donations")
@Table(name = "donations")
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donation_id")
	private long donationId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "donor_id")
	private Donor donor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "budget_id")
	private Budget budget;

	@Column(name = "amount")
	private float amount;

	@Column(name = "bank_code")
	private String bankCode;

	@Column(name = "bank_tran_number")
	private String bankTranNo;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "reason")
	private String reason;

	@Column(name = "donate_time")
	private Timestamp donateTime;

	@Column(name = "status", columnDefinition = "char(1)")
	private char status;

	@Column(name = "vnpay_tran_number")
	private String vnpayTranNo;

	public Donation(Donor donor, Budget budget, float amount, String bankCode, String bankTranNo, String cardType,
			String reason, Timestamp donateTime, char status, String vnpayTranNo) {
		super();
		this.donor = donor;
		this.budget = budget;
		this.amount = amount;
		this.bankCode = bankCode;
		this.bankTranNo = bankTranNo;
		this.cardType = cardType;
		this.reason = reason;
		this.donateTime = donateTime;
		this.status = status;
		this.vnpayTranNo = vnpayTranNo;
	}

	public Donation() {
		super();
	}

	public Donation(Donor donor, float amount, char status) {
		super();
		this.donor = donor;
		this.amount = amount;
		this.status = status;
	}

	public Donation(Donor donor, float amount, String reason, char status) {
		super();
		this.donor = donor;
		this.amount = amount;
		this.reason = reason;
		this.status = status;
	}

	public long getDonationId() {
		return donationId;
	}

	public void setDonationId(long donationId) {
		this.donationId = donationId;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankTranNo() {
		return bankTranNo;
	}

	public void setBankTranNo(String bankTranNo) {
		this.bankTranNo = bankTranNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Timestamp getDonateTime() {
		return donateTime;
	}

	public void setDonateTime(Timestamp donateTime) {
		this.donateTime = donateTime;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getVnpayTranNo() {
		return vnpayTranNo;
	}

	public void setVnpayTranNo(String vnpayTranNo) {
		this.vnpayTranNo = vnpayTranNo;
	}

	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donor=" + donor + ", budget=" + budget + ", amount=" + amount
				+ ", bankCode=" + bankCode + ", bankTranNo=" + bankTranNo + ", cardType=" + cardType + ", reason="
				+ reason + ", donateTime=" + donateTime + ", status=" + status + ", vnpayTranNo=" + vnpayTranNo + "]";
	}

}
