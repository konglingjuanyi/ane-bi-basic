package com.ane56.bi.application;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.BdpG7DstrbMapng;
import com.ane56.bi.domain.operation.BdpG7DstrbMapngRepository;

@Service
public class BdpG7DstrbMapngService extends AssertionConcern {

	@Autowired
   private BdpG7DstrbMapngRepository bdpG7DstrbMapngRepository;
	@Transactional
	public int addData(BdpG7DstrbMapng data) {
		data.setCrtTime(new Date());
		return bdpG7DstrbMapngRepository.add(data);
	}

	public int deleteData(Map<String, Object> condition) {
		int result = bdpG7DstrbMapngRepository.delete(condition);
		return result;
	}
	
   public List<BdpG7DstrbMapng> findByParams(Map<String,Object> condition){
	   List<BdpG7DstrbMapng> result = null;
	   result = bdpG7DstrbMapngRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateData(BdpG7DstrbMapng data){
	   int result = bdpG7DstrbMapngRepository.update(data);
	   return result;
   }

   public Pagination<BdpG7DstrbMapng> queryDataByPage(Map<String, Object> paramObject, int pageNum, int pageSize){
	   Pagination<BdpG7DstrbMapng> result = null;
	   result = bdpG7DstrbMapngRepository.queryDataByPage(paramObject,pageNum, pageSize);
	   return result;
   }
   
}
