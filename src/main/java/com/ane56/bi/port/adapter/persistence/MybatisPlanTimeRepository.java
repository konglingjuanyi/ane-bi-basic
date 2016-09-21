package com.ane56.bi.port.adapter.persistence;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.domain.operation.BdpDstrbPlanOpTime;
import com.ane56.bi.domain.operation.PlanTimeRepository;

@Component
public class MybatisPlanTimeRepository extends SpringMybatisRepositorySupport implements PlanTimeRepository {

	@Override
	public int add(BdpDstrbPlanOpTime data) {
		int result = this.repository().insert("BdpDstrbPlanOpTimeMapper.insert", data);
		return result;
	}

	@Override
	public int update(BdpDstrbPlanOpTime data) {
		int result = this.repository().update("BdpDstrbPlanOpTimeMapper.update", data);		
		return result;
	}

	@Override
	public int delete(Map<String,Object> condition) {
		int result  = this.repository().delete("BdpDstrbPlanOpTimeMapper.delete", condition);
		return result;
	}

	/*@Override
	public PageBean<PlanTime> queryDataByPage(Map<String,Object> paramObject,int offset, int limit) {
		//每页记录数
		Integer total =  (Integer) this.repository().queryBy("BdpDstrbPlanOpTimeMapper.queryPageCount", paramObject);
		Pagination<PlanTime> pageResult= this.repository().queryPage("BdpDstrbPlanOpTimeMapper.queryDataByPage", paramObject, offset, limit);
		List<PlanTime> dataList = pageResult.getResult();
		
		 * 5. 创建PageBean，设置参数
		 
		PageBean<PlanTime> pb = new PageBean<PlanTime>();
		
		 * 其中PageBean没有url，这个任务由Servlet完成
		 
		pb.setBeanList(dataList);
		pb.setTotal(total);
		return pb;
	}*/
	@Override
	public PageBean<BdpDstrbPlanOpTime> queryDataByPage(Map<String,Object> searchMap,int offset, int limit) {
		 PageBean<BdpDstrbPlanOpTime> pageList = null;
		try {
			pageList = this.queryPagedList("BdpDstrbPlanOpTimeMapper", BdpDstrbPlanOpTime.class, searchMap, offset, limit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageList;
	}
	@Override
	public List<BdpDstrbPlanOpTime> findByParams(Map<String,Object> condition) {
		List<BdpDstrbPlanOpTime> result = this.repository().query("BdpDstrbPlanOpTimeMapper.findByParams", condition);
		return result;
	}

}
