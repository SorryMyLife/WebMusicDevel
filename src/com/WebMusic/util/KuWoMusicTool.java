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
		String song_info_page = getByString(checkAndroid(LinkList.KuWoMusicSongInfoLink + song_id), "songinfo:(.+?payInfo)", "");
		System.out.println(LinkList.KuWoMusicSongInfoLink + song_id);
		musicInfo.setMusicHash(song_id);
		musicInfo.setMusicName(getByString(song_info_page, ",name"+math, ",name:|\""));
		musicInfo.setSingerName(getByString(song_info_page, "artist"+math,"artist:|\""));
		musicInfo.setAlbumName(getByString(song_info_page, "album"+math, "album:|\""));
		musicInfo.setMusicImg(UnicodeToString(getByString(song_info_page, "pic"+math, "pic:|\"")));
		musicInfo.setDownloadLink(LinkList.KuWoMusicDownloadLink + musicInfo.getMusicHash().replaceAll("\\s+", "")
				+ LinkList.KuWoMusicDownloadLinkEnd);
		musicInfo.setAuxiliary("���汾���ṩ�˹���");
		musicInfo.setVideoId("���汾���ṩ�˹���");
		String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
		musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
//		System.out.println(musicInfo.getAllToCloud());
		return musicInfo;
	}
	
	/**
	 * <p>
	 * ��ȡ������Ϣ
	 * <p>
	 * ��Ҫ����һ������������id
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
		musicInfo.setAuxiliary("���汾���ṩ�˹���");
		musicInfo.setVideoId("���汾���ṩ�˹���");
		String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
		musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
//		System.out.println(musicInfo.getAllToCloud());
		return musicInfo;
	}
}
