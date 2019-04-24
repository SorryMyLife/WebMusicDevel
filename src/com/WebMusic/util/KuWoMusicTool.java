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
		String song_info_page = checkAndroid(LinkList.KuWoMusicSongInfoLink + song_id);
		String sing_name = getByString(song_info_page, "artist/con(.+?data-id)\\S+</a", "");
		String album = getByString(song_info_page, "album/\\d+\\S+</a", "album/\\d+|</a|\"");
		musicInfo.setMusicHash(song_id);
		musicInfo.setMusicName(getByString(song_info_page, "lrcName\\S+<", "lrcName|>|<|\""));
		musicInfo.setSingerName(getByString(sing_name, ">\\S+<", ">|<"));
		musicInfo.setAlbumName(album.replaceAll("/>", ""));
		musicInfo.setMusicImg(getByString(song_info_page, "photopic(.+?.(jpg|png|jpeg))", "photopic|src=|\""));
		musicInfo.setDownloadLink(LinkList.KuWoMusicDownloadLink + musicInfo.getMusicHash().replaceAll(" ", "")
				+ LinkList.KuWoMusicDownloadLinkEnd);
		musicInfo.setAuxiliary("本版本不提供此功能");
		musicInfo.setVideoId("本版本不提供此功能");
		String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
		musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
		return musicInfo;
	}
}
