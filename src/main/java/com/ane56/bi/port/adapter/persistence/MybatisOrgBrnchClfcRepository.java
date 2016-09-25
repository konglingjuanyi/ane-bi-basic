package com.ane56.bi.port.adapter.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ane56.bi.domain.basic.OrgBrnchClfc;
import com.ane56.bi.domain.basic.OrgBrnchClfcRepository;
import com.ane56.bi.domain.basic.OrgBrnchClfcVO;
import com.ane56.db.mybatis.core.Pagination;
/**
 * 
 * @author 张一波
 *
 */
@Component
public class MybatisOrgBrnchClfcRepository extends SpringMybatisRepositorySupport implements OrgBrnchClfcRepository{

	/**
	 * 查询分拨属性
	 * @param paramObject
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Pagination<OrgBrnchClfcVO> getOrgBrnchClfc(Map<String, Object> paramObject, int offset, int limit) {
		Pagination<OrgBrnchClfcVO> pageData = this.queryWithPage("Basic_OrgBrnchClfcDao", paramObject,offset,limit);
		return pageData;
	}
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public int update(OrgBrnchClfc entity) {
		int result = this.repository().update("Basic_OrgBrnchClfcDao.update",entity);
		return result;
	}

}
