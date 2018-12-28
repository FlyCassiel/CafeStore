<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
a{
display: inline-block;
width:100px;
height:30px;
margin-right:40px;
border-radius:50%/50%;
background: -webkit-linear-gradient(left top, red , #974B00); /* Safari 5.1 - 6.0 */
background: -o-linear-gradient(bottom right, red, #974B00); /* Opera 11.1 - 12.0 */
background: -moz-linear-gradient(bottom right, red, #974B00); /* Firefox 3.6 - 15 */
background: linear-gradient(to bottom right, red , #974B00); /* 标准的语法 */
text-align: center;
line-height: 30px;
}
</style>
</head>
<body>
<div style="float: right;"><a href="${pageContext.request.contextPath}/order/showOrderItemAdmin.do">订单详情页</a></div>
<div style="margin:40px 100px; width:100%;">
	<table style="width:100%;border: 0px;">
		<tr>
			<td>订单id</td>
			<td>用户id</td>
			<td>订单生成时间</td>
		</tr>
		<c:forEach items="${orderList}" var="order">
			<tr>
				<td>${order.id}</td>
				<td>${order.userid}</td>
				<td>${order.tradetime}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>