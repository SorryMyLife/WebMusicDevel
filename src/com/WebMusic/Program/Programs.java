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
 * ����ʱ�䣺2019��2��3�� ����1:10:14
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵����
 *
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�Programs.java
 */
public class Programs {

	private WebMusicTools t = new WebMusicTools();
	private String ConfigureFile = "conf.ini";
	private String SavePathFile = "save";
	private String DefaultMusic = "music";
	private Scanner s = null; // ��ȡ��������

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
		System.out.print("�Ҿ�������Ҫ����һ���Ƿ��˳�(y|n): ");
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
		System.out.print("�Ҿ�������Ҫ����һ���Ƿ��˳�(y|n): ");
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
		System.out.println("��ǰ����·��: " + getSavePath());
		System.out.print("1.��������\n2.ѡ���������\n3.һ�������������ĸ���\n4.ѡ�����ظ赥�ڵĸ���\n5.һ�����ظ赥�ڵĸ���\n88.�˳�\n��ѡ��: ");
		s = new Scanner(System.in);
		String select = s.nextLine();
		if (select.equals("1")) {
			w.getInfo(getSearchName(), getPageNum());
		} else if (select.equals("2")) {
			ProselectDownlaod(getSearchName(), getPageNum(), w);
		} else if (select.equals("3")) {
			s = new Scanner(System.in);
			System.out.print("\n��ѡ������ \n1.��������(���ܻ�ȡ����)\n2.��Ʒ����(���ܻ�ȡ����)\n3.һ������\n4.��ͨ����\n5.ѹ������\n: ");
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
			System.out.print("\n��ѡ������ \n1.��������(���ܻ�ȡ����)\n2.��Ʒ����(���ܻ�ȡ����)\n3.һ������\n4.��ͨ����\n5.ѹ������\n: ");
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
			System.err.println("��ѡ��һ����ȷ��ѡ��!");
			Promenu(w);
		}
		ProcheckExit(w);
	}

	public void menu(WebMusic w) {
		System.out.println("��ǰ����·��: " + getSavePath());
		System.out.print("1.��������\n2.ѡ���������\n3.һ�������������ĸ���\n4.ѡ�����ظ赥�ڵĸ���\n5.һ�����ظ赥�ڵĸ���\n88.�˳�\n��ѡ��: ");
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
			System.err.println("��ѡ��һ����ȷ��ѡ��!");
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
		System.out.print("\n��ѡ������ \n1.��������(���ܻ�ȡ����)\n2.��Ʒ����(���ܻ�ȡ����)\n3.һ������\n4.��ͨ����\n5.ѹ������\n: ");
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
		System.out.print("\n��ѡ�����(����[0-9]) : ");
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
		System.out.print("\n��ѡ�����(����[0-9]) : ");
		String l = s.nextLine();
		if (l.equals("")) {
			System.out.println(l);
		}
		download(l.split(" "), map);
	}

	public String getSearchName() {
		String n = "";
		System.out.print("����������������: ");
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
		System.out.print("��������Ҫ��ȡ��ҳ������(Ĭ��Ϊ1ҳ): ");
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
		System.out.println("������赥���ӵ�ַ(��Ҫ��ĩβ������ֵ����ݣ���Ȼ�����): ");
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
					System.err.println("�Ҿ�������Ҫ����һ��Ĭ������");
					flag = true;
				}
			} else {
				System.err.println("�Ҿ�������Ҫ����һ��Ĭ�ϱ���·��");
				System.out.println("���������Ĭ�ϱ���·��: ");
				s = new Scanner(System.in);
				String ss = s.nextLine();
				if (isExists(ss)) {
					setSavePath(ss);
				} else {
					System.err.println("�һ�����tm�ڶ���(�Ѿ�������·��,����������һ��ոյ�·��)");
					new File(ss).mkdirs();
					checkConfigureFiles();
				}

			}
		} else {
			System.err.println("�Ҿ�������Ҫһ�������ļ�!!\n");
		}
		return flag;
	}
}
