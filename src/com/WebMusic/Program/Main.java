package com.WebMusic.Program;

import com.NewWebMusic.NewOtherMusic;
import com.NewWebMusic.MusicType.NewMusicTypeList;
import com.WebMusic.OtherMusic;
import com.WebMusic.util.MusicTypeList;
import com.WebMusicPro.OtherMusicPro;
import com.WebMusicPro.QQMusicProNoOhter;

/**
* <p>����ʱ�䣺2019��2��2�� ����5:45:36
* <p>��Ŀ���ƣ�WebMusic
* 
* <p>��˵����
* �޸�ʱ��: 2019��4��19��
* @version 1.0
* @since JDK 1.8
* �ļ����ƣ�Main.java
* */
public class Main {

	
	/**
	 * ��ͨ�汾
	 * �Ѿ��޸���������
	 * �Ѿ��޸�����������
	 * �Ѿ��޸�QQ����
	 * ����bug���ṷ������Ҫ����cookie���ɲ���
	 * ��׼�治��ά��Ϻ������
	 * �����°����ֽӿ�
	 * ��Ҫ�޸��߼�����
	 * */
	public static void main(String[] args) {
		String tmpSavePath = "E:\\WebMusic\\test\\";
//		new WebMusicProgram().menu(args);
		QQMusicProNoOhter music = new QQMusicProNoOhter();
		music.getInfo("����Ѹ");
		
		
		
	}

}
