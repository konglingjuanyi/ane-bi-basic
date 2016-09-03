package com.ane56.bi.g7.dao;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.ane56.bi.common.util.CommonUtils;
import com.ane56.bi.common.util.DateUtils;
import com.ane56.bi.common.util.TxQueryRunner;
import com.ane56.bi.g7.domain.Classline;
import com.ane56.bi.g7.domain.PassInfoData;
import com.ane56.bi.g7.domain.Test;
public class ClasslineDao {
	private QueryRunner qr = new TxQueryRunner();
	

	
	/**
	 * 按id查询班线信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Classline findClassLineByBid(String id) throws SQLException {
		Classline classline = null;
		String sql = "SELECT * FROM ODS_BDP.ANE_BI_BASIC_CLASSLINE b WHERE b.\"id\"=?";
		// 一行记录中，包含了很多的Classline的属性，还有一个id属性
		Map<String,Object> map = qr.query(sql, new MapHandler(), id);
		if(map == null){
			return classline;
		}else{
			// 把Map中除了id以外的其他属性映射到Classline对象中
			classline = CommonUtils.toBean(map, Classline.class);
			return classline;
		}
	}
	/**
	 * 添加passInfo
	 * @param book
	 * @throws SQLException 
	 */
	public boolean addPassInfoData(PassInfoData passInfo) throws SQLException {
		String sql = "INSERT INTO ODS_BDP.ANE_BI_BASIC_PASSINFO a (a.\"id\","+
		"a.\"orgroot\", a.\"lineid\", a.\"siteid\", a.\"order\", a.\"runtime\","+
		"a.\"staytime\", a.\"szflag\", a.\"tomiles\", a.\"name\", a.\"lat\", a.\"lng\", a.\"passSiteLngLat\",a.\"classLineId\")"+
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {passInfo.getId(),passInfo.getOrgroot(),passInfo.getLineid(),passInfo.getSiteid(),
				passInfo.getOrder(),passInfo.getRuntime(),passInfo.getStaytime(),passInfo.getSzflag(),passInfo.getTomiles(),
				passInfo.getName(),passInfo.getLat(),passInfo.getLng(),passInfo.getPassSiteLngLat(),passInfo.getClasslineId()};
		int result = qr.update(sql, params);
		if(result==1){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 按id查询passInfo
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public PassInfoData findPassInfoByBid(String id) throws SQLException {
		PassInfoData passInfo = null;
		String sql = "SELECT * FROM ODS_BDP.ANE_BI_BASIC_PASSINFO b WHERE b.\"id\"=?";
		// 一行记录中，包含了很多的Classline的属性，还有一个id属性
		Map<String,Object> map = qr.query(sql, new MapHandler(), id);
		if(map==null){
			return passInfo;
		}else{
			// 把Map中除了cid以外的其他属性映射到Classline对象中
			passInfo = CommonUtils.toBean(map, PassInfoData.class);
			return passInfo;
		}
	}
	
	/**
	 * 添加班线
	 * @param book
	 * @throws SQLException 
	 */
	public boolean addClassLine(Classline line) throws SQLException {
		String sql = "INSERT INTO ODS_BDP.ANE_BI_BASIC_CLASSLINE a (a.\"id\","+
	    "a.\"orgroot\", a.\"orgcode\", a.\"orgroot_name\", a.\"orgcode_name\", a.\"deleted\", a.\"code\", a.\"name\","+
		"a.\"startsite\", a.\"endsite\", a.\"startsiteid\", a.\"endsiteid\", a.\"runtime\", a.\"totalmileage\", a.\"startsitecode\"," +
		"a.\"endsitecode\", a.\"is_share\", a.\"startSiteLngLat\", a.\"endSiteLngLat\", a.\"createtime\",a.\"updatetime\")" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)";
		Object[] params = {line.getId(),line.getOrgroot(),line.getOrgcode(),line.getOrgroot_name(),line.getOrgcode_name(),line.getDeleted(),
				line.getCode(),line.getName(),line.getStartsite(),line.getEndsite(),line.getStartsiteid(),line.getEndsiteid(),line.getRuntime(),
				line.getTotalmileage(),line.getStartsitecode(),line.getEndsitecode(),line.getIs_share(),line.getStartSiteLngLat(),line.getEndSiteLngLat()};
		int result = qr.update(sql, params);
		if(result==1){
			return true;
		}else{
			return false;
		}
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
