package com.ane56.bi.application;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.BdpDstrbPlanOpTime;
import com.ane56.bi.domain.operation.BdpDstrbPlanOpTimeRepository;

@Service
public class BdpDstrbPlanOpTimeService extends AssertionConcern {

	@Autowired
	private BdpDstrbPlanOpTimeRepository BdpDstrbPlanOpTimeRepository;
	

	@Transactional
	public int addBdpDstrbPlanOpTime(BdpDstrbPlanOpTime data) {
		return BdpDstrbPlanOpTimeRepository.add(data);
	}

   public List<BdpDstrbPlanOpTime> findByParams(Map<String,Object> condition){
	   List<BdpDstrbPlanOpTime> result = null;
	   result = BdpDstrbPlanOpTimeRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateBdpDstrbPlanOpTime(BdpDstrbPlanOpTime data){
	   int result = BdpDstrbPlanOpTimeRepository.update(data);
	   return result;
   }

   public PageBean<BdpDstrbPlanOpTime> queryDataByPage(Map<String,Object> paramObject,int offset, int limit){
	   PageBean<BdpDstrbPlanOpTime> result = null;
	   result = BdpDstrbPlanOpTimeRepository.queryDataByPage(paramObject,offset,limit);
	   return result;
   }
   
}
