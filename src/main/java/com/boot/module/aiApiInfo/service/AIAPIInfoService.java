package com.boot.module.aiApiInfo.service;

import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.boot.common.constaints.GlobalConstaints;
import com.boot.common.utils.AccessUtil;
import com.boot.common.utils.Base64Util;
import com.boot.common.utils.HttpUtil;
import com.boot.module.aiApiInfo.bean.AIAPIInfo;
import com.boot.module.aiApiInfo.repository.AIAPIInfoRepository;

@Service
public class AIAPIInfoService {
	
	private static String accessToken = null;
	
	@Autowired
	private AIAPIInfoRepository repository;

	@Transactional
	public String gesture(String eMac, MultipartFile file) throws Exception {
		
		AIAPIInfo apiInfo = repository.findByEMac(eMac);
		if(apiInfo.geteCounter() > 2000) {
			return "当日已超过使用条数，请联系维护人员购买！";
		}
		apiInfo.seteCounter(apiInfo.geteCounter() + 1);
		repository.save(apiInfo);
		
		byte[] imgData = file.getBytes();
		String imgStr = Base64Util.encode(imgData);
		String imgParam = URLEncoder.encode(imgStr, "UTF-8");
		
		String param = "image=" + imgParam;
		
		String result = HttpUtil.post(GlobalConstaints.GESTURE_URL, accessToken, param);
		Map<?, ?> resultMap = JSONObject.parseObject(result, Map.class);
		
		if(110 == Integer.valueOf(resultMap.get("error_code").toString())) {
			accessToken = AccessUtil.getAccessToken();
			result = HttpUtil.post(GlobalConstaints.GESTURE_URL, accessToken, param);
			resultMap = JSONObject.parseObject(result, Map.class);
		}
		
		System.out.println(result);
		return result;
    }

	public Object list() {
		return repository.findAll();
	}

	public Object apiInfo(AIAPIInfo apiInfo) {
		return repository.save(apiInfo);
	}
	
}
