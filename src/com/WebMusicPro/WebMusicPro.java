package com.WebMusicPro;

import com.WebMusicPro.util.WebMusicProInfo;

/**
* <p>����ʱ�䣺2019��1��22�� ����7:57:24
* <p>��Ŀ���ƣ�WebMusic
* 
* <pre>��˵����
* WebMusicProΪWebMusic�ļ�ǿ��
* </pre>
*
* @version 1.0
* @since JDK 1.8
* �ļ����ƣ�WebMusicPro.java
* */

public interface WebMusicPro{
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
	 * �ú�������WebMusicProInfo�����ʽ��������Ϣ
	 **/
	public WebMusicProInfo[] getInfoToWebMusicProInfo(String search_name);

	/**
	 * <p>
	 * �ú�������WebMusicProInfo�����ʽ��������Ϣ
	 **/
	public WebMusicProInfo[] getInfoToWebMusicProInfo(String search_name, int maxpage);

	/**
	 * <p>
	 * �ú�������WebMusicProInfo�����ʽ��������Ϣ
	 **/
	public WebMusicProInfo[] getMusicListToWebMusicProInfo(String link);
	/**<p>�ú����ṩ�������ָ�Ʒ����*/
	public void DownloadFlac(String search_name);
	/**<p>�ú����ṩ�������ָ�Ʒ����*/
	public void DownloadFlac(String search_name , int maxpage);
	/**<p>�ú����ṩ����������������*/
	public void DownloadApe(String search_name);
	/**<p>�ú����ṩ����������������*/
	public void DownloadApe(String search_name , int maxpage);
	/**<p>�ú����ṩ��������һ������*/
	public void Download320k(String search_name);
	/**<p>�ú����ṩ��������һ������*/
	public void Download320k(String search_name , int maxpage);
	/**<p>�ú����ṩ������������������*/
	public void Download128k(String search_name);
	/**<p>�ú����ṩ������������������*/
	public void Download128k(String search_name , int maxpage);
	/**<p>�ú����ṩ��������ս������(Ĭ��)*/
	public void DownloadM4a(String search_name);
	/**<p>�ú����ṩ��������ս������(Ĭ��)*/
	public void DownloadM4a(String search_name , int maxpage);
	
	/**<p>�ú����ṩ�������ָ�Ʒ����*/
	public void DownloadFlac(String search_name ,String savePath);
	/**<p>�ú����ṩ�������ָ�Ʒ����*/
	public void DownloadFlac(String search_name ,String savePath , int maxpage);
	/**<p>�ú����ṩ����������������*/
	public void DownloadApe(String search_name ,String savePath);
	/**<p>�ú����ṩ����������������*/
	public void DownloadApe(String search_name  ,String savePath, int maxpage);
	/**<p>�ú����ṩ��������һ������*/
	public void Download320k(String search_name ,String savePath);
	/**<p>�ú����ṩ��������һ������*/
	public void Download320k(String search_name  ,String savePath, int maxpage);
	/**<p>�ú����ṩ������������������*/
	public void Download128k(String search_name ,String savePath);
	/**<p>�ú����ṩ������������������*/
	public void Download128k(String search_name  ,String savePath, int maxpage);
	/**<p>�ú����ṩ��������ս������(Ĭ��)*/
	public void DownloadM4a(String search_name ,String savePath);
	/**<p>�ú����ṩ��������ս������(Ĭ��)*/
	public void DownloadM4a(String search_name ,String savePath , int maxpage);
	
	/**<p>�ú����ṩ���ظ�Ʒ����*/
	public void DownloadFlacList(String link);
	/**<p>�ú����ṩ���ظ赥��������*/
	public void DownloadApeList(String link);
	/**<p>�ú����ṩ���ظ赥һ������*/
	public void Download320kList(String link);
	/**<p>�ú����ṩ���ظ赥����������*/
	public void Download128kList(String link);
	/**<p>�ú����ṩ���ظ赥ս������(Ĭ��)*/
	public void DownloadM4aList(String link);
	
