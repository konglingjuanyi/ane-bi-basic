package com.ane56.bi.application;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.BdpDstrbPlanOpTime;
import com.ane56.bi.domain.operation.PlanTimeRepository;

@Service
public class BdpDstrbPlanOpTimeService extends AssertionConcern {

	@Autowired
	private PlanTimeRepository planTimeRepository;
	

	@Transactional
	public int addData(BdpDstrbPlanOpTime data) {
		data.setCrtTime(new Date());
		data.setValidFlag("1");
		return planTimeRepository.add(data);
	}

	public int deleteData(Map<String, Object> condition) {
		int result = planTimeRepository.delete(condition);
		return result;
	}
	
   public List<BdpDstrbPlanOpTime> findByParams(Map<String,Object> condition){
	   List<BdpDstrbPlanOpTime> result = null;
	   result = planTimeRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateData(BdpDstrbPlanOpTime data){
	   int result = planTimeRepository.update(data);
	   return result;
   }

   public Pagination<BdpDstrbPlanOpTime> queryDataByPage(Map<String, Object> paramObject, int pageNum, int pageSize){
	   Pagination<BdpDstrbPlanOpTime> result = null;
	   result = planTimeRepository.queryDataByPage(paramObject,pageNum, pageSize);
	   return result;
   }
}
