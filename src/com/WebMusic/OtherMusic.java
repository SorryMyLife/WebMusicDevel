package com.WebMusic;

import com.WebMusic.util.MusicTypeList;
import com.WebMusic.util.OtherMusicUtils;
import com.WebMusic.util.WebMusicInfo;
import com.WebMusic.util.WebMusicTools;

/**
 * <p>
 * 创建时间：2019年2月1日 下午4:13:01
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明： OtherMusic模块
 * <p>
 * 其他几个音乐模块的父类
 * 
 * <pre>
* 
* OtherMusic为QQMusic,
* 	KuWoMusic,
* 	KuGou,
* 	CloudMusic163,
* 	XiaMiMusic的父类
* 
* 你可以通过OtherMusic来调用它们
* 运行实例:
* 
* OtherMusic o = new KuGou();
* o.getInfo("浮夸");
* 
* 这样就可以输出酷狗音乐类型的信息
* 
* 如果你不想要这样额外new一个对象实例
* 你可以通过setMusicType函数来设置音乐类型
* 实例:
* 
* OtherMusic o = new OtherMusic();
* o.setMusicType(MusicTypeList.CLOUD163); //注意这里,MusicTypeList是OtherMusic包内的
* o.getInfo("浮夸");
* 
* 这样输出来的内容就是网易云类型的
 * 
 * </pre>
 * <p>
 * 注解时间: 2019年2月1日 修改时间: 2020年2月23日
 * 
 * @version 1.0
 * @since JDK 1.8 文件名称：OtherMusic.java
 */
public class OtherMusic implements WebMusic {
	private String MusicType = "", SavePath = "";

	public String checkType(String type) {
		String t = "";
		if (type.equals(MusicTypeList.CLOUD163)) {
			t = MusicTypeList.CLOUD163;
		} else if (type.equals(MusicTypeList.KUGOU)) {
			t = MusicTypeList.KUGOU;
		} else if (type.equals(MusicTypeList.KUWO)) {
			t = MusicTypeList.KUWO;
		} else if (type.equals(MusicTypeList.XIAMI)) {
			t = MusicTypeList.XIAMI;
		} else if (type.equals(MusicTypeList.QQ)) {
			t = MusicTypeList.QQ;
		} else {
			t = MusicTypeList.KUGOU;
		}
		return t;
	}

	public String checkSave(String save) {
		String s = "";
		if (save.equals("")) {
			s = "e:\\WebMusic\\OtherMusic\\";
		} else {
			s = save;
		}
		return s;
	}

	@Override
	public void getInfo(String search_name) {
		new WebMusicTools().printList(new OtherMusicUtils().getInfoList(search_name, checkType(getMusicType())));
	}

	@Override
	public void getMusicList(String link) {
		new WebMusicTools().printList(new OtherMusicUtils().getMusicList(link, checkType(getMusicType())));
	}

	@Override
	public void getInfo(String search_name, int maxpage) {
		new WebMusicTools()
				.printList(new OtherMusicUtils().getInfoList(search_name, maxpage, checkType(getMusicType())));
	}

	@Override
	public String getInfoToString(String search_name) {
		return new WebMusicTools()
				.printListString(new OtherMusicUtils().getInfoList(search_name, checkType(getMusicType())));
	}

	@Override
	public String getInfoToString(String search_name, int maxpage) {
		return new WebMusicTools()
				.printListString(new OtherMusicUtils().getInfoList(search_name, maxpage, checkType(getMusicType())));
	}

	@Override
	public String getMusicListToString(String link) {
		return new WebMusicTools().printListString(new OtherMusicUtils().getMusicList(link, checkType(getMusicType())));
	}

	@Override
	public String[] getInfoToStringArray(String search_name) {
		return new WebMusicTools()
				.printListStringArray(new OtherMusicUtils().getInfoList(search_name, checkType(getMusicType())));
	}

	@Override
	public String[] getInfoToStringArray(String search_name, int maxpage) {
		return new WebMusicTools().printListStringArray(
				new OtherMusicUtils().getInfoList(search_name, maxpage, checkType(getMusicType())));
	}

	@Override
	public String[] getMusicListToStringArray(String link) {
		return new WebMusicTools()
				.printListStringArray(new OtherMusicUtils().getMusicList(link, checkType(getMusicType())));
	}

