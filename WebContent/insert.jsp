<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css" />
<script src="../js/checkform.js"></script>
<meta charset="UTF-8">
<title>插入数据</title>
</head>
<body class="mybody">
<div class="divcenter">
  【添加订单】<br><h2>请输入订单信息!</h2>
	<form id="myform" method="post" action="Userorder.do">
		<table>
			<tr>
				<td>证件号</td>
				<td><input type="text" name="insertUserId" required/></td>
			</tr>
			<tr>
				<td>联系电话</td>
				<td><input type="text" name="insertPhone" required/></td>
			</tr>
			<tr>
				<td>您的姓名</td>
				<td><input type="text" name="insertName" required/></td>
			</tr>
		</table>
		<input type="submit" name="order" value="添加" /><br>
	</form>
	<a href="index.jsp">返回</a>
</div>
</body>
</html>