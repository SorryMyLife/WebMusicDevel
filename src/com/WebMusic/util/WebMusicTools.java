package com.WebMusic.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import com.WebMusicPro.util.MusicFormat;
import com.WebMusicPro.util.OtherMusicProUtils;
import com.WebMusicPro.util.QQMusicProUtils;
import com.WebMusicPro.util.WebMusicProInfo;

/**
* <p>创建时间：2019年4月17日 下午6:29:54
* <p>项目名称：WebMusic
* 
* <p>类说明：
* 总工具实现功能类
* @version 1.0
* @since JDK 1.8
* 文件名称：WebMusicTools.java
* */
public class WebMusicTools {
	
	public String math=":\"(.+?\")";
	public final static String cookie_bak = "",
			ua_bak = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36",
			match_s = "\"(.+?\")", kg_re_str = ":|,|\"", kg_match_str = "\":" + match_s,
			enc_Sec_Key = "8a0d839b115fc4b9a8a78a585139b6605a4ef155e06bd367972d0f0d383c2da69bc4d94a0bcd5b74418912764589c0e66e5dd2b32e625d2715e3b26d8c20df151c353fda16cfefa652d9ff5d043ac783cff8caa1b9aa9be19f47f62c80019fb74a033e299a09ea36da8529490038a9ee1b59ef35c6cbc1acfc77800646b44882";
	public int len = -1, size = -1, num = 0;
	public List<WebMusicInfo> list = null;
	public String array[] = null;
	
	private String cookie = "" , userAgent = "";
	private final static int time = 3500;
	private String header,headers[];
	private String headers_bak[] = {
			"accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
			"accept-encoding: gzip, deflate, br",
			"Content-Type: text/plain",
			"Cache-Control: max-age=0",
			"Connection: keep-alive",
			"accept-language: zh-CN,zh;q=0.9"
	};
	
	public String doghs[] = {
			"accept: text/html,application/xhtml,xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9" , 
			"accept-encoding: gzip, deflate, br" , 
			"accept-language: zh-CN,zh;q=0.9" , 
			"cache-control: max-age=0" , 
			"cookie: kg_mid=6620da3132838588a74411987e879df3; kg_dfid=3dpiLo2jOchb0KlwMq05UWYD; ACK_SERVER_10016=%7B%22list%22%3A%5B%5B%22bjreg-user.kugou.com%22%5D%5D%7D; ACK_SERVER_10015=%7B%22list%22%3A%5B%5B%22bjlogin-user.kugou.com%22%5D%5D%7D; ACK_SERVER_10017=%7B%22list%22%3A%5B%5B%22bjverifycode.service.kugou.com%22%5D%5D%7D; Hm_lvt_aedee6983d4cfc62f509129360d6bb3d=1582356962; Hm_lpvt_aedee6983d4cfc62f509129360d6bb3d=1582356962; kg_dfid_collect=d41d8cd98f00b204e9800998ecf8427e" , 
			"user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36" , 
			"Host: www.kugou.com" 
	};
	
	
	private boolean isAndroid = false;
	
	public String getHeader() {
		return header;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}
	
	public void addMusic(List<WebMusicInfo> l , WebMusicInfo musicInfo) {
		if(musicInfo.getMusicName() != null && !musicInfo.getMusicName().equals("") && musicInfo.getMusicName().length() >0 && musicInfo.getAllToCloud().indexOf("</") == -1) {
			l.add(musicInfo);
		}
	}
	
