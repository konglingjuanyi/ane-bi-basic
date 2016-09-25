package com.ane56.bi.port.adapter.persistence;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.ane56.bi.domain.basic.OrgBrnchMtopRl;
import com.ane56.bi.domain.basic.OrgBrnchMtopRlRepository;
import com.ane56.bi.domain.basic.OrgBrnchQueryVO;
import com.ane56.db.mybatis.core.Pagination;

/**
 * 组织架构
 * @author 张一波
 *
 */
@Component
public class MybatisOrgBrnchMtopRlRepository extends SpringMybatisRepositorySupport implements OrgBrnchMtopRlRepository{
	
	/**
	 * 分页查询组织架构关系
	 */
	public Pagination<OrgBrnchQueryVO> getMtopRlWithPage(
			Map<String, Object> searchMap, int offset, int limit){
		Pagination<OrgBrnchQueryVO> pageData = this.queryWithPage("Bdp_OrgBrnchMtopRl", searchMap, offset, limit);
		return pageData;
	}
	/**
	 * 更新组织架构关系
	 * @param entity
	 * @return
	 */
	public int updateOrgBrnchMtopRl(OrgBrnchMtopRl entity){
		int result = this.repository().update("Bdp_OrgBrnchMtopRl.update", entity);
		return result;
	}
	/**
	 * 信息组织架构关系
	 * @param entity
	 * @return
	 */
	public int addOrgBrnchMtopRl(OrgBrnchMtopRl entity){
		int result = this.repository().update("Bdp_OrgBrnchMtopRl.add", entity);
		return result;
	}
	/**
	 * 获取一条数据
	 * @param entity
	 * @return
	 */
	public OrgBrnchMtopRl findOne(OrgBrnchMtopRl entity){
		OrgBrnchMtopRl result = (OrgBrnchMtopRl) this.repository().queryBy("Bdp_OrgBrnchMtopRl.findById", entity);
		return result;
	}
	
}
