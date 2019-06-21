<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css" />
<meta charset="UTF-8">
<title>删除数据结果</title>
</head>
<body class="mybody">
<div class="divcenter">
<h3>删除订单处理结果</h3>
	<c:set var="updatelog"
		value="${requestScope.deletelog}" />
	<c:choose>
		<c:when test="${updatelog > 0}">删除订单成功！</c:when>
		<c:otherwise>抱歉，删除订单失败！</c:otherwise>
	</c:choose>
	影响记录数：${updatelog }<br>
	<a href="index.jsp">返回</a>
</div>
</body>
</html>