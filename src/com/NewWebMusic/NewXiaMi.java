package com.NewWebMusic;

import com.NewWebMusic.MusicType.NewMusicTypeList;
import com.WebMusic.XiaMiMusic;
import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * 创建时间：2019年1月20日 下午2:30:53
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明：新版虾米音乐模块
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
 * @since JDK 1.8 文件名称：NewXiaMi.java
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
