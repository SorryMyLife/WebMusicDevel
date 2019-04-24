package com.WebMusic.util;

/**
 * <p>
 * ��Ÿ�����Ϣ
 **/

public class WebMusicInfo {
	private String MusicName = "" // ��������
			, MusicHash = "" // �����Ĺ�ϣֵ
			, SingerName = "" // ��������
			, AlbumName = "" // ר������
			, Auxiliary = "" // ��������
			, FileName = "" // �����ļ�����
			, DownloadLink = "" // ��������
			, VideoId = "" // ����mv��ƵID
			, MusicImg = "" // ����ͷ��д��
	;

	/**
	 * <p>
	 * ��ȡ�ṷ���е���Ϣ
	 **/
	public String getAllToKuGou() {
		return getAllToCloud() + "����mv����: https://www.kugou.com/mvweb/html/mv_" + getVideoId() + ".html\n";
	}

	/**
	 * <p>
	 * ��ȡ�������е���Ϣ
	 **/
	public String getNewWebMusic() {
		return "��������: " + getMusicName() + "\n" + "������id/��ϣֵ: " + getMusicHash() + "\n" + "��������: " + getSingerName()
				+ "\n" + "��������: " + getAuxiliary() + "\n" + "�����ļ�����: " + getFileName().replaceAll("\\s+", "") + "\n" + "������������: "
				+ getDownloadLink() + "\n" + "����д��ͼƬ: " + getMusicImg() + "\n";
	}

	/**
	 * <p>
	 * ��ȡ���������и�������Ϣ
	 **/
	public String getAllToCloud() {
		return "��������: " + getMusicName() + "\n" + "������id/��ϣֵ: " + getMusicHash() + "\n" + "��������: " + getSingerName()
				+ "\n" + "ר������: " + getAlbumName() + "\n" + "��������: " + getAuxiliary() + "\n" + "�����ļ�����: "
				+ getFileName().replaceAll("\\s+", "") + "\n" + "������������: " + getDownloadLink() + "\n" + "����д��ͼƬ: " + getMusicImg() + "\n"
				+ "����mvid: " + getVideoId() + "\n";
	}

	/**
	 * <p>
	 * ��ȡϺ�����и�������Ϣ
	 **/
	public String getAllToXiaMi() {
		return getAllToCloud();
	}

	/**
	 * <p>
	 * ��ȡ������ƵΨһID
	 **/
	public String getVideoId() {
		return VideoId;
	}

	/**
	 * <p>
	 * ���ø�����ƵΨһID
	 **/
	public void setVideoId(String videoId) {
		VideoId = videoId;
	}

	/**
	 * <p>
	 * ��ȡ��������������
	 **/
	public String getDownloadLink() {
		return DownloadLink;
	}

	/**
	 * <p>
	 * ���ø�������������
	 **/
	public void setDownloadLink(String downloadLink) {
		DownloadLink = downloadLink;
	}

	/**
	 * <p>
	 * ��ȡ����������
	 **/
	public String getMusicName() {
		return MusicName;
	}

	/**
	 * <p>
	 * ��ȡ������Ψһ����
	 * <p>
	 * �����ǹ�ϣֵ
	 * <p>
	 * Ҳ���������к�
	 **/
	public String getMusicHash() {
		return MusicHash;
	}

	/**
	 * <p>
	 * ���ø�������
	 **/
	public void setMusicName(String musicName) {
		MusicName = musicName;
	}

	/**
	 * <p>
	 * ���ø�����Ψһ����
	 **/
	public void setMusicHash(String musicHash) {
		MusicHash = musicHash;
	}

	/**
	 * <p>
	 * ��ȡ���ֵ�����
	 **/
	public String getSingerName() {
		return SingerName;
	}

	/**
	 * <p>
	 * ���ø��ֵ�����
	 **/
	public void setSingerName(String singerName) {
		SingerName = singerName;
	}

	/**
	 * <p>
	 * ��ȡ�����ĳ���
	 **/
	public String getAuxiliary() {
		return Auxiliary;
	}

	/**
	 * <p>
	 * ���ø����ĳ���
	 **/
	public void setAuxiliary(String auxiliary) {
		Auxiliary = auxiliary;
	}

	/**
	 * <p>
	 * ��ȡ����ר��������
	 **/
	public String getAlbumName() {
		return AlbumName;
	}

	/**
	 * <p>
	 * ���ø���ר��������
	 **/
	public void setAlbumName(String albumName) {
		AlbumName = albumName;
	}

	/**
	 * <p>
	 * ��ȡ����������
	 **/
	public String getFileName() {
		return FileName;
	}

	/**
	 * <p>
	 * ���ø���������
	 **/
	public void setFileName(String fileName) {
		FileName = fileName;
	}

	/**
	 * <p>
	 * ��ȡ�������߸��ֵ�д��
	 **/
	public String getMusicImg() {
		return MusicImg;
	}

	/**
	 * <p>
	 * ���ø������߸��ֵ�д��
	 **/
	public void setMusicImg(String musicImg) {
		MusicImg = musicImg;
	}
}
