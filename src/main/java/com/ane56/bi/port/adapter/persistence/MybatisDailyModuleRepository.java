package com.ane56.bi.port.adapter.persistence;

import java.util.List;
import java.util.Map;
import com.ane56.bi.domain.operation.DailyModule;
import com.ane56.bi.domain.operation.DailyModuleRepository;

@Component
public class MybatisDailyModuleRepository extends SpringMybatisRepositorySupport implements DailyModuleRepository {

	@Override
	public int add(DailyModule data) {
		int result = this.repository().insert("Opt_DailyModuleDao.add", data);
		return result;
	}

	@Override
	public int update(DailyModule data) {
		int result = this.repository().update("Opt_DailyModuleDao.update", data);		
		return result;
	}

	@Override
	public Pagination<DailyModule> queryAllData(int start, int limit) {
		SqlQuery sqlQuery = new QueryBuilder(DailyModule.class).build();
		Pagination<DailyModule> pageResult = this.repository().query(sqlQuery, start, limit);
		return pageResult;
	}

	@Override
	public List<DailyModule> findByParams(Map<String,Object> condition) {
		List<DailyModule> result = this.repository().query("Opt_DailyModuleDao.findByParams", condition);
		return result;
	}

	@Override
	public int delete(Map<String, Object> condition) {
		int result = this.repository().delete("Opt_DailyModuleDao.delete", condition);
		return result;
	}

}
