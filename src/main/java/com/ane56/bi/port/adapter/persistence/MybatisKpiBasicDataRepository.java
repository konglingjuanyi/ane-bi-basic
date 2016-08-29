package com.ane56.bi.port.adapter.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ane56.bi.domain.operation.KpiBasicData;
import com.ane56.bi.domain.operation.KpiBasicDataRepository;
import com.ane56.db.mybatis.core.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;
import com.ane56.db.mybatis.query.SqlQuery;

@Component
public class MybatisKpiBasicDataRepository extends SpringMybatisRepositorySupport implements KpiBasicDataRepository {

	@Override
	public int add(KpiBasicData data) {
		int result = this.repository().insert("Opt_KpiBasicDataDao.add", data);
		return result;
	}

	@Override
	public int update(KpiBasicData data) {
		int result = this.repository().update("Opt_KpiBasicDataDao.update", data);		
		return result;
	}

	@Override
	public int delete(KpiBasicData data) {
		int result  = this.repository().delete("Opt_KpiBasicDataDao.delete", data);
		return result;
	}

	@Override
	public Pagination<KpiBasicData> queryAllData(int start, int limit) {
		SqlQuery sqlQuery = new QueryBuilder(KpiBasicData.class).build();
		Pagination<KpiBasicData> pageResult = this.repository().query(sqlQuery, start, limit);
		return pageResult;
	}

	@Override
	public List<KpiBasicData> findByParams(Map<String,Object> condition) {
		List<KpiBasicData> result = this.repository().query("Opt_KpiBasicDataDao.findByParams", condition);
		return result;
	}

}
