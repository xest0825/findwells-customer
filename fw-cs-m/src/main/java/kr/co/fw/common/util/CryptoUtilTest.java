package kr.co.fw.common.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public class CryptoUtilTest {
	
	public static void main (String [] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		System.out.println(CryptoUtil.encrypt("0000"));
		String enc1 = CryptoUtil.encrypt("01046933992");
		System.out.println(enc1);
		String enc2 = CryptoUtil.encrypt("01046933692");
		System.out.println(enc2);
		System.out.println(CryptoUtil.decrypt(enc1));
		System.out.println(CryptoUtil.decrypt(enc2));
		System.out.println(CommUtil.getUUIDExceptDash());
		// b68b9107e68a4a63853db9026301aa8f // 최윤식 FC
		// 8e6346da523441afa9cb3dae020dfddf // 최윤식 고객
		// 412ad812be204a66b001f963ea5682da // 염동은 FC
		// 8a7c16d7a53141d7a5482cac8263d466 // 염동은 고객
		
	}

}
