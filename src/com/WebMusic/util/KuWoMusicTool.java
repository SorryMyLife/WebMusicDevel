package com.WebMusic.util;

/**
 * <p>
 * ����ʱ�䣺2019��1��22�� ����6:25:31
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵����
 * <p>
 * �������ֹ��߼�
 * <p>
 * ע��ʱ��: 2019��1��22��
 * 
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�KuWoMusicTool.java
 */
public class KuWoMusicTool extends WebMusicTools {
	/**
	 * <p>
	 * ��ȡ������Ϣ
	 * <p>
	 * ��Ҫ����һ������������id
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
		musicInfo.setAuxiliary("���汾���ṩ�˹���");
		musicInfo.setVideoId("���汾���ṩ�˹���");
		String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
		musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
		return musicInfo;
	}
}
