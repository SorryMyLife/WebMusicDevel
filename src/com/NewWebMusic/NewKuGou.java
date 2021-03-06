package com.NewWebMusic;

import com.NewWebMusic.MusicType.NewMusicTypeList;
import com.WebMusic.KuGouMusic;
import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * 创建时间：2019年1月20日 上午10:45:01
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明： 新版酷狗音乐模块
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
 * @since JDK 1.8 文件名称：KuGou.java
 */
public class NewKuGou extends NewOtherMusic {
	public NewKuGou() {
		setType(NewMusicTypeList.TYPE_KUGOU);
	}

	@Override
	public void getMusicList(String link) {

		new KuGouMusic().getMusicList(link);
	}

	@Override
	public String getMusicListToString(String link) {

		return new KuGouMusic().getMusicListToString(link);
	}

	@Override
	public String[] getMusicListToStringArray(String link) {

		return new KuGouMusic().getMusicListToStringArray(link);
	}

	@Override
	public void DownloadList(String link) {

		new KuGouMusic().DownloadList(link);
	}

	@Override
	public void DownloadList(String link, String savePath) {

		new KuGouMusic().DownloadList(link, savePath);
	}

	@Override
	public WebMusicInfo[] getMusicListToWebMusicInfo(String link) {

		return new KuGouMusic().getMusicListToWebMusicInfo(link);
	}

}
