package com.WebMusicPro.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.WebMusic.util.LinkList;
import com.WebMusic.util.WebMusicTools;
import com.WebMusicPro.util.WebMusicProInfo;

/**
 * <p>
 * 创建时间：2019年1月30日 下午8:05:31
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明：OtherMusicPro工具集
 *
 * @version 1.0
 * @since JDK 1.8 文件名称：OtherMusicProUtils.java
 */
public class OtherMusicProUtils extends WebMusicTools {

	private String Link;

	/**
	 * <p>
	 * 获取歌曲真实下载链接
	 * <p>
	 * 需要传入一个参数: apiPhp
	 * <p>
	 * 网站的链接
	 */
	public String getDownload(String apiPhp) {
		return getByJson(getPagesource(LinkList.MusicProLink + apiPhp), "url").replaceAll("\\\\", "");
	}

	/**
	 * <p>
	 * 存储酷我音乐歌单信息
	 * <p>
	 * 需要传入两个参数: page , list<WebMusicProInfo>
	 * <p>
	 * 歌单页面内容,带WebMusicProInfo的list
	 */
	public void KuWoMusicList(String page, List<WebMusicProInfo> list) {
		Matcher m = Pattern.compile("data-music=(.+?\",)").matcher(page);
		while (m.find()) {
			list.add(Info(getByJson(m.group(), "id").replaceAll("MUSIC_", ""), MusicTypePro.MusicProKUWO));
		}
		if (list.size() == 0) {
			Matcher n = Pattern.compile("mid=\"\\d+\"").matcher(page);
			while (n.find()) {
				list.add(Info(n.group().replaceAll("mid=|\"", ""), MusicTypePro.MusicProKUWO));
			}
		}
	}

	/**
	 * <p>
	 * 存储网易云音乐歌单信息
	 * <p>
	 * 需要传入两个参数: page , list<WebMusicProInfo>
	 * <p>
	 * 歌单页面内容,带WebMusicProInfo的list
	 */
	public void CloudMusic163MusicList(String page, List<WebMusicProInfo> list) {
		Matcher MusicName = Pattern.compile("song(.+?id)(.+?\\d+\")").matcher(page);
		while (MusicName.find()) {
			if (MusicName.group().replaceAll("song\\?id=|\"", "").indexOf("b") == -1) {
				list.add(Info(MusicName.group().replaceAll("song\\?id=|\"", ""), MusicTypePro.MusicProCLOUD163));
			}
		}
	}

	/**
	 * <p>
	 * 存储虾米音乐歌单信息
	 * <p>
	 * 需要传入两个参数: page , list<WebMusicProInfo>
	 * <p>
	 * 歌单页面内容,带WebMusicProInfo的list
	 */
	public void XiaMiMusicList(String page, List<WebMusicProInfo> list) {
		Matcher m = Pattern.compile("href=\"/song/\\d+\"").matcher(page);
		while (m.find()) {
			list.add(Info(m.group().replaceAll("href=|song|/|\"", ""), MusicTypePro.MusicProXIAMI));
		}
	}

	/**
	 * <p>
	 * 存储酷苟音乐歌单信息
	 * <p>
	 * 需要传入两个参数: page , list<WebMusicProInfo>
	 * <p>
	 * 歌单页面内容,带WebMusicProInfo的list
	 */
	public void KuGouMusicList(String page, List<WebMusicProInfo> list) {
		Matcher m = Pattern.compile("data=\"(.+?\")").matcher(page);
		while (m.find()) {
			list.add(Info(m.group().replaceAll("data=|\"", "").split("\\|")[0], MusicTypePro.MusicProKUGOU));
		}
	}

	/**
	 * <p>
	 * 存放酷我音乐歌曲各个音质直链
	 * <p>
	 * 需要传入两个参数: s , w
	 * <p>
	 * 返回的歌曲信息json列表 ，WebMusicProInfo实例对象
	 */
	public void KuWo(String s, WebMusicProInfo w) {
		w.setAPE(getDownload(getByJson(s, "APE")));
		w.setFLAC(getDownload(getByJson(s, "FLAC")));
		w.setM320k(getDownload(getByJson(s, "320MP3")));
		w.setM128k(getDownload(getByJson(s, "128MP3")));
		w.setM4a(getDownload(getByJson(s, "128MP3")));
	}

