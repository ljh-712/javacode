package com.atluming.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atluming.login.beans.User;
import com.atluming.login.util.DbUtil;


public class UserDaoImpl implements UserDao{
	

	@Override
	public User getUserByUsernameAndPassword(String username,String password) {
		/**
		 * 获取连接
		 * 编写sql
		 * 预编译sql
		 * 设置参数
		 * 执行sql
		 * 封装结果
		 * 关闭连接
		 */
		User u=null;
		try {

			Connection con=DbUtil.getConnection();
			String sql="select *from user where username=? and password=?";
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection();;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		User u=null;
		try {

			Connection con=DbUtil.getConnection();
			String sql="select *from user where username=?";
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1, username);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection();;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void insertUser(String username, String password) {
		
		try {
			Connection con=DbUtil.getConnection();
			String sql="insert into user (username,password) values(?,?)";
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				DbUtil.closeConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}
