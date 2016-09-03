package com.ane56.bi.application;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.TargetCost;
import com.ane56.bi.domain.operation.TargetCostRepository;

@Service
public class TargetCostService extends AssertionConcern {

	@Autowired
	private TargetCostRepository targetCostRepository;
	

	@Transactional
	public int addTargetCostData(TargetCost data) {
		return targetCostRepository.add(data);
	}

   public List<TargetCost> findByParams(Map<String,Object> condition){
	   List<TargetCost> result = null;
	   result = targetCostRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateTargetCostData(TargetCost data){
	   int result = targetCostRepository.update(data);
	   return result;
   }
   public int deleteTargetCostData(Map<String,Object> condition){
	   int result = targetCostRepository.delete(condition);
	   return result;
   }
}
