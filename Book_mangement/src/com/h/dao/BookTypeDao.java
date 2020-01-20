package com.h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.h.Util.StringUtil;
import com.h.model.BookType;

/**
 * 图书类别
 * @author Administrator
 *
 */
public class BookTypeDao {
	/**\
	 * 图书类别添加
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception 
	 * @throws Exception 
	 */
	public int add(Connection con,BookType bookType) throws Exception {
		String sql="insert into booktype values(null,?,?)";
		PreparedStatement pstm= con.prepareStatement(sql);
		pstm.setString(1,bookType.getBookTypeName());
		pstm.setString(2, bookType.getBookTypeDesc());
		return pstm.executeUpdate();
	}
	/**
	 * 查询图书类别
	 * @param con
	 * @param bookType
	 * @return
	 */
	public ResultSet list(Connection con,BookType bookType) throws Exception{
		StringBuffer stringBuffer=new StringBuffer("select * from booktype");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			stringBuffer.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement pstm= con.prepareStatement(stringBuffer.toString().replaceFirst("and", "where"));
		return pstm.executeQuery();
		
	}
	/**
	 * 删除图书类别
	 */
	public int delete(Connection con,String id)throws Exception {
		String sql="delete from booktype where id=?";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, id);
		return pstm.executeUpdate();
	}
	/**
	 * 修改图书类别
	 */
	public int update(Connection con,BookType bookType)throws Exception {
		String sql="update booktype set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstm= con.prepareStatement(sql);
		pstm.setString(1, bookType.getBookTypeName());
		pstm.setString(2, bookType.getBookTypeDesc());
		pstm.setInt(3, bookType.getId());
		return pstm.executeUpdate();
	}
}
