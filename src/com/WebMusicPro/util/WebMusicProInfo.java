package com.WebMusicPro.util;

import com.WebMusic.util.WebMusicInfo;

/**
* <p>����ʱ�䣺2019��1��29�� ����4:02:19
* <p>��Ŀ���ƣ�WebMusic
* 
* <p>��˵����
*
* @version 1.0
* @since JDK 1.8
* �ļ����ƣ�WebMusicProInfo.java
* */
public class WebMusicProInfo extends WebMusicInfo{
	private String APE ="" , FLAC="" , M320k = "" , M128k = "" , m4a = "";
	
	public String getQQProAll()
	{
		return getAllToCloud()+"��������: "+getAPE()+"\n��Ʒ����: "+getFLAC()+"\nһ������: "+getM320k()+"\n����������: "+getM128k()+"\nս������: "+getM4a()+"\n";
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
