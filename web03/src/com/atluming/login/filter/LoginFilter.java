package com.atluming.login.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("初始化");
	}
	
	

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//当前请求是谁
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		System.out.println("URI:"+req.getRequestURI());
		System.out.println("URL:"+req.getRequestURL());
		String url=req.getRequestURL().toString();
		//判断要过滤的请求
		if(url.endsWith("/main.jsp")) {
			//过滤，引导去往登陆页面
			resp.sendRedirect("login.jsp");
		}else {
			//放行，执行后续结果
			// FilterChain过滤器链对象
			chain.doFilter(req, resp);
		}
	}

	public void destroy() {
			System.out.println("销毁了");
	}
	

}
