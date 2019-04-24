package com.NewWebMusic.MusicType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.NewWebMusic.util.NewOtherMusicUtils;
import com.WebMusic.util.LinkList;

/**
 * <p>
 * ����ʱ�䣺2019��1��20�� ����11:52:31
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵���� ���ظ�������
 * <p>
 * ע��ʱ��: 2019��1��22��
 * 
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�getMusicType.java
 */
public class MusicType extends NewOtherMusicUtils {
	/**
	 * <p>
	 * ��ȡ������������
	 * 
	 */
	public String getMusicList() {
		String str = "", tmp = "", all = "";
		String headers[] = {
				"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
				"Accept-Encoding: gzip, deflate", "Accept-Language: zh-CN,zh;q=0.9", "Connection: keep-alive",
				"Host: " + LinkList.NewWebMusicHost.replaceAll("htt(p|ps)|:|/", ""),
				"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36" };
		setHeaders(headers);
		str = getGzipPagesource(LinkList.NewWebMusicHost);
		Matcher m = Pattern.compile("music_type\"(.+?>\\s+\\S*)").matcher(str);
		while (m.find()) {
			tmp = m.group();
			all += tmp.substring(tmp.indexOf("value=\""), tmp.lastIndexOf("da")).replaceAll("value=|\"", "") + "-"
					+ tmp.substring(tmp.indexOf(">")).replaceAll(">|\\s+", "") + "����" + "\n";
		}
		return all;
	}

	/**
	 * <p>
	 * ���������������
	 * 
	 */
	public void printMusicList() {
		System.out.println(getMusicList());
	}

	/**
	 * <p>
	 * ����������������
	 */
	public String[] getMusicTypeArray() {
		return getMusicList().split("\n");
	}
}
