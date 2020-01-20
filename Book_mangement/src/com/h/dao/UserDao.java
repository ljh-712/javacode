package com.h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.h.model.User;

/**
 * 操作数据库返回用户数据
 * @author Administrator
 *
 */
public class UserDao {
	public User login(Connection con,User user) throws Exception {
		User resUser=null;
		String sql="select *from user where userName=?and password=?";
		PreparedStatement pstm= con.prepareStatement(sql);
		pstm.setString(1, user.getUserName());
		pstm.setString(2, user.getPassword());
		ResultSet rs= pstm.executeQuery();
		if(rs.next()) {
			resUser=new User();
			resUser.setId(rs.getInt("id"));
			resUser.setUserName(rs.getString("username"));
			resUser.setPassword(rs.getString("password"));
		}
		return resUser;
		
	}
}
