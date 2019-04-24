package com.NewWebMusic;

import com.NewWebMusic.MusicType.MusicTypeList;
import com.WebMusic.KuWoMusic;
import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * 创建时间：2019年1月21日 下午7:49:11
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明：新版酷我音乐模块
 * 
 * <pre>
* 虽然说更换了接口，但部分功能依旧采用旧版的
* 依然采用WebMusic接口来实现功能
* 此版本不再提供set/getCookie，set/getUserAgent功能
 * </pre>
 * <p>
 * 注释时间: 2019年1月22日
 * 
 * @version 1.0
 * @since JDK 1.8 文件名称：NewKuWoMusic.java
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
