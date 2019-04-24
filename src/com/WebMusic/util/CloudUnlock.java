package com.WebMusic.util;

import java.util.Base64;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * <p>
 * 用来解密aes
 * <p>
 * 注释时间: 2019年1月22日
 */
public class CloudUnlock {
	private static final String paramHead = "{\"ids\":\"[", paramEnd = "]\",\"br\":128000,\"csrf_token\":\"\"}",
			param = "0CoJUm6Qyw8W8jud", num_id = "0102030405060708";
	private static String str = "";

	public static String AesEncrypt(String sSrc, String sKey, String iv) throws Exception {
		if (sKey == null) {
			System.out.print("Key不能为空null");
			return null;
		}
		if (sKey.length() != 16) {
			System.out.print("Key的长度不是16位");
			return null;
		}
		if (iv.length() != 16) {
			System.out.print("iv的长度不是16位");
			return null;
		}
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec iv1 = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv1);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
	}

	public static String AesDecrypt(String sSrc, String sKey, String iv) throws Exception {
		try {
			if (sKey == null) {
				System.out.print("Key不能为空null");
				return null;
			}
			if (sKey.length() != 16) {
				System.out.print("Key的长度不是16位");
				return null;
			}
			if (iv.length() != 16) {
				System.out.print("iv的长度不是16位");
				return null;
			}
			byte[] byte1 = Base64.getDecoder().decode(sSrc);// 先用Base64解码
			IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
			SecretKeySpec key = new SecretKeySpec(sKey.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
			// 与加密时不同MODE:Cipher.DECRYPT_MODE
			byte[] ret = cipher.doFinal(byte1);
			return new String(ret, "utf-8");
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}

	public static String getRandomCharAndNumr(Integer length) {
		String str = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			boolean b = random.nextBoolean();
			if (b) { // 字符串
				// int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
				str += (char) (65 + random.nextInt(26));// 取得大写字母
			} else { // 数字
				str += String.valueOf(random.nextInt(10));
			}
		}
		return str;
	}

	public static String getParams(String song_id) {
		try {
			str = AesEncrypt(paramHead + song_id + paramEnd, param, num_id);
			str = AesEncrypt(str, getRandomCharAndNumr(16), num_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
