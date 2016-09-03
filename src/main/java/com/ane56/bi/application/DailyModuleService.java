package com.ane56.bi.application;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.DailyModule;
import com.ane56.bi.domain.operation.DailyModuleRepository;

@Service
public class DailyModuleService extends AssertionConcern {

	@Autowired
	private DailyModuleRepository dailyModuleRepository;
	

	@Transactional
	public int addDailyModuleData(DailyModule data) {
		return dailyModuleRepository.add(data);
	}

   public List<DailyModule> findByParams(Map<String,Object> condition){
	   List<DailyModule> result = null;
	   result = dailyModuleRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateDailyModuleData(DailyModule data){
	   int result = dailyModuleRepository.update(data);
	   return result;
   }
   public int deleteDailyModuleData(Map<String,Object> condition){
	   int result = dailyModuleRepository.delete(condition);
	   return result;
   }
}
