package com.WebMusic.Program;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.WebMusic.WebMusic;
import com.WebMusic.util.WebMusicInfo;
import com.WebMusic.util.WebMusicTools;
import com.WebMusicPro.WebMusicPro;
import com.WebMusicPro.util.WebMusicProInfo;

/**
 * <p>
 * 创建时间：2019年2月3日 下午1:10:14
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明：
 *
 * @version 1.0
 * @since JDK 1.8 文件名称：Programs.java
 */
public class Programs {

	private WebMusicTools t = new WebMusicTools();
	private String ConfigureFile = "conf.ini";
	private String SavePathFile = "save";
	private String DefaultMusic = "music";
	private Scanner s = null; // 读取键盘输入

	public void selectDownlaodList(WebMusic wm) {
		int number = 1;
		HashMap<Integer, WebMusicInfo> map = new HashMap<>();
		for (WebMusicInfo w : wm.getMusicListToWebMusicInfo(getMusicList())) {
			map.put(number, w);
			number++;
		}
		opt(map);
	}

	public void ProselectDownlaodList(WebMusicPro wm) {
		int number = 1;
		HashMap<Integer, WebMusicProInfo> map = new HashMap<>();
		for (WebMusicProInfo w : wm.getMusicListToWebMusicProInfo(getMusicList())) {
			map.put(number, w);
			number++;
		}
		Proopt(map);
	}

	public void selectDownlaod(String search_name, int maxpage, WebMusic wm) {
		int number = 1;
		HashMap<Integer, WebMusicInfo> map = new HashMap<>();
		for (WebMusicInfo w : wm.getInfoToWebMusicInfo(search_name, maxpage)) {
			map.put(number, w);
			number++;
		}
		opt(map);
	}

	public void ProselectDownlaod(String search_name, int maxpage, WebMusicPro wm) {
		int number = 1;
		HashMap<Integer, WebMusicProInfo> map = new HashMap<>();
		for (WebMusicProInfo w : wm.getInfoToWebMusicProInfo(search_name, maxpage)) {
			map.put(number, w);
			number++;
		}
		Proopt(map);
	}

	public void checkExit(WebMusic w) {
		System.out.print("我觉得你需要考虑一下是否退出(y|n): ");
		s = new Scanner(System.in);
		String yn = s.nextLine();
		switch (yn) {
		case "y":
		case "Y":
			System.exit(-1);
			break;
		case "n":
		case "N":
			menu(w);
			break;
		default:
			checkExit(w);
			break;
		}
	}

	public void ProcheckExit(WebMusicPro w) {
		System.out.print("我觉得你需要考虑一下是否退出(y|n): ");
		s = new Scanner(System.in);
		String yn = s.nextLine();
		switch (yn) {
		case "y":
		case "Y":
			System.exit(-1);
			break;
		case "n":
		case "N":
			Promenu(w);
			break;
		default:
			ProcheckExit(w);
			break;
		}
	}

	public void Promenu(WebMusicPro w) {
		System.out.println("当前保存路径: " + getSavePath());
		System.out.print("1.搜索歌曲\n2.选择歌曲下载\n3.一键下载搜索到的歌曲\n4.选择下载歌单内的歌曲\n5.一键下载歌单内的歌曲\n88.退出\n请选择: ");
		s = new Scanner(System.in);
		String select = s.nextLine();
		if (select.equals("1")) {
			w.getInfo(getSearchName(), getPageNum());
		} else if (select.equals("2")) {
			ProselectDownlaod(getSearchName(), getPageNum(), w);
		} else if (select.equals("3")) {
			s = new Scanner(System.in);
			System.out.print("\n请选择音质 \n1.无损音质(可能获取不到)\n2.高品音质(可能获取不到)\n3.一般音质\n4.普通音质\n5.压缩音质\n: ");
			String fromat = s.nextLine();
			switch (fromat) {
			case "1":
				w.DownloadApe(getSearchName(), getPageNum());
				break;
			case "2":
				w.DownloadFlac(getSearchName(), getPageNum());
				break;
			case "3":
				w.Download320k(getSearchName(), getPageNum());
				break;
			case "4":
				w.Download128k(getSearchName(), getPageNum());
				break;
			case "5":
				w.DownloadM4a(getSearchName(), getPageNum());
				break;
			default:
				w.Download128k(getSearchName(), getPageNum());
				break;
			}
		} else if (select.equals("4")) {
			ProselectDownlaodList(w);

		} else if (select.equals("5")) {
			s = new Scanner(System.in);
			System.out.print("\n请选择音质 \n1.无损音质(可能获取不到)\n2.高品音质(可能获取不到)\n3.一般音质\n4.普通音质\n5.压缩音质\n: ");
			String fromat = s.nextLine();
			switch (fromat) {
			case "1":
				w.DownloadApeList(getMusicList(), getSavePath());
				break;
			case "2":
				w.DownloadFlacList(getMusicList(), getSavePath());
				break;
			case "3":
				w.Download320kList(getMusicList(), getSavePath());
				break;
			case "4":
				w.Download128kList(getMusicList(), getSavePath());
				break;
			case "5":
				w.DownloadM4aList(getMusicList(), getSavePath());
				break;
			default:
				w.Download128kList(getMusicList(), getSavePath());
				break;
			}
		} else if (select.equals("88")) {
			System.exit(-1);
		} else {
			System.err.println("请选择一个正确的选项!");
			Promenu(w);
		}
		ProcheckExit(w);
	}

