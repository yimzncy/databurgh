package com.databurgh.util;

import java.security.MessageDigest;

public class MD5Util {

	public static String encodeMD5(String targetString) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(targetString.getBytes("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static void main(String[] args) {
		String x = "afa432r 24rFGERW42T2 23R 3R2  REWfsf  wefwe  re#r#d%TTGG";
		try {
			System.out.println(encodeMD5(x));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
