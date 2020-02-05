package com.atluming.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atluming.login.beans.Employee;
import com.atluming.login.beans.User;
import com.atluming.login.dao.EmployeeDao;
import com.atluming.login.dao.EmployeeDaoImpl;
import com.atluming.login.dao.UserDao;
import com.atluming.login.dao.UserDaoImpl;

/**
 * 处理登录请求的Servlet
 * Servlet是sun公司制定的标准，Tomcat（web应用服务器，Servlet容器）实现了这些标准
 * HttpServlet
 *
 */

public class LoginServlet extends HttpServlet{
/**
 * 常用的方法：doGet   doPost   service
 * doGet处理客户端get方式的请求
 * doPost处理客户端post方式的请求
 * 
 * service:根据具体的请求方式调用对应的doGet\doPost方法
 */
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.service(req, resp);
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//登录功能的实现
		System.out.println("登录请求过来了。。。");
		//获取用户输入的密码和用户名，进行登录业务的处理
		/**
		 * HttpServletRequest：请求对象
		 *       servlet容器会在请求到达后，创建一个request对象
		 *       将http请求的相关信息全部封装到该对象中
		 */
		req.setCharacterEncoding("utf-8");
		//获取用户名
		String username=req.getParameter("username");
		//获取密码
		String password=req.getParameter("password");
		System.out.println(username+","+password);
		//登录验证
		//通过响应对象HttpServletResponse 响应数据
		resp.setContentType("text/html;charset=utf-8");//设置浏览器解析格式
		
		PrintWriter out=resp.getWriter();
		UserDao userdao=new UserDaoImpl();
		User user=userdao.getUserByUsernameAndPassword(username, password);
		if(user==null) {
			
			//out.println("<h1><font color='green'>login success&&登陆成功</font></h1>");忽略
			
			//通过重定向的方式去往登陆页面,重定向两次请求服务器
			/**
			 * 服务器会给浏览器发送一个302的状态码以及一个新的地址
			 */
			//resp.sendRedirect("login.jsp");
			/**
			 * 转发：一次请求
			 */
			//转发之前绑定数据：就是将想要交给下一个组件（jsp）处理的数据，绑定到request对象中
			req.setAttribute("login_message", "用户名或密码错误!");
			//获取转发器
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			//开始转发
			rd.forward(req, resp);
		}else {
			//out.println("<h1><font color='red'>login success&&登陆成功 </font></h1>");
			//登录用户设置到session中
			HttpSession session=req.getSession();
			session.setAttribute("loginUser", user);
			//查找所有员工数据
			EmployeeDao employeeDao=new EmployeeDaoImpl();
			List<Employee> emps=employeeDao.selectAllEmplyee();
			//转发之前绑定数据
			req.setAttribute("emps", emps);
			//转发数据
			req.getRequestDispatcher("main.jsp").forward(req, resp);
			
			//resp.sendRedirect("main.jsp");
			
		}

	}
	
	
}
