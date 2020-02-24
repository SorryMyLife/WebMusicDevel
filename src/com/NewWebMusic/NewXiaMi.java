package com.NewWebMusic;

import com.NewWebMusic.MusicType.NewMusicTypeList;
import com.WebMusic.XiaMiMusic;
import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * ����ʱ�䣺2019��1��20�� ����2:30:53
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵�����°�Ϻ������ģ��
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
 * @since JDK 1.8 �ļ����ƣ�NewXiaMi.java
 */


@SuppressWarnings("deprecation")
public class NewXiaMi extends NewOtherMusic {
	public NewXiaMi() {
		setType(NewMusicTypeList.TYPE_XIAMI);
	}

	@Override
	public String[] getMusicListToStringArray(String link) {
		return new XiaMiMusic().getMusicListToStringArray(link);
	}

	@Override
	public WebMusicInfo[] getMusicListToWebMusicInfo(String link) {
		return new XiaMiMusic().getMusicListToWebMusicInfo(link);
	}

	@Override
	public void DownloadList(String link) {
		new XiaMiMusic().DownloadList(link);
	}

	@Override
	public void DownloadList(String link, String savePath) {
		new XiaMiMusic().DownloadList(link, savePath);
	}

	@Override
	public String getMusicListToString(String link) {
		return new XiaMiMusic().getMusicListToString(link);
	}

	@Override
	public void getMusicList(String link) {
		new XiaMiMusic().getMusicList(link);
	}
}
