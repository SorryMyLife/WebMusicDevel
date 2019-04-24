package com.WebMusicPro;

import com.WebMusicPro.util.WebMusicProInfo;

/**
* <p>创建时间：2019年1月22日 下午7:57:24
* <p>项目名称：WebMusic
* 
* <pre>类说明：
* WebMusicPro为WebMusic的加强版
* </pre>
*
* @version 1.0
* @since JDK 1.8
* 文件名称：WebMusicPro.java
* */

public interface WebMusicPro{
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
	 * 该函数返回WebMusicProInfo数组格式的内容信息
	 **/
	public WebMusicProInfo[] getInfoToWebMusicProInfo(String search_name);

	/**
	 * <p>
	 * 该函数返回WebMusicProInfo数组格式的内容信息
	 **/
	public WebMusicProInfo[] getInfoToWebMusicProInfo(String search_name, int maxpage);

	/**
	 * <p>
	 * 该函数返回WebMusicProInfo数组格式的内容信息
	 **/
	public WebMusicProInfo[] getMusicListToWebMusicProInfo(String link);
	/**<p>该函数提供下载音乐高品音质*/
	public void DownloadFlac(String search_name);
	/**<p>该函数提供下载音乐高品音质*/
	public void DownloadFlac(String search_name , int maxpage);
	/**<p>该函数提供下载音乐无损音质*/
	public void DownloadApe(String search_name);
	/**<p>该函数提供下载音乐无损音质*/
	public void DownloadApe(String search_name , int maxpage);
	/**<p>该函数提供下载音乐一般音质*/
	public void Download320k(String search_name);
	/**<p>该函数提供下载音乐一般音质*/
	public void Download320k(String search_name , int maxpage);
	/**<p>该函数提供下载音乐伊拉克音质*/
	public void Download128k(String search_name);
	/**<p>该函数提供下载音乐伊拉克音质*/
	public void Download128k(String search_name , int maxpage);
	/**<p>该函数提供下载音乐战损音质(默认)*/
	public void DownloadM4a(String search_name);
	/**<p>该函数提供下载音乐战损音质(默认)*/
	public void DownloadM4a(String search_name , int maxpage);
	
	/**<p>该函数提供下载音乐高品音质*/
	public void DownloadFlac(String search_name ,String savePath);
	/**<p>该函数提供下载音乐高品音质*/
	public void DownloadFlac(String search_name ,String savePath , int maxpage);
	/**<p>该函数提供下载音乐无损音质*/
	public void DownloadApe(String search_name ,String savePath);
	/**<p>该函数提供下载音乐无损音质*/
	public void DownloadApe(String search_name  ,String savePath, int maxpage);
	/**<p>该函数提供下载音乐一般音质*/
	public void Download320k(String search_name ,String savePath);
	/**<p>该函数提供下载音乐一般音质*/
	public void Download320k(String search_name  ,String savePath, int maxpage);
	/**<p>该函数提供下载音乐伊拉克音质*/
	public void Download128k(String search_name ,String savePath);
	/**<p>该函数提供下载音乐伊拉克音质*/
	public void Download128k(String search_name  ,String savePath, int maxpage);
	/**<p>该函数提供下载音乐战损音质(默认)*/
	public void DownloadM4a(String search_name ,String savePath);
	/**<p>该函数提供下载音乐战损音质(默认)*/
	public void DownloadM4a(String search_name ,String savePath , int maxpage);
	
	/**<p>该函数提供下载高品音质*/
	public void DownloadFlacList(String link);
	/**<p>该函数提供下载歌单无损音质*/
	public void DownloadApeList(String link);
	/**<p>该函数提供下载歌单一般音质*/
	public void Download320kList(String link);
	/**<p>该函数提供下载歌单伊拉克音质*/
	public void Download128kList(String link);
	/**<p>该函数提供下载歌单战损音质(默认)*/
	public void DownloadM4aList(String link);
	
	/**<p>只需要传入一个歌曲的播放详细页面进来<p>就可以下载这首歌<p>需要传入歌曲的音质*/
	public void DownloadMusic(String musicPage , String format);
	/**<p>只需要传入一个歌单的播放详细页面进来<p>就可以下载这歌单<p>需要传入歌曲的音质*/
	public void DownloadMusicList(String musicPage , String format);
	
	/**<p>该函数提供下载歌单高品音质*/
	public void DownloadFlacList(String link ,String savePath );
	
	/**<p>该函数提供下载歌单无损音质*/
	public void DownloadApeList(String link ,String savePath );
	/**<p>该函数提供下载歌单一般音质*/
	public void Download320kList(String link ,String savePath );
	/**<p>该函数提供下载歌单伊拉克音质*/
	public void Download128kList(String link  ,String savePath);
	/**<p>该函数提供下载歌单战损音质(默认)*/
	public void DownloadM4aList(String link  ,String savePath);
	
	/**<p>只需要传入一个歌曲的播放详细页面进来<p>就可以下载这首歌<p>需要传入歌曲的音质<p>ape: 无损<p>flac: 高品<p>m320k: 一般<p>m128k: 伊拉克<p>m4a: 战损*/
	public void DownloadMusic(String musicPage  ,String savePath, String format);
	/**<p>只需要传入一个歌单的播放详细页面进来<p>就可以下载这歌单<p>需要传入歌曲的音质<p>ape: 无损<p>flac: 高品<p>m320k: 一般<p>m128k: 伊拉克<p>m4a: 战损*/
	public void DownloadMusicList(String musicPage  ,String savePath, String format);
	
	/**<p>该函数打印从xx页到xx页的数据*/
	public void getInfo(String search_name , int startPage , int endPage);
	/**<p>该函数返回从xx页到xx页的字符串数据*/
	public String getInfoToString(String search_name, int startPage , int endPage);
	/**<p>该函数返回从xx页到xx页的字符串数组数据*/
	public String[] getInfoToStringArray(String search_name, int startPage , int endPage);
	/**<p>该函数返回从xx页到xx页的WebMusicProInfo数据*/
	public WebMusicProInfo[] getInfoToWebMusicProInfo(String search_name, int startPage , int endPage);
	/**<p>该函数下载从xx页到xx页的数据*/
	public void DownloadAll(String search_name, int startPage , int endPage);
	public void DownloadAll(String search_name, String savePath, int startPage , int endPage);
	/**<p>该函数提供下载音乐高品音质*/
	public void DownloadFlac(String search_name , int startPage , int endPage);
	/**<p>该函数提供下载音乐无损音质*/
	public void DownloadApe(String search_name , int startPage , int endPage);
	/**<p>该函数提供下载音乐一般音质*/
	public void Download320k(String search_name , int startPage , int endPage);
	/**<p>该函数提供下载音乐伊拉克音质*/
	public void Download128k(String search_name , int startPage , int endPage);
	/**<p>该函数提供下载音乐战损音质(默认)*/
	public void DownloadM4a(String search_name , int startPage , int endPage);
	
	/**<p>该函数提供下载音乐高品音质*/
	public void DownloadFlac(String search_name ,String savePath , int startPage , int endPage);
	/**<p>该函数提供下载音乐无损音质*/
	public void DownloadApe(String search_name ,String savePath , int startPage , int endPage);
	/**<p>该函数提供下载音乐一般音质*/
	public void Download320k(String search_name ,String savePath , int startPage , int endPage);
	
	/**<p>该函数提供下载音乐伊拉克音质*/
	public void Download128k(String search_name ,String savePath, int startPage , int endPage);
	/**<p>该函数提供下载音乐战损音质(默认)*/
	public void DownloadM4a(String search_name ,String savePath, int startPage , int endPage);

}
