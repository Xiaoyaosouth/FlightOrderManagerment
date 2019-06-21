<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userorderService" class="service.impl.UserorderServiceImpl" />
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css" />
<meta charset="UTF-8">
<title>修改数据</title>
</head>
<body class="mybody">
<div class="divcenter">
     【修改订单】<br>
     <c:set var="userorder" value="${userorderService.searchById(param.updateId) }"/>
     <form method="post" action="Userorder.do">
    	<table>
    		<tr>
				<td>订单号（不可修改）</td>
				<td><input type="text" name="updateId" value="${userorder.id}" readonly/></td>
			</tr>
			<tr>
				<td>证件号</td>
				<td><input type="text" name="updateUserId" value="${userorder.userId}" required/></td>
			</tr>
			<tr>
				<td>联系电话</td>
				<td><input type="text" name="updatePhone" value="${userorder.phone}" required/></td>
			</tr>
			<tr>
				<td>用户姓名</td>
				<td><input type="text" name="updateName" value="${userorder.name}" required/></td>
			</tr>
			<tr>
				<td>订单状态</td>
				<td><input type="text" name="updateStatu" value="${userorder.statu}"/></td>
			</tr>
			<tr>
				<td>提交订单时间（不可修改）</td>
				<td><input type="text" name="updateStartTime" value="${userorder.startTime}" readonly/></td>
			</tr>
			<tr>
				<td>更新订单时间（不可修改）</td>
				<td><input type="text" name="updateUpdateTime" value="${userorder.updateTime}" readonly/></td>
			</tr>
			<tr>
				<td>订单总价（暂未实现，不可修改）</td>
				<td><input type="text" name="updateTotalPrice" value="${userorder.totalPrice}" readonly/></td>
			</tr>
		</table>
		<h4>订单状态：已提交；未付款；已付款；已完成</h4>
    <input type="submit" name="order" value="修改"/><br>
    <br><br>
    </form>
    <a href="index.jsp">返回</a>
</div>
</body>
</html>