package com.ane56.bi.port.adapter.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ane56.bi.domain.basic.AneBiCodes;
import com.ane56.bi.domain.basic.AneBiCodesRepository;
import com.ane56.db.mybatis.query.QueryBuilder;
/**
 * 类描述：数据字典实现类
 * @author zhangyibo
 *
 */
@Component
public class MybatisAneBiCodesRepository extends SpringMybatisRepositorySupport implements AneBiCodesRepository{

	/**
	 * 根据编码类型查询字典项
	 * @param codeType
	 * @return
	 */
	public List<AneBiCodes> getCodesByType(String codeType) {
		QueryBuilder sqlQuery = new QueryBuilder(AneBiCodes.class);
		return this.repository().query(sqlQuery.eq("code_type", codeType).build());
	}

	/**
	 * 根据编码类型和编码值查询对应字典项
	 * @param codeType
	 * @param codeValue
	 * @return
	 */
	public AneBiCodes findCodeByTypeAndValue(String codeType, int codeValue) {
		QueryBuilder sqlQuery = new QueryBuilder(AneBiCodes.class);
		sqlQuery = sqlQuery.eq("code_type", codeType).eq("code_value", codeValue);
		return this.repository().queryBy(sqlQuery.build());
	}

}
