package com.ane56.bi.domain.basics;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ane56.db.mybatis.spring.Mapper;

@Mapper
public interface SchedulesstopsRepository {
	/**
	 * 根据计划班次id查询经停地
	 * @param scheduleId
	 * @return
	 */
	List<StopsVO> findStopsByScheduleId(String scheduleId);
	/**
	 * 新增经停地
	 * @param stops
	 */
	void insertStops(Stops stops);
	/**
	 * 删除经停地
	 * @param id
	 */
	void deleteStops(String id);
	/**
	 * 新增关联关系：计划班次-经停地
	 * @param schedulesstops
	 */
	void insertRelation(Schedulesstops schedulesstops);
	/**
	 * 删除关联关系
	 * @param scheduleId
	 * @param stopId
	 */
	void deleteRelation(@Param("scheduleId") String scheduleId,@Param("stopId") String stopId);
}
