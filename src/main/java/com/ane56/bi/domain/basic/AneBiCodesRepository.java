package com.ane56.bi.domain.basic;

import java.util.List;
/**
 * 类描述：数据字典接口类
 * @author zhangyibo
 *
 */
public interface AneBiCodesRepository {

	/**
	 * 根据编码类型查询字典项list
	 * @param codeType
	 * @return
	 */
	List<AneBiCodes> getCodesByType(String codeType);
	/**
	 * 根据编码类型和编码值查询对应字典项
	 * @param codeType
	 * @param codeValue
	 * @return
	 */
	AneBiCodes findCodeByTypeAndValue(String codeType,int codeValue);
}
