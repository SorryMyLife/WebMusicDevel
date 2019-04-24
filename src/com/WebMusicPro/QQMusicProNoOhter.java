package com.WebMusicPro;

import com.WebMusic.util.WebMusicTools;
import com.WebMusicPro.util.MusicFormat;
import com.WebMusicPro.util.QQMusicProUtils;
import com.WebMusicPro.util.WebMusicProInfo;

/**
 * <p>
 * 创建时间：2019年1月30日 下午2:05:24
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明：QQ音乐高级版部分
 * <pre>
 * ------------------------
 * ----基于官方api制作版本------
 * ------------------------
 * 相对于原来版本而言
 * 当前版本加入更多的功能
 * 多线程下载歌曲、歌单
 * 支持页数选择，不再规定死页数
 * 支持歌曲音质选择
 * 支持歌单音质选择
 * 
 * </pre>
 * <p>注解时间: 2019年2月1日
 * @version 1.0
 * @since JDK 1.8 文件名称：QQMusicPro.java
 */
public class QQMusicProNoOhter implements WebMusicPro {
	private final static String save = "e:\\WebMusic\\QQMusic\\";

	@Override
	public void getInfo(String search_name) {
		new WebMusicTools().printListOnPro(new QQMusicProUtils().getInfoList(search_name));
	}

	@Override
	public void getMusicList(String link) {
		new WebMusicTools().printListOnPro(new QQMusicProUtils().getMusicInfoList(link));
	}

	@Override
	public void getInfo(String search_name, int maxpage) {
		new WebMusicTools().printListOnPro(new QQMusicProUtils().getInfoList(search_name, maxpage));
	}

	@Override
	public String getInfoToString(String search_name) {
		return new WebMusicTools().printListStringOnPro(new QQMusicProUtils().getInfoList(search_name));
	}

	@Override
	public String getInfoToString(String search_name, int maxpage) {
		return new WebMusicTools().printListStringOnPro(new QQMusicProUtils().getInfoList(search_name, maxpage));
	}

	@Override
	public String getMusicListToString(String link) {
		return new WebMusicTools().printListStringOnPro(new QQMusicProUtils().getMusicInfoList(link));
	}

	@Override
	public String[] getInfoToStringArray(String search_name) {
		return new WebMusicTools().printListStringArrayOnPro(new QQMusicProUtils().getInfoList(search_name));
	}

	@Override
	public String[] getInfoToStringArray(String search_name, int maxpage) {
		return new WebMusicTools().printListStringArrayOnPro(new QQMusicProUtils().getInfoList(search_name, maxpage));
	}

	@Override
	public String[] getMusicListToStringArray(String link) {
		return new WebMusicTools().printListStringArrayOnPro(new QQMusicProUtils().getMusicInfoList(link));
	}

	@Override
	public WebMusicProInfo[] getInfoToWebMusicProInfo(String search_name) {
		return new WebMusicTools().printListInfoOnPro(new QQMusicProUtils().getInfoList(search_name));
	}

	@Override
	public WebMusicProInfo[] getInfoToWebMusicProInfo(String search_name, int maxpage) {
		return new WebMusicTools().printListInfoOnPro(new QQMusicProUtils().getInfoList(search_name, maxpage));
	}

	@Override
	public WebMusicProInfo[] getMusicListToWebMusicProInfo(String link) {
		return new WebMusicTools().printListInfoOnPro(new QQMusicProUtils().getMusicInfoList(link));
	}

	@Override
	public void DownloadAll(String search_name) {
		DownloadAll(search_name, save, -1);
	}

	@Override
	public void DownloadAll(String search_name, String savePath) {
		DownloadAll(search_name, savePath, -1);
	}

	@Override
	public void DownloadAll(String search_name, String savePath, int maxpage) {
		DownloadAll(search_name, savePath, 1, maxpage);
	}

	@Override
	public void DownloadList(String link) {
		DownloadList(link, save);
	}

