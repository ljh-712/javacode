<%@page import="com.atluming.login.beans.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1 align="center">欢迎 <font color='blue'>${sessionScope.loginUser.username}</font>
		 登录,当前在线人数为<font color='orange'>${applicationScope.count}</font>人</h1>
		<br/>
		<br/>
		<h2 align="center">员工信息列表</h2>
		<c:if test="${!empty emps}">
			<table border="1px" width="70%" align="center" cellspacing="0px">
				<tr >
					<th>ID</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Gender</th>
					<th>DeptName</th>
					<th>Operation</th>
				</tr>
				<!-- 通过循环显示员工 -->
				<c:forEach items="${emps}" var="emp"><!-- items为指定循环的元素 emp当前循环的元素 -->
					<tr align="center">
						<td>${emp.id}</td>
						<td>${emp.lastName }</td>
						<td>${emp.email}</td>
						<td>${emp.gender.equals("0")?"男":"女"}</td>
						<td>${emp.dept.depName}</td>
						<td>
							<a href="#">Edit</a>
							&nbsp;&nbsp;<!-- 空格 -->
							<a href="#">Delete</a>
						</td>
						
					</tr>
				</c:forEach>
			<%-- 
				<%
					List<Employee> emps=(List<Employee>) request.getAttribute("emps");
				    for(Employee employee:emps) {
					%>
					<tr align="center">
						<td><%=employee.getId() %></td>
						<td><%=employee.getLastName() %></td>
						<td><%=employee.getEmail() %></td>
						<td><%=employee.getGender().equals("0")?"男":"女" %></td>
						<td><%=employee.getDept().getDepName() %></td>
						<td>
							<a href="#">Edit</a>
							<a href="#">Delete</a>
						</td>
						
					</tr>
					<% 
				}
				%>
				--%>
			</table>
		</c:if>
		<c:if test="${empty emps}"><h2 align="center">没有任何员工信息</h2></c:if>
		<h3 align="center"><a href="#">Add New Emp</a></h3>
		<!-- 
			JSTL：
			
			使用标签：
			1、导入标签库jar包
			2、在jsp页面中引入标签库
		 -->
	</body>
</html>