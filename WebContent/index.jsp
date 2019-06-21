<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理-JDBC数据库访问</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/myPage.css" />
</head>
<body class="mybody">
<div class="divcenter">
<h1>欢迎您进入订单管理页面！</h1>
请选择你接下来要做的 (*^__^*)<br><br>
  <form method="post" action="Userorder.do">
    →_→<input type="submit" name="order" value="查看订单"/><br><br>
    </form>
  <form method="post" action="Userorder.do">
    <h3>精确查询订单：由手机号查找</h3>
    请输入联系电话：<input type="text" name="queryPhone" required/><br>
    →_→<input type="submit" name="order" value="由手机号查找"/><br>
  </form>
  <h3>用户下订单（尚未实现与航班、机票的交互）</h3>
    →_→<a href="insert.jsp"><input type="button" value="添加数据"/></a>
   <br><br>
</div>
</body>
</html>