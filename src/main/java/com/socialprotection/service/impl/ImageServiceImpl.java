package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.ImageRepository;
import com.socialprotection.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageRepository imageRepository;
}
