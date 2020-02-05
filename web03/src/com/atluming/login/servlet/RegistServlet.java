package com.atluming.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atluming.login.beans.User;
import com.atluming.login.dao.UserDao;
import com.atluming.login.dao.UserDaoImpl;

public class RegistServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 注册业务处理
		
		//1、获取用户注册信息
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		//判断用户名是否可用
		UserDao userDao=new UserDaoImpl();
		User user=userDao.getUserByUsername(username);
		if(user!=null) {
			//注册失败，用户名重复
			//转发
			req.setAttribute("regist_msg", "用户名已存在");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
		}else {
			//可以注册
			userDao.insertUser(username, password);
			//注册完成后去往登陆页面
			resp.sendRedirect("login.jsp");
		}
		//2、将用户注册页面插入到数据库
		//3、注册成功去往登陆页面，注册失败回到注册页面，并进行相应提示
		 
	}

}
