<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<!-- 动态的去获取路径 -->
<%@include file="/WEB-INF/include/base.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
<script type="text/javascript">
	
	$(function(){
		$("#code_btn").click(function(){
			this.src="code.jpg?m="+Math.random();
		})
		//给注册按钮绑定一个单击响应函数
		$("#sub_btn").click(function(){
			
			//获取用户填写的用户名、密码、确认密码、电子邮件、验证码
			var username = $("[name=username]").val();
			var password = $("[name=password]").val();
			var repwd = $("[name=repwd]").val();
			var email = $("[name=email]").val();
			var code = $("[name=code]").val();
			
			//检查这些字符串是否符合格式
			//可以使用正则表达式来检查某一个字符串是否符合某种规则
			//创建一个正则表达式
			//a这个正则代表检查一个字符串是否包含a
			//var reg = /a/;
			
			//使用正则表达式
			//var flag = reg.test(username);
			
			//alert(flag);
			
			//创建一个username的正则表达式
			var nameReg = /^[a-zA-Z0-9_-]{3,16}$/;
			
			//测试用户名
			if(!nameReg.test(username)){
				//如果用户名不符合规则
				alert("请输入包括字母、数字、_、-3-16位的用户名！");
				
				//取消默认行为
				return false;
			}
			
			//测试密码
			var pwdReg = /^[a-z0-9_-]{6,18}$/;
			if(!pwdReg.test(password)){
				//密码不符合规则
				alert("请输入包括字母、数字、_、-6-18位的密码！");
				
				//取消默认行为
				return false;
			}
			
			//检查确认密码是否和密码一致
			if(password != repwd){
				
				alert("两次输入的密码不一致！");
				
				//取消默认行为
				return false;
			}
			
			//检查电子邮箱地址
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!emailReg.test(email)){
				
				alert("请输入正确的电子邮件地址！");
				
				//取消默认行为
				return false;
			}
			
			//检查验证码是否为空
			if(code == ""){
				alert("请输入验证码！");
				
				//取消默认行为
				return false;
			}
		});
		
		
	});
	

</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"></span>
							</div>
							<div class="form">
								<form action="login_success?method=regist" method="post">
									<label>用户名称：</label>
									<%--  <%=request.getAttribute("hintname")==null? "":request.getAttribute("hintname")%> --%>
									<input value="${param.username}" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<h5>${empty hintname? "<br />":hintname}</h5>
								
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input value="${param.email}"class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img alt="" src="code.jpg" style="float: right; margin-right: 40px "  width="90px"height="40px"  id="code_btn">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>