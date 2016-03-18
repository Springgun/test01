<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<!-- 动态的去获取路径 -->
<%@include file="/WEB-INF/include/base.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
<script type="text/javascript">
	
	$(function(){
		//给注册按钮绑定一个单击响应函数
		$("#sub_mit").click(function(){
			
			//获取用户填写的用户名、密码、确认密码、电子邮件、验证码
			var title=$("[name=title]").val();
			var price= $("[name=price]").val();
			var sales = $("[name=sales]").val();
			var stock = $("[name=stock]").val();

			
			//检查这些字符串是否符合格式
			//可以使用正则表达式来检查某一个字符串是否符合某种规则
			//创建一个正则表达式
			//a这个正则代表检查一个字符串是否包含a
			//var reg = /a/;
			
			//使用正则表达式
			//var flag = reg.test(username);
			var title_1=/^$/;
			if(title_1.test(title)){
				alert("正确输入书名");
				return false;
			}
			
		
			
			//测试密码
			var price_1 = /^$+[0-9.]{0,6}$/;
			if(!price_1.test(price)){
				//密码不符合规则
				alert("请输入正确的价格");
				
				//取消默认行为
				return false;
			}
		  var sales_1=/^$+[0-9.]{0,6}$/;
			if(!sales_1.test(sales)){
				
				alert("请输入正确的sales数量");
				
				//取消默认行为
				return false;
			}
		
		 var stock_1=/^S+[0-9.]{0,6}$/;
			if(!stock_1.test(stock)){
				
				alert("请输入正确的stock数量");
				
				//取消默认行为
				return false;
			}
			
			
		});
		
		
	});
	

</script>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<div>
				<a href="pages/manager/book_manager.jsp">图书管理</a>
				<a href="pages/manager/order_manager.jsp">订单管理</a>
				<a href="index.jsp">返回商城</a>
			</div>
		</div>
		
		<div id="main">
			<form action="manager?method=add" method="post">
			<input type="hidden" name="referer" value="${header.referer }" />
				<input type="hidden" name="id" value="${book.id }" />
		
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="title" type="text" value="${param.title }"/></td>
						<td><input name="price" type="text" value="${param.price}"/></td>
						<td><input name="author" type="text" value="${param.author}"/></td>
						<td><input name="sales" type="text" value="${param.sales}"/></td>
						<td><input name="stock" type="text" value="${param.stock}"/></td>
						<td><input id="sub_mit" type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>