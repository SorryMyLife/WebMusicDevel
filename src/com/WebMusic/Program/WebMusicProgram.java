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
 * ����ʱ�䣺2019��2��2�� ����5:45:24
 * <p>
 * ��Ŀ���ƣ�WebMusic
 * 
 * <p>
 * ��˵���� ������Ҫ����
 *
 * @version 1.0
 * @since JDK 1.8 �ļ����ƣ�WebMusicProgram.java
 */
/*
 * ���� ����߼��汾 ���� �����汾
 * 
 */
@SuppressWarnings("deprecation")
public class WebMusicProgram {

	public void help() {
		System.out.println("usage : -p | -new ");
		System.out.println("    -p | -pro : �߼��汾     ");
		System.out.println("    -new : �°汾     ");
		System.out.println("    -kg : �ṷ����ģʽ     ");
		System.out.println("    -qq : QQ����ģʽ     ");
		System.out.println("    -xm : Ϻ������ģʽ     ");
		System.out.println("    -kw : ��������ģʽ     ");
		System.out.println("    -c163 : ����������ģʽ     \n\n");
		info();
	}

	public void info() {
		System.out.println("��ͨģʽЧ�����,������Ҳ������\n" + "��ģʽЧ�ʱ���ͨģʽЧ��Ҫ��һЩ,����������\n" + "�߼�ģʽЧ�����,�����ݸ��ӷḻ\n\n"
				+ "���������ʱ��: 2019��4��19��\n" + "api�������ʱ��: 2019��2��1��\n" + "����ʱ��: 2019��2��20��\n" + "\n��л: \n"
				+ "music.cccyun.cc\n" + "moresound.tk\n" + "�������ֹٷ��ṩ��api\n");
	}

	public void ProSelect(String v) {
		WebMusicPro w = null;
		switch (v) {
		case "-kg":
			System.out.println("�ṷ����ģ��!\n");
			w = new KuGouMusicPro();
			break;
		case "-qq":
			System.out.println("QQ����ģ��!\n");
			w = new QQMusicPro();
			break;
		case "-xm":
			System.out.println("Ϻ������ģ��!\n");
			w = new XiaMiMusicPro();
			break;
		case "-kw":
			System.out.println("��������ģ��!\n");
			w = new KuWoMusicPro();
			break;
		case "-c163":
			System.out.println("����������ģ��!");
			w = new CloudMusic163Pro();
			break;
		case "-h":
		case "-help":
			help();
			break;
		default:
			System.out.println("�ṷ����ģ��!\n");
			w = new KuGouMusicPro();
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
			System.out.println("�ṷ����ģ��!\n");
			w = new NewKuGou();
			break;
		case "-qq":
			System.out.println("QQ����ģ��!\n");
			w = new NewQQMusic();
			break;
		case "-xm":
			System.out.println("Ϻ������ģ��!\n");
			w = new NewXiaMi();
			break;
		case "-kw":
			System.out.println("��������ģ��!\n");
			w = new NewKuWoMusic();
			break;
		case "-c163":
			System.out.println("����������ģ��!");
			w = new NewCloudMusic163();
			break;
		case "-h":
		case "-help":
			help();
			break;
		default:
			System.out.println("�ṷ����ģ��!\n");
			w = new NewKuGou();
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
			ProSelect(v[1]);
			break;
		case "-new":
			NewSelect(v[1]);
			break;
		case "-kg":
			System.out.println("�ṷ����ģ��!\n");
			w = new KuGouMusic();
			break;
		case "-qq":
			System.out.println("QQ����ģ��!\n");
			w = new QQMusic();
			break;
		case "-xm":
			System.out.println("Ϻ������ģ��!\n");
			w = new XiaMiMusic();
			break;
		case "-kw":
			System.out.println("��������ģ��!\n");
			w = new KuWoMusic();
			break;
		case "-c163":
			System.out.println("����������ģ��!");
			w = new CloudMusic163();
			break;
		case "-h":
		case "-help":
			help();
			break;
		default:
			System.out.println("�ṷ����ģ��!\n");
			w = new KuGouMusic();
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
			System.out.println("����Ҫ�ڵ�ǰ·������һ�������ļ�");
			System.out.println("�ļ���ʽΪ: conf.ini\n(ȫ����Ӣ�ı�����,Ī�����)");
			System.out.println("�ļ���ʽ����Ϊ: ");
			System.out.println("\"save\":\"���Ĭ�ϱ���·��\"");
			System.out.println("\"music\":\"���Ĭ����������\"\n���������Ĭ���������͵Ļ�,��ô����Ĭ��ʹ�ÿṷ\n");
			System.out.print("�Ƿ����������ļ�?(y|n): ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			switch(str) {
			case "y":
			case "Y":
				System.out.print("���뱣��·��: ");
				s = new Scanner(System.in);
				str = s.nextLine();
				p.setSavePath(str);
				System.out.println("�������!\n����������һ��!");
				break;
				default:
					System.exit(-1);
					break;
			}
		}
	}

}
