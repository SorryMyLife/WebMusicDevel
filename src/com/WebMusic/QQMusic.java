package com.WebMusic;

import com.WebMusic.util.MusicTypeList;

/**
 * <p>
 * QQ音乐模块
 * <pre>新特性:
 * 整体更新!
 * 减少代码量!
 * 移除utils包，全部整合进OtherMusicUtils里
 * 下载功能采用多线程技术
 * 下载更加快速!
 * </pre>
 * 
 * <pre>
 * 此版本已经完全把核心功能都整合进OtherMusicUtils里
 * 也就是说OtherMusicUtils是这个模块的父类
 * 通过OtherMusicUtils也可以直接操作QQ音乐部分
 * 
 * </pre>
 * <p>注解时间: 2019年2月1日
 * */

public class QQMusic extends OtherMusic {
	public QQMusic() {
		setMusicType(MusicTypeList.QQ);
	}
}
