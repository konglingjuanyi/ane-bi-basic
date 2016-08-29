package com.ane56.bi.common.util;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

public class CommonUtils {
	/**
	 * 杩斿洖涓�釜涓嶉噸澶嶇殑瀛楃涓�
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 鎶妋ap杞崲鎴愬璞�
	 * @param map
	 * @param clazz
	 * @return
	 * 
	 * 鎶奙ap杞崲鎴愭寚瀹氱被鍨�
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T toBean(Map map, Class<T> clazz) {
		try {
			/*
			 * 1. 閫氳繃鍙傛暟clazz鍒涘缓瀹炰緥
			 * 2. 浣跨敤BeanUtils.populate鎶妋ap鐨勬暟鎹皝闂埌bean涓�
			 */
			if(map == null){
				return null;
			}else{
				boolean result = map.isEmpty();
				if(result){
					return null;
				}else{
					T bean = clazz.newInstance();
					ConvertUtils.register(new DateConverter(), java.util.Date.class);
					BeanUtils.populate(bean, map);
					return bean;
				}
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
