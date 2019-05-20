package com.boot.module.aiApiInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.module.aiApiInfo.bean.AIAPIInfo;
import com.boot.module.aiApiInfo.service.AIAPIInfoService;

@RestController
@RequestMapping("/eeda/ai/gesture")
public class AIAPIInfoController {

	@Autowired
	private AIAPIInfoService aiAPIInfoService;
	
	@PostMapping("/{eMac}")
	public Object gesture(@PathVariable("eMac") String eMac, MultipartFile file) throws Exception {
		return aiAPIInfoService.gesture(eMac, file);
	}
	
	@GetMapping("/list")
	public Object list() {
		return aiAPIInfoService.list();
	}
	
	@PostMapping("/apiInfo")
	public Object apiInfo(@RequestBody AIAPIInfo apiInfo) {
		return aiAPIInfoService.apiInfo(apiInfo);
	}
	
}
