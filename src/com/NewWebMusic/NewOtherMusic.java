package com.NewWebMusic;

import com.NewWebMusic.MusicType.MusicTypeList;
import com.NewWebMusic.util.NewOtherMusicUtils;
import com.WebMusic.WebMusic;
import com.WebMusic.util.WebMusicInfo;
import com.WebMusic.util.WebMusicTools;

/**
 * <p>
 * 创建时间：2019年1月22日 下午4:25:53
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明： 其他类型的音乐
 * 
 * <pre>
* 由于此版本已经完全更换了接口
* 所有音乐类型都通过MusicTypeList来进行设置
* QQ、酷狗、虾米、酷我、网易云除外
* 虽然依旧实现于WebMusic接口
 * cookie、useragent、歌单功能均不再支持
 * 如果想要使用歌单功能，请去子类里面使用
 * QQ、酷狗等等
 * 
 * </pre>
 * 
 * <pre>
 * 运行实例: 
 * 
 * OtherMusic o = new OtherMusic();
 * o.getInfo("浮夸");
 * 
 * 如果你这样编写的话，它默认就是采用QQ音乐类型
 * 你可以通过setType函数来设置音乐类型
 * 比如这样: 
 * 
 * OtherMusic o = new OtherMusic();
 * o.setType(MusicTypeList.TYPE_KUGOU);
 * o.getInfo("浮夸");
 * 
 * 这样返回的内容就是酷狗类型的
 * 
 * 如果你想要知道支持什么音乐类型的话
 * 你可以这样操作:
 * 
 * MusicType m = new MusicType();
 * m.printMusicList();
 * 
 * 他可以将支持的类型都输出
 * 如果你不想要输出来的话
 * 你也可以调用getMusicList这个函数
 * 它是返回一个字符串类型
 * 
 * </pre>
 * 
 * <p>
 * 注释时间: 2019年2月1日
 * 
 * @version 1.0
 * @since JDK 1.8 文件名称：OtherMusic.java
 */
public class NewOtherMusic implements WebMusic {
	private final static String no_support = "此版本不再支持此功能";
	private String Type = "", save = "";

	/**
	 * <p>
	 * 获取设置的音乐类型
	 */
	public String getType() {
		return Type;
	}

	/**
	 * <p>
	 * 设置音乐类型
	 * <p>
	 * 需要传入一个参数：音乐类型名称
	 * <p>
	 * 可以通过MusicTypeList来查询有哪些音乐类型
	 * <p>
	 * 或者通过MusicType输出一下支持的音乐类型
	 */
	public void setType(String type) {
		this.Type = type;
	}

	/**
	 * <p>
	 * 配置音乐类型
	 * <p>
	 * 默认为QQ音乐
	 */
	public String checkType(String type) {
		String t = "";
		if (type.equals(MusicTypeList.TYPE_XIAMI)) {
			t = MusicTypeList.TYPE_XIAMI;
		} else if (type.equals(MusicTypeList.TYPE_CLOUD163)) {
			t = MusicTypeList.TYPE_CLOUD163;
		} else if (type.equals(MusicTypeList.TYPE_KUGOU)) {
			t = MusicTypeList.TYPE_KUGOU;
		} else if (type.equals(MusicTypeList.TYPE_KUWO)) {
			t = MusicTypeList.TYPE_KUWO;
		} else if (type.equals(MusicTypeList.TYPE_QQ)) {
			t = MusicTypeList.TYPE_QQ;
		} else {
			t = MusicTypeList.TYPE_QQ;
		}
		return t;
	}

	/**
	 * <p>
	 * 配置保存的位置
	 */
	public String checkSave(String save) {
		String s = "";
		if (save.equals("")) {
			s = "e:\\WebMusic\\OtherMusic\\music\\";
		} else {
			s = save;
		}
		return s;
	}

	private void p() {
		System.err.println(no_support);
	}

	@Override
	public void getInfo(String search_name) {
		new WebMusicTools().printList(new NewOtherMusicUtils().getInfoList(search_name, checkType(getType())));
	}

	@Override
	public void getInfo(String search_name, int maxpage) {
		new WebMusicTools().printList(new NewOtherMusicUtils().getInfoList(search_name, checkType(getType()), maxpage));
	}

	@Override
	public String getInfoToString(String search_name) {
		return new WebMusicTools().printListString(new NewOtherMusicUtils().getInfoList(search_name, checkType(getType())));
	}

