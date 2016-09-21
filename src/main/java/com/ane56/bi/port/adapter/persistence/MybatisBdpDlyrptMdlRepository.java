package com.ane56.bi.port.adapter.persistence;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.ane56.bi.common.pager.Pagination;
import com.ane56.bi.domain.operation.BdpDlyrptMdl;
import com.ane56.bi.domain.operation.BdpDlyrptMdlRepository;
import com.github.pagehelper.PageHelper;

@Component
public class MybatisBdpDlyrptMdlRepository extends SpringMybatisRepositorySupport implements BdpDlyrptMdlRepository {

	@Override
	public int add(BdpDlyrptMdl data) {
		int result = this.repository().insert("BdpDlyrptMdlMapper.insert", data);
		return result;
	}

	@Override
	public int update(BdpDlyrptMdl data) {
		int result = this.repository().update("BdpDlyrptMdlMapper.update", data);		
		return result;
	}

	@Override
	public int delete(Map<String,Object> condition) {
		int result  = this.repository().delete("BdpDlyrptMdlMapper.delete", condition);
		return result;
	}
	@Override
	public Pagination<BdpDlyrptMdl> queryDataByPage(Map<String,Object> searchMap,int pageNum,int pageSize) {
		Pagination<BdpDlyrptMdl> pageList =  new Pagination<BdpDlyrptMdl>();
		try {
			int offset = (pageNum-1)*pageSize;
			int limit = pageSize;
			Integer total =  (Integer) this.repository().queryBy("BdpDlyrptMdlMapper.queryPagedCount", searchMap);
			PageHelper.startPage(pageNum, pageSize); 	
			List<BdpDlyrptMdl> result = this.repository().query("BdpDlyrptMdlMapper.queryPagedList", searchMap);
			pageList.setResult(result);
			pageList.setCurrent(pageNum);
			pageList.setLimit(limit);
			pageList.setOffset(offset);
			pageList.setTotal(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageList;
	};
	@Override
	public List<BdpDlyrptMdl> findByParams(Map<String,Object> condition) {
		List<BdpDlyrptMdl> result = this.repository().query("BdpDlyrptMdlMapper.findByParams", condition);
		return result;
	}

}
