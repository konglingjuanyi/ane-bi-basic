package com.ane56.bi.common.util;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * 浣跨敤鏈被鐨勬柟娉曪紝蹇呴』鎻愪緵c3p0-copnfig.xml鏂囦欢
 * @author qdmmy6
 */
public class JdbcUtils {
	// 楗挎眽寮�
	private static DataSource ds = new ComboPooledDataSource();
	
	/**
	 * 瀹冧负null琛ㄧず娌℃湁浜嬪姟
	 * 瀹冧笉涓簄ull琛ㄧず鏈変簨鍔�
	 * 褰撳紑鍚簨鍔℃椂锛岄渶瑕佺粰瀹冭祴鍊�
	 * 褰撶粨鏉熶簨鍔℃椂锛岄渶瑕佺粰瀹冭祴鍊间负null
	 * 骞朵笖鍦ㄥ紑鍚簨鍔℃椂锛岃dao鐨勫涓柟娉曞叡浜繖涓狢onnection
	 */
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	/**
	 * dao浣跨敤鏈柟娉曟潵鑾峰彇杩炴帴
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		/*
		 * 濡傛灉鏈変簨鍔★紝杩斿洖褰撳墠浜嬪姟鐨刢on
		 * 濡傛灉娌℃湁浜嬪姟锛岄�杩囪繛鎺ユ睜杩斿洖鏂扮殑con
		 */
		Connection con = tl.get();//鑾峰彇褰撳墠绾跨▼鐨勪簨鍔¤繛鎺�
		if(con != null) return con;
		return ds.getConnection();
	}
	
	/**
	 * 寮�惎浜嬪姟
	 * @throws SQLException 
	 */
	public static void beginTransaction() throws SQLException {
		Connection con = tl.get();//鑾峰彇褰撳墠绾跨▼鐨勪簨鍔¤繛鎺�
		if(con != null) throw new SQLException("Connection is null!");
		con = ds.getConnection();//缁檆on璧嬪�锛岃〃绀哄紑鍚簡浜嬪姟
		con.setAutoCommit(false);//璁剧疆涓烘墜鍔ㄦ彁浜�
		tl.set(con);//鎶婂綋鍓嶄簨鍔¤繛鎺ユ斁鍒皌l涓�
	}
	
	/**
	 * 鎻愪氦浜嬪姟
	 * @throws SQLException 
	 */
	public static void commitTransaction() throws SQLException {
		Connection con = tl.get();//鑾峰彇褰撳墠绾跨▼鐨勪簨鍔¤繛鎺�
		if(con == null) throw new SQLException("Connection is null!");
		con.commit();//鎻愪氦浜嬪姟
		con.close();//鍏抽棴杩炴帴
		con = null;//琛ㄧず浜嬪姟缁撴潫锛�
		tl.remove();
	}
	
	/**
	 * 鍥炴粴浜嬪姟
	 * @throws SQLException 
	 */
	public static void rollbackTransaction() throws SQLException {
		Connection con = tl.get();//鑾峰彇褰撳墠绾跨▼鐨勪簨鍔¤繛鎺�
		if(con == null) throw new SQLException("Connection is null!");
		con.rollback();
		con.close();
		con = null;
		tl.remove();
	}
	
	/**
	 * 閲婃斁Connection
	 * @param con
	 * @throws SQLException 
	 */
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection con = tl.get();//鑾峰彇褰撳墠绾跨▼鐨勪簨鍔¤繛鎺�
		if(connection != con) {//濡傛灉鍙傛暟杩炴帴锛屼笌褰撳墠浜嬪姟杩炴帴涓嶅悓锛岃鏄庤繖涓繛鎺ヤ笉鏄綋鍓嶄簨鍔★紝鍙互鍏抽棴锛�
			if(connection != null &&!connection.isClosed()) {//濡傛灉鍙傛暟杩炴帴娌℃湁鍏抽棴锛屽叧闂箣锛�
				connection.close();
			}
		}
	}
}
