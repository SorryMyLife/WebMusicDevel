package com.WebMusic.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * <p>
 * 创建时间：2019年1月22日 下午6:12:35
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明： 虾米音乐专用工具集
 * <p>
 * 注释时间: 2019年1月22日
 * 
 * @version 1.0
 * @since JDK 1.8 文件名称：XiaMiTool.java
 */
public class XiaMiTool extends WebMusicTools {
	/**
	 * <p>
	 * loaction值转码
	 * <p>
	 * 需要传入一个参数：loaction值
	 * <p>
	 * 否则会出错
	 */
	public String UnLockLoactionToString(String str)// 这个是将loaction值转码的
	{
		int _local10;
		String _local9 = "";
		if (str.length() > 10) {
			int _local2 = Integer.parseInt(str.substring(0, 1));
			String _local3 = str.substring(1, str.length());
			double _local4 = Math.floor(_local3.length() / _local2);
			int _local5 = _local3.length() % _local2;
			String[] _local6 = new String[_local2];
			int _local7 = 0;
			while (_local7 < _local5) {
				if (_local6[_local7] == null) {
					_local6[_local7] = "";
				}
				_local6[_local7] = _local3.substring((((int) _local4 + 1) * _local7),
						(((int) _local4 + 1) * _local7) + ((int) _local4 + 1));
				_local7++;
			}
			_local7 = _local5;
			while (_local7 < _local2) {
				_local6[_local7] = _local3.substring(
						(((int) _local4 * (_local7 - _local5)) + (((int) _local4 + 1) * _local5)),
						(((int) _local4 * (_local7 - _local5)) + (((int) _local4 + 1) * _local5)) + (int) _local4);
				_local7++;
			}
			String _local8 = "";
			_local7 = 0;
			while (_local7 < ((String) _local6[0]).length()) {
				_local10 = 0;
				while (_local10 < _local6.length) {
					if (_local7 >= _local6[_local10].length()) {
						break;
					}
					_local8 = (_local8 + _local6[_local10].charAt(_local7));
					_local10++;
				}
				_local7++;
			}
			try {
				_local8 = URLDecoder.decode(_local8, "utf8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_local7 = 0;
			while (_local7 < _local8.length()) {
				if (_local8.charAt(_local7) == '^') {
					_local9 = (_local9 + "0");
				} else {
					_local9 = (_local9 + _local8.charAt(_local7));
				}
				;
				_local7++;
			}
			_local9 = _local9.replace("+", " ");
			// System.out.println(_local9);
		} else {
			_local9 = "not found download link !";
		}
		return _local9;
	}

	/**
	 * <p>
	 * 获取loaction值
	 * <p>
	 * 需要传入一个参数：歌曲id
	 * <p>
	 * 不传入的话，会出现奇妙的问题
	 */
	public String getLoaction(String song_id) {
		return getByString(getGzipPagesource(LinkList.XiaMiMusicLoactionInfoLink + song_id), "CDATA\\[\\S+</lo",
				"CDATA\\[|]]></lo");
	}

	/**
	 * <p>
	 * 获取歌曲信息
	 * <p>
	 * 需要传入一个参数，歌曲id
	 */
	public WebMusicInfo getSongInfo(String song_id) {
		String str = checkAndroid(LinkList.XiaMiMusicSongInfoLink + song_id);
		WebMusicInfo musicInfo = new WebMusicInfo();
		musicInfo.setMusicHash(song_id);
		musicInfo.setSingerName(
				getByString(str, "singers(.+?</a></div>)", "singers\"><a href=\"/artist/\\d+\">|</a></div>"));
		musicInfo.setMusicName(getByString(str, "song-name(.+?</div>)", "song-name\">|</div>"));
		musicInfo.setAuxiliary(getByString(str, "song-subname(.+?</div>)", "song-subname\">|</div>"));
		musicInfo.setAlbumName(getByString(str, "/album/\\d+(.+?</a></div>)", "/album/\\d+\">|</a></div>"));
		musicInfo.setMusicImg("//" + getByString(str, "pic.xiami.net/images(.+?\")", "\""));
		musicInfo.setVideoId(getByString(str, "/mv(.+?\")", "mv|/|\""));
		String fileName = musicInfo.getSingerName() + "-" + musicInfo.getMusicName();
		musicInfo.setFileName(fileName.replaceAll("\\s+", ""));
		musicInfo.setDownloadLink(UnLockLoactionToString(getLoaction(musicInfo.getMusicHash())));
		return musicInfo;
	}

}
