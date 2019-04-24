package com.WebMusic;

import com.WebMusic.util.MusicTypeList;

/**
 * <p>
 * 虾米音乐模块
 * <pre>新特性:
 * 整体更新!
 * 减少代码量!
 * 移除utils包，全部整合进OtherMusicUtils里
 * 下载功能采用多线程技术
 * 下载更加快速!
 * </pre>
 * 
 * <pre>
 * 由于这版存在获取歌曲信息不完全的问题
 * 推荐用新版跟Pro版
 * 
 * </pre>
 * 
 * <p>注解时间: 2019年2月1日
 * */

@Deprecated
public class XiaMiMusic extends OtherMusic {
	public XiaMiMusic() {
		setMusicType(MusicTypeList.XIAMI);
	}
}
