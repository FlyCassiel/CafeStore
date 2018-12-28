<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

body {
	background:#D76B00;
}

.ta_01 {
	padding-top: 4px;
	padding-bottom: 2px;
	padding-right: 2px;
	padding-left: 3px;
	line-height: 135%;
}

button {
	background-color: #555;
	margin: 1px;
	padding: 1px 3px;
	border: 1px solid #222;
	color: #fff;
	cursor: pointer;
	height: 40px;
    width: 100px;
}

.container {
	position: absolute;
	top: 150px;
	right: 150px;
}

.hang {
	width: 400px;
	height: 50px;
	line-height: 50px;
	font-size: 18px;
	color: white;
}

.hang span {
	display: inline-block;
	width: 100px;
	height: 30px;
	line-height: 30px;
}

.hang input {
	width: 200px;
	height: 30px;
	line-height: 30px;
	border: 2px solid #8ba7e3;
}

.hang input.sex {
	width: 20px;
	height: 30px;
	line-height: 30px;
	margin: 10px;
}
</style>
</head>

<body>

	<!-- 头部信息 -->
	<div
		style="height: 80px; line-height: 80px; font-size: 20px; color: #fff; text-align: center;">
		<span>编辑 Fly Cafe 用户信息</span>
	</div>

	<div class="container">
		<!-- 表单 -->
		<form id="adminsaveForm" name="adminsaveForm" action="" method="post">
			<!-- 隐藏的表单信息 -->
			<input type="hidden" name="id" value="${user.id}" />
			<!-- 用户名 -->
			<div class="hang">
				<span style="margin-right: 20px;">用户名:</span> <input type="text"
					id="username" name="username" value="${user.username}"
					readonly="readonly" />
			</div>
			<!-- 密码 -->
			<%-- <div class="hang">
				<span style="margin-right: 20px;">密码:</span> <input type="text"
					id="password" name="password" value="${user.password}" />
			</div> --%>
			<!-- 电话-->
			<div class="hang">
				<span style="margin-right: 20px;">电话:</span> <input type="text"
					id="phone" name="phone" value="${user.phone}" />
			</div>
			<!-- 邮箱 -->
			<div class="hang">
				<span style="margin-right: 20px;">邮箱:</span> <input type="text"
					id="email" name="email" value="${user.email}" />
			</div>
			<!-- 性别 -->
			<div class="hang">
				<span style="margin-right: 20px;">性别:</span> <input type="radio"
					name="gender" id="gender" class="sex"
					<c:if test="${user.gender==0}">checked="checked"</c:if> value="0">女
				<input type="radio" name="gender" id="gender" class="sex"
					<c:if test="${user.gender==1}">checked="checked"</c:if> value="1">男
			</div>
			<button type="button" value="确定" class="button_ok" id="edit_button">&#30830;&#23450;</button>
			<font face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
			<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>
			<font face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font> <input
				class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
			<span id="Label1"></span>
		</form>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script type="text/javascript">
	//点击确定的时候触发的异步刷新事件
	$("#edit_button")
			.click(
					function() {
						$
								.ajax({
									"url" : "${pageContext.request.contextPath}/admin/updateUser.do",
									"data" : $("#adminsaveForm").serialize(),
									"type" : "POST",
									"dataType" : "json",
									"success" : function(obj) {
										if (obj.state == 1) {
											location.href = "${pageContext.request.contextPath}/admin/showEdit.do?id=${user.id}";
										} else {
											alert(obj.state + "," + obj.message);
										}

									}
								})
					})
</script>
</html>