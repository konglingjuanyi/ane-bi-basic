package com.ane56.bi.port.adapter.web.resource.operate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.BdpG7DstrbMapngService;
import com.ane56.bi.common.data.RequestParameter;
import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.common.util.JSONUtils;
import com.ane56.bi.domain.operation.BdpG7DstrbMapng;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;

@RestController
@RequestMapping(value="module")
public class BdpG7DstrbMapngControll extends ResourceResponseSupport {

	@Autowired
	private BdpG7DstrbMapngService bdpG7DstrbMapngService;

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public RestResultResponse deleteData(@RequestBody BdpG7DstrbMapng data) {
		String dstrbNm = data.getDstrbNm();
		int result= 0 ;
			try {
				HashMap<String,Object> condition = new HashMap<String,Object>();
				condition.put("dstrbNm", dstrbNm);
				result = bdpG7DstrbMapngService.deleteData(condition);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/query",method = RequestMethod.POST)
	public RestResultResponse queryData() {
		HashMap<String,Object> condition = new HashMap<String,Object>();
		List<BdpG7DstrbMapng> result = bdpG7DstrbMapngService.findByParams(condition);
		return this.buildSuccessRestResultResponse(result);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public RestResultResponse updateData(@RequestBody BdpG7DstrbMapng data) {
		int result = bdpG7DstrbMapngService.updateData(data);
		return this.buildSuccessRestResultResponse(result);
	}
	@RequestMapping(value = "/queryDataByPage", method = RequestMethod.POST)
	public RestResultResponse queryDataByPage(@RequestBody RequestParameter  parameter) {
		String conditonStr = parameter.getSearch_condition();
		//页码
		int pageNum = parameter.getPageNum();
		//每页记录数
		int pageSize = parameter.getPageSize();
		HashMap<String, Object> condition = JSONUtils.convertJson2Object(conditonStr, HashMap.class);
		Pagination<BdpG7DstrbMapng> result = bdpG7DstrbMapngService.queryDataByPage(condition,pageNum,pageSize);
		return this.buildSuccessRestResultResponse(result);
	}
}
