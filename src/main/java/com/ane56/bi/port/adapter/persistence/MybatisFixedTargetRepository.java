package com.ane56.bi.port.adapter.persistence;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.ane56.bi.common.pager.PageBean;
import com.ane56.bi.domain.operation.BdpTgtVal;
import com.ane56.bi.domain.operation.FixedTargetRepository;

@Component
public class MybatisFixedTargetRepository extends SpringMybatisRepositorySupport implements FixedTargetRepository {

	@Override
	public int add(BdpTgtVal data) {
		int result = this.repository().insert("Opt_FixedTargetDao.add", data);
		return result;
	}

	@Override
	public int update(BdpTgtVal data) {
		int result = this.repository().update("Opt_FixedTargetDao.update", data);		
		return result;
	}

	@Override
	public int delete(BdpTgtVal data) {
		int result  = this.repository().delete("Opt_FixedTargetDao.delete", data);
		return result;
	}

	/*@Override
	public PageBean<BdpTgtVal> queryDataByPage(Map<String,Object> paramObject,int offset, int limit) {
		//每页记录数
		Integer total =  (Integer) this.repository().queryBy("Opt_FixedTargetDao.queryPageCount", paramObject);
		Pagination<BdpTgtVal> pageResult= this.repository().queryPage("Opt_FixedTargetDao.queryDataByPage", paramObject, offset, limit);
		List<BdpTgtVal> dataList = pageResult.getResult();
		
		 * 5. 创建PageBean，设置参数
		 
		PageBean<BdpTgtVal> pb = new PageBean<BdpTgtVal>();
		
		 * 其中PageBean没有url，这个任务由Servlet完成
		 
		pb.setBeanList(dataList);
		pb.setTotal(total);
		return pb;
	}*/
	@Override
	public PageBean<BdpTgtVal> queryDataByPage(Map<String,Object> searchMap,int offset, int limit) {
		 PageBean<BdpTgtVal> pageList = null;
		try {
			pageList = this.queryPagedList("Opt_FixedTargetDao", BdpTgtVal.class, searchMap, offset, limit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageList;
	}
	@Override
	public List<BdpTgtVal> findByParams(Map<String,Object> condition) {
		List<BdpTgtVal> result = this.repository().query("Opt_FixedTargetDao.findByParams", condition);
		return result;
	}

}
