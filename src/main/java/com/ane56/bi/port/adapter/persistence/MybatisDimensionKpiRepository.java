package com.ane56.bi.port.adapter.persistence;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.ane56.bi.domain.operation.DimensionKpi;
import com.ane56.bi.domain.operation.DimensionKpiRepository;
import com.ane56.db.mybatis.core.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;
import com.ane56.db.mybatis.query.SqlQuery;

@Component
public class MybatisDimensionKpiRepository extends SpringMybatisRepositorySupport implements DimensionKpiRepository {

	@Override
	public int add(DimensionKpi data) {
		int result = this.repository().insert("Opt_DimensionKpiDao.add", data);
		return result;
	}

	@Override
	public int update(DimensionKpi data) {
		int result = this.repository().update("Opt_DimensionKpiDao.update", data);		
		return result;
	}

	@Override
	public int delete(DimensionKpi data) {
		int result  = this.repository().delete("Opt_DimensionKpiDao.delete", data);
		return result;
	}

	@Override
	public Pagination<DimensionKpi> queryAllData(int start, int limit) {
		SqlQuery sqlQuery = new QueryBuilder(DimensionKpi.class).build();
		Pagination<DimensionKpi> pageResult = this.repository().query(sqlQuery, start, limit);
		return pageResult;
	}

	@Override
	public List<DimensionKpi> findByParams(Map<String,Object> condition) {
		List<DimensionKpi> result = this.repository().query("Opt_DimensionKpiDao.findByParams", condition);
		return result;
	}

}
