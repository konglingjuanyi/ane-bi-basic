package com.ane56.bi.application;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.DimensionKpi;
import com.ane56.bi.domain.operation.DimensionKpiRepository;

@Service
public class DimensionKpiService extends AssertionConcern {

	@Autowired
	private DimensionKpiRepository DimensionKpiRepository;
	

	@Transactional
	public int addDimensionKpiData(DimensionKpi data) {
		return DimensionKpiRepository.add(data);
	}

   public List<DimensionKpi> findByParams(Map<String,Object> condition){
	   List<DimensionKpi> result = null;
	   result = DimensionKpiRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateDimensionKpiData(DimensionKpi data){
	   int result = DimensionKpiRepository.update(data);
	   return result;
   }

   public int deleteDimensionKpiData(Map<String,Object> condition){
	   int result = DimensionKpiRepository.delete(condition);
	   return result;
   }
	/** 
	 * 导出权限对象属性信息
	 */
	public List<Map<String, Object>> exportEntities(Map<String,Object> condition){
		return DimensionKpiRepository.exportEntities(condition);
	}
}