	@Override
	public void DownloadList(String link, String savePath) {
		int c = 0;
		for (WebMusicProInfo i : getMusicListToWebMusicProInfo(link)) {
			new WebMusicTools().MultiThreadDownlaodMusic(i.getDownloadLink() , i.getFileName(), savePath, MusicFormat.m4aEnd);
			c++;
		}
		System.err.println("理论下载: " + c + " 个内容");
	}

	@Override
	public void DownloadFlac(String search_name) {
		DownloadFlac(search_name, save);
	}

	@Override
	public void DownloadFlac(String search_name, int maxpage) {
		DownloadFlac(search_name, save, maxpage);
	}

	@Override
	public void DownloadApe(String search_name) {
		DownloadApe(search_name, save);
	}

	@Override
	public void DownloadApe(String search_name, int maxpage) {
		DownloadApe(search_name, save, maxpage);
	}

	@Override
	public void Download320k(String search_name) {
		Download320k(search_name, save);
	}

	@Override
	public void Download320k(String search_name, int maxpage) {
		Download320k(search_name, save, maxpage);
	}

	@Override
	public void Download128k(String search_name) {
		Download128k(search_name, save);
	}

	@Override
	public void Download128k(String search_name, int maxpage) {
		Download128k(search_name, save, maxpage);
	}

	@Override
	public void DownloadM4a(String search_name) {
		DownloadAll(search_name);
	}

	@Override
	public void DownloadM4a(String search_name, int maxpage) {
		DownloadAll(search_name, save, maxpage);
	}

	@Override
	public void DownloadFlacList(String link) {
		DownloadFlacList(link, save);
	}

	@Override
	public void DownloadApeList(String link) {
		DownloadApeList(link, save);
	}

	@Override
	public void Download320kList(String link) {
		Download320kList(link, save);
	}

	@Override
	public void Download128kList(String link) {
		Download128kList(link, save);
	}

	@Override
	public void DownloadM4aList(String link) {
		DownloadList(link, save);
	}

	@Override
	public void DownloadMusic(String musicPage, String format) {
		DownloadMusic(musicPage, save, format);
	}

	@Override
	public void DownloadMusicList(String musicPage, String format) {
		DownloadMusicList(musicPage, save, format);
	}

	@Override
	public void DownloadFlac(String search_name, String savePath) {
		DownloadFlac(search_name, savePath, -1);
	}

	@Override
	public void DownloadFlac(String search_name, String savePath, int maxpage) {
		DownloadFlac(search_name, savePath, 1, maxpage);
	}

	@Override
	public void DownloadApe(String search_name, String savePath) {

		DownloadApe(search_name, savePath, -1);
	}

	@Override
	public void DownloadApe(String search_name, String savePath, int maxpage) {
		DownloadApe(search_name, savePath, 1, maxpage);
	}

	@Override
	public void Download320k(String search_name, String savePath) {
		Download320k(search_name, savePath, -1);
	}

	@Override
	public void Download320k(String search_name, String savePath, int maxpage) {
		Download320k(search_name, savePath, 1, maxpage);
	}

	@Override
	public void Download128k(String search_name, String savePath) {
		Download128k(search_name, savePath, -1);
	}

	@Override
	public void Download128k(String search_name, String savePath, int maxpage) {
		Download128k(search_name, savePath, 1, maxpage);
	}
	
	@Override
	public void DownloadM4a(String search_name, String savePath) {
		DownloadAll(search_name, savePath, -1);
	}

	@Override
	public void DownloadM4a(String search_name, String savePath, int maxpage) {
		DownloadAll(search_name, savePath, maxpage);
	}
	
	@Override
	public void DownloadFlacList(String link, String savePath) {
		int c = 0;
		for (WebMusicProInfo i : getMusicListToWebMusicProInfo(link)) {
			new WebMusicTools().MultiThreadDownlaodMusic(i.getFLAC(), i.getFileName(), savePath, MusicFormat.FlacEnd);
			c++;
		}
		System.err.println("理论下载: " + c + " 个内容");
	}

