<%@page import="com.sun.org.glassfish.gmbal.IncludeSubclass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<!-- 动态的去获取路径 -->
<%@include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
	$(function() {

		$(".id").click(function() {
			var title = $(this).parents("tr").find("td:eq(0)").text();
			if (!confirm("确定删除" + title + "吗？")) {
				return false;
			}

		});
	});
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">图书管理系统</span>
		<%@include file="/WEB-INF/include/manager-info.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${page.date}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="book_edit.jsp">修改</a></td>
					<td><a href="manager?method=delbook&id=${book.id}" class="id">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>
		</table>                                       
		
			<c:choose>
			<c:when test="${page.totalPage<5}">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value ="${page.totalPage}"></c:set>
			</c:when>
			<c:when test ="${page.pageNumber}">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value ="5"></c:set>
			</c:when>
			<c:otherwise>
			<c:set var="begin" value="${page.pageNumber-2}"></c:set>
			<c:set var="end"  value="${page.pageNumber+2}"> </c:set>
			<c:if test="${end>page.totalPage}">
				<c:set var="end" value="page.totalPage"></c:set>
			</c:if>
			</c:otherwise>
			</c:choose>
			<c:forEach begin="${begin}" end="${end}" var ="index">
			<c:choose>
			<c:when test ="${index ==page.pageNumber}">
			<span >[${index}]</span>
			</c:when>
			
			<c:otherwise><a href ="manager?method=findBook&pageNumber=${index}">${index}</a></c:otherwise></c:choose>
			</c:forEach>
			<input value="${index}" name="pn" id="pn_input" />页 <input type="button"
				value="确定" id="pn_btn">
			<script type="text/javascript">
				$("#pn_btn")
						.click(
								function() {
									var pn = $("#pn_input").val()
									window.location = "${pageContext.request.contextPath}/manager?method=findBook&pageNumber="
											+ pn;
								})
			</script>
		</div>
	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>