package com.h.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.h.Util.StringUtil;
import com.h.model.Book;

/**
 * 图书Dao类
 * @author Administrator
 *
 */
public class BookDao {
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception {
		String sql="insert into book values(null,?,?,?,?,?,?)";
		PreparedStatement pstm= con.prepareStatement(sql);
		pstm.setString(1, book.getBookName());
		pstm.setString(2,book.getAuthor());
		pstm.setString(3,book.getSex());
		pstm.setFloat(4, book.getPrice());
		pstm.setInt(5, book.getBookTypeId());
		pstm.setString(6, book.getBookDesc());
		return pstm.executeUpdate();
	}
	/**
	 * 图书信息查询
	 */
	public ResultSet list(Connection con,Book book)  throws Exception{
		StringBuffer sb=new StringBuffer("select *from book b,booktype bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=null&&book.getBookTypeId()!=-1) {
			sb.append(" and b.bookTypeId like '%"+book.getBookTypeId()+"%'");
		}
		PreparedStatement pstm= con.prepareStatement(sb.toString());
		return pstm.executeQuery();
	}
	/**
	 * 图书类别删除
	 */
	public int delete(Connection con,String id) throws Exception {
		String sql="delete from book where id=?";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1,id);
		return pstm.executeUpdate();
	}
	/**
	 * 
	 */
	public int update(Connection con,Book book)throws Exception {
		String sql="update book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1,book.getBookName());
		pstm.setString(2,book.getAuthor());
		pstm.setString(3,book.getSex());
		pstm.setFloat(4, book.getPrice());
		pstm.setString(5,book.getBookDesc());
		pstm.setInt(6,book.getBookTypeId());
		pstm.setInt(7,book.getId());
		return pstm.executeUpdate();
	}
	/**
	 * 判断指定图书类别下是否有图书
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean isExistBookTypeId(Connection con,String bookTypeId) throws Exception{
		String sql="select * from book where bookTypeId=?";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, bookTypeId);
		ResultSet rs= pstm.executeQuery();
		return rs.next();
	}
}
