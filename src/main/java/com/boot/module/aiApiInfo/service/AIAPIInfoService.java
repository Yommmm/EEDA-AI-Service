package com.boot.module.aiApiInfo.service;

import java.net.URLEncoder;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.boot.common.constaints.GlobalConstaints;
import com.boot.common.utils.AccessUtil;
import com.boot.common.utils.Base64Util;
import com.boot.common.utils.HttpUtil;

@Service
public class AIAPIInfoService {
	
	private static String accessToken = null;

	public String gesture(MultipartFile file) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