	@Override
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name) {
		return new WebMusicTools()
				.printListInfo(new OtherMusicUtils().getInfoList(search_name, checkType(getMusicType())));
	}

	@Override
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name, int maxpage) {
		return new WebMusicTools()
				.printListInfo(new OtherMusicUtils().getInfoList(search_name, maxpage, checkType(getMusicType())));
	}

	@Override
	public WebMusicInfo[] getMusicListToWebMusicInfo(String link) {
		return new WebMusicTools().printListInfo(new OtherMusicUtils().getMusicList(link, checkType(getMusicType())));
	}

	@Override
	public void getInfo(String search_name, int startPage, int endPage) {
		new WebMusicTools().printList(
				new OtherMusicUtils().getInfoList(search_name, startPage, endPage, checkType(getMusicType())));
	}

	@Override
	public String getInfoToString(String search_name, int startPage, int endPage) {
		return new WebMusicTools().printListString(
				new OtherMusicUtils().getInfoList(search_name, startPage, endPage, checkType(getMusicType())));
	}

	@Override
	public String[] getInfoToStringArray(String search_name, int startPage, int endPage) {
		return new WebMusicTools().printListStringArray(
				new OtherMusicUtils().getInfoList(search_name, startPage, endPage, checkType(getMusicType())));
	}

	@Override
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name, int startPage, int endPage) {
		return new WebMusicTools().printListInfo(
				new OtherMusicUtils().getInfoList(search_name, startPage, endPage, checkType(getMusicType())));
	}

	@Override
	public void DownloadAll(String search_name) {
		DownloadAll(search_name, checkSave(getSavePath()), 1, 1);
	}

	@Override
	public void DownloadAll(String search_name, String savePath) {
		DownloadAll(search_name, savePath, 1, 1);
	}

	@Override
	public void DownloadAll(String search_name, String savePath, int maxpage) {
		DownloadAll(search_name, savePath, 1, maxpage);
	}

	@Override
	public void DownloadList(String link) {
		DownloadList(link, checkSave(getSavePath()));
	}

	@Override
	public void DownloadList(String link, String savePath) {
		int n = 0;
		for (WebMusicInfo w : getMusicListToWebMusicInfo(link)) {
			new WebMusicTools().MultiThreadDownlaodMusic(w.getDownloadLink(), w.getFileName(), savePath, ".mp3");
			n++;
		}
		System.err.println("理论下载: " + n + " 个数据");
	}

	@Override
	public void DownloadAll(String search_name, int startPage, int endPage) {
		DownloadAll(search_name, checkSave(getSavePath()), startPage, endPage);
	}

	@Override
	public void DownloadAll(String search_name, String savePath, int startPage, int endPage) {
		int n = 0;
		WebMusicTools t = new WebMusicTools();
		if (startPage > 0) {
			if (endPage > startPage) {
				for (WebMusicInfo w : getInfoToWebMusicInfo(search_name, startPage, endPage)) {
					t.MultiThreadDownlaodMusic(w.getDownloadLink(), w.getFileName(), savePath, ".mp3");
					t.sleep(2000);
					n++;
				}
			} else {
				for (WebMusicInfo w : getInfoToWebMusicInfo(search_name, startPage, 1)) {
					t.MultiThreadDownlaodMusic(w.getDownloadLink(), w.getFileName(), savePath, ".mp3");
					t.sleep(2000);
					n++;
				}
			}
		} else {
			for (WebMusicInfo w : getInfoToWebMusicInfo(search_name, 1, 1)) {
				t.MultiThreadDownlaodMusic(w.getDownloadLink(), w.getFileName(), savePath, ".mp3");
				t.sleep(2000);
				n++;
			}
		}
		System.err.println("理论下载: " + n + " 个数据");
	}

	public String getMusicType() {
		return MusicType;
	}

	public String getSavePath() {
		return SavePath;
	}

	public void setMusicType(String musicType) {
		MusicType = musicType;
	}

	public void setSavePath(String savePath) {
		SavePath = savePath;
	}

	@Override
	public String getCookie() {
		return new OtherMusicUtils().getCookie();
	}

	@Override
	public String getUserAgent() {
		return new OtherMusicUtils().getUserAgent();
	}

	@Override
	public void setCookie(String cookie) {
		new OtherMusicUtils().setCookie(cookie);
	}

	@Override
	public void setUserAgent(String userAgent) {
		new OtherMusicUtils().setUserAgent(userAgent);
	}

}
