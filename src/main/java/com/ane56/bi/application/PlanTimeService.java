package com.ane56.bi.application;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.PlanTime;
import com.ane56.bi.domain.operation.PlanTimeRepository;

@Service
public class PlanTimeService extends AssertionConcern {

	@Autowired
	private PlanTimeRepository planTimeRepository;
	

	@Transactional
	public int addPlanTime(PlanTime data) {
		return planTimeRepository.add(data);
	}

   public List<PlanTime> findByParams(Map<String,Object> condition){
	   List<PlanTime> result = null;
	   result = planTimeRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updatePlanTime(PlanTime data){
	   int result = planTimeRepository.update(data);
	   return result;
   }

   public PageBean<PlanTime> queryDataByPage(Map<String,Object> paramObject,int offset, int limit){
	   PageBean<PlanTime> result = null;
	   result = planTimeRepository.queryDataByPage(paramObject,offset,limit);
	   return result;
   }
   
}
