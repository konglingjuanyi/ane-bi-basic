package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.KpiBasicDataService;
import com.ane56.bi.common.data.RequestParameter;
import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.common.util.JSONUtils;
import com.ane56.bi.common.util.StringUtils;
import com.ane56.bi.domain.operation.BdpKpiBasisData;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="kpi")
public class KpiBasicDataControll extends ResourceResponseSupport {

	@Autowired
	private KpiBasicDataService kpiBasicDataService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RestResultResponse addKpiData(@RequestBody BdpKpiBasisData data ) {
		
		String kpiNm = data.getKpiNm();
		int result = 0;
		if(!StringUtils.isEmpty(kpiNm)){
			HashMap<String,Object> condition = new HashMap<String,Object>();
			condition.put("kpiNm", kpiNm);
			List<BdpKpiBasisData>  list = kpiBasicDataService.findByParams(condition);
			if(CollectionUtils.isEmpty(list)){
				data.setCrtUserId("34343");
				data.setCrtAppSysId("212121");
				data.setKpiTypeCd("222");
		      result = kpiBasicDataService.addData(data);
			}else{
				result = -1;
			}
		}		
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public RestResultResponse queryKpiData() {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("kpiId", 1);
		List<BdpKpiBasisData> result = kpiBasicDataService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public RestResultResponse deleteKpiData(@RequestBody BdpKpiBasisData data) {
		String kpiId = data.getKpiId();
		int result= 0 ;
		try {
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("kpiId", kpiId);
			result = kpiBasicDataService.deleteData(condition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public RestResultResponse updateKpiData(@RequestBody BdpKpiBasisData data) {		
		int result = kpiBasicDataService.updateData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/queryDataByPage", method = RequestMethod.POST)
	public RestResultResponse queryDataByPage(@RequestBody RequestParameter  parameter) {
		String conditonStr = parameter.getSearch_condition();
		//页码
		int pageNum = parameter.getPageNum();
		//每页记录数
		int pageSize = parameter.getPageSize();
		HashMap condition = JSONUtils.convertJson2Object(conditonStr, HashMap.class);
		Pagination<BdpKpiBasisData> result = kpiBasicDataService.queryDataByPage(condition,pageNum,pageSize);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/get/{type}", method = RequestMethod.GET)
	public RestResultResponse getFileData(@PathVariable("type") String type,HttpServletRequest request) {
		String result= null ;
		try {
			result = kpiBasicDataService.getFileData(type,request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.buildSuccessRestResultResponse(result);
	}
}
