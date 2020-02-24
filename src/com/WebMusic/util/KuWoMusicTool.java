package com.WebMusic.util;

/**
 * <p>
 * 创建时间：2019年1月22日 下午6:25:31
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明：
 * <p>
 * 酷我音乐工具集
 * <p>
 * 注释时间: 2019年1月22日
 * 
 * @version 1.0
 * @since JDK 1.8 文件名称：KuWoMusicTool.java
 */
public class KuWoMusicTool extends WebMusicTools {
	/**
	 * <p>
	 * 获取歌曲信息
	 * <p>
	 * 需要传入一个参数：歌曲id
	 */
	public WebMusicInfo Info(String song_id) {
		WebMusicInfo musicInfo = new WebMusicInfo();
		String song_info_page = getByString(checkAndroid(LinkList.KuWoMusicSongInfoLink + song_id), "songinfo:(.+?payInfo)", "");
		System.out.println(LinkList.KuWoMusicSongInfoLink + song_id);
		musicInfo.setMusicHash(song_id);
		musicInfo.setMusicName(getByString(song_info_page, ",name"+math, ",name:|\""));
		musicInfo.setSingerName(getByString(song_info_page, "artist"+math,"artist:|\""));
		musicInfo.setAlbumName(getByString(song_info_page, "album"+math, "album:|\""));
		musicInfo.setMusicImg(UnicodeToString(getByString(song_info_page, "pic"+math, "pic:|\"")));
		musicInfo.setDownloadLink(LinkList.KuWoMusicDownloadLink + musicInfo.getMusicHash().replaceAll("\\s+", "")
				+ LinkList.KuWoMusicDownloadLinkEnd);
		musicInfo.setAuxiliary("本版本不提供此功能");
		musicInfo.setVideoId("本版本不提供此功能");
		String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
		musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
//		System.out.println(musicInfo.getAllToCloud());
		return musicInfo;
	}
	
	/**
	 * <p>
	 * 获取歌曲信息
	 * <p>
	 * 需要传入一个参数：歌曲id
	 */
	public WebMusicInfo InfoJson(String song_id) {
		WebMusicInfo musicInfo = new WebMusicInfo();
		String song_info_page = getByString(checkAndroid(LinkList.KuWoMusicSongJsonInfoLink + song_id), "songinfo(.+?msg)" , "");
//		System.out.println(song_info_page);
		musicInfo.setMusicHash(song_id);
		musicInfo.setMusicName(getByJson(song_info_page, "songName"));
		musicInfo.setSingerName(getByJson(song_info_page, "artist"));
		musicInfo.setAlbumName(getByJson(song_info_page, "album"));
		musicInfo.setMusicImg(getByJson(song_info_page, "pic"));
		musicInfo.setDownloadLink(LinkList.KuWoMusicDownloadLink + musicInfo.getMusicHash().replaceAll("\\s+", "")
				+ LinkList.KuWoMusicDownloadLinkEnd);
		musicInfo.setAuxiliary("本版本不提供此功能");
		musicInfo.setVideoId("本版本不提供此功能");
		String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
		musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
//		System.out.println(musicInfo.getAllToCloud());
		return musicInfo;
	}
}
