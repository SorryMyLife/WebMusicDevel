package com.NewWebMusic;

import com.NewWebMusic.MusicType.MusicTypeList;
import com.WebMusic.KuWoMusic;
import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * ����ʱ�䣺2019��1��21�� ����7:49:11
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵�����°��������ģ��
 * 
 * <pre>
* ��Ȼ˵�����˽ӿڣ������ֹ������ɲ��þɰ��
* ��Ȼ����WebMusic�ӿ���ʵ�ֹ���
* �˰汾�����ṩset/getCookie��set/getUserAgent����
 * </pre>
 * <p>
 * ע��ʱ��: 2019��1��22��
 * 
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�NewKuWoMusic.java
 */
public class NewKuWoMusic extends NewOtherMusic {
	public NewKuWoMusic() {
		setType(MusicTypeList.TYPE_KUWO);
	}

	@Override
	public void getMusicList(String link) {

		new KuWoMusic().getMusicList(link);
	}

	@Override
	public String getMusicListToString(String link) {

		return new KuWoMusic().getMusicListToString(link);
	}

	@Override
	public String[] getMusicListToStringArray(String link) {

		return new KuWoMusic().getMusicListToStringArray(link);
	}

	@Override
	public void DownloadList(String link) {

		new KuWoMusic().DownloadList(link);
	}

	@Override
	public void DownloadList(String link, String savePath) {

		new KuWoMusic().DownloadList(link, savePath);
	}

	@Override
	public WebMusicInfo[] getMusicListToWebMusicInfo(String link) {

		return new KuWoMusic().getMusicListToWebMusicInfo(link);
	}
}