	@Override
	public String getInfoToString(String search_name, int maxpage) {
		return new WebMusicTools()
				.printListString(new NewOtherMusicUtils().getInfoList(search_name, checkType(getType()), maxpage));
	}

	@Override
	public String[] getInfoToStringArray(String search_name) {
		return new WebMusicTools()
				.printListStringArray(new NewOtherMusicUtils().getInfoList(search_name, checkType(getType())));
	}

	@Override
	public String[] getInfoToStringArray(String search_name, int maxpage) {
		return new WebMusicTools()
				.printListStringArray(new NewOtherMusicUtils().getInfoList(search_name, checkType(getType()), maxpage));
	}

	@Override
	public void DownloadAll(String search_name) {
		DownloadAll(search_name, checkSave(getSave()), -1);
	}

	@Override
	public void DownloadAll(String search_name, String savePath) {
		DownloadAll(search_name, savePath, -1);
	}

	@Override
	public void DownloadAll(String search_name, String savePath, int maxpage) {
		DownloadAll(search_name, savePath, 1, maxpage);
	}

	@Override
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name) {
		return getInfoToWebMusicInfo(search_name, -1);
	}

	@Override
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name, int maxpage) {
		return new WebMusicTools()
				.printListInfo(new NewOtherMusicUtils().getInfoList(search_name, checkType(getType()), maxpage));
	}

	@Override
	public void getInfo(String search_name, int startPage, int endPage) {
		new WebMusicTools()
				.printList(new NewOtherMusicUtils().getInfoList(search_name, startPage, endPage, checkType(getType())));
	}

	@Override
	public String getInfoToString(String search_name, int startPage, int endPage) {
		return new WebMusicTools()
				.printListString(new NewOtherMusicUtils().getInfoList(search_name, startPage, endPage, checkType(getType())));
	}

	@Override
	public String[] getInfoToStringArray(String search_name, int startPage, int endPage) {
		return new WebMusicTools().printListStringArray(
				new NewOtherMusicUtils().getInfoList(search_name, startPage, endPage, checkType(getType())));
	}

	@Override
	public WebMusicInfo[] getInfoToWebMusicInfo(String search_name, int startPage, int endPage) {
		return new WebMusicTools()
				.printListInfo(new NewOtherMusicUtils().getInfoList(search_name, startPage, endPage, checkType(getType())));
	}

	@Override
	public void DownloadAll(String search_name, int startPage, int endPage) {
		DownloadAll(search_name, checkSave(getSave()), startPage, endPage);
	}

	@Override
	public void DownloadAll(String search_name, String savePath, int startPage, int endPage) {
		if (startPage > 0) {
			if (endPage > startPage) {
				for (WebMusicInfo w : getInfoToWebMusicInfo(search_name, startPage, endPage)) {
					new WebMusicTools().MultiThreadDownlaodMusic(w.getDownloadLink(), w.getFileName(),
							checkSave(getSave()), ".mp3");
				}
			} else {
				for (WebMusicInfo w : getInfoToWebMusicInfo(search_name, startPage, 1)) {
					new WebMusicTools().MultiThreadDownlaodMusic(w.getDownloadLink(), w.getFileName(),
							checkSave(getSave()), ".mp3");
				}
			}
		} else {
			for (WebMusicInfo w : getInfoToWebMusicInfo(search_name, 1, 1)) {
				new WebMusicTools().MultiThreadDownlaodMusic(w.getDownloadLink(), w.getFileName(), checkSave(getSave()),
						".mp3");
			}
		}
	}

	public String getSave() {
		return save;
	}

	public void setSave(String save) {
		this.save = save;
	}

	@Override
	public WebMusicInfo[] getMusicListToWebMusicInfo(String link) {
		p();
		return null;
	}

	@Override
	public String getCookie() {
		p();
		return null;
	}

	@Override
	public String getUserAgent() {
		p();
		return null;
	}

	@Override
	public void setCookie(String cookie) {
		p();
	}

	@Override
	public void setUserAgent(String userAgent) {
		p();
	}

	@Override
	public void DownloadList(String link) {
		p();
	}

	@Override
	public void DownloadList(String link, String savePath) {
		p();
	}

	@Override
	public void getMusicList(String link) {
		p();
	}

	@Override
	public String getMusicListToString(String link) {
		return no_support;
	}

	@Override
	public String[] getMusicListToStringArray(String link) {
		p();
		return null;
	}

}
