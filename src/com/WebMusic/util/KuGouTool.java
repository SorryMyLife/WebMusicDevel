package com.WebMusic.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 创建时间：2019年1月22日 下午6:31:11
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明： 酷狗音乐专用工具集
 * <p>
 * 注释时间: 2019年1月22日
 * 
 * @version 1.0
 * @since JDK 1.8 文件名称：KuGouTool.java
 */
public class KuGouTool extends WebMusicTools {
	private String str;

	/**
	 * <p>
	 * 获取歌曲哈希值
	 * <p>
	 * 需要传入两个参数：歌曲页面，WebMusicInfo类型list接口
	 */
	public void InfoList(String data, List<WebMusicInfo> l) {
		Matcher MusicHash = Pattern.compile("0,\"FileHash" + kg_match_str).matcher(data);
		Matcher Auxiliary = Pattern.compile("Auxiliary" + kg_match_str).matcher(data);
		while (MusicHash.find() && Auxiliary.find()) {
			str = checkAndroid(
					LinkList.KuGouSearchSongHashJsonLink + MusicHash.group().replaceAll("0,\"FileHash|\"|:", ""),
					doghs);
			str = UnicodeToString(str);
			PrivateInfoList(str, Auxiliary.group().replaceAll("Auxiliary|" + kg_re_str, ""), l);
		}
	}

	/**
	 * <p>
	 * 获取歌曲信息
	 * <p>
	 * 需要传入三个参数：歌曲页面、歌曲出处，WebMusicInfo类型list接口
	 * <p>
	 * 歌曲出处不是必须
	 */
	public void PrivateInfoList(String data, String Auxiliary, List<WebMusicInfo> l) {
		WebMusicInfo musicInfo = new WebMusicInfo();
		musicInfo.setMusicHash(getByJson(data, "hash"));
		musicInfo.setAlbumName(getByJson(data, "album_name"));
		musicInfo.setFileName(getByJson(data, "audio_name").replaceAll("\\s+", ""));
		musicInfo.setDownloadLink(getByJson(data, "play_url").replaceAll("\\\\", ""));
		musicInfo.setVideoId(getByJson(data, "video_id"));
		musicInfo.setMusicImg(getByJson(data, "img").replaceAll("\\\\", ""));
		if (Auxiliary.equals("")) {
			musicInfo.setAuxiliary("没有找到歌曲出处");
		} else {
			musicInfo.setAuxiliary(Auxiliary);
		}
		musicInfo.setSingerName(musicInfo.getFileName().split("-")[0]);
		musicInfo.setMusicName(musicInfo.getFileName().split("-")[1]);
		if (musicInfo.getDownloadLink().replaceAll("\\s+", "").length() < 10) {
			musicInfo.setDownloadLink("没有获取到");
		}
		if (musicInfo.getAlbumName().replaceAll("\\s+", "").length() < 1) {
			musicInfo.setAlbumName("没有找到歌曲专辑");
		}
		addMusic(l, musicInfo);
	}

}
