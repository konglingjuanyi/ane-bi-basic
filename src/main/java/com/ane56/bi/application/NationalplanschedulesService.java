package com.ane56.bi.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.basics.NationalplanschedulesRepository;
import com.ane56.bi.domain.basics.PlanSchedulesVO;
import com.ane56.bi.domain.basics.SchedulesstopsRepository;
import com.ane56.bi.domain.basics.Stops;
import com.ane56.bi.domain.basics.StopsVO;
import com.ane56.bi.port.adapter.web.resource.form.NationalplanscheduleForm;
import com.ane56.db.mybatis.core.Pagination;

@Service
public class NationalplanschedulesService extends AssertionConcern{
	
	@Autowired
	private NationalplanschedulesRepository nationalplanschedulesRepository;
	@Autowired
	private SchedulesstopsRepository schedulesstopsRepository;
	
	/**
	 * 分页查询全国班次计划
	 * @param start
	 * @param limit
	 * @param form
	 * @return
	 */
	public Pagination<PlanSchedulesVO> getPlanSchedulesWithPage(int start, int limit,NationalplanscheduleForm form){
		Pagination<PlanSchedulesVO> planSchedulesVOs =  nationalplanschedulesRepository.getPlanSchedulesWithPage(start, limit,form);
		for(PlanSchedulesVO planSchedule : planSchedulesVOs.getResult()){
			List<StopsVO> stopsVO = new ArrayList<StopsVO>();
			stopsVO = schedulesstopsRepository.findStopsByScheduleId(planSchedule.getId());
			for(StopsVO vo : stopsVO){
				vo.setArteryTimeStr();
				vo.setIntervalTimeStr();
				vo.setArriveTimeStr();
				vo.setLeaveTimeStr();
			}
			planSchedule.setStopsVO(stopsVO);
			planSchedule.setArteryTimeStr();
			planSchedule.setDepartTimeStr();
			planSchedule.setArriveTimeStr();
		}
		return planSchedulesVOs;
	}
}
