package com.WebMusic.util;
/**
* <p>创建时间：2019年2月1日 下午4:14:23
* <p>项目名称：WebMusic
* 
* <p>类说明：
*
* @version 1.0
* @since JDK 1.8
* 文件名称：OtherMusicUtils.java
* */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtherMusicUtils extends WebMusicTools {

	private String tmp;
	
	@Deprecated
	public void XiaMiSong(String search_name, int i, List<WebMusicInfo> l) {
		Matcher m = Pattern.compile("type=\"checkbox\"  value=\"\\d+\"").matcher(
				checkAndroid(LinkList.XiaMiMusicSongSearchLinkHeadOld + LinkList.XiaMiMusicSongSearchNextPageLinkOld + i
						+ LinkList.XiaMiMusicSongSearchKeyLinkOld + URLEncode(search_name)));
		System.out.println(LinkList.XiaMiMusicSongSearchLinkHeadOld + LinkList.XiaMiMusicSongSearchNextPageLinkOld + i
						+ LinkList.XiaMiMusicSongSearchKeyLinkOld + URLEncode(search_name));
		while (m.find()) {
			l.add(new XiaMiTool().getSongInfo(m.group().replaceAll("type=\"checkbox\"  value=|\"", "")));
		}
	}
	
	@Deprecated
	public void XiaMiMusicList(String link, List<WebMusicInfo> l) {
		Matcher m = Pattern.compile("href=\"/song/\\d+\"").matcher(checkAndroid(link));
		while (m.find()) {
			l.add(new XiaMiTool().getSongInfo(m.group().replaceAll("href=|song|/|\"", "")));
		}
	}

	public void QQMusicList(String link, List<WebMusicInfo> l) {

		list = new ArrayList<>();
		String page = new QQMusicTool().getMusicListPage(link);
		Matcher m = Pattern.compile("songmid\":(.+?\",)").matcher(page);
		Matcher vid = Pattern.compile("\"vid\":(.+?\")").matcher(page);
		while (m.find() && vid.find()) {
			addMusic(l, new QQMusicTool().getSongInfo(m.group().replaceAll("songmid|:|\"|,", ""),
					vid.group().replaceAll("vid|:|\"", ""), "歌单类型不提供"));
		}
	}

	public void QQInfoList(String search_name, int i, List<WebMusicInfo> l) {
		new QQMusicTool().PriInfo(checkAndroid(
				LinkList.QQMusicSearchSongLink + URLEncode(search_name) + LinkList.QQMusicSearchSongLinkPage + i), l);
	}

	public void KUWOInfoList(String search_name, int i, List<WebMusicInfo> l) {
		Matcher MusicHash = Pattern.compile("MUSIC_\\d+\"")
				.matcher(checkAndroid(LinkList.KuWoMusicSongSearchLink + URLEncode(search_name)
						+ LinkList.KuWoMusicSongSearchLinkEnd + LinkList.KuWoMusicSongSearchLinkPage + i));
		while (MusicHash.find()) {
			addMusic(l,new KuWoMusicTool().InfoJson(MusicHash.group().replaceAll("MUSIC_|\"", "")));
		}
	}

	public void KUWOMusicInfoList(String link, List<WebMusicInfo> l) {
		String page = checkAndroid(link);
		Matcher m = Pattern.compile("MUSIC_\\d+\"").matcher(getByString(page, "musicList:(.+?\\],error)", ""));
		while (m.find()) {
			addMusic(l, new KuWoMusicTool().InfoJson(m.group().replaceAll("MUSIC_|\"", "")));
		}
		if (l.size() == 0) {
			KUWOMusicInfoList(link, l);
		}
	}

	public void KUGOUInfoList(String search_name, int i, List<WebMusicInfo> l) {
		new KuGouTool().InfoList(checkAndroid(LinkList.KuGouSearchSongLink + URLEncode(search_name)
				+ LinkList.KuGouSearchSongLinkPage + i + LinkList.KuGouSearchSongLinkEnd), l);
	}

	public void KUGOUMusicInfoList(String link, List<WebMusicInfo> l) {
		HashSet<String> hashSet = new HashSet<>();
		Matcher m = Pattern.compile("data=" + match_s).matcher(checkAndroid(link));
		while (m.find()) {
			hashSet.add(m.group().replaceAll("data=|\"", "").split("\\|")[0]);
		}
		Iterator<String> it = hashSet.iterator();
		while (it.hasNext()) {
			tmp = checkAndroid(LinkList.KuGouSearchSongHashJsonLink + it.next(),doghs);
			tmp = UnicodeToString(tmp);
			new KuGouTool().PrivateInfoList(tmp, "", l);
		}
	}

	public void CLOUD163InfoList(String search_name, int music_num, List<WebMusicInfo> l) {
		Matcher M = Pattern.compile("\"id(.+?},\\{)")
				.matcher(checkAndroid(LinkList.CloudMusicSongSearchLink + URLEncode(search_name)
						+ LinkList.CloudMusicSongSearchLinkEnd + LinkList.CloudMusicSongSearchNum + music_num));
		while (M.find()) {
			addMusic(l, new CloudMusic163Tool().getSongInfo(getByString(M.group(), "id\":\\d+", "id|:|\"")));
		}
	}

	public void CLOUD163MusicList(String link, List<WebMusicInfo> l) {
		Matcher MusicName = Pattern.compile("song(.+?id)(.+?\\d+\")").matcher(checkAndroid(link.replaceAll("#", "")));
		while (MusicName.find()) {
			if (MusicName.group().replaceAll("song\\?id=|\"", "").indexOf("b") == -1) {
				addMusic(l, new CloudMusic163Tool().getSongInfo(MusicName.group().replaceAll("song\\?id=|\"", "")));
			}
		}
	}

	public void checkMusicList(String link, List<WebMusicInfo> l, String type) {
		if (type.equals(MusicTypeList.CLOUD163)) {
			CLOUD163MusicList(link, l);
		} else if (type.equals(MusicTypeList.KUGOU)) {
			KUGOUMusicInfoList(link, l);
		} else if (type.equals(MusicTypeList.KUWO)) {
			KUWOMusicInfoList(link, l);
		} else if (type.equals(MusicTypeList.XIAMI)) {
			XiaMiMusicList(link, l);
		} else if (type.equals(MusicTypeList.QQ)) {
			QQMusicList(link, l);
		} else {
			KUGOUMusicInfoList(link, l);
		}
	}

	public void checkMusicInfo(String search_name, int i, List<WebMusicInfo> l, String type) {
		if (type.equals(MusicTypeList.CLOUD163)) {
			CLOUD163InfoList(search_name, i, l);
		} else if (type.equals(MusicTypeList.KUGOU)) {
			KUGOUInfoList(search_name, i, l);
		} else if (type.equals(MusicTypeList.KUWO)) {
			KUWOInfoList(search_name, i, l);
		} else if (type.equals(MusicTypeList.XIAMI)) {
			XiaMiSong(search_name, i, l);
		} else if (type.equals(MusicTypeList.QQ)) {
			QQInfoList(search_name, i, l);
		} else {
			KUGOUInfoList(search_name, i, l);
		}
	}

	public List<WebMusicInfo> getInfoList(String search_name, int startPage, int endPage, String type) {
		List<WebMusicInfo> li = new ArrayList<>();
		if (startPage > 0) {
			if (endPage > startPage) {
				if (type.equals(MusicTypeList.CLOUD163)) {
					checkMusicInfo(search_name, (endPage * 10), li, type);
				} else {
					for (int i = startPage; i <= endPage; i++) {
						checkMusicInfo(search_name, i, li, type);
					}
				}
			} else {
				if (type.equals(MusicTypeList.CLOUD163)) {
					checkMusicInfo(search_name, (startPage * 10), li, type);
				} else {
					checkMusicInfo(search_name, startPage, li, type);
				}
			}
		} else {
			if (type.equals(MusicTypeList.CLOUD163)) {
				checkMusicInfo(search_name, 20, li, type);
			} else {
				checkMusicInfo(search_name, 1, li, type);
			}

		}
		return li;
	}

	public List<WebMusicInfo> getInfoList(String search_name, int maxpage, String type) {
		return getInfoList(search_name, 1, maxpage, type);
	}

	public List<WebMusicInfo> getInfoList(String search_name, String type) {
		return getInfoList(search_name, 1, 1, type);
	}

	public List<WebMusicInfo> getMusicList(String link, String type) {
		List<WebMusicInfo> l = new ArrayList<>();
		checkMusicList(link, l, type);
		return l;
	}
	
}
