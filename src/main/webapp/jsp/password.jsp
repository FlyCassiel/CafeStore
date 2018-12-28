<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Fly Cafe 用户密码修改页面</title>
<link href="../css/header.css" rel="Stylesheet" />
<link href="../css/address.css" rel="stylesheet" />
</head>
<body>
	<!-- 头部信息-->
	<%@include file="header.jsp"%>
	<!-- 账号中心 -->
	<div id="center_top">
		<div id="center_top_l">
			<div id="childlogo">
				<img src="${pageContext.request.contextPath}/img/childlogo.png" />
			</div>
			<span class="logo_text">帐号中心</span>
		</div>
		<div id="center_top_r">
			<ul class="ul">
				<li><a href="#" class="active">账号与安全</a></li>
				<li><a href="${pageContext.request.contextPath}/user/showPerson.do">个人信息</a></li>
				<li><a href="${pageContext.request.contextPath}/address/showAddress.do" >收货地址</a></li>
			</ul>
		</div>
	</div>
	<!--我的订单内容区域 #container-->
	<div id="container" class="clearfix">
		<!-- 右边栏-->
		<!--个人信息头部-->
		<div class="rightsidebar_box">
			<!--安全管理 -->
			<div class="rs_content">
				<p class="change_password_title">更改密码</p>
				<div class="new_password">
					<span class="word">输入旧密码：</span> <input type="password"
						name="oldPassword" id="oldPassword" /> <span class="change_hint"
						id="oldPasswordSpan"></span>
				</div>
				<div class="new_password">
					<span class="word">输入新密码：</span> <input type="password"
						name="newPassword" id="newPassword" /> <span class="change_hint"
						id="newPasswordSpan"></span>
				</div>
				<div class="confirm_password">
					<span class="word">确认新密码：</span> <input type="password"
						name="confirmPassword" id="confirmPassword" /> <span
						class="confirm_hint" id="confirmPasswordSpan"></span>
				</div>
				<div class="save_password" onclick="updatePwd()">保存更改</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>


<script type="text/javascript">
	//提交请求的异步提交
	function updatePwd() {
		var oldPwd = $("#oldPassword").val();
		var newPwd = $("#newPassword").val();
		var confirm = $("#confirmPassword").val();
		if (checkPasswordLength(oldPwd) && checkPasswordLength(newPwd)
				&& checkPasswordLength(confirm) && checkPasswordEquals()) {
			$.ajax({
				"url" : "../user/updatePassword.do",
				"data" : "oldPassword=" + oldPwd + "&newPassword=" + newPwd,
				"type" : "POST",
				"dataType" : "json",
				"success" : function(obj) {
					alert(obj.state + "," + obj.message);
					if (obj.state == 1) {
						$("#oldPassword").val("");
						$("#newPassword").val("");
						$("#confirmPassword").val("");
						$("#oldPasswordSpan").html("");
						$("#newPasswordSpan").html("");
						$("#confirmPasswordSpan").html("");
					}
				}
			})
		} else {
			alert("信息不正确");
		}
	}
	//验证密码长度  长度是6-18位
	function checkPasswordLength(pwd) {
		return pwd.length >= 6 && pwd.length <= 18;
	}
	//验证两次输入密码是否相同
	function checkPasswordEquals() {
		var value1 = $("#newPassword").val();
		var value2 = $("#confirmPassword").val();
		if (value1 == value2) {
			return true;
		} else {
			return false;
		}

	}
	//让3个框发生失去焦点事件
	//旧密码失去焦点的同时触发异步刷新页面  判断用户密码是否正确
	$("#oldPassword").blur(function() {
		var value = $("#oldPassword").val();
		/* alert(value); */
		if (checkPasswordLength(value)) {
			$("#oldPasswordSpan").html("密码样式正确");
			$("#oldPasswordSpan").css("color", "#0f0");
		} else {
			$("#oldPasswordSpan").html("密码长度为6-18位");
			$("#oldPasswordSpan").css("color", "#f00");
		}
		$.ajax({
			"url":"${pageContext.request.contextPath}/user/checkPassword.do",
			"data":"oldPassword=" + value,
			"dateType":"json",
			"type":"GET",
			"success":function(obj){
				//状态码为1的时候说明和数据库中的密码相匹配
				if(obj.state==1){
					$("#oldPasswordSpan").html("验证密码正确");
					$("#oldPasswordSpan").css("color", "#0f0");
				}else{
					//状态码不为1的时候说明和数据库中的密码不匹配
					$("#oldPasswordSpan").html("密码不正确，请重新输入");
					$("#oldPasswordSpan").css("color", "#f00");
				}
			}
		})
	});

	$("#newPassword").blur(function() {
		var value = $("#newPassword").val();
		if (checkPasswordLength(value)) {
			$("#newPasswordSpan").html("密码格式正确");
			$("#newPasswordSpan").css("color", "#0f0");
		} else {
			$("#newPasswordSpan").html("密码长度为6-18位");
			$("#newPasswordSpan").css("color", "#f00");
		}
	});
	$("#confirmPassword").blur(function() {
		var value = $("#confirmPassword").val();
		if (checkPasswordLength(value)) {
			$("#confirmPasswordSpan").html("密码格式正确");
			$("#confirmPasswordSpan").css("color", "#0f0");
			if (checkPasswordEquals()) {
				$("#confirmPasswordSpan").html("密码一致");
				$("#confirmPasswordSpan").css("color", "#0f0");

			} else {
				$("#confirmPasswordSpan").html("两次密码输入不一致");
				$("#confirmPasswordSpan").css("color", "#f00");

			}
		} else {
			$("#confirmPasswordSpan").html("密码长度为6-18位");
			$("#confirmPasswordSpan").css("color", "#f00");
		}
	});
</script>

</html>