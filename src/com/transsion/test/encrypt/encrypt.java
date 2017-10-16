package com.transsion.test.encrypt;
/**
 * @author {2016521xiaoli@gmail.com}
 * @date 2017-10-16 ÉÏÎç10:23:41
 * @version 0.0.1
 * 
 */

import java.util.Map;

public class encrypt {
	private byte[] key;
	
	private char parameterSeparator='&';
	
	private char tagValueSeparator='=';
	
	private String parameterTag="Param";

	public encrypt(byte[] key) {
		this.key=key;
	}
	
	public encrypt(String key) {
		this.key=key.getBytes();
	}
	
	public String encrptUrlParams(Map<String, String> urlParams) {
		String[] urlParamTags=new String[urlParams.size()];
		String[] urlParamValues=new String[urlParams.size()];
		int count=0;
		for(String key:urlParams.keySet()) {
			urlParamTags[count]=key;
			urlParamValues[count]=urlParams.get(key);
			count++;
		}
		return encrptUrlParams(urlParamTags,urlParamValues);
	}
	
	public String encrptUrlParams(String[] urlParamValues) {
		String[] urlParamTags=new String[urlParamValues.length];
		for(int i=0;i<urlParamTags.length;i++) {
			urlParamTags[i]=parameterTag+"i";
		}
		return encrptUrlParams(urlParamTags,urlParamValues);
	}
	
	public String encrptUrlParams(String[] urlParamTags,String[] urlParamValues) {
		StringBuilder paramBuilder=new StringBuilder();
		for(int i=0;i<urlParamTags.length;i++) {
			if(i>0) {
				paramBuilder.append(parameterSeparator);
			}
			paramBuilder.append(urlParamTags[i]).append(tagValueSeparator).append(urlParamValues[i]);
		}
		return null;
	}
	
	public Map<String, String> decodeUrlParams(String url){
		return null;
	}
}
