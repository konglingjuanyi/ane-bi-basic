package com.ane56.bi.common.util;

/**
 * 使用apache的commons-codec-1.10来采用MD5加密解密
 */
public class MD5Util {
	static StringBuilder sb = null;
	/**
	 * 直接将数据md5
	 * @param data
	 * @return
	 */
	public static String md5Hex(String data){
		return DigestUtils.md5Hex(data);
	}
	/**
	 * 输入密码加盐值加密
	 * @param data
	 * @param salt
	 * @return
	 */
	public static String md5HexWithSalt(String data,String salt){
		sb = new StringBuilder();
		sb.append(data).append(salt);
		return DigestUtils.md5Hex(sb.toString());
	}
	
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		String passWord = String.valueOf(time);
		System.out.println(md5HexWithSalt(passWord,"EX-PDA"));
		System.out.println(time);
//		System.out.println(md5HexWithSalt(passWord,currDate).length());
//		System.out.println(currDate);
	}
}