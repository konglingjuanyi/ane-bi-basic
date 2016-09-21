package com.ane56.bi.domain.extraDays;

import java.util.List;

import com.ane56.db.mybatis.core.Pagination;

/**
 * 类描述：全国时效额外天数接口类
 * @author zhangyibo
 *
 */
public interface AneBiSiteExtraDaysRepository {
	/**
	 * 获取全国时效额外天数list
	 * @return
	 */
	List<AneBiSiteExtraDays> getExtraDaysAll();
	/**
	 * 分页查询全国时效额外天数
	 * @param start
	 * @param limit
	 * @param siteName
	 * @param agingType
	 * @return
	 */
	Pagination<AneBiSiteExtraDays> getExtraDaysWithPage(int start,int limit,String siteName,String agingType);
	/**
	 * 新增全国时效额外天数
	 * @param entity
	 */
	void addExtraDay(AneBiSiteExtraDays entity);
	/**
	 * 更新全国时效额外天数
	 * @param entity
	 */
	void updateExtraDay(AneBiSiteExtraDays entity);
	/**
	 * （物理）删除全国时效额外天数
	 * @param entity
	 */
	void deleteExtraDay(AneBiSiteExtraDays entity);
	/**
	 * 根据id查询全国时效额外天数
	 * @param id
	 * @return
	 */
	AneBiSiteExtraDays findById(long id);
	/**
	 * 根据分拨名称,时效类型查询全国时效额外天数
	 * @param siteName
	 * @param agingType
	 * @return
	 */
	AneBiSiteExtraDays findIsUnique(String siteName,String agingType);
		
}
