<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userorderService"
	class="service.impl.UserorderServiceImpl" />
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css" />
<meta charset="UTF-8">
<title>删除数据</title>
</head>
<body class="mybody">
<div class="divcenter">
	【删除订单】<br>
	<h3>将要删除的订单：</h3>
	<c:set var="userorder"
		value="${userorderService.searchById(param.deleteId) }" />
	<form method="post" action="Userorder.do">
		<table>
			<tr>
				<td>id：</td>
				<td><input type="text" name="deleteId" value="${userorder.id}"
					readonly /></td>
			</tr>
			<tr>
				<td>phone：</td>
				<td><input type="text" name="deletePhone"
					value="${userorder.phone}" readonly /></td>
			</tr>
			<tr>
				<td>name：</td>
				<td><input type="text" name="deleteName"
					value="${userorder.name}" readonly /></td>
			</tr>
		</table>
		确认删除？&nbsp; <input type="submit" name="order" value="删除" /><br>
	</form>
	<a href="index.jsp">返回</a>
</div>
</body>
</html>