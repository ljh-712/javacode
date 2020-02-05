<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			body{
				background-color:pink;
			}
			span{
				color:red;
			}
		</style>
		<script type="text/javascript">
			//编写js代码
			function clearLoginMsg(){
				var spanEle=document.getElementById("login_span");
				spanEle.innerHTML="";
				
			}
		</script>
		<script type="text/javascript" src="引入一个jsp文件"></script>
		<title>登录界面</title>
	</head>
	<body bgcolor="pink">
		<h1>欢迎登陆</h1>
		<form action="login" method="post">
		<!-- 
		action:请求的地址
		method:请求的方式
		Get:将请求的数据拼接到请求的地址中，直接暴露出来，不安全，并且不适用请求的数据较多
		Post:将请求的数据存到请求体中提交，不会直接暴露出来
		 -->
			用户名称：<input type="text" name="username" onfocus="clearLoginMsg()"/>
			
			<!-- EL表达式会从pageScope  requestScope   sessionScope  applicationScope中查找数据.
			    EL表达式有数据就会输出，如果为空，就什么也不输出。相对于request对象来说可以不用判断
			 -->
			<span id="login_span">${login_message}</span>
			<%-- 
			<%
				//获取request对象：request可以直接用
				String loginMsg=(String)request.getAttribute("login_message");
			%>
			<span><%=loginMsg==null?"":loginMsg %></span>  注释--%>
			<br/>
			用户密码：<input type="password" name="password"/>
			<br/>
			<input type="submit" value="Login"/>
		</form>
	</body>
</html>