	/**
	 * <p>
	 * 存放网易云音乐歌曲各个音质直链
	 * <p>
	 * 需要传入两个参数: s , w
	 * <p>
	 * 返回的歌曲信息json列表 ，WebMusicProInfo实例对象
	 */
	public void Cloud163(String s, WebMusicProInfo w) {
		w.setAPE(getDownload(getByJson(s, "FLAC")));
		w.setFLAC(w.getAPE());
		w.setM320k(getDownload(getByJson(s, "320MP3")));
		w.setM128k(getDownload(getByJson(s, "128MP3")));
		w.setM4a(getDownload(getByJson(s, "64AAC")));
	}

	/**
	 * <p>
	 * 存放虾米音乐歌曲各个音质直链
	 * <p>
	 * 需要传入两个参数: s , w
	 * <p>
	 * 返回的歌曲信息json列表 ，WebMusicProInfo实例对象
	 */
	public void XiaMi(String s, WebMusicProInfo w) {
		w.setAPE(getDownload(getByJson(s, "WAV")));
		w.setFLAC(w.getAPE());
		w.setM320k(getDownload(getByJson(s, "320MP3")));
		w.setM128k(getDownload(getByJson(s, "128MP3")));
		w.setM4a(getDownload(getByJson(s, "32AAC")));
	}

	/**
	 * <p>
	 * 存放酷狗音乐歌曲各个音质直链
	 * <p>
	 * 需要传入两个参数: s , w
	 * <p>
	 * 返回的歌曲信息json列表 ，WebMusicProInfo实例对象
	 */
	public void KuGou(String s, WebMusicProInfo w) {
		w.setAPE(getDownload(getByJson(s, "FLAC")));
		w.setFLAC(w.getAPE());
		w.setM320k(getDownload(getByJson(s, "320MP3")));
		w.setM128k(getDownload(getByJson(s, "128MP3")));
		w.setM4a(getDownload(getByJson(s, "32AAC")));
	}

	/**
	 * <p>
	 * 存放千千音乐(百度音乐)歌曲各个音质直链
	 * <p>
	 * 需要传入两个参数: s , w
	 * <p>
	 * 返回的歌曲信息json列表 ，WebMusicProInfo实例对象
	 */
	public void BD(String s, WebMusicProInfo w) {
		w.setAPE(getDownload(getByJson(s, "FLAC")));
		w.setFLAC(getDownload(getByJson(s, "FLAC")));
		w.setM320k(getDownload(getByJson(s, "320MP3")));
		w.setM128k(getDownload(getByJson(s, "128MP3")));
		w.setM4a(w.getM128k());
	}

	/**
	 * <p>
	 * 获取歌曲相关信息
	 * <p>
	 * 需要传入两个参数: song_id , type
	 * <p>
	 * 歌曲id，音乐类型
	 */
	public WebMusicProInfo Info(String song_id, String type) {
		WebMusicProInfo w = new WebMusicProInfo();
		String s = getPagesourceOnPost(LinkList.MusicProLink + LinkList.MusicProGetSongLink + type, "mid=" + song_id);
		w.setMusicHash(song_id);
		w.setMusicName(getByJson(s, "song"));
		w.setSingerName(getByJson(s, "singer"));
		w.setAlbumName(getByJson(s, "album"));
		w.setAuxiliary("不提供!");
		String fileName = w.getSingerName() + "-" + w.getMusicName();
		w.setFileName(fileName.replaceAll("\\s+", ""));
		w.setVideoId(getDownload(getByJson(s, "MV")));
		w.setMusicImg("不提供!");
		if (type.equals(MusicTypePro.MusicProKUWO)) {
			KuWo(s, w);
		} else if (type.equals(MusicTypePro.MusicProCLOUD163)) {
			Cloud163(s, w);
		} else if (type.equals(MusicTypePro.MusicProXIAMI)) {
			XiaMi(s, w);
		} else if (type.equals(MusicTypePro.MusicProKUGOU)) {
			KuGou(s, w);
		} else if (type.equals(MusicTypePro.MusicProBAIDU)) {
			BD(s, w);
		}
		w.setDownloadLink(w.getM320k());
		return w;
	}

