<!--注解，页面语言，编码等  -->>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		#d1{
			width:200px;
			height:200px;
			background-color:red;
		}
	</style>
	<script type="text/javascript" src="scripts/jquery-1.7.2.min.js"></script><!-- 引入jquery -->
	<script type="text/javascript">
		//定义函数
		function clickButtton() {
			//window.alert("是谁在点我");//弹窗
			var spanEle=window.document.getElementById("s1");
			var msg=spanEle.innerHTML;
			
			spanEle.innerHTML="不负如来不负卿";
			document.getElementById("i1").value=msg;
			//alert(msg);
			
		}
		function mouseOver(){
			//window.alert("鼠标进来了");
		}
		function mouseOut(){
			alert("鼠标离开了");
		}
		$(function() {//相当于window.onload();
			//alert("文档加载完毕了");
			//$("#d2")  相当于document.getElementById("d2");
			$("#d2").click(function() {
				var msg=$("#s1").html();
				//alert(msg);
				$("#i1").val(msg);
			});
		
		});
	</script>
	
	
	
</head>
	<body>
		<!-- java代码:
		     java片段，java表达式 -->>
		     <!-- java片段 -->
		<%
		String str="a";
		System.out.println(str);
		%>
		<!-- java 表达式 -->
		<%=5>3?"大于":"小于" %>
		
		<!-- jsp页面的执行原理：
		jsp本质上就是一个Servlet,执行的时候先转化为一个.java文件，在编译成.class文件。
		如何转化：
		java代码照搬，html,css,js,表达式通过输出流out.writer()方法往出写。
		作用：可以自动将html相关的代码通过流写到浏览器
		      支持写java代码，可以灵活地做出一些处理
		 -->
		 <!-- EL表达式的常用 -->
		 <br/>
		 ${1+1}
		 <br/>
		 ${2>3}
		 <br/>
		 ${empty a}<!-- 判空 -->
		  ${!empty a}
		 <br/>
		 <input type="button" value="点我呀" onclick="clickButtton()"/>
		 <div id="d1" onmouseover="mouseOver();" onmouseout="mouseOut();"></div>
		 <span id="s1">世间安得两全法</span>
		 <br/>
		 <input id="i1" type="text" name="msg" value="">
		 <input type="button" id="d2" value="测试Jquery"/>
		 <br/>
		 <a href="CookieServlet">Test cookie</a>
		 
	</body>
</html>