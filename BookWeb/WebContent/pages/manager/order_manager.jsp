<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
<!-- 动态的去获取路径 -->
<%@include file="/WEB-INF/include/base.jsp"%>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">订单管理系统</span>
		<%@include file="/WEB-INF/include/user-info.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>

			</tr>
			<c:forEach items="${list }" var="order">
				<tr>
					<td><fmt:formatDate value="${order.orderTime}" type="both"/></td>
					<td>${order.totalAmount }</td>
					<td><a href="#">查看详情</a></td>
					<td>
				<c:choose>
					<c:when test="${order.state==0 }"><a href="OrderManagerServlet?method=sendBook&orderId=${order.id}">点击发货</a>
				</c:when>
				<c:when test="${order.state==1 }"><span>已发货</span>
				</c:when>
				<c:when test="${order.state==2 }"><span>交易完成</span></c:when>
				</c:choose>		
					
				</td>
			</c:forEach>

		</table>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>