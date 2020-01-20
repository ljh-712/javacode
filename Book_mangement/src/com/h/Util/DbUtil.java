package com.h.Util;

import java.sql.Connection;
import java.sql.DriverManager;



public class DbUtil {
	private String url="jdbc:mysql://localhost:3306/libarary";
	private String userName="root";
	private String password="";
	private String jdbcName="com.mysql.jdbc.Driver";
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		Class.forName(jdbcName);
		Connection con= DriverManager.getConnection(url,userName,password);
		return con;
	}
	/**
	 * 关闭数据库
	 * @throws Exception 
	 */
	public void closeCollection(Connection con) throws Exception {
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getConnection();
			System.out.println("sucess");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		
	}
}
