package com.ane56.bi.common.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class ObjectMapUtils {
	private static Logger log = Logger.getLogger(ObjectMapUtils.class);
	// Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map  
	public static Map<String, Object> transBean2Map(Object obj) {  
	    if (obj == null) {  
	        return null;  
	    }  
	    Map<String, Object> map = new HashMap<String, Object>();  
	    try {  
	        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
	        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
	        for (PropertyDescriptor property : propertyDescriptors) {  
	            String key = property.getName();  
	            // 过滤class属性  
	            if (!key.equals("class")) {  
	                // 得到property对应的getter方法  
	                Method getter = property.getReadMethod();  
	                Object value = getter.invoke(obj);  
	                map.put(key, value);  
	            }  
	        }  
	    } catch (Exception e) {  
	    	log.error("transBean2Map Error {}" ,e);  
	    }  
	    return map;  
	  
	}  

}
