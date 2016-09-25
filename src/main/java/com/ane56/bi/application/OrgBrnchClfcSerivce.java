package com.ane56.bi.application;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.basic.OrgBrnchClfc;
import com.ane56.bi.domain.basic.OrgBrnchClfcRepository;
import com.ane56.bi.domain.basic.OrgBrnchClfcVO;
import com.ane56.bi.port.adapter.utils.Constants;
import com.ane56.db.mybatis.core.Pagination;
/**
 * 
 * @author 张一波
 *
 */
@Service
public class OrgBrnchClfcSerivce extends AssertionConcern{
	@Autowired
	private OrgBrnchClfcRepository orgBrnchClfcRepository;
	
	public final static Map mapType = new HashMap();// 分拨类型 
	static {  
		mapType.put("30", "网络");
		mapType.put("20", "运营");
		mapType.put("10", "综合");
	} 
	public final static Map mapDtld = new HashMap();// 分拨功能
	static {  
		mapDtld.put("121", "集散");
		mapDtld.put("122", "枢纽");
		mapDtld.put("123", "转运");
	} 
	/**
	 * 分页查询分拨属性
	 * @param paramObject
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Pagination<OrgBrnchClfcVO> getOrgBrnchClfc(Map<String,Object> paramObject,int offset, int limit){
		Pagination<OrgBrnchClfcVO> pageData =  orgBrnchClfcRepository.getOrgBrnchClfc(paramObject, offset, limit);
		for(OrgBrnchClfcVO vo : pageData.getResult()){
			if(StringUtils.isNoneBlank(vo.getStatFlag())){
				if(vo.getStatFlag().equals(Constants.STAT_FLAG_YES)){//是否统计
					vo.setStatFlagStr("是");
				}else if(vo.getStatFlag().equals(Constants.STAT_FLAG_NO)){
					vo.setStatFlagStr("否");
				}
			}
			if(mapType.containsKey(vo.getClfcTypeCd())){// 设置分拨类型
				vo.setClfcTypeCdStr((String) mapType.get(vo.getClfcTypeCd()));;
			}
			if(mapDtld.containsKey(vo.getClfcDtldCd())){// 设置分拨功能
				vo.setClfcDtldCdStr((String) mapDtld.get(vo.getClfcDtldCd()));;
			}
		}
		return pageData;
	}
	/**
	 * 更新分拨属性
	 * @return
	 */
	public int updateOrgBrnchClfc(OrgBrnchClfc entity){
		return orgBrnchClfcRepository.update(entity);
	}
}
