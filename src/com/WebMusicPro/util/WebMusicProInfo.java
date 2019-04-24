package com.WebMusicPro.util;

import com.WebMusic.util.WebMusicInfo;

/**
* <p>创建时间：2019年1月29日 下午4:02:19
* <p>项目名称：WebMusic
* 
* <p>类说明：
*
* @version 1.0
* @since JDK 1.8
* 文件名称：WebMusicProInfo.java
* */
public class WebMusicProInfo extends WebMusicInfo{
	private String APE ="" , FLAC="" , M320k = "" , M128k = "" , m4a = "";
	
	public String getQQProAll()
	{
		return getAllToCloud()+"无损音质: "+getAPE()+"\n高品音质: "+getFLAC()+"\n一般音质: "+getM320k()+"\n伊拉克音质: "+getM128k()+"\n战损音质: "+getM4a()+"\n";
	}
	
	public String getAPE() {
		return APE;
	}

	public String getFLAC() {
		return FLAC;
	}

	public String getM320k() {
		return M320k;
	}

	public String getM128k() {
		return M128k;
	}

	public String getM4a() {
		return m4a;
	}

	public void setAPE(String aPE) {
		APE = aPE;
	}

	public void setFLAC(String fLAC) {
		FLAC = fLAC;
	}

	public void setM320k(String m320k) {
		M320k = m320k;
	}

	public void setM128k(String m128k) {
		M128k = m128k;
	}

	public void setM4a(String m4a) {
		this.m4a = m4a;
	}
	
}
