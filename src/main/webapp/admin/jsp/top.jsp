<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	background:#D76B00;
	margin: 0;
	font-size: 12px;
}

td {
	font-size: 12px;
	color: #eee;
	
}

.td_1 {
	font-size: 18px;
}

th {
	font-size: 12px;
	color: #000;
}

.back {
	width: 100%;
	height: 70px;
	background: url(${pageContext.request.contextPath}/images/admin-top.jpg)
		no-repeat;
}
.xianxian{
width:100%;
height:2px;
background: #884400;
}
</style>
</head>
<body>
	<div class="back"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" valign="bottom">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="85%" align="left" class="td_1">&nbsp;&nbsp;&nbsp;&nbsp;
							<font> <script language="JavaScript">
								tmpDate = new Date();
								date = tmpDate.getDate();
								month = tmpDate.getMonth() + 1;
								year = tmpDate.getFullYear();

								document.write(year);
								document.write("年");
								document.write(month);
								document.write("月");
								document.write(date);
								document.write("日 ");

								myArray = new Array(6);
								myArray[0] = "星期日"
								myArray[1] = "星期一"
								myArray[2] = "星期二"
								myArray[3] = "星期三"
								myArray[4] = "星期四"
								myArray[5] = "星期五"
								myArray[6] = "星期六"
								weekday = tmpDate.getDay();
								if (weekday == 0 | weekday == 6) {
									document.write(myArray[weekday])
								} else {
									document.write(myArray[weekday])
								};
							</script>
						</font>
						</td>
						<td width="15%">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr style="color: #fff;">
									<td width="16"></td>
									<td width="155" valign="bottom" class="td_1">管理员: <font
										color="skyblue">${admin.username}</font>
									</td>
									<td width="10" align="right"></td>
								</tr>
							</table>
						</td>
						<td align="right" width="5%"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<div class="xianxian"></div>
</body>
</html>