	@Override
	public void DownloadApeList(String link, String savePath) {
		int c = 0;
		for (WebMusicProInfo i : getMusicListToWebMusicProInfo(link)) {
			new WebMusicTools().MultiThreadDownlaodMusic(i.getAPE(), i.getFileName(), savePath, MusicFormat.ApeEnd);
			c++;
		}
		System.err.println("理论下载: " + c + " 个内容");
	}

	@Override
	public void Download320kList(String link, String savePath) {

		int c = 0;
		for (WebMusicProInfo i : getMusicListToWebMusicProInfo(link)) {
			new WebMusicTools().MultiThreadDownlaodMusic(i.getM320k(), i.getFileName(), savePath, MusicFormat.QQ320kEnd);
			c++;
		}
		System.err.println("理论下载: " + c + " 个内容");
	}

	@Override
	public void Download128kList(String link, String savePath) {
		int c = 0;
		for (WebMusicProInfo i : getMusicListToWebMusicProInfo(link)) {
			new WebMusicTools().MultiThreadDownlaodMusic(i.getM128k(), i.getFileName(), savePath, MusicFormat.QQ128kEnd);
			c++;
		}
		System.err.println("理论下载: " + c + " 个内容");
	}

	@Override
	public void DownloadM4aList(String link, String savePath) {
		DownloadList(link, savePath);
	}
	
	@Override
	public void getInfo(String search_name, int startPage, int endPage) {
		new WebMusicTools().printListOnPro(new QQMusicProUtils().getInfoList(search_name, startPage, endPage));
	}

	@Override
	public String getInfoToString(String search_name, int startPage, int endPage) {
		return new WebMusicTools().printListStringOnPro(new QQMusicProUtils().getInfoList(search_name, startPage, endPage));
	}

	@Override
	public String[] getInfoToStringArray(String search_name, int startPage, int endPage) {
		return new WebMusicTools().printListStringArrayOnPro(new QQMusicProUtils().getInfoList(search_name, startPage, endPage));
	}

	@Override
	public WebMusicProInfo[] getInfoToWebMusicProInfo(String search_name, int startPage, int endPage) {
		return new WebMusicTools().printListInfoOnPro(new QQMusicProUtils().getInfoList(search_name, startPage, endPage));
	}

	@Override
	public void DownloadAll(String search_name, int startPage, int endPage) {
		DownloadAll(search_name, save, startPage, endPage);
	}
	
