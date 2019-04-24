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
 * ����ʱ�䣺2019��1��30�� ����8:05:31
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵����OtherMusicPro���߼�
 *
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�OtherMusicProUtils.java
 */
public class OtherMusicProUtils extends WebMusicTools {

	private String Link;

	/**
	 * <p>
	 * ��ȡ������ʵ��������
	 * <p>
	 * ��Ҫ����һ������: apiPhp
	 * <p>
	 * ��վ������
	 */
	public String getDownload(String apiPhp) {
		return getByJson(getPagesource(LinkList.MusicProLink + apiPhp), "url").replaceAll("\\\\", "");
	}

	/**
	 * <p>
	 * �洢�������ָ赥��Ϣ
	 * <p>
	 * ��Ҫ������������: page , list<WebMusicProInfo>
	 * <p>
	 * �赥ҳ������,��WebMusicProInfo��list
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
	 * �洢���������ָ赥��Ϣ
	 * <p>
	 * ��Ҫ������������: page , list<WebMusicProInfo>
	 * <p>
	 * �赥ҳ������,��WebMusicProInfo��list
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
	 * �洢Ϻ�����ָ赥��Ϣ
	 * <p>
	 * ��Ҫ������������: page , list<WebMusicProInfo>
	 * <p>
	 * �赥ҳ������,��WebMusicProInfo��list
	 */
	public void XiaMiMusicList(String page, List<WebMusicProInfo> list) {
		Matcher m = Pattern.compile("href=\"/song/\\d+\"").matcher(page);
		while (m.find()) {
			list.add(Info(m.group().replaceAll("href=|song|/|\"", ""), MusicTypePro.MusicProXIAMI));
		}
	}

	/**
	 * <p>
	 * �洢�Ṷ���ָ赥��Ϣ
	 * <p>
	 * ��Ҫ������������: page , list<WebMusicProInfo>
	 * <p>
	 * �赥ҳ������,��WebMusicProInfo��list
	 */
	public void KuGouMusicList(String page, List<WebMusicProInfo> list) {
		Matcher m = Pattern.compile("data=\"(.+?\")").matcher(page);
		while (m.find()) {
			list.add(Info(m.group().replaceAll("data=|\"", "").split("\\|")[0], MusicTypePro.MusicProKUGOU));
		}
	}

	/**
	 * <p>
	 * ��ſ������ָ�����������ֱ��
	 * <p>
	 * ��Ҫ������������: s , w
	 * <p>
	 * ���صĸ�����Ϣjson�б� ��WebMusicProInfoʵ������
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
	 * ������������ָ�����������ֱ��
	 * <p>
	 * ��Ҫ������������: s , w
	 * <p>
	 * ���صĸ�����Ϣjson�б� ��WebMusicProInfoʵ������
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
	 * ���Ϻ�����ָ�����������ֱ��
	 * <p>
	 * ��Ҫ������������: s , w
	 * <p>
	 * ���صĸ�����Ϣjson�б� ��WebMusicProInfoʵ������
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
	 * ��ſṷ���ָ�����������ֱ��
	 * <p>
	 * ��Ҫ������������: s , w
	 * <p>
	 * ���صĸ�����Ϣjson�б� ��WebMusicProInfoʵ������
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
	 * ���ǧǧ����(�ٶ�����)������������ֱ��
	 * <p>
	 * ��Ҫ������������: s , w
	 * <p>
	 * ���صĸ�����Ϣjson�б� ��WebMusicProInfoʵ������
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
	 * ��ȡ���������Ϣ
	 * <p>
	 * ��Ҫ������������: song_id , type
	 * <p>
	 * ����id����������
	 */
	public WebMusicProInfo Info(String song_id, String type) {
		WebMusicProInfo w = new WebMusicProInfo();
		String s = getPagesourceOnPost(LinkList.MusicProLink + LinkList.MusicProGetSongLink + type, "mid=" + song_id);
		w.setMusicHash(song_id);
		w.setMusicName(getByJson(s, "song"));
		w.setSingerName(getByJson(s, "singer"));
		w.setAlbumName(getByJson(s, "album"));
		w.setAuxiliary("���ṩ!");
		String fileName = w.getSingerName() + "-" + w.getMusicName();
		w.setFileName(fileName.replaceAll("\\s+", ""));
		w.setVideoId(getDownload(getByJson(s, "MV")));
		w.setMusicImg("���ṩ!");
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
	 * ����һ������WebMusicProInfo��List
	 * <p>
	 * ��Ҫ�����ĸ�����: search_name , maxpage , music_num , type
	 * <p>
	 * ���������ݣ����ҳ������(ֻ����������) , һҳ����������(ֻ�������֣��������ֻ����11) , ��������
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
	 * ����һ������WebMusicProInfo��List
	 * <p>
	 * ��Ҫ������������: search_name , music_num , type
	 * <p>
	 * ����������, һҳ����������(ֻ�������֣��������ֻ����11) , ��������
	 */
	public List<WebMusicProInfo> getInfoList(String search_name, int music_num, String type) {
		return getInfoList(search_name, -1, music_num, type);
	}

	/**
	 * <p>
	 * ����һ������WebMusicProInfo��List
	 * <p>
	 * ��Ҫ������������: link , type
	 * <p>
	 * �赥���� , ��������
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
			System.err.println("�������ؿ���,�Ҿ���û��Ҫ֧����������");
			System.exit(-1);
		}
		return list;
	}

	/**
	 * <p>
	 * ����һ������WebMusicProInfo��List
	 * <p>
	 * ��Ҫ�����������: search_name , startPage , endPage , music_num , type
	 * <p>
	 * ���������� , ҳ�濪ʼ��λ�� , ҳ�������λ��, һҳ����������(ֻ�������֣��������ֻ����11) , ��������
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
