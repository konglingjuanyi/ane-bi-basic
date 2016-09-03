package com.ane56.bi.port.adapter.persistence;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.ane56.bi.domain.operation.TargetCost;
import com.ane56.bi.domain.operation.TargetCostRepository;
import com.ane56.db.mybatis.core.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;
import com.ane56.db.mybatis.query.SqlQuery;

@Component
public class MybatisTargetCostRepository extends SpringMybatisRepositorySupport implements TargetCostRepository {

	@Override
	public int add(TargetCost data) {
		int result = this.repository().insert("Opt_TargetCostDao.add", data);
		return result;
	}

	@Override
	public int update(TargetCost data) {
		int result = this.repository().update("Opt_TargetCostDao.update", data);		
		return result;
	}

	@Override
	public Pagination<TargetCost> queryAllData(int start, int limit) {
		SqlQuery sqlQuery = new QueryBuilder(TargetCost.class).build();
		Pagination<TargetCost> pageResult = this.repository().query(sqlQuery, start, limit);
		return pageResult;
	}

	@Override
	public List<TargetCost> findByParams(Map<String,Object> condition) {
		List<TargetCost> result = this.repository().query("Opt_TargetCostDao.findByParams", condition);
		return result;
	}

	@Override
	public int delete(Map<String, Object> condition) {
		int result = this.repository().delete("Opt_TargetCostDao.delete", condition);
		return result;
	}

}
