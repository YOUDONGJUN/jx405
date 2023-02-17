package com.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// [출처] [Java] MessageDigest 클래스 : 해시 값 구하기 ( MD5, SHA-256 )|작성자 자바킹
public class SHA256Utils {
	public static String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());
		byte[] sha256Hash = md.digest();
		
		StringBuilder hexSHA256hash = new StringBuilder();
        for(byte b : sha256Hash) {
            String hexString = String.format("%02x", b);
            hexSHA256hash.append(hexString);
        }     

		return hexSHA256hash.toString();
	}
	
}
