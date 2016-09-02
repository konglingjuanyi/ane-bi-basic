package com.ane56.bi.common.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		if(value == null) return null;//濡傛灉瑕佽浆鎹㈡垚鍊间负null锛岄偅涔堢洿鎺ヨ繑鍥瀗ull
		if(!(value instanceof String)) {//濡傛灉瑕佽浆鎹㈢殑鍊间笉鏄疭tring锛岄偅涔堝氨涓嶈浆鎹簡锛岀洿鎺ヨ繑鍥�
			return value;
		}
		String val = (String) value;//鎶婂�杞崲鎴怱tring
		
		// 浣跨敤SimpleDateFormat杩涜杞崲
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(val);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
