package com.ane56.bi.application;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.common.util.JSONUtils;
import com.ane56.bi.common.util.MyFileFilter;
import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.operation.BdpDlyrptMdl;
import com.ane56.bi.domain.operation.BdpKpiBasisData;
import com.ane56.bi.domain.operation.KpiBasicDataRepository;

@Service
public class KpiBasicDataService extends AssertionConcern {

	@Autowired
	private KpiBasicDataRepository kpiBasicDataRepository;

	@Transactional
	public int addData(BdpKpiBasisData data) {
		data.setCrtTime(new Date());
		return kpiBasicDataRepository.add(data);
	}

	public int deleteData(Map<String, Object> condition) {
		int result = kpiBasicDataRepository.delete(condition);
		return result;
	}

	public List<BdpKpiBasisData> findByParams(Map<String, Object> condition) {
		List<BdpKpiBasisData> result = null;
		result = kpiBasicDataRepository.findByParams(condition);
		return result;
	}

	@Transactional
	public int updateData(BdpKpiBasisData data) {
		data.setModfTime(new Date());
		int result = kpiBasicDataRepository.update(data);
		return result;
	}

	 public Pagination<BdpKpiBasisData> queryDataByPage(Map<String, Object> paramObject, int pageNum, int pageSize){
		   Pagination<BdpKpiBasisData> result = null;
		   result = kpiBasicDataRepository.queryDataByPage(paramObject,pageNum, pageSize);
		   return result;
	   }
	public String getFileData(String type,HttpServletRequest request) throws Exception{
		    String path =  request.getSession().getServletContext().getRealPath("") ;
		    System.out.println("web目录是："+path);
		    String  parent = new File(path).getParent();
		    System.out.println("上级目录是："+path);
		    ArrayList<String> fileList = new ArrayList<String>();
	        MyFileFilter.filterfile(path,path,type, fileList);
	        List<String> list = MyFileFilter.getObjlist();
	        String str = JSONUtils.convertObject2Json(list);
	        MyFileFilter.getObjlist().clear();
	        System.out.println("执行完成!");
	        return str;
	}
}
