<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<!-- 动态的去获取路径 -->
<%@include file="/WEB-INF/include/base.jsp"%>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">我的订单</span>
		<%@include file="/WEB-INF/include/user-info.jsp"%>
	</div>

	<div id="main">

		<table>
			<tr>
				<td>定单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			
	<c:forEach items="${list}" var="order">		
			<tr>
			<td>${order.id }</td>
				<td><fmt:formatDate value="${order.orderTime }"  type="both"/></td>
				<td>${order.totalAmount}</td>
				<td>
				<c:choose>
					<c:when test="${order.state==0 }"><span>未发货</span>
				</c:when>
				<c:when test="${order.state==1 }"><span><a href="OrderClientServlet?method=takeBook&orderId=${order.id}">确认收货</a></span>
				</c:when>
				<c:when test="${order.state==2 }"><span>交易完成</span></c:when>
				</c:choose>					
				</td>
				<td><a href="OrderClientServlet?method=orderInfo&orderId=${order.id }">查看详情</a></td>
			</tr>

			</c:forEach>
		</table>


	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>