	/**<p>ֻ��Ҫ����һ�������Ĳ�����ϸҳ�����<p>�Ϳ����������׸�<p>��Ҫ�������������*/
	public void DownloadMusic(String musicPage , String format);
	/**<p>ֻ��Ҫ����һ���赥�Ĳ�����ϸҳ�����<p>�Ϳ���������赥<p>��Ҫ�������������*/
	public void DownloadMusicList(String musicPage , String format);
	
	/**<p>�ú����ṩ���ظ赥��Ʒ����*/
	public void DownloadFlacList(String link ,String savePath );
	
	/**<p>�ú����ṩ���ظ赥��������*/
	public void DownloadApeList(String link ,String savePath );
	/**<p>�ú����ṩ���ظ赥һ������*/
	public void Download320kList(String link ,String savePath );
	/**<p>�ú����ṩ���ظ赥����������*/
	public void Download128kList(String link  ,String savePath);
	/**<p>�ú����ṩ���ظ赥ս������(Ĭ��)*/
	public void DownloadM4aList(String link  ,String savePath);
	
	/**<p>ֻ��Ҫ����һ�������Ĳ�����ϸҳ�����<p>�Ϳ����������׸�<p>��Ҫ�������������<p>ape: ����<p>flac: ��Ʒ<p>m320k: һ��<p>m128k: ������<p>m4a: ս��*/
	public void DownloadMusic(String musicPage  ,String savePath, String format);
	/**<p>ֻ��Ҫ����һ���赥�Ĳ�����ϸҳ�����<p>�Ϳ���������赥<p>��Ҫ�������������<p>ape: ����<p>flac: ��Ʒ<p>m320k: һ��<p>m128k: ������<p>m4a: ս��*/
	public void DownloadMusicList(String musicPage  ,String savePath, String format);
	
	/**<p>�ú�����ӡ��xxҳ��xxҳ������*/
	public void getInfo(String search_name , int startPage , int endPage);
	/**<p>�ú������ش�xxҳ��xxҳ���ַ�������*/
	public String getInfoToString(String search_name, int startPage , int endPage);
	/**<p>�ú������ش�xxҳ��xxҳ���ַ�����������*/
	public String[] getInfoToStringArray(String search_name, int startPage , int endPage);
	/**<p>�ú������ش�xxҳ��xxҳ��WebMusicProInfo����*/
	public WebMusicProInfo[] getInfoToWebMusicProInfo(String search_name, int startPage , int endPage);
	/**<p>�ú������ش�xxҳ��xxҳ������*/
	public void DownloadAll(String search_name, int startPage , int endPage);
	public void DownloadAll(String search_name, String savePath, int startPage , int endPage);
	/**<p>�ú����ṩ�������ָ�Ʒ����*/
	public void DownloadFlac(String search_name , int startPage , int endPage);
	/**<p>�ú����ṩ����������������*/
	public void DownloadApe(String search_name , int startPage , int endPage);
	/**<p>�ú����ṩ��������һ������*/
	public void Download320k(String search_name , int startPage , int endPage);
	/**<p>�ú����ṩ������������������*/
	public void Download128k(String search_name , int startPage , int endPage);
	/**<p>�ú����ṩ��������ս������(Ĭ��)*/
	public void DownloadM4a(String search_name , int startPage , int endPage);
	
	/**<p>�ú����ṩ�������ָ�Ʒ����*/
	public void DownloadFlac(String search_name ,String savePath , int startPage , int endPage);
	/**<p>�ú����ṩ����������������*/
	public void DownloadApe(String search_name ,String savePath , int startPage , int endPage);
	/**<p>�ú����ṩ��������һ������*/
	public void Download320k(String search_name ,String savePath , int startPage , int endPage);
	
	/**<p>�ú����ṩ������������������*/
	public void Download128k(String search_name ,String savePath, int startPage , int endPage);
	/**<p>�ú����ṩ��������ս������(Ĭ��)*/
	public void DownloadM4a(String search_name ,String savePath, int startPage , int endPage);

}