	@Override
	public void DownloadAll(String search_name, String savePath, int startPage, int endPage) {
		int c = 0;
		if(startPage >0)
		{
			if(endPage >startPage)
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, endPage))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getDownloadLink(), savePath, w.getFileName(), MusicFormat.m4aEnd);
					c++;
				}
			}else
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, 1))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getDownloadLink(), savePath, w.getFileName(), MusicFormat.m4aEnd);
					c++;
				}
			}
		}else
		{
			for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, 1, 1))
			{
				new WebMusicTools().MultiThreadDownlaodMusic(w.getDownloadLink(), savePath, w.getFileName(), MusicFormat.m4aEnd);
				c++;
			}
		}
		System.err.println("理论下载: "+c + " 个数据");
	}
	
	@Override
	public void DownloadFlac(String search_name, int startPage, int endPage) {
		DownloadFlac(search_name, save, startPage, endPage);
	}

	@Override
	public void DownloadApe(String search_name, int startPage, int endPage) {
		DownloadApe(search_name, save, startPage, endPage);
	}

	@Override
	public void Download320k(String search_name, int startPage, int endPage) {
		Download320k(search_name, save, startPage, endPage);
	}

	@Override
	public void Download128k(String search_name, int startPage, int endPage) {
		Download128k(search_name, save, startPage, endPage);
	}

	@Override
	public void DownloadM4a(String search_name, int startPage, int endPage) {
		DownloadAll(search_name, startPage, endPage);
		
	}

	@Override
	public void DownloadFlac(String search_name, String savePath, int startPage, int endPage) {
		int c = 0;
		if(startPage >0)
		{
			if(endPage >startPage)
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, endPage))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getFLAC(), savePath, w.getFileName(), MusicFormat.FlacEnd);
					c++;
				}
			}else
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, 1))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getFLAC(), savePath, w.getFileName(),  MusicFormat.FlacEnd);
					c++;
				}
			}
		}else
		{
			for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, 1, 1))
			{
				new WebMusicTools().MultiThreadDownlaodMusic(w.getFLAC(), savePath, w.getFileName(),MusicFormat.FlacEnd);
				c++;
			}
		}
		System.err.println("理论下载: "+c + " 个数据");
	}

	@Override
	public void DownloadApe(String search_name, String savePath, int startPage, int endPage) {
		int c = 0;
		if(startPage >0)
		{
			if(endPage >startPage)
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, endPage))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getAPE(), savePath, w.getFileName(), MusicFormat.ApeEnd);
					c++;
				}
			}else
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, 1))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getAPE(), savePath, w.getFileName(),  MusicFormat.ApeEnd);
					c++;
				}
			}
		}else
		{
			for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, 1, 1))
			{
				new WebMusicTools().MultiThreadDownlaodMusic(w.getAPE(), savePath, w.getFileName(),MusicFormat.ApeEnd);
				c++;
			}
		}
		System.err.println("理论下载: "+c + " 个数据");
	}

	@Override
	public void Download320k(String search_name, String savePath, int startPage, int endPage) {
		int c = 0;
		if(startPage >0)
		{
			if(endPage >startPage)
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, endPage))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getM320k(), savePath, w.getFileName(), MusicFormat.QQ320kEnd);
					c++;
				}
			}else
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, 1))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getM320k(), savePath, w.getFileName(),  MusicFormat.QQ320kEnd);
					c++;
				}
			}
		}else
		{
			for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, 1, 1))
			{
				new WebMusicTools().MultiThreadDownlaodMusic(w.getM320k(), savePath, w.getFileName(),MusicFormat.QQ320kEnd);
				c++;
			}
		}
		System.err.println("理论下载: "+c + " 个数据");
	}

	@Override
	public void Download128k(String search_name, String savePath, int startPage, int endPage) {
		int c = 0;
		if(startPage >0)
		{
			if(endPage >startPage)
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, endPage))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getM128k(), savePath, w.getFileName(), MusicFormat.QQ128kEnd);
					c++;
				}
			}else
			{
				for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, startPage, 1))
				{
					new WebMusicTools().MultiThreadDownlaodMusic(w.getM128k(), savePath, w.getFileName(),  MusicFormat.QQ128kEnd);
					c++;
				}
			}
		}else
		{
			for(WebMusicProInfo w :getInfoToWebMusicProInfo(search_name, 1, 1))
			{
				new WebMusicTools().MultiThreadDownlaodMusic(w.getM128k(), savePath, w.getFileName(),MusicFormat.QQ128kEnd);
				c++;
			}
		}
		System.err.println("理论下载: "+c + " 个数据");
	}

	@Override
	public void DownloadM4a(String search_name, String savePath, int startPage, int endPage) {
		DownloadAll(search_name, savePath, startPage, endPage);
	}

	@Override
	public void DownloadMusic(String musicPage, String savePath, String format) {
		String id = musicPage;
		if (id.length() > 10) {
			id = id.substring(id.lastIndexOf("/") + 1).replace(".html", "");
		}
		WebMusicTools t = new WebMusicTools();
		String s[] = t.checkFormat(format, id).split("--");
		if (s[1].length() > 10) {
			t.Downlaod(s[1], savePath, s[2], s[0]);
		} else {
			System.err.println("skip");
		}
	}

	@Override
	public void DownloadMusicList(String musicPage, String savePath, String format) {
		for (WebMusicProInfo w : getMusicListToWebMusicProInfo(musicPage)) {
			new Thread() {
				@Override
				public void run() {
					DownloadMusic(w.getMusicHash(), savePath, format);
				}
			}.start();
			new WebMusicTools().sleep(3500);
		}
	}

}