	/**
	 * <p>
	 * 返回一个带有WebMusicProInfo的List
	 * <p>
	 * 需要传入四个参数: search_name , maxpage , music_num , type
	 * <p>
	 * 搜索的内容，最大页面数量(只能是整数型) , 一页歌曲的数量(只能是数字，而且最低只能是11) , 音乐类型
	 */
	public List<WebMusicProInfo> getInfoList(String search_name, int maxpage, int music_num, String type) {
		List<WebMusicProInfo> l = null;
		if (maxpage > 1) {
			l = getInfoList(search_name, 1, maxpage, music_num, type);
		} else {
			l = getInfoList(search_name, 1, 1, music_num, type);
		}
		return l;
	}

	/**
	 * <p>
	 * 返回一个带有WebMusicProInfo的List
	 * <p>
	 * 需要传入三个参数: search_name , music_num , type
	 * <p>
	 * 搜索的内容, 一页歌曲的数量(只能是数字，而且最低只能是11) , 音乐类型
	 */
	public List<WebMusicProInfo> getInfoList(String search_name, int music_num, String type) {
		return getInfoList(search_name, -1, music_num, type);
	}

	/**
	 * <p>
	 * 返回一个带有WebMusicProInfo的List
	 * <p>
	 * 需要传入两个参数: link , type
	 * <p>
	 * 歌单链接 , 音乐类型
	 */
	public List<WebMusicProInfo> getMusicListInfo(String link, String type) {
		List<WebMusicProInfo> list = new ArrayList<>();
		String page = getGzipPagesource(link);
		if (type.equals(MusicTypePro.MusicProKUWO)) {
			KuWoMusicList(page, list);
		} else if (type.equals(MusicTypePro.MusicProCLOUD163)) {
			CloudMusic163MusicList(page, list);
		} else if (type.equals(MusicTypePro.MusicProXIAMI)) {
			XiaMiMusicList(page, list);
		} else if (type.equals(MusicTypePro.MusicProKUGOU)) {
			KuGouMusicList(page, list);
		} else if (type.equals(MusicTypePro.MusicProBAIDU)) {
			System.err.println("经过慎重考虑,我觉得没必要支持这个玩意儿");
			System.exit(-1);
		}
		return list;
	}

	/**
	 * <p>
	 * 返回一个带有WebMusicProInfo的List
	 * <p>
	 * 需要传入五个参数: search_name , startPage , endPage , music_num , type
	 * <p>
	 * 搜索的内容 , 页面开始的位置 , 页面结束的位置, 一页歌曲的数量(只能是数字，而且最低只能是11) , 音乐类型
	 */
	public List<WebMusicProInfo> getInfoList(String search_name, int startPage, int endPage, int music_num,
			String type) {
		List<WebMusicProInfo> l = new ArrayList<WebMusicProInfo>();
		if (startPage > 0) {
			if (endPage > startPage) {
				for (int i = startPage; i <= endPage; i++) {
					setLink(LinkList.MusicProLink + LinkList.MusicProSearchTypeLink + type + LinkList.MusicProSearchLink
							+ URLEncode(search_name) + LinkList.MusicProPageLink + i + LinkList.MusicProMusicNumLink
							+ music_num);
					Matcher mid = Pattern.compile("\"songmid\":(.+?\")(.+?\")").matcher(checkAndroid(getLink()));
					while (mid.find()) {
						l.add(Info(mid.group().replaceAll("songmid|songname|:|,|\"", ""), type));
					}
				}
			} else {
				setLink(LinkList.MusicProLink + LinkList.MusicProSearchTypeLink + type + LinkList.MusicProSearchLink
						+ URLEncode(search_name) + LinkList.MusicProPageLink + startPage + LinkList.MusicProMusicNumLink
						+ music_num);
				Matcher mid = Pattern.compile("\"songmid\":(.+?\")(.+?\")").matcher(checkAndroid(getLink()));
				while (mid.find()) {
					l.add(Info(mid.group().replaceAll("songmid|songname|:|,|\"", ""), type));
				}
			}
		} else {
			setLink(LinkList.MusicProLink + LinkList.MusicProSearchTypeLink + type + LinkList.MusicProSearchLink
					+ URLEncode(search_name) + LinkList.MusicProPageLink + 1 + LinkList.MusicProMusicNumLink
					+ music_num);
			Matcher mid = Pattern.compile("\"songmid\":(.+?\")(.+?\")").matcher(checkAndroid(getLink()));
			while (mid.find()) {
				l.add(Info(mid.group().replaceAll("songmid|songname|:|,|\"", ""), type));
			}
		}
		return l;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}

}
