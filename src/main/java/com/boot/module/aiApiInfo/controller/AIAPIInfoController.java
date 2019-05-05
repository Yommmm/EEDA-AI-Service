package com.boot.module.aiApiInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.module.aiApiInfo.service.AIAPIInfoService;

@RestController
@RequestMapping("/eeda/ai/gesture")
public class AIAPIInfoController {

	@Autowired
	private AIAPIInfoService aiAPIInfoService;
	
	@PostMapping
	public Object test(MultipartFile file) {
		return aiAPIInfoService.gesture(file);
	}
	
}