	public void menu(WebMusic w) {
		System.out.println("当前保存路径: " + getSavePath());
		System.out.print("1.搜索歌曲\n2.选择歌曲下载\n3.一键下载搜索到的歌曲\n4.选择下载歌单内的歌曲\n5.一键下载歌单内的歌曲\n88.退出\n请选择: ");
		s = new Scanner(System.in);
		String select = s.nextLine();
		if (select.equals("1")) {
			w.getInfo(getSearchName(), getPageNum());
		} else if (select.equals("2")) {
			selectDownlaod(getSearchName(), getPageNum(), w);

		} else if (select.equals("3")) {
			w.DownloadAll(getSearchName(), getSavePath(), getPageNum());

		} else if (select.equals("4")) {
			selectDownlaodList(w);

		} else if (select.equals("5")) {
			w.DownloadList(getMusicList(), getSavePath());

		} else if (select.equals("88")) {
			System.exit(-1);
		} else {
			System.err.println("请选择一个正确的选项!");
			menu(w);
		}
		checkExit(w);
	}

	public void mulitDown(int n, Map<Integer, WebMusicInfo> map) {
		new Thread() {
			public void run() {
				for (Entry<Integer, WebMusicInfo> e : map.entrySet()) {
					if (e.getKey() == n) {
						new WebMusicTools().Downlaod(e.getValue().getDownloadLink(), getSavePath(), e.getValue().getFileName(), ".mp3"); 
					}
				}
			};
		}.start();
	}

