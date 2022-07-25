package com.blogweb.common;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

public class Util {

	/**
	 * 지정된 암호화 알고리즘에 따라 문자열 데이터를 암호화 처리
	 * 
	 * @param source    암호화 대상 문자열
	 * @param algorithm 암호화 알고리즘 문자열 (SHA-1, MD5, SHA-256, ...)
	 * @return 암호화된 데이터
	 */
	public static byte[] getHashedData(String source, String algorithm) {

		byte[] hashedData = null;

		try {
			// 지정된 암호화 알고리즘에 따라 암호화 처리 인스턴스 생성
			MessageDigest md = MessageDigest.getInstance(algorithm);
			hashedData = md.digest(source.getBytes());// 지정된 알고리즘으로 암호화
		} catch (NoSuchAlgorithmException ex) {
			hashedData = null;
		}

		return hashedData;
	}

	public static String getHashedString(String source, String algorithm) {

		byte[] hashedData = getHashedData(source, algorithm);

		if (hashedData == null)
			return null;

		// 각 byte 단위로 16진수 문자열 변환 처리
		String hashedString = "";
		for (int i = 0; i < hashedData.length; i++) {
			String hexString = Integer.toHexString((int) hashedData[i] & 0x000000ff);
			if (hexString.length() < 2)
				hexString = "0" + hexString;

			hashedString += hexString;
		}

		return hashedString;
	}
}