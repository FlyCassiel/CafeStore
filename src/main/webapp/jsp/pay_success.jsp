<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>学子商城——支付页面</title>
<link rel="stylesheet" href="../css/header.css" />
<link rel="stylesheet" href="../css/footer.css" />
<link href="../css/payment.css" rel="Stylesheet" />
<script src="../js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<!-- 页面顶部-->
	<jsp:include page="header.jsp"></jsp:include>
	<div id="navlist">
		<ul>
			<li class="navlist_gray_left"></li>
			<li class="navlist_gray">确认订单信息</li>
			<li class="navlist_gray_arrow"></li>
			<li class="navlist_gray">支付订单<b></b></li>
			<li class="navlist_gray_arrow"></li>
			<li class="navlist_blue">支付完成<b></b></li>
			<li class="navlist_blue_right"></li>
		</ul>
	</div>
	<div id="container">
		<div>
			<h1>
				<i>支付结果</i><span class="rt">支付订单：${orderid} &nbsp; 支付金额：
				<b>
            	<span class="sum"></span>
				</b>
			<c:if test="${cartVoList!=null}">
			<script type="text/javascript">
            var sum=0;
            <c:forEach items="${cartVoList}" var="cartVo">
            	sum=sum+${cartVo.count}*${cartVo.price};
            </c:forEach>
            $(".sum").html(sum);
            </script>
            </c:if>
            <c:if test="${orderItemVos!=null}">
			<script type="text/javascript">
            var sum=0;
            <c:forEach items="${orderItemVos}" var="cartVo">
            	sum=sum+${cartVo.count}*${cartVo.price};
            </c:forEach>
            $(".sum").html(sum);
            </script>
            </c:if>
			</span>
			</h1>
		</div>
		<div class="rightsidebar_box rt">
			<div class="pay_result">
				<img src="../images/pay/pay_succ.png" alt="" />
				<p>支付成功</p>
				<span><a href="#">查看订单状态？ </a><b><a href="#">查看订单&gt;&gt;</a></b></span>
				<br /> FlyCafe学子商城不会以系统异常、订单升级为由，要求你点击任何链接进行退款操作！
			</div>
		</div>
	</div>
</body>
</html>