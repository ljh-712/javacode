package com.atluming.login.dao;

import com.atluming.login.beans.User;

public interface UserDao {
	public User getUserByUsernameAndPassword(String username,String password);
	
	public User getUserByUsername(String username);
	public void insertUser(String username,String password);

}
