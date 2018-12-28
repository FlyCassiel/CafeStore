<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>FlyCafe 商城管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- css -->
<style type="text/css">
body {
	color: white;
	margin: 0;
	padding: 0;
	background: -webkit-linear-gradient(left top, red , #974B00); /* Safari 5.1 - 6.0 */
  	background: -o-linear-gradient(bottom right, red, #974B00); /* Opera 11.1 - 12.0 */
  	background: -moz-linear-gradient(bottom right, red, #974B00); /* Firefox 3.6 - 15 */
  	background: linear-gradient(to bottom right, red , #974B00); /* 标准的语法 */
}

td {
	line-height: 50px;
}

.button {
	padding: 5px 80px;
	margin: 15px 15px;
	background-color: #fff;
	border-radius: 10px;
}
/* 头部样式 */
.header {
	width: 100%;
	height: 68px;
}

.form {
	width: 500px;
	height: 400px;
	position: absolute;
	top: 250px;
	right: 150px;
}

.font-success {
	color: width;
	border-radius: 20px;
}

.font-error {
	color: red;
	border-radius: 20px;
}
</style>
</head>
<body>
	<div class="header">
		<img src="${pageContext.request.contextPath}/images/admin-top.jpg">
	</div>
	<div class="container">
		<div class="form">
			<form method="post" id="form-admin" action=""
				target="_parent" onsubmit="return validate()">
				<table>
					<tr>
						<td>管理员姓名：</td>
						<td>
						<input id="username" type="text" name="username" /> <span id="usernamefont"></span></td>
					</tr>
					<tr>
						<td>管理员密码：</td>
						<td><input id="password" type="password" name="password" /> <span
							id="passwordfont"></span></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="button" value="进入管理中心" class="button" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<!-- js -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-1.11.3.js"></script>
	<script type="text/javascript">
	//点击登录按钮的时候触发的异步刷新事件
	$(".button").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		if(username==null||username==""){
			$("#usernamefont").html("用户名不能为空");
			$("#usernamefont").attr("class", "font-error");
			return false;
		}
		if(password==null||password==""){
			$("#passwordfont").html("密码不能为空");
			$("#passwordfont").attr("class", "font-error");
			return false;
		}
		$.ajax({
			"url":"${pageContext.request.contextPath}/admin/login.do",
			"data":"username="
				+ $("#username").val()
				+ "&password="
				+ $("#password").val(),
			"dataType":"json",
			"Type":"POST",
			"success":function(obj){
				if (obj.state == 1) {
					location.href = "${pageContext.request.contextPath}/admin/showIndex.do";
				} else {
					alert(obj.message);
				}
			}
		})
	})
	
	
		//验证用户名信息
		$("#username").blur(function() {
			var username = $("#username").val();
			/* alert(username); */
			if (username == null || username == "") {
				$("#usernamefont").html("用户名不能为空");
				$("#usernamefont").attr("class", "font-error");
			} else if (!/^[a-zA-Z]{5,8}$/.test(username)) {
				$("#usernamefont").html("用户名必须是5-8位字母");
				$("#usernamefont").attr("class", "font-error");
			} else {
				$("#usernamefont").html("");
				$("#usernamefont").attr("class", "font-success");
			}
		})
		$("#username").focus(function() {
			$("#usernamefont").html("");
		})
		//验证密码信息

		$("#password").blur(function() {
			var password = $("#password").val();
			/* alert(password);
			alert(password.length); */
			if (password == null || password == "") {
				$("#passwordfont").html("密码不能为空");
				$("#passwordfont").attr("class", "font-error");
			} else if (password.length<6||password.length>18) {
				$("#passwordfont").html("密码长度为必须6-18");
				$("#passwordfont").attr("class", "font-error");
			} else {
				$("#passwordfont").html("");
				$("#passwordfont").attr("class", "font-success");
			}
		})
		$("#password").focus(function() {
			$("#passwordfont").html("");
		})

		function validate() {
			var lengths = 0;
			$("span").each(function(){
				if($(this).hasClass("font-success")){
					lengths++;
					alert("length:"+lengths)
				}
			})
			alert(lengths);
			if (lengths == 2) {
				return true;
			}
			return false;
		}
	</script>
</body>
</html>