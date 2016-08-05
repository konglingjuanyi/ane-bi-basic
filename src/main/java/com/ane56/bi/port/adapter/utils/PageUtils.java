package com.ane56.bi.port.adapter.utils;

public class PageUtils {
	
	public static int getOffset(int current , int pageSize){
		return (current - 1) * pageSize;
	}

}
