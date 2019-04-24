package com.NewWebMusic.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.WebMusic.util.LinkList;
import com.WebMusic.util.WebMusicInfo;
import com.WebMusic.util.WebMusicTools;

/**
 * <p>
 * ����ʱ�䣺2019��1��20�� ����12:14:59
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵���� �ṩ������Ϣ�Ĺ���
 * <p>
 * ע��ʱ��: 2019��1��22��
 * 
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�MusicTools.java
 */
public class NewOtherMusicUtils extends WebMusicTools {
	/**
	 * <p>
	 * ��ȡ������Ϣ
	 * <p>
	 * ��Ҫ�����ĸ��������������ơ��������͡�ҳ������WebMusicInfo���͵�list�ӿ�
	 */
	public void InfoList(String music_name, String type, int page, List<WebMusicInfo> list) {
		music_name = URLEncode(music_name);
		String url_name = LinkList.NewWebMusicHost + "/?name=" + music_name + "&type=" + type, tmp = "";
		String headers[] = { "Accept: application/json, text/javascript, */*; q=0.01", 
				"Accept-Language: zh-CN,zh;q=0.9", "Connection: keep-alive",
				"Content-Type: application/x-www-form-urlencoded; charset=UTF-8", "Host: music.cccyun.cc",
				"Origin: " + LinkList.NewWebMusicHost, "Referer: " + url_name, "X-Requested-With: XMLHttpRequest" };
		try {
			setHeaders(headers);
			tmp = getPagesourceOnPost(url_name,
					"input=" + music_name + "&filter=name&type=" + type + "&page=" + page);
			tmp = UnicodeToString(tmp);
			Matcher m = Pattern.compile("\\{(.+?\\})").matcher(tmp);
			while (m.find()) {
				WebMusicInfo webMusicInfo = new WebMusicInfo();
				String str = m.group().replaceAll("\\{\"data\":\\[", "");
				webMusicInfo.setMusicName(getByJson(str, "title"));
				webMusicInfo.setSingerName(getByJson(str, "author"));
				webMusicInfo.setMusicHash(getByJson(str, "songid"));
				webMusicInfo.setMusicImg(getByJson(str, "pic").replaceAll("\\\\", ""));
				webMusicInfo.setDownloadLink(getByJson(str, "url").replaceAll("\\\\", ""));
				webMusicInfo.setAuxiliary(getByJson(str, "link"));
				String fileName = webMusicInfo.getSingerName() + "-" + webMusicInfo.getMusicName();
				webMusicInfo.setFileName(fileName.replaceAll("\\s+", ""));
				webMusicInfo.setAuxiliary("�°治���ṩ�˹���");
				webMusicInfo.setVideoId("�°治���ṩ�˹���");
				list.add(webMusicInfo);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * ��ȡ������Ϣ
	 * <p>
	 * ��Ҫ���������������������ơ��������͡�ҳ������
	 */
	public List<WebMusicInfo> getInfoList(String music_name, String type, int maxpage) {
		return getInfoList(music_name, 1, maxpage, type);
	}

	public List<WebMusicInfo> getInfoList(String music_name, int startPage, int endPage, String type) {
		List<WebMusicInfo> list = new ArrayList<>();
		if (startPage > 0) {
			if (endPage > startPage) {
				for (int i = startPage; i <= endPage; i++) {
					InfoList(music_name, type, i, list);
				}
			} else {
				InfoList(music_name, type, startPage, list);
			}
		} else {
			InfoList(music_name, type, 1, list);
		}
		return list;
	}

	/**
	 * <p>
	 * ��ȡ������Ϣ
	 * <p>
	 * ��Ҫ���������������������ơ���������
	 */
	public List<WebMusicInfo> getInfoList(String music_name, String type) {
		return getInfoList(music_name, type, 1);
	}
}
