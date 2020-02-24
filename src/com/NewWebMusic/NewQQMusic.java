package com.NewWebMusic;

import com.NewWebMusic.MusicType.NewMusicTypeList;
import com.WebMusic.QQMusic;
import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * ����ʱ�䣺2019��1��20�� ����2:42:26
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵�����°�QQ����ģ��
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
 * @since JDK 1.8 �ļ����ƣ�NewQQMusic.java
 */
public class NewQQMusic extends NewOtherMusic {
	public NewQQMusic() {
		setType(NewMusicTypeList.TYPE_QQ);
	}

	@Override
	public WebMusicInfo[] getMusicListToWebMusicInfo(String link) {

		return new QQMusic().getMusicListToWebMusicInfo(link);
	}

	@Override
	public String getMusicListToString(String link) {

		return new QQMusic().getMusicListToString(link);
	}

	@Override
	public void getMusicList(String link) {

		new QQMusic().getMusicList(link);
	}

	@Override
	public String[] getMusicListToStringArray(String link) {

		return new QQMusic().getMusicListToStringArray(link);
	}

	@Override
	public void DownloadList(String link) {

		new QQMusic().DownloadList(link);
	}

	@Override
	public void DownloadList(String link, String savePath) {

		new QQMusic().DownloadList(link, savePath);
	}
}
