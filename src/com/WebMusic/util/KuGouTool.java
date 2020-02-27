package com.WebMusic.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * ����ʱ�䣺2019��1��22�� ����6:31:11
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵���� �ṷ����ר�ù��߼�
 * <p>
 * ע��ʱ��: 2019��1��22��
 * 
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�KuGouTool.java
 */
public class KuGouTool extends WebMusicTools {
	private String str;

	/**
	 * <p>
	 * ��ȡ������ϣֵ
	 * <p>
	 * ��Ҫ������������������ҳ�棬WebMusicInfo����list�ӿ�
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
	 * ��ȡ������Ϣ
	 * <p>
	 * ��Ҫ������������������ҳ�桢����������WebMusicInfo����list�ӿ�
	 * <p>
	 * �����������Ǳ���
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
			musicInfo.setAuxiliary("û���ҵ���������");
		} else {
			musicInfo.setAuxiliary(Auxiliary);
		}
		musicInfo.setSingerName(musicInfo.getFileName().split("-")[0]);
		musicInfo.setMusicName(musicInfo.getFileName().split("-")[1]);
		if (musicInfo.getDownloadLink().replaceAll("\\s+", "").length() < 10) {
			musicInfo.setDownloadLink("û�л�ȡ��");
		}
		if (musicInfo.getAlbumName().replaceAll("\\s+", "").length() < 1) {
			musicInfo.setAlbumName("û���ҵ�����ר��");
		}
		addMusic(l, musicInfo);
	}

}
