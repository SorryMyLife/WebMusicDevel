package com.WebMusic.Program;

import com.NewWebMusic.NewOtherMusic;
import com.NewWebMusic.MusicType.NewMusicTypeList;
import com.WebMusic.OtherMusic;
import com.WebMusic.util.MusicTypeList;
import com.WebMusicPro.OtherMusicPro;
import com.WebMusicPro.QQMusicProNoOhter;

/**
* <p>创建时间：2019年2月2日 下午5:45:36
* <p>项目名称：WebMusic
* 
* <p>类说明：
* 修改时间: 2019年4月19日
* @version 1.0
* @since JDK 1.8
* 文件名称：Main.java
* */
public class Main {

	
	/**
	 * 普通版本
	 * 已经修复酷我音乐
	 * 已经修复网易云音乐
	 * 已经修复QQ音乐
	 * 发现bug，酷狗音乐需要依赖cookie方可操作
	 * 标准版不再维护虾米音乐
	 * 更换新版音乐接口
	 * 需要修复高级音乐
	 * */
	public static void main(String[] args) {
		String tmpSavePath = "E:\\WebMusic\\test\\";
//		new WebMusicProgram().menu(args);
		QQMusicProNoOhter music = new QQMusicProNoOhter();
		music.getInfo("陈奕迅");
		
		
		
	}

}
