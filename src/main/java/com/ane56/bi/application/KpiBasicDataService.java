package com.ane56.bi.application;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.KpiBasicData;
import com.ane56.bi.domain.operation.KpiBasicDataRepository;

@Service
public class KpiBasicDataService extends AssertionConcern {

	@Autowired
	private KpiBasicDataRepository kpiBasicDataRepository;
	

	@Transactional
	public int addKpiData(KpiBasicData data) {
		return kpiBasicDataRepository.add(data);
	}

   public List<KpiBasicData> findByParams(Map<String,Object> condition){
	   List<KpiBasicData> result = null;
	   result = kpiBasicDataRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateKpiData(KpiBasicData data){
	   int result = kpiBasicDataRepository.update(data);
	   return result;
   }

   public PageBean<KpiBasicData> queryDataByPage(Map<String,Object> paramObject,int offset, int limit){
	   PageBean<KpiBasicData> result = null;
	   result = kpiBasicDataRepository.queryDataByPage(paramObject,offset,limit);
	   return result;
   }
   
}
