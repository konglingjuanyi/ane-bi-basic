package com.ane56.bi.port.adapter.utils;

public class IdUtils {

	private static IdGenerater generater;

	private static IdGenerater getGenerater() {
		if (generater == null) {
			generater = new IdGenerater();
		}
		return generater;
	}

	public static void setGenerater(IdGenerater generater) {
		IdUtils.generater = generater;
	}

	public static String id4str() {
		return getGenerater().generate();
	}

	public static long id() {
		return getGenerater().generateId();
	}

}
