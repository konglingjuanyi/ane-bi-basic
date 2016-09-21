package com.ane56.bi.application;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.BdpTgtVal;
import com.ane56.bi.domain.operation.FixedTargetRepository;

@Service
public class FixedTargetService extends AssertionConcern {

	@Autowired
	private FixedTargetRepository fixedTargetRepository;
	

	@Transactional
	public int addFixedTarget(BdpTgtVal data) {
		return fixedTargetRepository.add(data);
	}

   public List<BdpTgtVal> findByParams(Map<String,Object> condition){
	   List<BdpTgtVal> result = null;
	   result = fixedTargetRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateFixedTarget(BdpTgtVal data){
	   int result = fixedTargetRepository.update(data);
	   return result;
   }

   public PageBean<BdpTgtVal> queryDataByPage(Map<String,Object> paramObject,int offset, int limit){
	   PageBean<BdpTgtVal> result = null;
	   result = fixedTargetRepository.queryDataByPage(paramObject,offset,limit);
	   return result;
   }
   
}
