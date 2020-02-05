package com.atluming.login.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *监听器属于设计模式中的观察者模式
 */
public class MySessionListener implements HttpSessionListener {


	/**
	 * 监听session对象被创建
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	//ServletContext，servlet上下文对象，
    	//web应用服务器会为每个web应用创建一个唯一的ServletContext对象，作用域最大，所有用户共享
    	//随着服务器启动而创建，服务器销毁而销毁
    	
    	ServletContext sc=se.getSession().getServletContext();
    	//在ServletContex中绑定一个在线人数，从ServletContex中获取count
    	Object count=sc.getAttribute("count");
    	if(count==null) {
    		//第一个用户上线
    		sc.setAttribute("count", 1);
    	}else {
    		sc.setAttribute("count", (Integer)count+1);
    	}
    	
        
    }

	/**
	 * 监听session对象被销毁
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
       
    }
	
}
