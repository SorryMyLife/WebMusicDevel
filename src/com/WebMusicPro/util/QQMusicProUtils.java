package com.WebMusicPro.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.WebMusic.util.LinkList;
import com.WebMusic.util.WebMusicTools;

/**
* <p>创建时间：2019年1月22日 下午7:56:33
* <p>项目名称：WebMusic
* 
* <p>类说明：
* QQMusicPro为QQMusic的高级版
* 也就是加强版，直接支持音乐音质的操作
* @version 1.0
* @since JDK 1.8
* 文件名称：QQMusicPro.java
* */
public class QQMusicProUtils extends WebMusicTools{
	
	/**获取vkey页面*/
	public String getVkey(String song_id)
	{
		String vkey = getPagesource(LinkList.QQMusicProLink + song_id + LinkList.QQMusicProLinkFileName
				+ MusicFormat.QQm4aHead + song_id + MusicFormat.m4aEnd);
		return vkey;
	}
	
	/**<p>这个函数主要是用来配置跟添加QQ音乐各个音质<p>需要传入两个参数: song_id,WebMusicProInfo<p>歌曲id是必须的<p>WebMusicProInfo是返回歌曲各个音质直链*/
	public void getFormat(String song_id, WebMusicProInfo w) {
		String ape = "", flac = "", k320 = "", k128 = "", m4a = "";
		setUserAgent("Mozilla/5.0 (Linux; Android 8.0.0; Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Mobile Safari/537.36");
		String vkey = getByJson(getVkey(song_id), "vkey");
		ape = LinkList.QQMusicProDownloadHead + MusicFormat.QQApeHead + song_id + MusicFormat.ApeEnd + "?guid=0&uin=0&vkey="
				+ vkey + MusicFormat.QQApeFormat;
		flac = LinkList.QQMusicProDownloadHead + MusicFormat.QQFlaceHead + song_id + MusicFormat.FlacEnd
				+ "?guid=0&uin=0&vkey=" + vkey + MusicFormat.QQFlacFormat;
		k320 = LinkList.QQMusicProDownloadHead + MusicFormat.QQ320KHead + song_id + MusicFormat.QQ320kEnd
				+ "?guid=0&uin=0&vkey=" + vkey + MusicFormat.QQ320kFormat;
		k128 = LinkList.QQMusicProDownloadHead + MusicFormat.QQ128KHead + song_id + MusicFormat.QQ128kEnd
				+ "?guid=0&uin=0&vkey=" + vkey + MusicFormat.QQ128kFormat;
		m4a = LinkList.QQMusicProDownloadHead + MusicFormat.QQm4aHead + song_id + MusicFormat.m4aEnd + "?guid=0&uin=0&vkey="
				+ vkey + MusicFormat.QQm4aFormat;
		w.setAPE(ape);
		w.setFLAC(flac);
		w.setM128k(k128);
		w.setM320k(k320);
		w.setM4a(m4a);
		w.setDownloadLink(m4a);
	}
	
	/**<p>获取歌曲相关信息<p>需要传入三个参数: song_id , mvid , aux<p>歌曲id，歌曲视频id，歌曲出处*/
	public WebMusicProInfo getSongInfo(String song_id, String mvid, String aux) {
		WebMusicProInfo proinfo = new WebMusicProInfo();
		String ss = getGzipPagesource(LinkList.QQMusicSongInfoLink + song_id + ".html");
		String value_str = "";
		Matcher JsonArray = Pattern.compile("g_SongData =(.+?\\};)").matcher(ss);
		Matcher Img = Pattern.compile("background-image:url(.+?\\))").matcher(ss);
		while(JsonArray.find() && Img.find()) {
			value_str = JsonArray.group().replaceAll("g_SongData = ", "");
			proinfo.setMusicHash(getByJson(value_str, "songmid"));
			proinfo.setMusicName(getByJson(value_str, "songname"));
			proinfo.setSingerName(getByJson(value_str, "name"));
			proinfo.setAlbumName(getByJson(value_str, "albumname"));
			proinfo.setMusicImg(Img.group().replaceAll("background-image:url|\\(|\\)", ""));
			proinfo.setVideoId(mvid);
			proinfo.setAuxiliary(aux);
			proinfo.setFileName(proinfo.getSingerName() + "-" + proinfo.getMusicName());
			getFormat(proinfo.getMusicHash(), proinfo);
		}
		return proinfo;
	}
	
