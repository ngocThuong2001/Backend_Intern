package com.socialprotection.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Donation;
import com.socialprotection.entity.Donor;
import com.socialprotection.service.DonationService;
import com.socialprotection.vnpay.DonationRequest;
import com.socialprotection.vnpay.DonationReturnRequest;
import com.socialprotection.vnpay.VnpayService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DonationController {
	@Autowired
	private DonationService donationService;

	@Autowired
	private VnpayService vnpayService;

	@GetMapping(value = "/donations", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Donation>> getAllDonations() throws ParseException {
		List<Donation> donations = donationService.fndAll();
		
		return ResponseEntity.ok(donations);
	}

	@PostMapping(value = "/donations/return", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> receiveDonation(@RequestBody DonationReturnRequest request) throws ParseException {
		String resCode = request.getVnp_ResponseCode();
		if (resCode.equals("00")) {
			long donationId = Integer.valueOf(request.getVnp_TxnRef());
			Donation donation = donationService.getDonationById(donationId);
			donation.setBankCode(request.getVnp_BankCode());
			donation.setBankTranNo(request.getVnp_BankTranNo());
			donation.setCardType(request.getVnp_CardType());
			donation.setVnpayTranNo(request.getVnp_TransactionNo());
			donation.setStatus('0');

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = (Date) formatter.parse(request.getVnp_PayDate());
			Timestamp timestamp = new java.sql.Timestamp(date.getTime());
			donation.setDonateTime(timestamp);
			System.out.println(donation.toString());
			donationService.saveDonation(donation);
			return ResponseEntity.ok(donation);
		}

		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}

	@PostMapping(value = "/donations", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> receiveDonor(@RequestBody DonationRequest request) {

//		System.out.println(request.getParameterNames().nextElement().toString());
//		System.out.println(donor.toString());
//		System.out.println(amount);
//		System.out.println(bankCode);

		Donor donor = donationService.saveDonor(request.getDonor());
		Donation donation = new Donation(donor, request.getAmount(), request.getMessage(), '1');
		donationService.saveDonation(donation);
		String urlRedirect = vnpayService.generateUrlRedirect(request.getAmount(), donation.getDonationId(),
				request.getUrlReturn(), request.getMessage());

		Map<String, String> returnStatement = new HashMap<>();
		returnStatement.put("urlRedirect", urlRedirect);
		return ResponseEntity.ok(returnStatement);

	}
}
