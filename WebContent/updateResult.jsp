<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css" />
<meta charset="UTF-8">
<title>更新数据结果</title>
</head>
<body class="mybody">
<div class="divcenter">
	<c:set var="updatelog"
		value="${requestScope.updatelog }" />
	<c:choose>
		<c:when test="${updatelog > 0}">恭喜您！修改订单成功！</c:when>
		<c:otherwise>抱歉，修改订单失败！</c:otherwise>
	</c:choose>
	影响记录数：${updatelog }<br>
	<a href="index.jsp">返回</a>
</div>
</body>
</html>