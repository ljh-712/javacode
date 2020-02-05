package com.atluming.login.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class DbUtil {

	private static String url=null;
	private static String username=null;
	private static String password=null;
	private static String jdbcName=null;
	private static Properties props=new Properties();
	//ThreadLocal保证一个线程中只能有一个连接
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	
	/**
	 * 静态代码块读取db.properties
	 * @return
	 * @throws Exception
	 */
	static {
		
		try {
			//通过类加载器读取
			InputStream in=DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
			props.load(in);
			
			jdbcName=props.getProperty("jdbc.driver");
			url=props.getProperty("jdbc.url");
			username=props.getProperty("jdbc.username");
			password=props.getProperty("jdbc.password");
			Class.forName(jdbcName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//连接数据库
	public static Connection getConnection() throws Exception {
		//先从tl中获取
		Connection con=tl.get();
		if(con==null) {
			con=DriverManager.getConnection(url, username, password);
			tl.set(con);//将获取的con绑定到tl中，下次访问他就不会为空了
		}
		return con;
		
	}
	//关闭连接
	public static void closeConnection() throws Exception {
		//先从tl中获取
		Connection con=tl.get();
		if(con!=null) {
			con.close();
			
		}
		tl.set(null);//保证下次获取时tl为空
	}

}
