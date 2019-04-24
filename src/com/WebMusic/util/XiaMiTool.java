package com.WebMusic.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * <p>
 * ����ʱ�䣺2019��1��22�� ����6:12:35
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵���� Ϻ������ר�ù��߼�
 * <p>
 * ע��ʱ��: 2019��1��22��
 * 
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�XiaMiTool.java
 */
public class XiaMiTool extends WebMusicTools {
	/**
	 * <p>
	 * loactionֵת��
	 * <p>
	 * ��Ҫ����һ��������loactionֵ
	 * <p>
	 * ��������
	 */
	public String UnLockLoactionToString(String str)// ����ǽ�loactionֵת���
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
	 * ��ȡloactionֵ
	 * <p>
	 * ��Ҫ����һ������������id
	 * <p>
	 * ������Ļ�����������������
	 */
	public String getLoaction(String song_id) {
		return getByString(getGzipPagesource(LinkList.XiaMiMusicLoactionInfoLink + song_id), "CDATA\\[\\S+</lo",
				"CDATA\\[|]]></lo");
	}

	/**
	 * <p>
	 * ��ȡ������Ϣ
	 * <p>
	 * ��Ҫ����һ������������id
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
