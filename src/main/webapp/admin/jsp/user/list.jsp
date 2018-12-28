<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
body{
background:#D76B00;
}
.ta_01 {
	padding-top: 4px;
	padding-bottom: 2px;
	padding-right: 2px;
	padding-left: 3px;
	line-height: 135%;
}
.div {
	color: #fff;
	height: 60px;
	line-height: 60px;
	font-size: 20px;
}
.div input{
height:30px;
}
.footer{
margin:0 auto;
font-size:14px;
width:400px;
margin-right: 30%;
}
.footer ul{
list-style: none;
}
.footer ul li{
float: left;
width:28px;
height:28px;
line-height:28px;
font-size:14px;
border:1px solid black;
background-color:#7e422c;
text-align: center;
cursor: pointer;
}
</style>
</head>
<body>
	<table cellSpacing="0" cellPadding="0" width="100%" align="center" border="0">
		<tbody>
			<tr>
				<td class="ta_01" align="center" height="60px"><strong style="color:#fff;">用户列表</strong>
				</TD>
			</tr>
			<tr>

			</tr>
			<tr>
				<td class="ta_01" align="center">
					<div class="div">
						请输入要查询的姓名:&nbsp; <input type="text" name="username" id="username"
							value="${username}" />
						<button onclick="query()">查询</button>
					</div>
					<table cellspacing="0" cellpadding="0" rules="all" border="1" id="DataGrid1"
						style="width: 100%; WORD-BREAK: break-all; WORD-WRAP: break-word">
						<tr
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; height: 35px;">

							<td align="center" width="18%" style="color: #fff;">序号</td>
							<td align="center" width="17%" style="color: #fff;">用户名</td>
							<td align="center" width="17%" style="color: #fff;">密码</td>
							<td align="center" width="17%" style="color: #fff;">手机号码</td>
							<td align="center" width="17%" style="color: #fff;">电子邮箱</td>
							<td width="7%" align="center" style="color: #fff;">编辑</td>
							<td width="7%" align="center" style="color: #fff;">删除</td>
						</tr>

						<c:if test="${userlist!=null}">
							<c:forEach items="${userlist}" var="user" varStatus="st">
								<tr style="height:35px">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${user.id}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${user.username}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${user.password}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${user.phone}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${user.email}</td>

									<td align="center" style="HEIGHT: 22px">
									<a href="${pageContext.request.contextPath}/admin/showEdit.do?id=${user.id}">
									<img src="${pageContext.request.contextPath}/admin/img/userlist/i_edit.gif"
										border="0" style="CURSOR: hand">
									</a>
									</td>

									<td align="center" style="HEIGHT: 22px"><a
										href="javascript:del(${user.id})"> <img
											src="${pageContext.request.contextPath}/admin/img/userlist/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${userQuerylist!=null}">
							<c:forEach items="${userQuerylist}" var="userQuery">
								<tr style="height:35px">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${userQuery.id}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${userQuery.username}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${userQuery.password}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${userQuery.phone}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${userQuery.email}</td>

									<td align="center" style="HEIGHT: 22px"><a
										href="${pageContext.request.contextPath}/admin/showEdit.do?id=${userQuery.id}">
											<img
											src="${pageContext.request.contextPath}/admin/img/userlist/i_edit.gif"
											border="0" style="CURSOR: hand">
									</a></td>

									<td align="center" style="height: 22px"><a
										href="javascript:del(${userQuery.id})"> <img
											src="${pageContext.request.contextPath}/admin/img/userlist/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
	<!--分页查询  -->
	<c:if test="${username==null}">
	<div class="footer">
		<div style="height:35px;">
		 <c:forEach begin="1" end="${pageCount}" var="i">
				<c:if test="${currentPage==i}">
				<ul><li><font color="red">${i}</font></li></ul>
				</c:if>
				<c:if test="${currentPage!=i}">
					<ul><li onclick="fenye(${i})" style="color:skyblue">${i}</li></ul>
				</c:if>
		</c:forEach> 
		<span style="margin-left: 20px;">
		跳转到： <select onchange="fenye(this.value)" style="height:30px; width:50px;">
				<c:forEach begin="1" end="${pageCount}" var="i">
					<option style="color: black"
						${currentPage==i?"selected='selected'":""} value="${i}">${i}</option>
			</c:forEach>
		</select>
		</span>
		</div>
		共${count}条记录|共${pageCount}页
	</div>
	</c:if>
	<c:if test="${username!=null}">
	<div class="footer">
		<div style="height:35px;">
		 <c:forEach begin="1" end="${pageCount}" var="i">
				<c:if test="${currentPage==i}">
				<ul><li><font color="red">${i}</font></li></ul>
				</c:if>
				<c:if test="${currentPage!=i}">
					<ul><li onclick="queryfenye(${i})" style="color:skyblue">${i}</li></ul>
				</c:if>
		</c:forEach> 
		<span style="margin-left: 20px;">
		跳转到： <select onchange="queryfenye(this.value)" style="height:30px; width:50px;">
				<c:forEach begin="1" end="${pageCount}" var="i">
					<option style="color: black"
						${currentPage==i?"selected='selected'":""} value="${i}">${i}</option>
			</c:forEach>
		</select>
		</span>
		</div>
		共${count}条记录|共${pageCount}页
	</div>
	</c:if>

</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script type="text/javascript">
	/*删除  */
	function del(id) {
		if (confirm("你确认删除吗?")) {
			location.href = "${pageContext.request.contextPath}/admin/deleteUser.do?id="
					+ id;
		}
	}
	/* 查询加查询分页 */
	function queryfenye(curPage) {
		var useranme = $("#username").val();
		location.href = "${pageContext.request.contextPath}/admin/showQuery.do?page="+curPage+"username="+useranme;
	}
	function query() {
		var useranme = $("#username").val();
		location.href = "${pageContext.request.contextPath}/admin/showQuery.do?username="+useranme;
	}
	/* 分页 */
	function fenye(curPage) {
		var useranme = $("#username").val();
		location.href = "${pageContext.request.contextPath}/admin/showUser.do?page="
				+ curPage;
	}
</script>
</HTML>

