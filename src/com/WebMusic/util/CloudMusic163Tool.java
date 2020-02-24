package com.WebMusic.util;

/**
 * <p>
 * ����ʱ�䣺2019��1��22�� ����6:36:33
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵����
 * <p>
 * ����������ר�ù��߼�
 * <p>
 * ע��ʱ��: 2019��1��22��
 * 
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�CloudMusic163Tool.java
 */
public class CloudMusic163Tool extends WebMusicTools {
	/**
	 * <p>
	 * ��ȡ������Ϣ
	 * <p>
	 * ��Ҫ����һ������������id
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
		musicInfo.setAuxiliary("δ�ṩ");
		musicInfo.setVideoId(getByString(ss, "/mv(.+?>)", "/mv\\?id=|\">"));
		String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
		musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
		musicInfo.setDownloadLink(LinkList.CloudMusicDownloadSongLink + musicInfo.getMusicHash());
//		System.out.println(musicInfo.getAllToCloud());
		return musicInfo;
	}
}
