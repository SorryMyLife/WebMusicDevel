package com.WebMusic.util;

/**
 * <p>
 * 创建时间：2019年1月22日 下午6:36:33
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明：
 * <p>
 * 网易云音乐专用工具集
 * <p>
 * 注释时间: 2019年1月22日
 * 
 * @version 1.0
 * @since JDK 1.8 文件名称：CloudMusic163Tool.java
 */
public class CloudMusic163Tool extends WebMusicTools {
	/**
	 * <p>
	 * 获取音乐信息
	 * <p>
	 * 需要传入一个参数：歌曲id
	 */
	public WebMusicInfo getSongInfo(String song_id) {
		String ss = checkAndroid(LinkList.CloudMusicSongInfoLink + song_id);
//		System.out.println(LinkList.CloudMusicSongInfoLink + song_id);
		WebMusicInfo musicInfo = new WebMusicInfo();
		musicInfo.setMusicHash(song_id);
		musicInfo.setSingerName(getByString(ss, "<spantitle=(.+?<aclass)", "<spantitle=|<aclass|>|\""));
		musicInfo.setMusicName(getByString(ss, "f-ff2\">(.+?)</em>", "f-ff2\">|</em>"));
		musicInfo.setMusicImg(getByString(ss, "images(.+?],)","images|:|\\[|\\]|\"|,"));
		musicInfo.setAlbumName(getByString(ss, "class=\"s-fc7\">(.+?</a>)", "class=\"s-fc7|>|</a|\""));
		musicInfo.setAuxiliary("未提供");
		musicInfo.setVideoId(getByString(ss, "/mv(.+?>)", "/mv\\?id=|\">"));
		String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
		musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
		musicInfo.setDownloadLink(LinkList.CloudMusicDownloadSongLink + musicInfo.getMusicHash());
//		System.out.println(musicInfo.getAllToCloud());
		return musicInfo;
	}
}
