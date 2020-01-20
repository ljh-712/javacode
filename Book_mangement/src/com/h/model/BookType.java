package com.h.model;
/**
 * 图书类别实体
 * @author Administrator
 *
 */
public class BookType {
	private int id;
	private String bookTypeName;
	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}
	private String bookTypeDesc;
	public BookType( String bookTypeName, String bookTypeDesc) {
		super();
		
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}
	public BookType(String bookTypeName) {
		super();
		this.bookTypeName = bookTypeName;
	}
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}
	@Override
	public String toString() {
		return bookTypeName ;
	}
	
	
}
