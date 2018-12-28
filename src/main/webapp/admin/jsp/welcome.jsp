<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<style type="text/css">
body {
	margin: 0;
	background:#D76B00;
}
.container {
	width: 100%;
	text-align: center;
	color: #fff;
}

.h1{
width:100%;
height:150px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="h1">系统首页</h1>
		<div style="font-size:20px;">
			<p>恭喜 ${admin.username} ,登录成功！</p>
		</div>
	</div>
</body>
</html>