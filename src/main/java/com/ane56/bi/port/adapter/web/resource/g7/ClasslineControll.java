package com.ane56.bi.port.adapter.web.resource.g7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
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
@RequestMapping(value="g7")
public class ClasslineControll  extends ResourceResponseSupport{

	private ClasslineService classlineService = new ClasslineService();
	
	@RequestMapping(value = "/sync", method = RequestMethod.GET)
	public int insertG7DataToDB() {
     PageResult pageResult=null;
     G7QueryVO g7Vo = new G7QueryVO();
     int res = 0;
	 for(int i=1;i<110;i++){
		ApiResult result  = null;
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		ObjectMapper mapper = new ObjectMapper();
		//String data1 = DateUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss");		
			g7Vo.setPageNo(i);
			g7Vo.setPageSize(50);
			//g7Vo.setOrgnum("20009E");
			//g7Vo.setUpdatetimeLe("2016-07-02 10:48:18");
			//g7Vo.setUpdatetimeGe("2016-06-01 10:48:18");
			//g7Vo.setPathid(0);
			//g7Vo.setDeleted(2);
			g7Vo.setIs_passall("1");
			g7Vo.setIs_share("0");
			try {
				paramsMap.put("data", mapper.writeValueAsString(g7Vo));
				result = ApiUtil.getResult("classline.postline.getPostLineInfo", paramsMap);
				Object objData = result.getData();
				System.out.println(objData);
				pageResult = convertResultToList(objData);
				boolean rest = classlineService.addClassLine(pageResult);
				System.out.println("成功新增第"+i+"页数据!");
				if(rest){
					res =  i;
					System.out.println("成功新增第"+i+"页数据!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	};
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
			g7List.add(g7DataBean);
			Object passInfoObj = g7DataBean.getPassinfo();
			if(passInfoObj !=null){
				String str = passInfoObj.toString();
				if(!"{}".equals(str)){
					passInfoArray = JSON.parseArray(passInfoObj.toString());
					for(int j=0;j<passInfoArray.size();j++){
						Object passObj = passInfoArray.get(j);
						PassInfoData passInfoData = JSON.parseObject(passObj.toString(), PassInfoData.class);
						passInfoList.add(passInfoData);
					}
					g7DataBean.setPassinfoList(passInfoList);
				}
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
