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
	 * 分页查询数据字典
	 * @param start
	 * @param limit
	 * @return
	 */
	Pagination<AneBiCodes> getCodesWithPage(int start,int limit,String codeType,String description,String codeName);
	/**
	 * 根据编码类型和编码值查询对应字典项
	 * @param codeType
	 * @param codeValue
	 * @return
	 */
	AneBiCodes findCodeByTypeAndValue(String codeType,String codeValue);
	/**
	 * 新增字典项
	 * @param aneBiCodes
	 */
	void addCode(AneBiCodes aneBiCodes);
	/**
	 * 删除字典项
	 * @param aneBiCodes
	 */
	void deleteCode(AneBiCodes aneBiCodes);
	/**
	 * 更新字典项
	 * @param aneBiCodes
	 */
	void updateCode(AneBiCodes aneBiCodes);
	/**
	 * 根据id查询字典项
	 * @param id
	 * @return
	 */
	AneBiCodes findById(long id);
	
}
