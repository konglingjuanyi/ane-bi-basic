package com.ane56.bi.application;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.Cost;
import com.ane56.bi.domain.operation.CostRepository;

@Service
public class CostService extends AssertionConcern {

	@Autowired
	private CostRepository costRepository;
	

	@Transactional
	public int addCostData(Cost data) {
		return costRepository.add(data);
	}

   public List<Cost> findByParams(Map<String,Object> condition){
	   List<Cost> result = null;
	   result = costRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateCostData(Cost data){
	   int result = costRepository.update(data);
	   return result;
   }
   public int deleteCostData(Map<String,Object> condition){
	   int result = costRepository.delete(condition);
	   return result;
   }
}
