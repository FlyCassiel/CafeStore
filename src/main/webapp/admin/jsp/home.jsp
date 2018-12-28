<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<frameset rows="103,*,43" frameborder=0 border="0" framespacing="0">
	<frame src="${pageContext.request.contextPath}/admin/jsp/top.jsp"	name="topFrame" scrolling="NO" noresize>
	<frameset cols="159,*" frameborder="0" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath}/admin/jsp/left.jsp" name="leftFrame" noresize scrolling="YES">
		<frame src="${pageContext.request.contextPath}/admin/jsp/welcome.jsp" name="mainFrame">
	</frameset>
	<frame src="${pageContext.request.contextPath}/admin/jsp/bottom.jsp" name="bottomFrame" scrolling="NO" noresize>
</frameset>
</html>