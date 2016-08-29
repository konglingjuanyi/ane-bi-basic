package com.ane56.bi.g7.dao;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import oracle.sql.DATE;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.ane56.bi.common.util.CommonUtils;
import com.ane56.bi.common.util.DateUtils;
import com.ane56.bi.common.util.TxQueryRunner;
import com.ane56.bi.g7.domain.Classline;
import com.ane56.bi.g7.domain.Test;
import com.sun.org.apache.bcel.internal.generic.NEW;
public class ClasslineDao {
	private QueryRunner qr = new TxQueryRunner();
	

	
	/**
	 * 按bid查询
	 * @param bid
	 * @return
	 * @throws SQLException
	 */
	public Classline findByBid(String bid) throws SQLException {
		String sql = "SELECT * FROM ODS_BDP.ANE_BI_BASIC_CLASSLINE b WHERE b.\"id\"=?";
		// 一行记录中，包含了很多的Classline的属性，还有一个cid属性
		Map<String,Object> map = qr.query(sql, new MapHandler(), bid);
		// 把Map中除了cid以外的其他属性映射到Classline对象中
		Classline classline = CommonUtils.toBean(map, Classline.class);
		return classline;
	}
	/**
	 * 添加班线
	 * @param book
	 * @throws SQLException 
	 */
	public void addClassLine(Classline line) throws SQLException {
		String sql = "INSERT INTO ODS_BDP.ANE_BI_BASIC_CLASSLINE a (a.\"id\","+
	    "a.\"orgroot\", a.\"orgcode\", a.\"orgroot_name\", a.\"orgcode_name\", a.\"deleted\", a.\"code\", a.\"name\","+
		"a.\"startsite\", a.\"endsite\", a.\"startsiteid\", a.\"endsiteid\", a.\"runtime\", a.\"totalmileage\", a.\"startsitecode\"," +
		"a.\"endsitecode\", a.\"is_share\", a.\"startSiteLngLat\", a.\"endSiteLngLat\", a.\"createtime\",a.\"updatetime\")" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)";
		Object[] params = {line.getId(),line.getOrgroot(),line.getOrgcode(),line.getOrgroot_name(),line.getOrgcode_name(),line.getDeleted(),
				line.getCode(),line.getName(),line.getStartsite(),line.getEndsite(),line.getStartsiteid(),line.getEndsiteid(),line.getRuntime(),
				line.getTotalmileage(),line.getStartsitecode(),line.getEndsitecode(),line.getIs_share(),line.getStartSiteLngLat(),line.getEndSiteLngLat()};
		qr.update(sql, params);
	}
	
	public void addTest(Test test){
		/*String sql = "insert into ODS_BDP.TEST b (b.id,b.name,b.age,b.birthday,b.money)"  +
				" values(?,?,?,to_date(?,'SYYYY-MM-DD HH24:MI:SS'),?)";*/
		String sql = "insert into ODS_BDP.TEST b (b.id,b.name,b.age,b.birthday,b.money)"  +
				" values(?,?,?,?,?)";
		Date birthday = test.getBirthday();
		String date = DateUtils.format(birthday, "yyyy-MM-dd hh:mm:ss");
		Object[] params = {test.getId(),test.getName(),test.getAge(),new java.sql.Date(birthday.getTime()),test.getMoney()};
		try {
			qr.update(sql, params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
