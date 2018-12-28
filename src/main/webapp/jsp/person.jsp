<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Fly Cafe 会员信息</title>
<link href="${pageContext.request.contextPath}/css/person.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/header.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="container">
		<%@include file="header.jsp"%>
		<div id="main">
			<div id="center">
				<div id="center_top">
					<div id="center_top_l">
						<div id="childlogo">
							<img src="${pageContext.request.contextPath}/img/childlogo.png" />
						</div>
						<span class="logo_text">帐号中心</span>
					</div>
					<div id="center_top_r">
						<ul class="ul">
							<li><a
								href="${pageContext.request.contextPath}/user/showPassword.do">账号与安全</a></li>
							<li><a href="#" class="active">个人信息</a></li>
							<li><a
								href="${pageContext.request.contextPath}/address/showAddress.do">收货地址</a></li>
						</ul>
					</div>
				</div>
				<!-- 个人信息具体内容 -->
				<div id="center_m">
					<form action="" enctype="multipart/form-data">
						<div id="center_m_l">
							<div id="touxiang-pic">
								<img alt="暂无图片" id="myImg" src="/upload/${user.image}" height="100px" width="100px">
								<input type="file" name="file" id="file" accept="image/*" onchange="showImage(event)">
							</div>
							<p>编辑头像</p>
						</div>
					</form>
					<form action="" id="person_form" name="person_form" method="post">
						<div id="center_m_r">
							<p class="title">公开信息</p>
							<div class="line"></div>
							<!-- 用户名 -->
							<div class="text">
								<span class="font">用户名称：</span> <input type="text" id="username"
									name="username" class="input" style="display: none"
									value="${user.username}"> <span class="usernamespan">${user.username}</span>
								<span class="font_meg" id="username">更改用户名</span>
							</div>
							<div class="line"></div>

							<!--性别-->
							<div class="text">
								<span class="font">性别：</span> 女 <input type="radio"
									name="gender" id="woman"
									style="margin-right: 80px; margin-left: 20px;"
									<c:if test="${user.gender==0}">checked="checked"</c:if>
									value="0"> 男 <input type="radio" name="gender" id="man"
									style="margin-left: 20px;"
									<c:if test="${user.gender==1}">checked="checked"</c:if>
									value="1">
							</div>
							<div class="line"></div>
							<!-- 绑定电话 -->
							<div class="text">
								<span class="font">电话:</span> <input type="text"
									style="display: none" id="phone" name="phone" class="input"
									value="${user.phone}"> <span class="phonespan">${user.phone}</span>
								<span class="font_meg" id="phone">更改绑定电话号码</span>

							</div>
							<div class="line"></div>
							<!-- 绑定邮箱 -->
							<div class="text">
								<span class="font">邮箱：</span> <input type="text"
									style="display: none" id="email" name="email" class="input"
									value="${user.email}"> <span class="emailspan">${user.email}</span>
								<span class="font_meg" id="email">更改邮箱</span>

							</div>
							<div class="line"></div>
							<a href="#"><input type="button" id="messageUpdate"
								value="修改信息" /></a>
						</div>
					</form>
				</div>

			</div>
		</div>
		<!-- footer -->
		<div id="footer">
			<div class="ft">
				<p class="ft_a">
					<a
						href="https://hwid1.vmall.com/CAS/portal/agreements/userAgreement/zh-cn_userAgreement.html?version=china"
						class="rule" target="_blank">用户协议</a> | <a
						href="https://hwid1.vmall.com/CAS/portal/agreements/userPrivacyPolicy/zh-cn_userPrivacyPolicy.html?version=europe"
						class="rule" target="_blank">隐私政策</a> | <a
						href="https://hwid1.vmall.com/CAS/portal/faq/faq.html"
						class="ifaq" target="_blank">常见问题</a>
				</p>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
	<script type="text/javascript">
		//图片上传并显示
		function showImage(e) {
			for (var i = 0; i < e.target.files.length; i++) {
				var file = e.target.files.item(i);
				if (!(/^image\/.*$/i.test(file.type))) {
					continue; //不是图片 就跳出这一次循环  
				}
				//实例化FileReader API  
				var freader = new FileReader();
				freader.readAsDataURL(file);
				freader.onload = function(e) {
					$("#myImg").attr("src", e.target.result);
				};
			}
			//创建FormData对象
			var formData = new FormData();
			var file = document.getElementById("file").files[0];
			formData.append("file", file);
			$.ajax({
				"url" : "../user/uploadImage.do",
				"data" : formData,
				"type" : "POST",
				"dataType" : "json",
				"contentType" : false,
				"processData" : false,
				"success" : function(obj) {
					alert(obj.message);
				}
			}) 
		}
		//点击更改的span时触发的事件
		$(".font_meg").each(function() {
			$(this).click(function() {
				var parent = $(this).parent();
				$(parent).children("span").eq(1).hide();
				var name = $(parent).children("span").eq(1).html();
				$(parent).children("input").val(name);
				$(parent).children("input").show();
			})
		})
		//保存的点击事件的触发事件
		$("#messageUpdate")
				.click(
						function() {
							alert("aaa");
							$
									.ajax({
										"url" : "${pageContext.request.contextPath}/user/updatePerson.do",
										"data" : $("#person_form").serialize(),
										"type" : "POST",
										"dataType" : "json",
										"success" : function(obj) {
											if (obj.state == 1) {
												location.href = "${pageContext.request.contextPath}/user/showPerson.do";
											} else {
												alert(obj.state + ","
														+ obj.message);
											}

										}
									})
						})
	</script>
</body>
</html>