package com.WebMusic.Program;

import java.util.Scanner;

import com.NewWebMusic.NewCloudMusic163;
import com.NewWebMusic.NewKuGou;
import com.NewWebMusic.NewKuWoMusic;
import com.NewWebMusic.NewQQMusic;
import com.NewWebMusic.NewXiaMi;
import com.WebMusic.CloudMusic163;
import com.WebMusic.KuGouMusic;
import com.WebMusic.KuWoMusic;
import com.WebMusic.QQMusic;
import com.WebMusic.WebMusic;
import com.WebMusic.XiaMiMusic;
import com.WebMusicPro.CloudMusic163Pro;
import com.WebMusicPro.KuGouMusicPro;
import com.WebMusicPro.KuWoMusicPro;
import com.WebMusicPro.QQMusicPro;
import com.WebMusicPro.WebMusicPro;
import com.WebMusicPro.XiaMiMusicPro;

/**
 * <p>
 * 创建时间：2019年2月2日 下午5:45:24
 * <p>
 * 项目名称：WebMusic
 * 
 * <p>
 * 类说明： 程序主要功能
 *
 * @version 1.0
 * @since JDK 1.8 文件名称：WebMusicProgram.java
 */
/*
 * 需求： 加入高级版本 分类 三个版本
 * 
 */
@SuppressWarnings("deprecation")
public class WebMusicProgram {

	public void musichelp() {
		System.out.println("    -kg : 酷狗音乐模式     ");
		System.out.println("    -qq : QQ音乐模式     ");
		System.out.println("    -xm : 虾米音乐模式     (3.0.5版本已不再被支持)");
		System.out.println("    -kw : 酷我音乐模式     ");
		System.out.println("    -c163 : 网易云音乐模式     ");
	}
	
	public void help() {
		System.out.println("usage : ");
		System.out.println("    -p | -pro : 高级版本     (3.0.5版本已不再被支持)");
		System.out.println("    -new : 新版本     ");
		musichelp();
		System.out.println("    -version : 输出版本号     \n\n");
		info();
	}

	public void info() {
		System.out.println("普通模式效率最高,但问题也是最多的\n" + "新模式效率比普通模式效率要低一些,但问题最少\n" + "高级模式效率最低,但内容更加丰富\n\n"
				+ "本程序完成时间: 2019年4月19日\n" + "api工具完成时间: 2019年2月1日\n" + "更新时间: 2020年2月27日\n" + "\n感谢: \n"
				+ "www.musictool.top\n" + "moresound.tk\n" + "各大音乐官方提供的api\n\n当前版本: 3.0.5\n\n");
	}

	public void ProSelect(String v) {
		WebMusicPro w = null;
		switch (v) {
		case "-kg":
			System.out.println("酷狗音乐模块!\n");
			w = new KuGouMusicPro();
			break;
		case "-qq":
			System.out.println("QQ音乐模块!\n");
			w = new QQMusicPro();
			break;
		case "-xm":
			System.out.println("虾米音乐模块!\n");
			w = new XiaMiMusicPro();
			break;
		case "-kw":
			System.out.println("酷我音乐模块!\n");
			w = new KuWoMusicPro();
			break;
		case "-c163":
			System.out.println("网易云音乐模块!");
			w = new CloudMusic163Pro();
			break;
		case "-h":
		case "--h":
		case "-help":
		case "--help":
			help();
			break;
		case "-v":
		case "--v":
		case "-version":
		case "--version":
			System.out.println("version : 3.0.5 ");
			break;
		default:
			System.out.println("默认音乐模块!\n");
			v=new Programs().getDefaultMusic();
			ProSelect(v);
			break;
		}
		if (w != null) {
			new Programs().Promenu(w);
		}
	}

	public void NewSelect(String v) {
		WebMusic w = null;
		switch (v) {
		case "-kg":
			System.out.println("酷狗音乐模块!\n");
			w = new NewKuGou();
			break;
		case "-qq":
			System.out.println("QQ音乐模块!\n");
			w = new NewQQMusic();
			break;
		case "-xm":
			System.out.println("虾米音乐模块!\n");
			w = new NewXiaMi();
			break;
		case "-kw":
			System.out.println("酷我音乐模块!\n");
			w = new NewKuWoMusic();
			break;
		case "-c163":
			System.out.println("网易云音乐模块!");
			w = new NewCloudMusic163();
			break;
		case "-h":
		case "--h":
		case "-help":
		case "--help":
			help();
			break;
		case "-v":
		case "--v":
		case "-version":
		case "--version":
			System.out.println("version : 3.0.5 ");
			break;
		default:
			System.out.println("默认音乐模块!\n");
			v=new Programs().getDefaultMusic();
			NewSelect(v);
			break;
		}
		if (w != null) {
			new Programs().menu(w);
		}
	}

	public void select(String v[]) {
		WebMusic w = null;
		switch (v[0]) {
		case "-p":
		case "-pro":
			System.out.println("高级版本已不再被支持,是否要继续使用?(y/n): ");
			Scanner yn = new Scanner(System.in);
			String yyyy = yn.nextLine();
			if (yyyy.indexOf("n") != -1 || yyyy.indexOf("N") != -1) {
				break;
			}
			ProSelect(v[1]);
			break;
		case "-new":
			NewSelect(v[1]);
			break;
		case "-kg":
			System.out.println("酷狗音乐模块!\n");
			w = new KuGouMusic();
			break;
		case "-qq":
			System.out.println("QQ音乐模块!\n");
			w = new QQMusic();
			break;
		case "-xm":
			System.out.println("虾米音乐模块!\n");
			w = new XiaMiMusic();
			break;
		case "-kw":
			System.out.println("酷我音乐模块!\n");
			w = new KuWoMusic();
			break;
		case "-c163":
			System.out.println("网易云音乐模块!");
			w = new CloudMusic163();
			break;
		case "-h":
		case "--h":
		case "-help":
		case "--help":
			help();
			break;
		case "-v":
		case "--v":
		case "-version":
		case "--version":
			System.out.println("version : 3.0.5 ");
			break;
		default:
			System.out.println("默认音乐模块!\n");
			v[0]=new Programs().getDefaultMusic();
			select(v);
			break;
		}
		if (w != null) {
			new Programs().menu(w);
		}
	}

	@SuppressWarnings("resource")
	public void menu(String arr[]) {
		Programs p = new Programs();
		if (p.checkConfigureFiles()) {
			select(arr);
		} else {
			System.out.println("你需要在当前路径创建一个配置文件");
			System.out.println("文件格式为: conf.ini\n(全都是英文标点符号,莫搞错了)");
			System.out.println("文件格式内容为: ");
			System.out.println("\"save\":\"你的默认保存路径\"");
			System.out.println("\"music\":\"你的默认音乐类型\"\n如果不设置默认音乐类型的话,那么将会默认使用酷狗\n");
			System.out.print("是否设置配置文件?(y|n): ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			switch (str) {
			case "y":
			case "Y":
				System.out.print("输入保存路径: ");
				s = new Scanner(System.in);
				str = s.nextLine();
				p.setSavePath(str);
				System.out.print("输入默认音乐: ");
				musichelp();
				s = new Scanner(System.in);
				String ss = s.nextLine();
				p.setDefMusic(ss);
				System.out.println("设置完成!\n请重新运行一下!");
				break;
			default:
				System.exit(-1);
				break;
			}
		}
	}

}
