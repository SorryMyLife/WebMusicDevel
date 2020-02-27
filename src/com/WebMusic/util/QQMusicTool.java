package com.WebMusic.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * <p>
 * 创建时间：2019年1月22日 下午5:31:39
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明：
 * <p>
 * QQ音乐工具集
 * <p>
 * 注释时间: 2019年1月22日
 * 
 * @version 1.0
 * @since JDK 1.8 文件名称：QQMusicTool.java
 */
public class QQMusicTool extends WebMusicTools {
	/**
	 * <p>
	 * 获取歌曲信息
	 * <p>
	 * 需要传入三个参数，歌曲id、视频id、歌曲出处
	 * <p>
	 * 后两个不是必须的，但歌曲id是一定要传
	 */
	public WebMusicInfo getSongInfo(String song_id, String mvid, String aux) {
		WebMusicInfo musicInfo = new WebMusicInfo();
		String ss = checkAndroid(LinkList.QQMusicSongInfoLink + song_id + ".html");
		String value_str = "";
		Matcher JsonArray = Pattern.compile("g_SongData=(.+?\\};)").matcher(ss);
		Matcher Img = Pattern.compile("background-image:url(.+?\\))").matcher(ss);
		if (JsonArray.find() && Img.find()) {
			value_str = JsonArray.group().replaceAll("g_SongData = ", "");
			musicInfo.setMusicHash(getByJson(value_str, "songmid"));
			musicInfo.setMusicName(getByJson(value_str, "songname"));
			musicInfo.setSingerName(getByJson(value_str, "name"));
			musicInfo.setAlbumName(getByJson(value_str, "albumname"));
			musicInfo.setDownloadLink(getDownLink(musicInfo.getMusicHash()));
			musicInfo.setMusicImg(Img.group().replaceAll("background-image:url|\\(|\\)", ""));
			musicInfo.setVideoId(mvid);
			musicInfo.setAuxiliary(aux);
			String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
			musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
		}
		return musicInfo;
	}

	/**
	 * <p>
	 * 获取歌曲id、视频id(mv_id)，歌曲出处
	 * <p>
	 * 需要传入两个参数,歌曲详细信息页面、WebMusicInfo类型的list接口
	 */
	public void PriInfo(String data, List<WebMusicInfo> l) {
		Matcher mid = Pattern.compile("songmid\":\"(.+?\")").matcher(data);
		Matcher vid = Pattern.compile("vid\":\"(.+?\")").matcher(data);
		Matcher aux = Pattern.compile("lyric\":\"(.+?\")").matcher(data);
		while (mid.find() && vid.find() && aux.find()) {
			addMusic(l, getSongInfo(mid.group().replaceAll("songmid|:|\"", ""), vid.group().replaceAll("vid|:|\"", ""),
					aux.group().replaceAll("lyric|:|\"|,", "")));
		}
	}

	/**
	 * <p>
	 * 获取歌曲的下载链接
	 * <p>
	 * 需要传入一个参数，歌曲ID
	 */
	public String getDownLink(String song_id) {
		String downloadLink = checkAndroid(
				LinkList.QQMusicSongDownloadPage + song_id + LinkList.QQMusicSongDownloadPageEnd);
		downloadLink = LinkList.QQMusicSongDownloadHead + getByJson(downloadLink, "purl");
		return downloadLink;
	}

	/**
	 * <p>
	 * 获取歌单页面内容
	 * <p>
	 * 需要传入一个参数，歌单链接
	 */
	public String getMusicListPage(String link) {
		String page = "", line = "";
		HttpURLConnection c = null;
		try {
			c = (HttpURLConnection) new URL(LinkList.QQMusicListLink).openConnection();
			c.setRequestMethod("POST");
			c.setRequestProperty("accept", "application/json, text/javascript, */*; q=0.01");
			c.setRequestProperty("accept-encoding", "gzip, deflate, br");
			c.setRequestProperty("origin", "https://y.qq.com");
			c.setRequestProperty("referer", link);
			c.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
			c.setDoOutput(true);
			c.setDoInput(true);
			OutputStreamWriter w = new OutputStreamWriter(c.getOutputStream());
			w.write("type=1&json=1&utf8=1&disstid="
					+ link.substring(link.lastIndexOf("/") + 1).replaceAll(".ht(m|ml)", ""));
			w.flush();
			BufferedReader br = null;
			if (isAndroid()) {
				br = new BufferedReader(new InputStreamReader(c.getInputStream(), "utf-8"));
				while ((line = br.readLine()) != null) {
					page += line + "\n";
				}
			} else {
				br = new BufferedReader(new InputStreamReader(new GZIPInputStream(c.getInputStream()), "utf-8"));
				while ((line = br.readLine()) != null) {
					page += line + "\n";
				}
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * <p>
	 * 随机生成n位整数型数字
	 * <p>
	 * 需要传入一个参数：长度单位,数字
	 */
	public String ran(int n) {
		String s = "";
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			s += r.nextInt(10);
		}
		return s;
	}

}
