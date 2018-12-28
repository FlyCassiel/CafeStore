<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Flycafe会员注册</title>
<link href="${pageContext.request.contextPath}/css/register.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/register.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div class="center">
				<div id="logo">
					<img src="${pageContext.request.contextPath}/img/logo2.png" />
				</div>
				<span>FlyCafe咖啡网站</span>
			</div>
		</div>
		<div id="main">
			<div class="center">
				<form id="form-reg" action="" method="post">
					<div class="reg_tab">
						<div class="login_r">
							<span>已有FlyCafe帐号 <a
								href="${pageContext.request.contextPath}/user/showLogin.do">登录</a> ▶
							</span>
						</div>
					</div>
					<div class="reg_detail">
						<h3 class="reg_title">注册FlyCafe帐号</h3>

						<div class="box_shadow_in"></div>

						<div class="node">
							<p class="node_title">新用户注册</p>
							<p class="node_intro">输入用户名作为您的华为帐号，用于登录、重设密码、验证身份。</p>
							<!--用户名  -->
							<div class="node_des">
								<label for="uname" class="input_intro">用户名:</label>
								<div class="input_text">
									<input autocomplete required minlength="6" maxlength="9"
										type="text" placeholder="输入用户名" autofocus id="uname"
										name="uname" class="text3" /> <span class="msg-default"
										id="usernamespan">用户名长度在6到9位之间</span>
								</div>
							</div>
							<!-- 手机号 -->
							<div class="node_des">
								<label for="phone" class="input_intro">手机号:</label>
								<div class="input_text">
									<input type="text" id="phone" name="phone" class="text3"
										placeholder="输入您的手机号"
										pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$"
										required /> <span class="msg-default hidden" id="phonespan">请输入合法的手机号</span>
								</div>
							</div>
							<!-- 邮箱 -->
							<div class="node_des">
								<label for="email" class="input_intro">邮箱：</label>
								<div class="input_text">
									<input type="text" id="email" name="email" class="text3"
										placeholder="请输入邮箱地址" autocomplete required /> <span
										class="msg-default hidden" id="emailspan">请输入合法的邮箱地址</span>
								</div>
							</div>

							<div class="box_shadow_in"></div>

						</div>
						<!-- 密码 -->
						<div class="node">
							<p class="node_title">设置登录密码</p>
							<div class="node_des">
								<label for="password" class="input_intro">登录密码：</label>
								<div class="input_text">
									<input id="password" name="password" type="password" required
										minlength="6" maxlength="12" placeholder="请输入密码" autofocus
										class="text3" /> <span class="msg-default hidden">密码长度在6到12位之间</span>
								</div>
							</div>
							<div class="node_des">
								<label for="upwdconfirm" class="input_intro">确认密码：</label>
								<div class="input_text">
									<input id="upwdconfirm" name="upwdconfirm" type="password"
										required minlength="6" maxlength="12" placeholder="请确认密码"
										autofocus class="text3" /> 
										<span id="upwdconfirmspan" class="msg-default hidden">密码长度在6到12位之间</span>
								</div>
							</div>
							<div class="node_des">
								<div class="psd_info">
									<div class="normal_tips">密码须包含：</div>
									<div id="pwdLength">
										<img class="pwd_format"
											src="${pageContext.request.contextPath}/img/reg_img/format_no.png">
										<img id="pwdLength_1" class="pwd_format hide"
											src="${pageContext.request.contextPath}/img/reg_img/format_ok.png">
										<span class="pwd_span">至少8个字符（不超过32个）</span>
									</div>
									<div id="pwdChar">
										<img class="pwd_format"
											src="${pageContext.request.contextPath}/img/reg_img/format_no.png"><img
											id="pwdChar_1" class="pwd_format hide"
											src="${pageContext.request.contextPath}/img/reg_img/format_ok.png"><span
											class="pwd_span">大写与小写字母</span>
									</div>
									<div id="pwdNumber">
										<img class="pwd_format"
											src="${pageContext.request.contextPath}/img/reg_img/format_no.png"><img
											id="pwdNumber_1" class="pwd_format hide"
											src="${pageContext.request.contextPath}/img/reg_img/format_ok.png">
										<span class="pwd_span">至少一个数字</span>
									</div>
								</div>
								<div class="psd_info">
									<div class="normal_tips">
										<a>密码强度：<span id="pwdComplexFlag">强</span><a>
									</div>
									<div id="pwd_strong"></div>
									<div class="node_intro" id="pwd_intro">勿使用其他帐号的密码。</div>
								</div>
							</div>
							<div class="box_shadow_in"></div>
						</div>
						<div class="node">
							<div class="titleNew node_title">FlyCafe帐号服务条款</div>
							<div id="agreement">
								<div class="node_intro">
									<div class="agrLineH">FlyCafe将为您创建唯一的FlyCafe帐号，来标识您和提供更优服务，且需搜集和处理以下信息：</div>
									<div class="agrLineH marginTop2">•&nbsp;&nbsp;设备信息，包括：IMEI、IMSI、SN、国家/地区、语言、型号和版本号；</div>
									<div class="agrLineH marginTop2">•&nbsp;&nbsp;个人信息，包括：手机号、邮件地址、密码、头像、昵称、生日、姓名和性别；</div>
									<div class="agrLineH marginTop8">
										点击“注册”，即表示您同意上述内容及 <a href="#" target="_blank"
											class="loginAndRegLink">FlyCafe帐号用户协议</a> 并确认您已阅读 <a href="#"
											target="_blank" class="loginAndRegLink">FlyCafe隐私政策</a>。
									</div>
								</div>
							</div>
							<div class="box_shadow_in"></div>
						</div>
					</div>
					<div class="reg_btn">
						<div id="reg_button">
							<input id="btnSubmit" value="注册" tabindex="7" type="button">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		/* 注册成功提交 */
		$('#btnSubmit').click(function() {
							var lengths = 0;
							$('.node_des').each(function() {
										if ($(this).find('span').hasClass(
												'msg-success')) {
											lengths++;
										}

									});
							alert(lengths);
							if (lengths == 5) {
								$.ajax({
									"url":"${pageContext.request.contextPath}/user/reg.do",
									"data":$("#form-reg").serialize(),
									"type":"POST",
									"dataType":"json",
									"success":function(obj){
										alert("00");
												//用户名重复
												if (obj == 0) {
													alert(obj.message);
												} else {
													location.href = "${pageContext.request.contextPath}/user/showLogin.do";
												}
											}
										});
							}
						})
	</script>
	<script type="text/javascript">
		/*1.对用户名进行验证*/
		uname.onblur = function() {
			if (this.validity.valueMissing) {
				this.nextElementSibling.innerHTML = '用户名不能为空';
				this.nextElementSibling.className = 'msg-error';
				this.setCustomValidity('用户名不能为空');
			} else if (this.validity.tooShort) {
				this.nextElementSibling.innerHTML = '用户名不能少于6位';
				this.nextElementSibling.className = 'msg-error';
				this.setCustomValidity('用户名不能少于6位');
			} else {
				this.nextElementSibling.innerHTML = '用户名格式正确';
				this.nextElementSibling.className = 'msg-success';
				this.setCustomValidity('');
				var data = document.getElementById("uname").value;
				if (!data) { //用户没有输入任何内容
					return;
				}
				/**发起异步GET请求，询问服务器用户名是否已经存在**/
				$
						.ajax({
							"url" : "${pageContext.request.contextPath}/user/checkUsername.do",
							"type" : "GET",
							"data" : "username=" + $("#uname").val(),
							"dataType" : "json",
							"success" : function(obj) {
								if (obj.state == 0) {
									$("#usernamespan").attr("class",
											"msg-error");
								} else {
									$("#usernamespan").attr("class",
											"msg-success");
								}
								$("#usernamespan").html(obj.message);
							}
						});
			}
		}
		uname.onfocus = function() {
			this.nextElementSibling.innerHTML = '用户名长度在6到9位之间';
			this.nextElementSibling.className = 'msg-default';
		}

		/*2.对密码进行验证*/
		password.onfocus = function() {
			this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
			this.nextElementSibling.className = 'msg-default';
		}
		password.onblur = function() {
			if (this.validity.valueMissing) {
				this.nextElementSibling.innerHTML = '密码不能为空';
				this.nextElementSibling.className = 'msg-error';
				this.setCustomValidity('密码不能为空');
			} else if (this.validity.tooShort) {
				this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
				this.nextElementSibling.className = 'msg-error';
				this.setCustomValidity('密码长度在尽量别少于6位');
			} else {
				this.nextElementSibling.innerHTML = '密码格式正确';
				this.nextElementSibling.className = 'msg-success';
				this.setCustomValidity('');
			}
		}
		/*2.对确认密码进行验证  */
		$("#upwdconfirm").focus(function(){
			$("#upwdconfirmspan").html("密码长度在6到12位之间");
			$("#upwdconfirmspan").attr("class","msg-default");
		})
		$("#upwdconfirm").blur(function(){
			var data=$("#upwdconfirm").val();
			var passwordData=$("#password").val();
			if(data==null||data==""){
				$("#upwdconfirmspan").html("密码不能为空");
				$("#upwdconfirmspan").attr("class","msg-error");
			}else if(data.length<6||data.length>12){
				$("#upwdconfirmspan").html("密码格式不正确");
				$("#upwdconfirmspan").attr("class","msg-error");
			}else if(data!=passwordData){
				$("#upwdconfirmspan").html("两次密码不一致");
				$("#upwdconfirmspan").attr("class","msg-error");
			}else{
				$("#upwdconfirmspan").html("密码格式正确");
				$("#upwdconfirmspan").attr("class","msg-success");
			}
		})

		
		/*4.对邮箱地址进行验证*/
		email.onblur = function() {
			var str = $("#email").val();
			var emailStr = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
			if (this.validity.valueMissing) {
				this.nextElementSibling.innerHTML = '邮箱不能为空';
				this.nextElementSibling.className = 'msg-error';
				this.setCustomValidity('邮箱不能为空');
			} else if (this.validity.typeMismatch) {
				this.nextElementSibling.innerHTML = '邮箱格式不正确';
				this.nextElementSibling.className = 'msg-error';
				this.setCustomValidity('邮箱格式不正确');
			}else if(!emailStr.test(str)){
				this.nextElementSibling.innerHTML = '邮箱格式不正确';
				this.nextElementSibling.className = 'msg-error';
				this.setCustomValidity('邮箱格式不正确');
			}
			else {
				this.nextElementSibling.innerHTML = '邮箱格式正确';
				this.nextElementSibling.className = 'msg-success';
				this.setCustomValidity('');

				var data = document.getElementById("email").value;
				if (!data) { //用户没有输入任何内容
					return;
				}
				/**发起异步GET请求，询问服务器用户名是否已经存在**/
				$
						.ajax({
							"url" : "${pageContext.request.contextPath}/user/checkEmail.do",
							"type" : "GET",
							"data" : "email=" + $("#email").val(),
							"dataType" : "json",
							"success" : function(obj) {
								if (obj.state == 0) {
									$("#emailspan").attr("class", "msg-error");
								} else {
									$("#emailspan")
											.attr("class", "msg-success");
								}
								$("#emailspan").html(obj.message);
							}
						});
			}
		}
		email.onfocus = function() {
			this.nextElementSibling.innerHTML = '请输入合法的邮箱地址';
			this.nextElementSibling.className = 'msg-default';
		}
		/*5.对手机号进行验证*/
		phone.onblur = function() {
			if (this.validity.valueMissing) {
				this.nextElementSibling.innerHTML = '手机号不能为空';
				this.nextElementSibling.className = 'msg-error';
				this.setCustomValidity('手机号不能为空');
			} else if (this.validity.patternMismatch) {
				this.nextElementSibling.innerHTML = '手机号格式不正确';
				this.nextElementSibling.className = 'msg-error';
				this.setCustomValidity('手机号格式不正确');
			} else {
				this.nextElementSibling.innerHTML = '手机号格式正确';
				this.nextElementSibling.className = 'msg-success';
				this.setCustomValidity('');

				var data = document.getElementById("phone").value;
				if (!data) { //用户没有输入任何内容
					return;
				}
				/**发起异步GET请求，询问服务器用户名是否已经存在**/
				$
						.ajax({
							"url" : "${pageContext.request.contextPath}/user/checkPhone.do",
							"type" : "GET",
							"data" : "phone=" + $("#phone").val(),
							"dataType" : "json",
							"success" : function(obj) {
								if (obj.state == 0) {
									$("#phonespan").attr("class", "msg-error");
								} else {
									$("#phonespan")
											.attr("class", "msg-success");
								}
								$("#phonespan").html(obj.message);
							}
						});
			}
		}
		phone.onfocus = function() {
			this.nextElementSibling.innerHTML = '请输入合法的手机号';
			this.nextElementSibling.className = 'msg-default';
		}
	</script>
</body>
</html>