package com.WebMusic;

import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * ���Ϊ�������ֹ��ܵ�ȫ��ʵ�ֽӿ�
 **/

public interface WebMusic {
	/**
	 * <p>
	 * �ú��������������ȡ��������������Ϣ
	 **/
	public void getInfo(String search_name);

	/**
	 * <p>
	 * �ú�������������赥��������Ϣ
	 **/
	public void getMusicList(String link);

	/**
	 * <p>
	 * �ú��������������ȡ��������������Ϣ
	 **/
	public void getInfo(String search_name, int maxpage);

	/**
	 * <p>
	 * �ú������ػ�ȡ��������������Ϣ
	 **/
	public String getInfoToString(String search_name);

	/**
	 * <p>
	 * �ú������ػ�ȡ��������������Ϣ
	 **/
	public String getInfoToString(String search_name, int maxpage);

	/**
	 * <p>
	 * �ú������ػ�ȡ���ĸ赥������Ϣ
	 **/
	public String getMusicListToString(String link);

	/**
	 * <p>
	 * �ú��������ַ��������ʽ��������Ϣ
	 **/
	public String[] getInfoToStringArray(String search_name);

	/**
	 * <p>
	 * �ú��������ַ��������ʽ��������Ϣ
	 **/
	public String[] getInfoToStringArray(String search_name, int maxpage);

	/**
	 * <p>
	 * �ú��������ַ��������ʽ��������Ϣ
	 **/
	public String[] getMusicListToStringArray(String link);

	/**
	 * <p>
	 * �ú���ֱ�����������������и���
	 **/
	public void DownloadAll(String search_name);

	/**
	 * <p>
	 * �ú���ֱ�����������������и���
	 **/
	public void DownloadAll(String search_name, String savePath);

	/**
	 * <p>
	 * �ú���ֱ�����������������и���
	 **/
	public void DownloadAll(String search_name, String savePath, int maxpage);

	/**
	 * <p>
	 * �ú���ֱ�����������������и���
	 **/
	public void DownloadList(String link);

	/**
	 * <p>
	 * �ú���ֱ�����������������и���
	 **/
	public void DownloadList(String link, String savePath);

	/**
	 * <p>
	 * �ú�������WebMusicInfo�����ʽ��������Ϣ
	 **/
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name);

	/**
	 * <p>
	 * �ú�������WebMusicInfo�����ʽ��������Ϣ
	 **/
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name, int maxpage);

	/**
	 * <p>
	 * �ú�������WebMusicInfo�����ʽ��������Ϣ
	 **/
	public WebMusicInfo[] getMusicListToWebMusicInfo(String link);

	/**
	 * <p>
	 * �ú����������õ�cookie����
	 **/
	public String getCookie();

	/**
	 * <p>
	 * �ú����������õ�userAgent����
	 **/
	public String getUserAgent();

	/**
	 * <p>
	 * �ú�������cookie����
	 **/
	public void setCookie(String cookie);

	/**
	 * <p>
	 * �ú�������userAgent����
	 **/
	public void setUserAgent(String userAgent);
	
	/**<p>�ú�����ӡ��xxҳ��xxҳ������*/
	public void getInfo(String search_name , int startPage , int endPage);
	/**<p>�ú������ش�xxҳ��xxҳ���ַ�������*/
	public String getInfoToString(String search_name, int startPage , int endPage);
	/**<p>�ú������ش�xxҳ��xxҳ���ַ�����������*/
	public String[] getInfoToStringArray(String search_name, int startPage , int endPage);
	/**<p>�ú������ش�xxҳ��xxҳ��WebMusicInfo����*/
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name, int startPage , int endPage);
	/**<p>�ú������ش�xxҳ��xxҳ������*/
	public void DownloadAll(String search_name, int startPage , int endPage);
	/**<p>�ú������ش�xxҳ��xxҳ������*/
	public void DownloadAll(String search_name , String savePath, int startPage , int endPage);
	
}
