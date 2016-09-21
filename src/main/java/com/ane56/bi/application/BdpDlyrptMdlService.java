package com.ane56.bi.application;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.BdpDlyrptMdl;
import com.ane56.bi.domain.operation.BdpDlyrptMdlRepository;

@Service
public class BdpDlyrptMdlService extends AssertionConcern {

	@Autowired
   private BdpDlyrptMdlRepository bdpDlyrptMdlRepository;
	@Transactional
	public int addData(BdpDlyrptMdl data) {
		data.setCrtTime(new Date());
		return bdpDlyrptMdlRepository.add(data);
	}

	public int deleteData(Map<String, Object> condition) {
		int result = bdpDlyrptMdlRepository.delete(condition);
		return result;
	}
	
   public List<BdpDlyrptMdl> findByParams(Map<String,Object> condition){
	   List<BdpDlyrptMdl> result = null;
	   result = bdpDlyrptMdlRepository.findByParams(condition);
	   return result;
   }
   @Transactional
   public int updateData(BdpDlyrptMdl data){
	   int result = bdpDlyrptMdlRepository.update(data);
	   return result;
   }

   public Pagination<BdpDlyrptMdl> queryDataByPage(Map<String, Object> paramObject, int pageNum, int pageSize){
	   Pagination<BdpDlyrptMdl> result = null;
	   result = bdpDlyrptMdlRepository.queryDataByPage(paramObject,pageNum, pageSize);
	   return result;
   }
   
}
