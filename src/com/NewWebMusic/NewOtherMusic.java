package com.NewWebMusic;

import com.NewWebMusic.MusicType.MusicTypeList;
import com.NewWebMusic.util.NewOtherMusicUtils;
import com.WebMusic.WebMusic;
import com.WebMusic.util.WebMusicInfo;
import com.WebMusic.util.WebMusicTools;

/**
 * <p>
 * ����ʱ�䣺2019��1��22�� ����4:25:53
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵���� �������͵�����
 * 
 * <pre>
* ���ڴ˰汾�Ѿ���ȫ�����˽ӿ�
* �����������Ͷ�ͨ��MusicTypeList����������
* QQ���ṷ��Ϻ�ס����ҡ������Ƴ���
* ��Ȼ����ʵ����WebMusic�ӿ�
 * cookie��useragent���赥���ܾ�����֧��
 * �����Ҫʹ�ø赥���ܣ���ȥ��������ʹ��
 * QQ���ṷ�ȵ�
 * 
 * </pre>
 * 
 * <pre>
 * ����ʵ��: 
 * 
 * OtherMusic o = new OtherMusic();
 * o.getInfo("����");
 * 
 * �����������д�Ļ�����Ĭ�Ͼ��ǲ���QQ��������
 * �����ͨ��setType������������������
 * ��������: 
 * 
 * OtherMusic o = new OtherMusic();
 * o.setType(MusicTypeList.TYPE_KUGOU);
 * o.getInfo("����");
 * 
 * �������ص����ݾ��ǿṷ���͵�
 * 
 * �������Ҫ֪��֧��ʲô�������͵Ļ�
 * �������������:
 * 
 * MusicType m = new MusicType();
 * m.printMusicList();
 * 
 * �����Խ�֧�ֵ����Ͷ����
 * ����㲻��Ҫ������Ļ�
 * ��Ҳ���Ե���getMusicList�������
 * ���Ƿ���һ���ַ�������
 * 
 * </pre>
 * 
 * <p>
 * ע��ʱ��: 2019��2��1��
 * 
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�OtherMusic.java
 */
public class NewOtherMusic implements WebMusic {
	private final static String no_support = "�˰汾����֧�ִ˹���";
	private String Type = "", save = "";

	/**
	 * <p>
	 * ��ȡ���õ���������
	 */
	public String getType() {
		return Type;
	}

	/**
	 * <p>
	 * ������������
	 * <p>
	 * ��Ҫ����һ��������������������
	 * <p>
	 * ����ͨ��MusicTypeList����ѯ����Щ��������
	 * <p>
	 * ����ͨ��MusicType���һ��֧�ֵ���������
	 */
	public void setType(String type) {
		this.Type = type;
	}

	/**
	 * <p>
	 * ������������
	 * <p>
	 * Ĭ��ΪQQ����
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
	 * ���ñ����λ��
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
