package com.ane56.bi.domain.basics;

import com.ane56.bi.port.adapter.web.resource.form.NationalplanscheduleForm;
import com.ane56.db.mybatis.core.Pagination;
/**
 * 全国计划班次接口类
 * @author zhangyibo
 *
 */
public interface NationalplanschedulesRepository {
	/**
	 * 分页查询全国计划班次
	 * @param start
	 * @param limit
	 * @param form
	 * @return
	 */
	Pagination<PlanSchedulesVO> getPlanSchedulesWithPage(int start, int limit,NationalplanscheduleForm form);
	
	/**
	 * 新增全国计划班次
	 * @param nationalplanschedules
	 */
	void addPlanSchedule(Nationalplanschedules nationalplanschedules);
	/**
	 * 更新全国班次计划
	 * @param nationalplanschedules
	 */
	void updatePlanSchedule(Nationalplanschedules nationalplanschedules);
	/**
	 * 删除全国班次计划
	 * @param nationalplanschedules
	 */
	void delPlanSchedule(Nationalplanschedules nationalplanschedules);
	/**
	 * 根据id获取全国班次计划
	 * @param id
	 * @return
	 */
	Nationalplanschedules findById(String id);
}
