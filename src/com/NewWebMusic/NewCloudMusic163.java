package com.NewWebMusic;

import com.NewWebMusic.MusicType.MusicTypeList;
import com.WebMusic.CloudMusic163;
import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * ����ʱ�䣺2019��1��20�� ����2:28:41
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵�����°汾����������ģ��
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
 * @since JDK 1.8 �ļ����ƣ�NewCloudMusic163.java
 */
public class NewCloudMusic163 extends NewOtherMusic {
	public NewCloudMusic163() {
		setType(MusicTypeList.TYPE_CLOUD163);
	}

	@Override
	public void getMusicList(String link) {
		new CloudMusic163().getMusicList(link);
	}

	@Override
	public String getMusicListToString(String link) {
		return new CloudMusic163().getMusicListToString(link);
	}

	@Override
	public String[] getMusicListToStringArray(String link) {

		return new CloudMusic163().getMusicListToStringArray(link);
	}

	@Override
	public void DownloadList(String link) {
		new CloudMusic163().DownloadList(link);
	}

	@Override
	public void DownloadList(String link, String savePath) {
		new CloudMusic163().DownloadList(link, savePath);
	}

	@Override
	public WebMusicInfo[] getMusicListToWebMusicInfo(String link) {
		return new CloudMusic163().getMusicListToWebMusicInfo(link);
	}

}
