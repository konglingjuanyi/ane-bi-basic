package com.ane56.bi.port.adapter.web.resource.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ane56.bi.application.OrgBrnchClfcSerivce;
import com.ane56.bi.domain.basic.OrgBrnchClfc;
import com.ane56.bi.domain.basic.OrgBrnchClfcVO;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
import com.ane56.bi.port.adapter.rest.RestResultResponse;
import com.ane56.bi.port.adapter.utils.Constants;
import com.ane56.bi.port.adapter.utils.DecodeUtils;
import com.ane56.bi.port.adapter.utils.PageUtils;
import com.ane56.db.mybatis.core.Pagination;
/**
 * 分拨属性管理控制层
 * @author zhangyibo
 *
 */
@RestController
public class OrgBrnchClfcController extends ResourceResponseSupport{
	
	@Autowired
	private OrgBrnchClfcSerivce orgBrnchClfcSerivce;
	
	/**
	 * 分页查询分拨属性
	 * @param page
	 * @param size
	 * @param siteName
	 * @return
	 */
	@RequestMapping(value = "/api/getOrgBrnchClfc", method = RequestMethod.GET)
	public RestResultResponse getOrgBrnchClfc(@RequestParam(value = "p", required = false, defaultValue = "1") int page,
			@RequestParam(value = "s", required = false, defaultValue = "10") int size
			,@RequestParam(value = "siteName", required = false) String siteName
			,@RequestParam(value = "statFlag", required = false) String statFlag){
		siteName = DecodeUtils.encodeStr(siteName);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("siteName", siteName);
		condition.put("statFlag", statFlag);
		Pagination<OrgBrnchClfcVO> pageData = orgBrnchClfcSerivce.getOrgBrnchClfc(condition, PageUtils.getOffset(page, size),size);
		return this.buildSuccessRestResultResponse(pageData);
	}
	/**
	 * 更新分拨属性
	 * @param orgBrnchClfc
	 * @return
	 */
	@RequestMapping(value = "/api/updateOrgBrnchClfc", method = RequestMethod.PUT)
	public RestResultResponse updateOrgBrnchClfc(@RequestBody OrgBrnchClfc entity){
		int	result = orgBrnchClfcSerivce.updateOrgBrnchClfc(entity);
		return this.buildSuccessRestResultResponse(result);
	}
	
}
