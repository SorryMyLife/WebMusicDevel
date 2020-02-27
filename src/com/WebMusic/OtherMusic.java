package com.WebMusic;

import com.WebMusic.util.MusicTypeList;
import com.WebMusic.util.OtherMusicUtils;
import com.WebMusic.util.WebMusicInfo;
import com.WebMusic.util.WebMusicTools;

/**
 * <p>
 * ����ʱ�䣺2019��2��1�� ����4:13:01
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵���� OtherMusicģ��
 * <p>
 * ������������ģ��ĸ���
 * 
 * <pre>
* 
* OtherMusicΪQQMusic,
* 	KuWoMusic,
* 	KuGou,
* 	CloudMusic163,
* 	XiaMiMusic�ĸ���
* 
* �����ͨ��OtherMusic����������
* ����ʵ��:
* 
* OtherMusic o = new KuGou();
* o.getInfo("����");
* 
* �����Ϳ�������ṷ�������͵���Ϣ
* 
* ����㲻��Ҫ��������newһ������ʵ��
* �����ͨ��setMusicType������������������
* ʵ��:
* 
* OtherMusic o = new OtherMusic();
* o.setMusicType(MusicTypeList.CLOUD163); //ע������,MusicTypeList��OtherMusic���ڵ�
* o.getInfo("����");
* 
* ��������������ݾ������������͵�
 * 
 * </pre>
 * <p>
 * ע��ʱ��: 2019��2��1�� �޸�ʱ��: 2020��2��23��
 * 
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�OtherMusic.java
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
		System.err.println("��������: " + n + " ������");
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
		System.err.println("��������: " + n + " ������");
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
