package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.MedicalRecordRepository;
import com.socialprotection.service.MedicalRecordService;

@Service
public class MedicalRecordServiceimpl implements MedicalRecordService{
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
}
