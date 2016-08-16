package com.ane56.bi.port.adapter.utils;

public class TimeFormatUtils {

	/**
	 * 毫秒数格式化为天数 "1日 03:02"
	 * @param msec
	 * @return
	 */
	public static String mescFormatToDays(int msec){
		String str = "";
		int d = msec/(1000*60*60*24);
		int h = (msec-d*(1000*60*60*24))/(1000*60*60);
		String hStr = h+"";
		hStr = hStr.length()<2 ? "0"+hStr : hStr;
		int m = (msec-d*(1000*60*60*24)-h*(1000*60*60))/(1000*60);
		String mStr = m+"";
		mStr = mStr.length()<2 ? "0"+mStr : mStr;
		str = d+"日 " + hStr + ":" + mStr;
		return str;
	}
	
	/**
	 * 毫秒数格式化为小时数 "43:02"
	 * @param msec
	 * @return
	 */
	public static String mescFormatToHours(int msec){
		String str = "";
		int h = msec/(1000*60*60);
		String hStr = h+"";
		hStr = hStr.length()<2 ? "0"+hStr : hStr;
		int m = (msec-h*(1000*60*60))/(1000*60);
		String mStr = m+"";
		mStr = mStr.length()<2 ? "0"+mStr : mStr;
		str = hStr + ":" + mStr;
		return str;
	}
	
	/**
	 * 求时间差，并格式化为小时数 "25:22"
	 * @param large
	 * @param small
	 * @return
	 */
	public static String getTimeDifference(int large,int small){
		int dif = large - small;
		return mescFormatToHours(dif);
	}
	
}
