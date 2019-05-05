package com.boot.common.utils;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AccessUtil {

	public static String getAccessToken() throws UnirestException {
		HttpResponse<String> response = Unirest.post("https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=cGLH31mqliyPcEdonan9IrOP&client_secret=4ZqxDNGzFSSM65G2WqyeRE0wbszAlhLM")
				  .header("cache-control", "no-cache")
				  .asString();
		
		String body = response.getBody();
		Map<?, ?> result = JSONObject.parseObject(body, Map.class);
		
		return result.get("access_token").toString();
	}
	
}
