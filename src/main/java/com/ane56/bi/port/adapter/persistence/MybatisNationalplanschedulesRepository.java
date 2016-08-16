package com.ane56.bi.port.adapter.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.ane56.bi.domain.basics.Nationalplanschedules;
import com.ane56.bi.domain.basics.NationalplanschedulesRepository;
import com.ane56.bi.domain.basics.PlanSchedulesVO;
import com.ane56.bi.port.adapter.web.resource.form.NationalplanscheduleForm;
import com.ane56.db.mybatis.core.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;
import com.ane56.db.mybatis.query.SqlQuery;
@Component
public class MybatisNationalplanschedulesRepository extends SpringMybatisRepositorySupport implements NationalplanschedulesRepository{

	/**
	 * 分页查询全国计划班次表
	 */
	public Pagination<PlanSchedulesVO> getPlanSchedulesWithPage(int start,int limit,NationalplanscheduleForm form) {
		QueryBuilder sql = new QueryBuilder(PlanSchedulesVO.class, "nationalplanschedules");
		if(StringUtils.isNotBlank(form.getDepartPlace())){//始发地
			sql = sql.like("departPlace", "%"+form.getDepartPlace()+"%");
		}
		if(StringUtils.isNotBlank(form.getDestination())){//目的地
			sql.like("destination", "%"+form.getDestination()+"%");
		}
		if(StringUtils.isNotBlank(form.getStopNames())){//经停地
			sql.like("stopNames", "%"+form.getStopNames()+"%");
		}
		if(StringUtils.isNotBlank(form.getDepartPeriod())){//发车周期
			sql.like("departPeriod", "%"+form.getDepartPeriod()+"%");
		}
		if(StringUtils.isNotBlank(form.getLoadType())){//装卸方式
			sql.eq("loadType", form.getLoadType());
		}
		if(StringUtils.isNotBlank(form.getVehicleType())){//车型
			sql.eq("vehicleType", form.getVehicleType());
		}
		Pagination<PlanSchedulesVO> page =  this.repository().query(sql.build(), start, limit);
		return page;
	}
	
	/**
	 * 新增全国班次计划
	 */
	public void addPlanSchedule(Nationalplanschedules nationalplanschedules) {
		this.repository().insert(nationalplanschedules);
	}
	
	/**
	 * 更新全国班次计划
	 * @param nationalplanschedules
	 */
	public void updatePlanSchedule(Nationalplanschedules nationalplanschedules){
		this.repository().update(nationalplanschedules);
	}

	/**
	 * 删除全国班次计划
	 */
	public void delPlanSchedule(Nationalplanschedules nationalplanschedules) {
		this.repository().delete(nationalplanschedules);
	}

	/**
	 * 根据id获取全国班次计划
	 */
	public Nationalplanschedules findById(String id) {
		return findByProp(Nationalplanschedules.class, "id", id);
	}

}
