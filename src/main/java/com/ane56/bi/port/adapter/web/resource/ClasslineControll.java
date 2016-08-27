package com.ane56.bi.port.adapter.web.resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ane56.bi.common.ApiResult;
import com.ane56.bi.common.ApiUtil;
import com.ane56.bi.g7.domain.Classline;
import com.ane56.bi.g7.domain.G7QueryVO;
import com.ane56.bi.g7.domain.PageResult;
import com.ane56.bi.g7.domain.PassInfoData;
import com.ane56.bi.g7.service.ClasslineService;
import com.ane56.bi.port.adapter.rest.ResourceResponseSupport;
@RestController
public class ClasslineControll  extends ResourceResponseSupport{

	private ClasslineService classlineService = new ClasslineService();
	
	@RequestMapping(value = "/api/g7", method = RequestMethod.GET)
	public  boolean insertG7DataToDB() {
		PageResult pageResult=null;
		G7QueryVO g7Vo = new G7QueryVO();
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		ObjectMapper mapper = new ObjectMapper();
		g7Vo.setPageNo("1");
		g7Vo.setPageSize("100");
		g7Vo.setIs_passall("1");
		g7Vo.setIs_share("0");
		//g7Vo.setId("8620253B0B267EF55CE41CFDBDA7B4B3");
		try {
			paramsMap.put("data", mapper.writeValueAsString(g7Vo));
			ApiResult result = ApiUtil.getResult("classline.postline.getPostLineInfo", paramsMap);
			Object objData = result.getData();
			System.out.println(objData);
			pageResult = convertResultToList(objData);
			classlineService.addClassLine(pageResult);
			//classlineService.findByBid("144");
			/*Test test = new Test();
			test.setId(222);
			test.setName("yangdechao");
			test.setAge(22);
			test.setMoney(88.0);
			test.setBirthday(new Date());
			classlineService.addTest(test);*/
			/*if (result.getCode() == 0) {
				System.out.println(result);
				
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	};
	public boolean insertData(PageResult pageResult){
		if(pageResult!=null){
			List<Classline> list = pageResult.getResult();
			if(!CollectionUtils.isEmpty(list)){
				for(int i=0;i<list.size();i++){
					Classline g7Bean= list.get(i);
				}
			}
		}
		
		return true;
	}
	public static PageResult convertResultToList(Object obj){
		PageResult pageResult = new PageResult();
		List<Classline> g7List = new ArrayList<Classline>();
		JSONArray jsonArray = null;
		JSONObject json = (JSONObject) JSON.toJSON(obj);
		Object obj2 = json.get("result");	
		int pageNo = (int) json.get("pageNo");
		boolean autoCount =(boolean) json.get("autoCount");
		int pageSize = (int) json.get("pageSize");
		String pk = (String) json.get("pk");
		String totalCount =(String) json.get("totalCount");
		jsonArray = JSON.parseArray(obj2.toString());
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONArray passInfoArray = null;
			List<PassInfoData> passInfoList = new ArrayList<PassInfoData>();
			Object obj3 = jsonArray.get(i);
			Classline g7DataBean = JSON.parseObject(obj3.toString(),Classline.class);
			Object passInfoObj = g7DataBean.getPassinfo();
			String str = passInfoObj.toString();
			if(!"{}".equals(str)){
				passInfoArray = JSON.parseArray(passInfoObj.toString());
				for(int j=0;j<passInfoArray.size();j++){
					Object passObj = passInfoArray.get(j);
					PassInfoData passInfoData = JSON.parseObject(passObj.toString(), PassInfoData.class);
					passInfoList.add(passInfoData);
				}
				g7DataBean.setPassinfoList(passInfoList);
				g7List.add(g7DataBean);
			}
		}
		pageResult.setPageNo(pageNo);
		pageResult.setPageSize(pageSize);
		pageResult.setPk(pk);
		pageResult.setAutoCount(autoCount);
		pageResult.setTotalCount(totalCount);
		pageResult.setResult(g7List);
		
		return pageResult;
	};
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis(); 
		//insertG7DataToDB();
		System.out.println(System.currentTimeMillis() - start);
	}
}
