<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css" />
<meta charset="UTF-8">
<title>查询数据</title>
</head>
<body class="mybody">
<div class="divcenter">
	<a href="index.jsp"><input type="button" value="返回" /></a>&nbsp;
	<a href="insert.jsp"><input type="button" value="添加数据" /></a>
	查询完成，共查询到&nbsp;${requestScope.userorderList.size() }&nbsp;条数据。
	<br><br>
	<table border="1">
		<tr align="center" class="tr">
			<td>订单号</td>
			<td>手机号</td>
			<td>用户姓名</td>
			<td>证件号</td>
			<td>订单状态</td>
			<td>提交时间</td>
			<td>更新时间</td>
			<td>订单总价</td>
			<td>操作</td>
		</tr>
		<c:forEach var="userorder" items="${requestScope.userorderList}">
			<tr align="center">
				<td>${userorder.id}</td>
				<td>${userorder.phone}</td>
				<td>${userorder.name}</td>
				<td>${userorder.userId}</td>
				<td>${userorder.statu}</td>
				<td>${userorder.startTime}</td>
				<td>${userorder.updateTime}</td>
				<td>${userorder.totalPrice}</td>
				<td><a href="delete.jsp?deleteId=${userorder.id}">
				    <input type="button" value="删除"/></a><br> 
					<a href="update.jsp?updateId=${userorder.id}">
					<input type="button" value="修改"/></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>