package com.WebMusic.util;

/**
 * <p>
 * 存放歌曲信息
 **/

public class WebMusicInfo {
	private String MusicName = "" // 歌曲名称
			, MusicHash = "" // 歌曲的哈希值
			, SingerName = "" // 歌手名称
			, AlbumName = "" // 专辑名称
			, Auxiliary = "" // 歌曲出处
			, FileName = "" // 歌曲文件名称
			, DownloadLink = "" // 下载链接
			, VideoId = "" // 歌曲mv视频ID
			, MusicImg = "" // 歌手头像、写真
	;

	/**
	 * <p>
	 * 获取酷狗所有的信息
	 **/
	public String getAllToKuGou() {
		return getAllToCloud() + "歌曲mv链接: https://www.kugou.com/mvweb/html/mv_" + getVideoId() + ".html\n";
	}

	/**
	 * <p>
	 * 获取歌曲所有的信息
	 **/
	public String getNewWebMusic() {
		return "歌曲名称: " + getMusicName() + "\n" + "歌曲哈id/哈希值: " + getMusicHash() + "\n" + "歌手名称: " + getSingerName()
				+ "\n" + "歌曲出处: " + getAuxiliary() + "\n" + "歌曲文件名称: " + getFileName().replaceAll("\\s+", "") + "\n" + "歌曲下载链接: "
				+ getDownloadLink() + "\n" + "歌手写真图片: " + getMusicImg() + "\n";
	}

	/**
	 * <p>
	 * 获取网易云所有歌曲的信息
	 **/
	public String getAllToCloud() {
		return "歌曲名称: " + getMusicName() + "\n" + "歌曲哈id/哈希值: " + getMusicHash() + "\n" + "歌手名称: " + getSingerName()
				+ "\n" + "专辑名称: " + getAlbumName() + "\n" + "歌曲出处: " + getAuxiliary() + "\n" + "歌曲文件名称: "
				+ getFileName().replaceAll("\\s+", "") + "\n" + "歌曲下载链接: " + getDownloadLink() + "\n" + "歌手写真图片: " + getMusicImg() + "\n"
				+ "歌曲mvid: " + getVideoId() + "\n";
	}

	/**
	 * <p>
	 * 获取虾米所有歌曲的信息
	 **/
	public String getAllToXiaMi() {
		return getAllToCloud();
	}

	/**
	 * <p>
	 * 获取歌曲视频唯一ID
	 **/
	public String getVideoId() {
		return VideoId;
	}

	/**
	 * <p>
	 * 设置歌曲视频唯一ID
	 **/
	public void setVideoId(String videoId) {
		VideoId = videoId;
	}

	/**
	 * <p>
	 * 获取歌曲的下载链接
	 **/
	public String getDownloadLink() {
		return DownloadLink;
	}

	/**
	 * <p>
	 * 设置歌曲的下载链接
	 **/
	public void setDownloadLink(String downloadLink) {
		DownloadLink = downloadLink;
	}

	/**
	 * <p>
	 * 获取歌曲的名称
	 **/
	public String getMusicName() {
		return MusicName;
	}

	/**
	 * <p>
	 * 获取歌曲的唯一特征
	 * <p>
	 * 可能是哈希值
	 * <p>
	 * 也可能是序列号
	 **/
	public String getMusicHash() {
		return MusicHash;
	}

	/**
	 * <p>
	 * 设置歌曲名称
	 **/
	public void setMusicName(String musicName) {
		MusicName = musicName;
	}

	/**
	 * <p>
	 * 设置歌曲的唯一特征
	 **/
	public void setMusicHash(String musicHash) {
		MusicHash = musicHash;
	}

	/**
	 * <p>
	 * 获取歌手的名称
	 **/
	public String getSingerName() {
		return SingerName;
	}

	/**
	 * <p>
	 * 设置歌手的名称
	 **/
	public void setSingerName(String singerName) {
		SingerName = singerName;
	}

	/**
	 * <p>
	 * 获取歌曲的出处
	 **/
	public String getAuxiliary() {
		return Auxiliary;
	}

	/**
	 * <p>
	 * 设置歌曲的出处
	 **/
	public void setAuxiliary(String auxiliary) {
		Auxiliary = auxiliary;
	}

	/**
	 * <p>
	 * 获取歌曲专辑的名称
	 **/
	public String getAlbumName() {
		return AlbumName;
	}

	/**
	 * <p>
	 * 设置歌曲专辑的名称
	 **/
	public void setAlbumName(String albumName) {
		AlbumName = albumName;
	}

	/**
	 * <p>
	 * 获取歌曲的名称
	 **/
	public String getFileName() {
		return FileName;
	}

	/**
	 * <p>
	 * 设置歌曲的名称
	 **/
	public void setFileName(String fileName) {
		FileName = fileName;
	}

	/**
	 * <p>
	 * 获取歌曲或者歌手的写真
	 **/
	public String getMusicImg() {
		return MusicImg;
	}

	/**
	 * <p>
	 * 设置歌曲或者歌手的写真
	 **/
	public void setMusicImg(String musicImg) {
		MusicImg = musicImg;
	}
}
