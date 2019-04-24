package com.WebMusic;

import com.WebMusic.util.MusicTypeList;

/**
 * <p>
 * 酷我音乐模块
 * <pre>新特性:
 * 整体更新!
 * 减少代码量!
 * 移除utils包，全部整合进OtherMusicUtils里
 * 下载功能采用多线程技术
 * 下载更加快速!
 * </pre>
 * <pre>
 * 完全剔除cookie、useragent相关操作
 * </pre>
 * 
 * <p>注解时间: 2019年2月1日
 * */

public class KuWoMusic extends OtherMusic {
	public KuWoMusic() {
		setMusicType(MusicTypeList.KUWO);
	}
}
