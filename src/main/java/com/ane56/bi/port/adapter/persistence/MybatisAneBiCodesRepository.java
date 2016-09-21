package com.ane56.bi.port.adapter.persistence;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.ane56.bi.domain.basic.AneBiCodes;
import com.ane56.bi.domain.basic.AneBiCodesRepository;
import com.ane56.db.mybatis.core.Pagination;
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
	@Override
	public List<AneBiCodes> getCodesByType(String codeType) {
		QueryBuilder sqlQuery = new QueryBuilder(AneBiCodes.class);
		return this.repository().query(sqlQuery.eq("code_type", codeType).build());
	}

	/**
	 * 根据编码类型和编码名称查询对应字典项
	 * @param codeType
	 * @param codeValue
	 * @return
	 */
	@Override
	public AneBiCodes findCodeByTypeAndValue(String codeType, int codeValue) {
		QueryBuilder sqlQuery = new QueryBuilder(AneBiCodes.class);
		sqlQuery = sqlQuery.eq("code_type", codeType).eq("code_value", codeValue);
		return this.repository().queryBy(sqlQuery.build());
	}

	/**
	 * 新增字典项
	 * @param aneBiCodes
	 */
	@Override
	public void addCode(AneBiCodes aneBiCodes) {
		this.repository().insert(aneBiCodes);
	}

	/**
	 * 删除字典项
	 * @param aneBiCodes
	 */
	@Override
	public void deleteCode(AneBiCodes aneBiCodes) {
		this.repository().delete(aneBiCodes);
	}

	/**
	 * 更新字典项
	 * @param aneBiCodes
	 */
	@Override
	public void updateCode(AneBiCodes aneBiCodes) {
		this.repository().update(aneBiCodes);
	}

	/**
	 * 分页查询数据字典
	 * @param start
	 * @param limit
	 * @return
	 */
	@Override
	public Pagination<AneBiCodes> getCodesWithPage(int start, int limit,String codeType,String description,String codeName) {
		QueryBuilder sqlBuilder = new QueryBuilder(AneBiCodes.class);
		if(StringUtils.isNotBlank(codeType)){
			sqlBuilder.like("code_type", "%"+codeType+"%");
		}
		if(StringUtils.isNotBlank(description)){
			sqlBuilder.like("description", "%"+description+"%");
		}
		if(StringUtils.isNotBlank(codeName)){
			sqlBuilder.like("code_name", "%"+codeName+"%");
		}
		return this.repository().query(sqlBuilder.desc("update_time").build(), start, limit);
	}

	/**
	 * 根据id查询字典项
	 * @param id
	 * @return
	 */
	@Override
	public AneBiCodes findById(long id) {
		return findByProp(AneBiCodes.class, "id", id+"");
	}

}
