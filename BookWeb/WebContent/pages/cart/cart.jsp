<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<!-- 动态的去获取路径 -->
<%@include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#clear").click(function(){
			if(!confirm("是否要清空购物车！")){
				return false;
			}
			
		})
		
		$(".delbook").click(function(){
		var title =$(this).parents("tr").find("td:eq(0)").text();
			if (!confirm("确定删除"+title+"吗？")){
				return false;
			}
			
		})
		
		$(".number").change(function(){
			var number=this.value;

			var reg = /^\+?[1-9][0-9]*$/;
			
			if (!reg.test(number)){
				alert("请输入有效数字");
				this.value=this.defaultValue;
			}else{
				var bookId=this.id;
				window .location="${pageContext.request.contextPath}/CartServlet"+
			"?method=updateCount&bookId="+bookId+"&count="+number;
			}
			
		 
			
			
		})
	})
	
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">购物车</span>
		<%@include file="/WEB-INF/include/user-info.jsp"%>
	</div>


	<div id="main">
		<c:choose>
			<c:when test="${empty cart.cartItem}">
			<br/><br/><br/>
				<h1 align="center">购物车中没有商品，去购物吧！</h1>
			</c:when>
			<c:otherwise>

				<table>
					<tr>
						<td>商品名称</td>
						<td>数量</td>
						<td>单价</td>
						<td>金额</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${cart.cartItem}" var="item">
						<tr>
							<td>${item.book.title}</td>
							<td><input id ="${item.book.id}" class="number" type="text" value="${item.count}" style="width:40px "/></td>
							<td>${item.book.price }</td>
							<td>${item.amount}</td>
							<td><a  class="delbook" href="CartServlet?method=delbook&bookId=${item.book.id }">删除</a></td>
						</tr>
					</c:forEach>

				</table>
				<div class="cart_info">
					<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount}</span>件商品
					</span> <span class="cart_span">总金额<span class="b_price">${cart.totalAmount}</span>元

					</span><span class="cart_span"><a href="CartServlet?method=clear" id="clear">清空购物车</a></span> 
					<span class="cart_span"><a href="OrderClientServlet?method=checkout">去结账</a></span>
				</div>
			</c:otherwise>
		</c:choose>


	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>