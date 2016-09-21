package com.ane56.bi.port.adapter.persistence;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.ane56.bi.domain.extraDays.AneBiSiteExtraDays;
import com.ane56.bi.domain.extraDays.AneBiSiteExtraDaysRepository;
import com.ane56.db.mybatis.core.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;

/**
 * 类描述：全国时效额外天数实现类
 * @author Administrator
 *
 */
@Component
public class MybatisAneBiSiteExtraDaysRepository extends SpringMybatisRepositorySupport implements AneBiSiteExtraDaysRepository{

	/**
	 * 获取全国时效额外天数list
	 * @return
	 */
	@Override
	public List<AneBiSiteExtraDays> getExtraDaysAll() {
		return this.repository().query(new QueryBuilder(AneBiSiteExtraDays.class).build());
	}

	/**
	 * 分页查询全国时效额外天数
	 * @return
	 */
	@Override
	public Pagination<AneBiSiteExtraDays> getExtraDaysWithPage(int start,int limit,String siteName,String agingType) {
		QueryBuilder sqlBuilder = new QueryBuilder(AneBiSiteExtraDays.class);
		if(StringUtils.isNotBlank(siteName)){
			if(siteName.matches("[a-zA-Z]+")){
				String sitePinyin = siteName.toLowerCase();
				sqlBuilder.like("site_pinyin", "%"+sitePinyin+"%");
			}else{
				sqlBuilder.like("site_name", "%"+siteName+"%");
			}
		}
		if(StringUtils.isNoneBlank(agingType)){
			sqlBuilder.eq("aging_type", agingType);
		}
		sqlBuilder.desc("update_time");
		return this.repository().query(sqlBuilder.build(), start, limit);
	}

	/**
	 * 新增全国时效额外天数
	 * @param entity
	 */
	@Override
	public void addExtraDay(AneBiSiteExtraDays entity) {
		this.repository().insert(entity);
	}

	/**
	 * 更新全国时效额外天数
	 * @param entity
	 */
	@Override
	public void updateExtraDay(AneBiSiteExtraDays entity) {
		this.repository().update(entity);
	}

	/**
	 * （物理）删除全国时效额外天数
	 * @param entity
	 */
	@Override
	public void deleteExtraDay(AneBiSiteExtraDays entity) {
		this.repository().delete(entity);
	}

	/**
	 * 根据id查询全国时效额外天数
	 * @param id
	 * @return
	 */
	@Override
	public AneBiSiteExtraDays findById(long id) {
		return findByProp(AneBiSiteExtraDays.class, "id", id+"");
	}

	/**
	 * 根据分拨名称,时效类型查询全国时效额外天数
	 */
	@Override
	public AneBiSiteExtraDays findIsUnique(String siteName, String agingType) {
		QueryBuilder sqlBuilder = new QueryBuilder(AneBiSiteExtraDays.class);
		sqlBuilder = sqlBuilder.eq("site_name", siteName).eq("aging_type", agingType);
		return this.repository().queryBy(sqlBuilder.build());
	}

}
