package com.WebMusic.util;

/**
 * <p>
 * 主要用于存储相关音乐api
 * <p>
 * 注解日期: 2019年1月17日
 * <p>
 * JDK版本 JDK1.8
 * 
 */

public class LinkList {

	public final static String KuGouSearchSongLink = "https://songsearch.kugou.com/song_search_v2?keyword=";
	public final static String KuGouSearchSongLinkEnd = "&platform=WebFilter";
	public final static String KuGouSearchSongLinkPage = "&page=";
	public final static String KuGouSearchSongHashLink = "https://wwwapi.kugou.com/yy/index.php?r=play/getdata&hash=";
	public final static String KuGouSearchSongHashJsonLink = "http://www.kugou.com/yy/index.php?r=play/getdata&hash=";
	
	public final static String CloudMusicSongSearchLink = "http://music.163.com/api/search/get/web?csrf_token=hlpretag=&hlposttag=&s=";
	public final static String CloudMusicSongSearchLinkEnd = "&type=1&offset=0&total=true";
	public final static String CloudMusicSongSearchNum = "&limit=";
	public final static String CloudMusicDownloadSongLink = "http://music.163.com/song/media/outer/url?id=";
	public final static String CloudMusicSongInfoLink = "https://music.163.com/song?id=";
	public final static String XiaMiMusicLoactionInfoLink = "https://www.xiami.com/widget/xml-single/uid/0/sid/";
	public final static String XiaMiMusicSongInfoLink = "https://www.xiami.com/song/";
	public final static String XiaMiMusicSongSearchKeyLinkOld = "?key=";
	public final static String XiaMiMusicSongSearchNextPageLinkOld = "page/";
	public final static String XiaMiMusicSongSearchLinkHeadOld = "https://www.xiami.com/search/song/";
	public final static String XiaMiMusicSongSearchLinkOld = XiaMiMusicSongSearchLinkHeadOld
			+ XiaMiMusicSongSearchNextPageLinkOld + "1" + XiaMiMusicSongSearchKeyLinkOld;
	public final static String QQMusicSearchSongLink = "https://c.y.qq.com/soso/fcgi-bin/client_search_cp?&new_json=1&aggr=1&cr=1&n=40&w=";
	public final static String QQMusicSearchSongLinkPage = "&p=";
	public final static String QQMusicSongInfoLink = "https://y.qq.com/n/yqq/song/";
	public final static String QQMusicListLink = "https://c.y.qq.com/qzone/fcg-bin/fcg_ucc_getcdinfo_byids_cp.fcg";
	public final static String QQMusicSongDownloadHead = "http://dl.stream.qqmusic.qq.com/";
	public final static String QQMusicSongDownloadPage = "https://u.y.qq.com/cgi-bin/musicu.fcg?&data={\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"45888997\",\"songmid\":[\"";
	public final static String QQMusicSongDownloadPageEnd = "\"],\"songtype\":[0],\"uin\":\"26548214\",\"loginflag\":1,\"platform\":\"20\"}},\"comm\":{\"uin\":26548214,\"format\":\"json\",\"ct\":24,\"cv\":0}}";
	public final static String KuWoMusicDownloadLink = "http://antiserver.kuwo.cn/anti.s?format=mp3&rid=MUSIC_";
	public final static String KuWoMusicDownloadLinkEnd = "&type=convert_url&response=res";
	public final static String KuWoMusicSongSearchLink = "http://sou.kuwo.cn/ws/NSearch?key=";
	public final static String KuWoMusicSongSearchLinkPage = "&pn=";
	public final static String KuWoMusicSongSearchLinkEnd = "&type=music";
	public final static String KuWoMusicSongInfoLink = "http://www.kuwo.cn/yinyue/";
	public final static String KuWoMusicSongJsonInfoLink = "http://m.kuwo.cn/newh5/singles/songinfoandlrc?musicId=";
	

	public final static String NewWebMusicHost = "http://www.musictool.top/";
	
	public final static String QQMusicProDownloadHead3 = "http://mobileoc.music.tc.qq.com/";
	public final static String QQMusicProDownloadHead2 = "http://isure.stream.qqmusic.qq.com/";
	public final static String QQMusicProDownloadHead = "http://dl.stream.qqmusic.qq.com/";
	
	
	public final static String QQMusicProLink = "https://c.y.qq.com/base/fcgi-bin/fcg_music_express_mobile3.fcg?cid=205361747&guid=0&songmid=";
	public final static String QQMusicProLinkFileName = "&filename=";
	
	public final static String MusicProAPILink = "api.php";
	public final static String MusicProSearchTypeLink = MusicProAPILink+"?search=";
	public final static String MusicProGetSongLink = MusicProAPILink+"?get_song=";
	public final static String MusicProSearchLink = "&w=";
	public final static String MusicProPageLink = "&p=";
	public final static String MusicProMusicNumLink = "&n=";
	public final static String MusicProLink = "http://moresound.tk/music/";
	
}
