
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>

<!-- 动态的去获取路径 -->
<%@include file="/WEB-INF/include/base.jsp"%>
</head>

<body>
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">网上书城</span>
		<%@include file="/WEB-INF/include/user-info.jsp"%>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				价格：<input type="text" name="min"> 元 - <input type="text"
					name="max"> 元
				<button>查询</button>
			</div>
			<div style="text-align: center">
				<c:choose>
					<c:when test="${empty cart.cartItem}">
						<span>您的购物车中没有商品</span>
					</c:when>
					<c:otherwise>
						<span>您的购物车中有${cart.totalCount}件商品</span>
						<div>
							您刚刚将<span style="color: red">${title}</span>加入到了购物车中
					
						</div>
						
					</c:otherwise>
				</c:choose>


			</div>

			<c:choose>
				<c:when test="${empty page.date}">
					<h1>没有查找到图书！</h1>
				</c:when>
				<c:otherwise>
					<c:forEach items="${page.date}" var="book">
						<div class="b_list">
							<div class="img_div">
								<img class="book_img" alt=""
									src="${pageContext.request.contextPath}${book.img_path}" />
							</div>
							<div class="book_info">
								<div class="book_name">
									<span class="sp1">书名:</span> <span class="sp2">${book.title}</span>
								</div>
								<div class="book_author">
									<span class="sp1">作者:</span> <span class="sp2">${book.author}</span>
								</div>
								<div class="book_price">
									<span class="sp1">价格:</span> <span class="sp2">${book.price}</span>
								</div>
								<div class="book_sales">
									<span class="sp1">销量:</span> <span class="sp2">${book.sales }</span>
								</div>
								<div class="book_amount">
									<span class="sp1">库存:</span> <span class="sp2">${book.stock}</span>
								</div>
								<div class="book_add">
									<a href="CartServlet?method=add2Cart&bookId=${book.id }">加入购物车</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>




			<div id="page_nav">
				<a href="#">首页</a> <a href="#">上一页</a> <a href="#">3</a> 【4】 <a
					href="#">5</a> <a href="#">下一页</a> <a href="#">末页</a> 共10页，30条记录 到第<input
					value="4" name="pn" id="pn_input" />页 <input type="button"
					value="确定">
			</div>

		</div>

		<div id="bottom">
			<span> 尚硅谷书城.Copyright &copy;2015 </span>
		</div>
</body>
</html>