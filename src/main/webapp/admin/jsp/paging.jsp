<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>分页</title>
<style type="text/css">
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
<!-- 底部的分页 -->
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
</body>
</html>