	/**
	 * <p>
	 * 获取response的头部
	 * */
	@SuppressWarnings("unused")
	public String getResponseHeader(String url_name , String key) {
		String getKey = "";
		try {
			HttpURLConnection hc = checkCon(url_name);
			getKey = hc.getHeaderField(key);
			if(getKey.equals(""))
				getKey = "not get !";
			else if(getKey == null)
				getKey = "not get !";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getKey;
	}
	
	/**
	 * <p>
	 * 获取response的头部
	 * */
	public String getResponseHeaders(String url_name) {
		String getKey = "";
		try {
			HttpURLConnection hc = checkCon(url_name);
			Map<String,List<String>> m = hc.getHeaderFields();
			for(Entry<String, List<String>> e : m.entrySet()) {
				getKey += e.getKey() + " -- " + e.getValue() + "\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getKey;
	}
	
	/**
	 * <p>
	 * 读取本地文件
	 * <p>
	 * 需要传入一个参数：文件路径
	 */
	public String read(String filePath) {
		String str = "", line = "";
		File file = new File(filePath);
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while ((line = br.readLine()) != null) {
					str += line + "\n";
				}
				br.close();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} else {
			System.err.println("没有这个文件 : " + filePath);
		}
		return str;
	}
	
	
	/**
	 * <p>
	 * 链接-文件名称-保存路径-文件后缀
	 * */
	public void MultiThreadDownlaodMusic(String link , String fileName , String savePath , String format)
	{
		new Thread() {@Override
			public void run() {
				Downlaod(link, savePath, fileName, format);
			}}.start();
	}
	
	public void sleep(int times)
	{
		try {
			new Thread();
			Thread.sleep(times);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	/**配置是否为Android开发环境*/
	public String checkAndroid(String url , String headers[]) {
		url=url.replaceAll("\\s+", "");
		String data = isAndroid() ? getPagesource(url) : getGzipPagesource(url,headers);
		return data.replaceAll("\\s+", "");
	}
	
	/**配置是否为Android开发环境*/
	public String checkAndroid(String url) {
		return checkAndroid(url, null);
	}
	
	public String checkOhterFormat(String format , String song_id , String Mtype)
	{
		WebMusicProInfo w = new OtherMusicProUtils().Info(song_id, Mtype);
		String f = "" , r = "" , type = "";
		if(format.equals("ape"))
		{
			f = MusicFormat.ApeEnd;
			type = w.getAPE();
		}else if(format.equals("flac"))
		{
			f = MusicFormat.FlacEnd;
			type = w.getFLAC();
		}else if(format.equals("m320k"))
		{
			f = MusicFormat.QQ320kEnd;
			type = w.getM320k();
		}else if(format.equals("m128k"))
		{
			f = MusicFormat.QQ128kEnd;
			type = w.getM128k();
		}else
		{
			f = MusicFormat.m4aEnd;
			type = w.getM4a();
		}
		r = f+"--"+type+"--"+w.getFileName();
		return r;
	}
	
	public String checkFormat(String format , String song_id)
	{
		WebMusicProInfo w = new QQMusicProUtils().getSongInfo(song_id, "", "");
		String f = "" , r = "" , type = "";
		if(format.equals("ape"))
		{
			f = MusicFormat.ApeEnd;
			type = w.getAPE();
		}else if(format.equals("flac"))
		{
			f = MusicFormat.FlacEnd;
			type = w.getFLAC();
		}else if(format.equals("m320k"))
		{
			f = MusicFormat.QQ320kEnd;
			type = w.getM320k();
		}else if(format.equals("m128k"))
		{
			f = MusicFormat.QQ128kEnd;
			type = w.getM128k();
		}else
		{
			f = MusicFormat.m4aEnd;
			type = w.getM4a();
		}
		r = f+"--"+type+"--"+w.getFileName();
		return r;
	}
	
	/**
	 * <p>
	 * 链接-保存路径-保存名字-文件后缀
	 * */
	public void Downlaod(String url_name , String dirPath , String fileName , String format)
	{
		if(url_name.equals(""))
		{
			System.err.println("skip : "+fileName);
		}else if(url_name.length() < 10)
		{
			System.err.println("skip : "+fileName);
		}else
		{
			File d = new File(dirPath);
			if(!d.exists())
			{
				d.mkdirs();
				Downlaod(url_name, dirPath, fileName, format);
			}else
			{
				File f = new File(dirPath+"/"+fileName+format);
				if(f.exists())
				{
					System.err.println("file is exists : skip ------ " +f);
				}else
				{
					try {
						InputStream in = checkCon(url_name).getInputStream();
						FileOutputStream fos = new FileOutputStream(f);
						int len = -1;
						byte buff[] = new byte[1024];
						System.err.println("start download : "+url_name);
						while((len = in.read(buff)) != -1)
						{
							fos.write(buff, 0, len);
						}
						fos.close();
						in.close();
						System.err.println("downlaod ok ! ---> " + f);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public String getMusicListPageOnQQ(String link) {
		String page = "" , line = "";
		HttpURLConnection c = null;
		try {
			c = (HttpURLConnection) new URL(LinkList.QQMusicListLink).openConnection();
			c.setRequestMethod("POST");
			c.setRequestProperty("accept", "application/json, text/javascript, */*; q=0.01");
			c.setRequestProperty("accept-encoding", "gzip, deflate, br");
			c.setRequestProperty("origin", "https://y.qq.com");
			c.setRequestProperty("referer", link);
			c.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
			c.setDoOutput(true);
			c.setDoInput(true);
			OutputStreamWriter w = new OutputStreamWriter(c.getOutputStream());
			w.write("type=1&json=1&utf8=1&disstid="
					+ link.substring(link.lastIndexOf("/") + 1).replaceAll(".ht(m|ml)", ""));
			w.flush();
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new GZIPInputStream(c.getInputStream()), "utf-8"));
			while ((line = br.readLine()) != null) {
				page += line + "\n";
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
	public String getPagesourceOnPost(String url_name , String parm) {
		String line = "" , str = "";
		try {
			HttpURLConnection huc = (HttpURLConnection) new URL(url_name).openConnection();
			huc.setRequestMethod("POST");
			huc.setConnectTimeout(time);
			if(getHeader()!=null) {
				String s[] = getHeader().split(":");
				huc.setRequestProperty(s[0], s[1].replaceAll("\\s+", ""));
			}
			if(getHeaders()!=null) {
				for(String ss : getHeaders()) {
					String s[] = ss.split(":");
					huc.setRequestProperty(s[0], s[1].replaceAll("\\s+", ""));
				}
			}
			if (!getUserAgent().equals("")) {
				huc.setRequestProperty("user-agent", getUserAgent());
			} else {
				huc.setRequestProperty("user-agent", ua_bak);
				setUserAgent(ua_bak);
			}
			if (!getCookie().equals("")) {
				huc.setRequestProperty("cookie", getCookie());
			}
			huc.setDoOutput(true);
			huc.setDoInput(true);
			OutputStreamWriter osw = new OutputStreamWriter(huc.getOutputStream());
			osw.write(parm);
			osw.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(), "utf-8"));
			while((line = br.readLine()) != null) {
				str += line + "\n";
			}
			br.close();
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public String getGzipPagesourceOnPost(String url_name , String parm) {
		String line = "" , str = "";
		try {
			HttpURLConnection huc = (HttpURLConnection) new URL(url_name).openConnection();
			huc.setRequestMethod("POST");
			huc.setConnectTimeout(time);
			if(getHeader()!=null) {
				String s[] = getHeader().split(":");
				huc.setRequestProperty(s[0], s[1].replaceAll("\\s+", ""));
			}
			if(getHeaders()!=null) {
				for(String ss : getHeaders()) {
					String s[] = ss.split(":");
					huc.setRequestProperty(s[0], s[1].replaceAll("\\s+", ""));
				}
			}
			if (!getUserAgent().equals("")) {
				huc.setRequestProperty("user-agent", getUserAgent());
			} else {
				huc.setRequestProperty("user-agent", ua_bak);
				setUserAgent(ua_bak);
			}
			if (!getCookie().equals("")) {
				huc.setRequestProperty("cookie", getCookie());
			}
			huc.setDoOutput(true);
			huc.setDoInput(true);
			OutputStreamWriter osw = new OutputStreamWriter(huc.getOutputStream());
			osw.write(parm);
			osw.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(huc.getInputStream()), "utf-8"));
			while((line = br.readLine()) != null) {
				str += line + "\n";
			}
			br.close();
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public HttpURLConnection checkCon(String url_name) throws Exception {
//		String ua_bak = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36";
		HttpURLConnection huc = (HttpURLConnection) new URL(url_name).openConnection();
		huc.setRequestMethod("GET");
		if (getHeader() != null) {
			huc.setRequestProperty(getHeader().split(":")[0], getHeader().split(":")[1].replaceAll("\\s+", ""));
		} else if (getHeaders() != null) {
			for (String s : getHeaders()) {
				String arr[] = s.split(":");
				huc.setRequestProperty(arr[0], arr[1].replaceAll("\\s+", ""));
			}
		}
		return huc;
	}
	
	/**
	 * <p>
	 * 获取普通网页,html格式
	 */

	public String getPagesource(String url_name) {
		String str = "" , line = "";
		try {
			if(getHeaders() == null) {
				setHeaders(headers_bak);
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(checkCon(url_name).getInputStream(), "utf-8"));
			while ((line = br.readLine()) != null) {
				str += line + "\n";
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * <p>
	 * 获取gzip传输格式的网页内容
	 */

	public String getGzipPagesource(String url_name , String hs[]) {
		String str = "" , line = "";
		try {
			setHeaders(hs);
			if(getHeaders() == null) {
				setHeaders(headers_bak);
			}
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new GZIPInputStream(checkCon(url_name).getInputStream()), "utf-8"));
			while ((line = br.readLine()) != null) {
				str += line + "\n";
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	/**
	 * <p>
	 * 获取gzip传输格式的网页内容
	 */

	public String getGzipPagesource(String url_name) {
		return getGzipPagesource(url_name, null);
	}

	/**
	 * <p>
	 * 用于将中文字符串转义为URL可以认识的
	 */
	public String URLEncode(String src) {
		String tmp = "";
		try {
			tmp = URLEncoder.encode(src, "utf-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return tmp;
	}
	
	/**
	 * <p>
	 * 将字符串转义为Unicode编码
	 * <p>
	 * 转义前可以看
	 * <p>
	 * 转义后不是人看的
	 */
	public String StringToUnicode(String string) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			// 取出每一个字符
			char c = string.charAt(i);
			// 转换为unicode
			unicode.append("\\u" + Integer.toHexString(c));
		}
		return unicode.toString();
	}

	/**
	 * <p>
	 * 字符串编码的转换,主要是懒得总try-catch,干脆封装成函数一键操作
	 */
	public String StringToEncode(String src, String encode) {
		String str = "";
		try {
			src = new String(src.getBytes(), encode);
			str = src;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;

	}

	/**
	 * <p>
	 * 将Unicode编码转义为字符串
	 * <p>
	 * 转义前不是人看
	 * <p>
	 * 转义后的可以看
	 */
	public String UnicodeToString(String unicode) // Unicode转String用的，因为这个酷狗音乐非常鸡肋，歌名、歌手、简介居然用的都是Unicode编码，不得不转一下，不然没法用
	{
		Matcher m = Pattern.compile("(\\\\u(\\p{XDigit}{4}))").matcher(unicode);
		String tmp = "" , str = "";
		char ch;
		while (m.find()) {
			tmp = m.group(2);
			ch = (char) Integer.parseInt(tmp, 16);
			str = m.group(1);
			unicode = unicode.replace(str, ch + "");
		}

		return unicode;
	}
	
	public String getByJson(String src , String name)
	{
		return getByString(src, "\""+name+"\":(.+?\")", name+"\":|\"");
	}
	
	public String getByString(String src, String reg, String re_str) {
		String t = "";
		Matcher m = Pattern.compile(reg).matcher(src);
		if (m.find()) {
			t = m.group().replaceAll(re_str, "");
		}
		return t;
	}
	
	public String getCookie() {
		return cookie;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * <p>
	 * 直接输出带有歌曲信息的链表高级版
	 */

	public void printListOnPro(List<WebMusicProInfo> l) {
		System.out.println(printListStringOnPro(l));
	}

	/**
	 * <p>
	 * 返回一个字符串类型的歌曲信息高级版
	 */
	public String printListStringOnPro(List<WebMusicProInfo> l) {
		String str = "";
		int n = 0;
		for (WebMusicProInfo w : l) {
			str += w.getQQProAll() + "\n";
			n++;
		}
		System.err.println("一共遍历出: "+n+" 个数据");
		return str;
	}

	/**
	 * <p>
	 * 返回一个字符串数组类型的歌曲信息高级版
	 */
	public String[] printListStringArrayOnPro(List<WebMusicProInfo> l) {
		return printListStringOnPro(l).split("\n");
	}

	/**
	 * <p>
	 * 返回一个WebMusicInfo数组类型的歌曲信息高级版
	 * 
	 * @param 传入一个带有WebMusicInfo的List
	 * @return WebMusicInfo
	 */
	public WebMusicProInfo[] printListInfoOnPro(List<WebMusicProInfo> l) {
		int num = 0,size = l.size();
		int n = 0;
		WebMusicProInfo musicInfoArray[] = new WebMusicProInfo[size];
		for (WebMusicProInfo w : l) {
			musicInfoArray[num] = w;
			num++;
			n++;
		}
		System.err.println("一共遍历出: "+n+" 个数据");
		return musicInfoArray;
	}
	
	/**
	 * <p>
	 * 直接输出带有歌曲信息的链表
	 */

	public void printList(List<WebMusicInfo> l) {
		System.out.println(printListString(l));
	}

	/**
	 * <p>
	 * 返回一个字符串类型的歌曲信息
	 */
	public String printListString(List<WebMusicInfo> l) {
		String str = "";
		int n = 0;
		for (WebMusicInfo w : l) {
			str += w.getAllToCloud() + "\n";
			n++;
		}
		System.err.println("一共遍历出: "+n+" 个数据\n");
		return str;
	}

	/**
	 * <p>
	 * 返回一个字符串数组类型的歌曲信息
	 */
	public String[] printListStringArray(List<WebMusicInfo> l) {
		return printListString(l).split("\n");
	}

	/**
	 * <p>
	 * 返回一个WebMusicInfo数组类型的歌曲信息
	 * 
	 * @param 传入一个带有WebMusicInfo的List
	 * @return WebMusicInfo
	 */
	public WebMusicInfo[] printListInfo(List<WebMusicInfo> l) {
		num = 0;
		size = l.size();
		int n = 0;
		WebMusicInfo musicInfoArray[] = new WebMusicInfo[size];
		for (WebMusicInfo w : l) {
			musicInfoArray[num] = w;
			num++;
			n++;
		}
		System.err.println("一共遍历出: "+n+" 个数据\n");
		return musicInfoArray;
	}
	
	/**用来判断是否为Android开发环境*/
	public boolean isAndroid() {
		return isAndroid;
	}

	public void setAndroid(boolean isAndroid) {
		this.isAndroid = isAndroid;
	}
	
}
