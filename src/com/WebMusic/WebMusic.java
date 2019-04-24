package com.WebMusic;

import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * 这个为所有音乐功能的全部实现接口
 **/

public interface WebMusic {
	/**
	 * <p>
	 * 该函数是用来输出获取到的搜索内容信息
	 **/
	public void getInfo(String search_name);

	/**
	 * <p>
	 * 该函数是用来输出歌单的内容信息
	 **/
	public void getMusicList(String link);

	/**
	 * <p>
	 * 该函数是用来输出获取到的搜索内容信息
	 **/
	public void getInfo(String search_name, int maxpage);

	/**
	 * <p>
	 * 该函数返回获取到的搜索内容信息
	 **/
	public String getInfoToString(String search_name);

	/**
	 * <p>
	 * 该函数返回获取到的搜索内容信息
	 **/
	public String getInfoToString(String search_name, int maxpage);

	/**
	 * <p>
	 * 该函数返回获取到的歌单内容信息
	 **/
	public String getMusicListToString(String link);

	/**
	 * <p>
	 * 该函数返回字符串数组格式的内容信息
	 **/
	public String[] getInfoToStringArray(String search_name);

	/**
	 * <p>
	 * 该函数返回字符串数组格式的内容信息
	 **/
	public String[] getInfoToStringArray(String search_name, int maxpage);

	/**
	 * <p>
	 * 该函数返回字符串数组格式的内容信息
	 **/
	public String[] getMusicListToStringArray(String link);

	/**
	 * <p>
	 * 该函数直接下载搜索到的所有歌曲
	 **/
	public void DownloadAll(String search_name);

	/**
	 * <p>
	 * 该函数直接下载搜索到的所有歌曲
	 **/
	public void DownloadAll(String search_name, String savePath);

	/**
	 * <p>
	 * 该函数直接下载搜索到的所有歌曲
	 **/
	public void DownloadAll(String search_name, String savePath, int maxpage);

	/**
	 * <p>
	 * 该函数直接下载搜索到的所有歌曲
	 **/
	public void DownloadList(String link);

	/**
	 * <p>
	 * 该函数直接下载搜索到的所有歌曲
	 **/
	public void DownloadList(String link, String savePath);

	/**
	 * <p>
	 * 该函数返回WebMusicInfo数组格式的内容信息
	 **/
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name);

	/**
	 * <p>
	 * 该函数返回WebMusicInfo数组格式的内容信息
	 **/
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name, int maxpage);

	/**
	 * <p>
	 * 该函数返回WebMusicInfo数组格式的内容信息
	 **/
	public WebMusicInfo[] getMusicListToWebMusicInfo(String link);

	/**
	 * <p>
	 * 该函数返回设置的cookie内容
	 **/
	public String getCookie();

	/**
	 * <p>
	 * 该函数返回设置的userAgent内容
	 **/
	public String getUserAgent();

	/**
	 * <p>
	 * 该函数设置cookie内容
	 **/
	public void setCookie(String cookie);

	/**
	 * <p>
	 * 该函数设置userAgent内容
	 **/
	public void setUserAgent(String userAgent);
	
	/**<p>该函数打印从xx页到xx页的数据*/
	public void getInfo(String search_name , int startPage , int endPage);
	/**<p>该函数返回从xx页到xx页的字符串数据*/
	public String getInfoToString(String search_name, int startPage , int endPage);
	/**<p>该函数返回从xx页到xx页的字符串数组数据*/
	public String[] getInfoToStringArray(String search_name, int startPage , int endPage);
	/**<p>该函数返回从xx页到xx页的WebMusicInfo数据*/
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name, int startPage , int endPage);
	/**<p>该函数下载从xx页到xx页的数据*/
	public void DownloadAll(String search_name, int startPage , int endPage);
	/**<p>该函数下载从xx页到xx页的数据*/
	public void DownloadAll(String search_name , String savePath, int startPage , int endPage);
	
}
