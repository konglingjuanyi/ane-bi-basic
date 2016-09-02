package com.ane56.bi.port.adapter.persistence;

import java.util.List;
import java.util.Map;
import com.ane56.bi.domain.operation.Cost;
import com.ane56.bi.domain.operation.CostRepository;

@Component
public class MybatisCostRepository extends SpringMybatisRepositorySupport implements CostRepository {

	@Override
	public int add(Cost data) {
		int result = this.repository().insert("Opt_CostDao.add", data);
		return result;
	}

	@Override
	public int update(Cost data) {
		int result = this.repository().update("Opt_CostDao.update", data);		
		return result;
	}

	@Override
	public Pagination<Cost> queryAllData(int start, int limit) {
		SqlQuery sqlQuery = new QueryBuilder(Cost.class).build();
		Pagination<Cost> pageResult = this.repository().query(sqlQuery, start, limit);
		return pageResult;
	}

	@Override
	public List<Cost> findByParams(Map<String,Object> condition) {
		List<Cost> result = this.repository().query("Opt_CostDao.findByParams", condition);
		return result;
	}

	@Override
	public int delete(Map<String, Object> condition) {
		int result = this.repository().delete("Opt_CostDao.delete", condition);
		return result;
	}

}
