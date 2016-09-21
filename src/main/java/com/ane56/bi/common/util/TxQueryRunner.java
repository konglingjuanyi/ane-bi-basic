package com.ane56.bi.common.util;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.ane56.bi.port.adapter.utils.PageUtils;
import com.ane56.db.mybatis.core.Pagination;

public class TxQueryRunner extends QueryRunner {

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int[] result = super.batch(con, sql, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
			throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T result = super.query(con, sql, rsh, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}
	
	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		T result = super.query(con, sql, rsh);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int result = super.update(con, sql);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int result = super.update(con, sql, param);
		JdbcUtils.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		int result = super.update(con, sql, params);
		JdbcUtils.releaseConnection(con);
		return result;
	}
	
	public <T> Pagination queryWithPage(String sql, ResultSetHandler<T> rsh,int offset,int limit, Object... params) throws SQLException{
		String sqlPage = "SELECT RESULT.*,ROWNUM RN FROM ( " + sql +" ) RESULT WHERE ROWNUM<=" + PageUtils.getEnd(offset, limit);
		sqlPage = "SELECT * FROM ( " + sqlPage + " ) WHERE RN >" + offset;
		List list = (List) this.query(sqlPage, rsh, params);
		String totalsql = "SELECT COUNT(1) FROM (" + sql + ")"; 
		Map<String,Object> map = this.query(totalsql, new MapHandler(),params);
		Set<String> keys = map.keySet();
		int total = 0;
		for(Entry<String, Object> vo : map.entrySet()){
			BigDecimal big=(BigDecimal) vo.getValue();
			total = big.intValue();
		}
		return new Pagination(list, total, offset, limit);
	}
}
