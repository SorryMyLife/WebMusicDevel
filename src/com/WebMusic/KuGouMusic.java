package com.WebMusic;

import com.WebMusic.util.MusicTypeList;

/**
 * <p>
 * 酷狗音乐模块
 * <pre>新特性:
 * 整体更新!
 * 减少代码量!
 * 移除utils包，全部整合进OtherMusicUtils里
 * 下载功能采用多线程技术
 * 下载更加快速!
 * </pre>
 * <p>注解时间: 2019年2月1日
 * */

public class KuGouMusic extends OtherMusic {
	public KuGouMusic() {
		setMusicType(MusicTypeList.KUGOU);
	}
}
