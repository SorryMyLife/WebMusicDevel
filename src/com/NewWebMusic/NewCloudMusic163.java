package com.NewWebMusic;

import com.NewWebMusic.MusicType.MusicTypeList;
import com.WebMusic.CloudMusic163;
import com.WebMusic.util.WebMusicInfo;

/**
 * <p>
 * 创建时间：2019年1月20日 下午2:28:41
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明：新版本网易云音乐模块
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
 * @since JDK 1.8 文件名称：NewCloudMusic163.java
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
