<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<base href="${pageContext.request.contextPath}/">
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<!-- 登录js -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login.js"></script>
<!-- 验证码 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/gVerify.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FlyCafe会员登录</title>
</head>

<body>
	<div id="container">
		<div id="header">
			<%-- <img src="${pageContext.request.contextPath}/img/huaweiLogo.png" /> --%>
			<span>FlyCafe 商城</span>
		</div>
		<div id="main">
			<!-- 右边的内容 -->
			<div id="main_r">
				<p id="logintitle">欢迎登录FlyCafe网站</p>
				<div class="login">
					<!-- form表单 -->
					<div class="login_up">
						<form id="login-form" method="post" name="form1">
							<table border="0px" cellspacing="0px">
								<!-- 用户名 -->
								<tr>
									<td colspan="3"><input id="username" type="text"
										name="username" placeholder="请输入您的用户名" required><br>
										<span id="usernamespan"></span></td>
								</tr>
								<!-- 密码 -->
								<tr>
									<td colspan="3"><input type="password" id="password"
										name="password" placeholder="请输入您的密码" required minlength="6"
										maxlength="15"><br> <span id="passwordspan"></span>
									</td>
								</tr>
								<!-- 验证码 -->
								<tr>
									<td><input type="text" id="checkcode" placeholder="不区分大小写" />
										<br> 
										<span id="checkcodespan"></span>
									</td>
									<td><div id="v_container"
											style="width: 100px; height: 50px;"></div></td>
									<td><div id="re_v">
											<img
												src="${pageContext.request.contextPath}/img/login_img/chg_image.png" />
										</div></td>
								</tr>
								<!-- 忘记密码 -->
								<tr id="l1">
									<td><input type="checkbox" id="ck_rmbUser"
										class="checkbox"><label>&nbsp;自动登录</label></td>
									<td colspan="2"><a href="#"><label>忘记密码？</label></a></td>
								</tr>
								<tr>
									<td colspan="3">
										<div id="line"></div> 
										<input type="button" id="bt-login" class="button_login" value="登录">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<!-- 表单下方 -->
					<div class="login_down">
						<p class="logintips">
							<span id="third_login">第三方账号登录：</span> <span id="qq" class="3"><a
								href="#"> <img
									src="${pageContext.request.contextPath}/img/login_img/qq23.png" /></a></span>
							<span id="alipay" class="3"><a href="#"> <img
									src="${pageContext.request.contextPath}/img/login_img/alipay23.png" /></a></span>
							<span id="weixin" class="3"><a href="#"> <img
									src="${pageContext.request.contextPath}/img/login_img/weixin23.png" /></a></span>
						</p>
						<p class="logintips" id="login_t">
							<span>您还没有FlyCafe账号吧？</span>&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/user/showReg.do">免费注册</a>
						</p>
						<p class="logintips">
							<span id="ps">FlyCafe帐号适用于访问所有FlyCafe服务。您可登录该帐号，访问云服务、FlyCafe商城等更多服务。</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- cookie验证 -->
	<script
		src="${pageContext.request.contextPath}/jquery/jquery.cookie.js"></script>
	<script>
		$("#username")
				.blur(
						function() {
							var data = $("#username").val();
							if (data == null || data == "") {
								$("#usernamespan").text("用户名不能为空！");
								$("#usernamespan").css("color", "red");
								return false;
							}
							$
									.ajax({
										"type" : "POST",
										"url" : "${pageContext.request.contextPath}/user/loginCheckUsername.do",
										"data" : "username=" + data,
										"beforeSend" : function(XMLHttpRequest) {
											$("#showResult").text("正在查询");

										},
										"success" : function(obj) {
											if (obj.state == 0) {
												$("#usernamespan").html(
														obj.message);
												$("#usernamespan").css("color",
														"#EA5E00");
											} else if (obj.state == 1) {
												$("#usernamespan").html(
														obj.message);
												$("#usernamespan").css("color",
														"red");
											} else {
												$("#usernamespan").text("系统异常！");
												$("#usernamespan").css("color",
														"red");
											}
										},
										error : function() {
											//错误处理
										}
									});
						});
	</script>
	<script>
	//点击登录按钮的时候触发的异步刷新事件
		$('#bt-login')
				.click(
						function() {
							//异步提交请求，进行验证
							$
									.ajax({
										"url" : "${pageContext.request.contextPath}/user/login.do",
										"data" : "username="
												+ $("#username").val()
												+ "&password="
												+ $("#password").val(),
										"type" : "POST",
										"dataType" : "json",
										"success" : function(obj) {
											if (obj.state == 1) {
												Save();
												location.href = "${pageContext.request.contextPath}/main/showIndex.do";
											} else {
												alert(obj.message);
											}
										}
									});
						});
	</script>

	<!-- 自动登录 -->
	<script type="text/javascript">
		$(document).ready(function() {
			if ($.cookie("rmbUser") == "true") {
				$("#ck_rmbUser").attr("checked", true);
				$("#username").val($.cookie("username"));
				$("#password").val($.cookie("password"));
			}
		});

		//记住用户名密码
		function Save() {
			if ($("#ck_rmbUser").prop("checked")) {
				var str_username = $("#username").val();
				console.log(str_username);
				var str_password = $("#password").val();
				$.cookie("rmbUser", "true", {
					expires : 7
				}); //存储一个带7天期限的cookie
				$.cookie("username", str_username, {
					expires : 7
				});
				$.cookie("password", str_password, {
					expires : 7
				});
			} else {
				$.cookie("rmbUser", "false", {
					expire : -1
				});
				$.cookie("username", "", {
					expires : -1
				});
				$.cookie("password", "", {
					expires : -1
				});
			}
		};
	</script>
</body>
</html>