	public void PromulitDown(int n, Map<Integer, WebMusicProInfo> map, String fromat) {
		try {
			new Thread() {
				public void run() {
					for (Entry<Integer, WebMusicProInfo> e : map.entrySet()) {
						if (e.getKey() == n) {
							String link = "", f = "";
							switch (fromat) {
							case "ape":
								link = e.getValue().getAPE();
								f = ".ape";
								break;
							case "flac":
								link = e.getValue().getFLAC();
								f = ".flac";
								break;
							case "m320":
								link = e.getValue().getM320k();
								f = ".mp3";
								break;
							case "m128":
								link = e.getValue().getM128k();
								f = ".mp3";
								break;
							case "m4a":
								link = e.getValue().getM4a();
								f = ".m4a";
								break;
							default:
								link = e.getValue().getDownloadLink();
								f = ".mp3";
								break;
							}
							new WebMusicTools().Downlaod(link, getSavePath(), e.getValue().getFileName(),
									f);
						}
					}
				};
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void download(String arr[], Map<Integer, WebMusicInfo> map) {
		for (String num : arr) {
			int n = Integer.parseInt(num);
			mulitDown(n, map);
		}
	}

	public void Prodownload(String arr[], Map<Integer, WebMusicProInfo> map, String fromat) {
		for (String num : arr) {
			int n = Integer.parseInt(num);
			PromulitDown(n, map, fromat);
		}
	}

	public String getFromat() {
		String str = "";
		s = new Scanner(System.in);
		System.out.print("\n请选择音质 \n1.无损音质(可能获取不到)\n2.高品音质(可能获取不到)\n3.一般音质\n4.普通音质\n5.压缩音质\n: ");
		String fromat = s.nextLine();
		switch (fromat) {
		case "1":
			str = "ape";
			break;
		case "2":
			str = "flac";
			break;
		case "3":
			str = "m320";
			break;
		case "4":
			str = "m128";
			break;
		case "5":
			str = "m4a";
			break;
		default:
			str = "m320";
			break;
		}
		return str;
	}

	public void Proopt(Map<Integer, WebMusicProInfo> map) {
		int count = 0;
		s = new Scanner(System.in);
		for (Entry<Integer, WebMusicProInfo> e : map.entrySet()) {
			if (count == 5) {
				System.out.println();
				count = 0;
			}
			System.out.print(e.getKey() + " --- " + e.getValue().getFileName() + "\t");
			count++;
		}
		String fromat = getFromat();
		System.out.print("\n请选择序号(数字[0-9]) : ");
		String l = s.nextLine();
		Prodownload(l.split(" "), map, fromat);
	}

	public void opt(Map<Integer, WebMusicInfo> map) {
		int count = 0;
		s = new Scanner(System.in);
		for (Entry<Integer, WebMusicInfo> e : map.entrySet()) {
			if (count == 5) {
				System.out.println();
				count = 0;
			}
			System.out.print(e.getKey() + " --- " + e.getValue().getFileName() + "\t");
			count++;
		}
		System.out.print("\n请选择序号(数字[0-9]) : ");
		String l = s.nextLine();
		if (l.equals("")) {
			System.out.println(l);
		}
		download(l.split(" "), map);
	}

	public String getSearchName() {
		String n = "";
		System.out.print("请输入搜索的内容: ");
		s = new Scanner(System.in);
		String tmp = s.nextLine();
		if (tmp.equals("")) {
			getSearchName();
		} else {
			n = tmp;
		}
		return n;
	}

	public Integer getPageNum() {
		Integer i = 0;
		s = new Scanner(System.in);
		System.out.print("请输入需要获取的页面数量(默认为1页): ");
		int n = s.nextInt();
		if (n > 0) {
			i = n;
		} else {
			i = 1;
		}
		return i;
	}

	public String getMusicList() {
		String l = "";
		s = new Scanner(System.in);
		System.out.println("请输入歌单链接地址(不要在末尾加入奇怪的内容，不然会出错): ");
		String ml = s.nextLine();
		if (ml.equals("")) {
			getMusicList();
		} else {
			l = ml;
		}
		return l;
	}

	public boolean isExists(String f) {
		return new File(f).exists();
	}

	public boolean Del(String f) {
		return new File(f).delete();
	}

	public void write(String data) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(ConfigureFile)));
			bw.write(data);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSavePath(String savePath) {
		write("\"save\":\"" + savePath + "\"");
	}

	public void setDefMusic(String DefMusic) {
		write("\"music\":\"" + DefMusic + "\"");
	}

	public String getSavePath() {
		return t.getByJson(t.read(ConfigureFile), SavePathFile);
	}

	public String getDefaultMusic() {
		return t.getByJson(t.read(ConfigureFile), DefaultMusic);
	}

	public boolean checkConfigureFiles() {
		boolean flag = false;
		if (isExists(ConfigureFile)) {
			if (!getSavePath().equals("")) {
				if (!getDefaultMusic().equals("")) {
					flag = true;
				} else {
					System.err.println("我觉得你需要设置一下默认音乐");
					flag = true;
				}
			} else {
				System.err.println("我觉得你需要设置一下默认保存路径");
				System.out.println("请输入你的默认保存路径: ");
				s = new Scanner(System.in);
				String ss = s.nextLine();
				if (isExists(ss)) {
					setSavePath(ss);
				} else {
					System.err.println("我怀疑你tm在逗我(已经创建好路径,请重新输入一遍刚刚的路径)");
					new File(ss).mkdirs();
					checkConfigureFiles();
				}

			}
		} else {
			System.err.println("我觉得你需要一个配置文件!!\n");
		}
		return flag;
	}
}