	/**<p>返回一个带有WebMusicProInfo的List<p>需要传入两个参数: search_name , maxpage <p>搜索的内容，最大页面数量(只能是整数型)*/
	public List<WebMusicProInfo> getInfoList(String search_name , int maxpage)
	{
		List<WebMusicProInfo> l = null;
		if(maxpage > 1)
		{
			l = getInfoList(search_name, 1, maxpage);
		}else
		{
			l = getInfoList(search_name, 1, 1);
		}
		return l;
	}
	
	/**<p>返回一个带有WebMusicProInfo的List<p>需要传入一个参数: search_name<p>搜索的内容 (默认的函数，只返回一页的内容)*/
	public List<WebMusicProInfo> getInfoList(String search_name)
	{
		return getInfoList(search_name, -1);
	}
	
	/**<p>返回一个带有WebMusicProInfo的List<p>需要传入三个参数: search_name , startPage , endPage <p>搜索的内容，开始的位置(从xx页开始) , 结束的位置(到xx页结束)(只能是整数型)*/
	public List<WebMusicProInfo> getInfoList(String search_name , int startPage , int endPage )
	{
		List<WebMusicProInfo> l = new ArrayList<>();
		if(startPage >0)
		{
			if(endPage >startPage)
			{
				for(int i = startPage ; i<= endPage;i++)
				{
					String data = getGzipPagesource(LinkList.QQMusicSearchSongLink + URLEncode(search_name)+ LinkList.QQMusicSearchSongLinkPage + i);
					Matcher id = Pattern.compile("songmid\":\"(.+?\")").matcher(data);
					Matcher mid = Pattern.compile("vid\":\"(.+?\")").matcher(data);
					Matcher aux = Pattern.compile("lyric\":\"(.+?\")").matcher(data);
					while (id.find() && mid.find() && aux.find()) {
						l.add(getSongInfo(id.group().replaceAll("songmid|:|\"", ""),mid.group().replaceAll("vid|:|\"|(\\}|\\{|\\]|\\[)|,", ""),aux.group().replaceAll("lyric|:|\"|,", "")));
					}
				}
			}else
			{
				String data = getGzipPagesource(LinkList.QQMusicSearchSongLink + URLEncode(search_name)+ LinkList.QQMusicSearchSongLinkPage + startPage);
				Matcher id = Pattern.compile("songmid\":\"(.+?\")").matcher(data);
				Matcher mid = Pattern.compile("vid\":\"(.+?\")").matcher(data);
				Matcher aux = Pattern.compile("lyric\":\"(.+?\")").matcher(data);
				while (id.find() && mid.find() && aux.find()) {
					l.add(getSongInfo(id.group().replaceAll("songmid|:|\"", ""),mid.group().replaceAll("vid|:|\"|(\\}|\\{|\\]|\\[)|,", ""),aux.group().replaceAll("lyric|:|\"|,", "")));
				}
			}
		}else
		{
			String data = getGzipPagesource(LinkList.QQMusicSearchSongLink + URLEncode(search_name)+ LinkList.QQMusicSearchSongLinkPage + 1);
			Matcher id = Pattern.compile("songmid\":\"(.+?\")").matcher(data);
			Matcher mid = Pattern.compile("vid\":\"(.+?\")").matcher(data);
			Matcher aux = Pattern.compile("lyric\":\"(.+?\")").matcher(data);
			while (id.find() && mid.find() && aux.find()) {
				l.add(getSongInfo(id.group().replaceAll("songmid|:|\"", ""),mid.group().replaceAll("vid|:|\"|(\\}|\\{|\\]|\\[)|,", ""),aux.group().replaceAll("lyric|:|\"|,", "")));
			}
		}
		return l;
	}
	
	/**<p>返回一个带有WebMusicProInfo的List<p>需要传入一个参数: link <p>QQ音乐歌单链接*/
	public List<WebMusicProInfo> getMusicInfoList(String link)
	{
		if(link.indexOf("id=") != -1)
		{
			link = "https://y.qq.com/n/yqq/playlist/"+link.substring(link.indexOf("id=")+3)+".html";
		}
		List<WebMusicProInfo> l = new ArrayList<WebMusicProInfo>();
		String page = getMusicListPageOnQQ(link);
		Matcher m = Pattern.compile("songmid\":(.+?\",)").matcher(page);
		Matcher vid = Pattern.compile("\"vid\":(.+?\")").matcher(page);
		while (m.find() && vid.find()) {
			l.add(getSongInfo(m.group().replaceAll("songmid|:|\"|,", ""),vid.group().replaceAll("vid|:|\"", ""), "歌单类型不提供"));
		}
		return l;
	}
	
}
