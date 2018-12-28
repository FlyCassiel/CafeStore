<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>FlyCafe商城——支付页面</title>
<link href="${pageContext.request.contextPath}/css/header.css"
	rel="Stylesheet" />
<link href="${pageContext.request.contextPath}/css/payment.css"
	rel="Stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<style>
.okPay a {
	color: #FFFFFF;
}
</style>
</head>
<body>
	<!-- 头部 -->
	<%@include file="header.jsp"%>
	<div id="navlist">
		<ul>
			<li class="navlist_gray_left"></li>
			<li class="navlist_gray">确认订单信息</li>
			<li class="navlist_gray_arro"><canvas id="canvas_gray"
					width="20" height="38"></canvas></li>
			<li class="navlist_blue">支付订单<b></b></li>
			<li class="navlist_blue_arro"><canvas id="canvas_blue"
					width="20" height="38"></canvas></li>
			<li class="navlist_gray">支付完成<b></b></li>
			<li class="navlist_gray_right"></li>
		</ul>
	</div>
	<!--订单确认-->
	<form action="pay_success.html" method="post" id="pay_form">
		<div id="container" class="clearfix">
			<!-- 支付订单信息-->
			<div class="pay_info">
				<!-- <b>支付金额：<i>4800元</i></b> -->
				<input type="hidden" name="payment" value="0.01" /> <span>支付订单：${orderid}
					收款方：FlyCafe 商城</span><input type="hidden" name="orderId" />
			</div>
			<!--支付方式-->
			<div id="pay_type">
				<!-- 支付方式头-->
				<div class="pay_type_title">
					<b>网上银行支付</b>
				</div>
				<div id="dnBank">
					<ul>
						<li><input type="radio" name="bankId" value="BOC-NET-B2C"
							id="02zg"> <label for="02zg"><img
								src="${pageContext.request.contextPath}/img/order/pay_img1.jpg"
								alt="" /></label></li>
						<li><input type="radio" name="bankId" value="ICBC-NET-B2C"
							id="03gs"> <label for="03gs"><img
								src="${pageContext.request.contextPath}/img/order/pay_img2.jpg"
								alt="" /></label></li>
						<li><input type="radio" name="bankId"
							value="CMBCHINA-NET-B2C" id="04zs"> <label for="04zs"><img
								src="${pageContext.request.contextPath}/img/order/pay_img3.jpg"
								alt="" /></label></li>
						<li><input type="radio" name="bankId" value="CCB-NET-B2C"
							id="05js"> <label for="05js"><img
								src="${pageContext.request.contextPath}/img/order/pay_img4.jpg"
								alt="" /></label></li>
						<li><input type="radio" name="bankId" value="ABC-NET-B2C"
							id="06ny"> <label for="06ny"><span><img
									src="${pageContext.request.contextPath}/img/order/pay_img5.jpg"
									alt="" /></span></label></li>

					</ul>
				</div>

			</div>
			<!--结算条-->
			<div id="count_bar">
				<span class="pay_leftTime"> 剩余付款时间:</span> 
				<span id="time"></span>
				<input id="remainingTime" value="${remainingTime}"></input> <span
					class="okPay"> <a
					href="${pageContext.request.contextPath}/order/pay.do">确认支付</a></span>

			</div>

		</div>
	</form>
	<script>
		$("#count_bar .okPay").css("display", "none");
		$("#dnBank>ul>li img").click(
				function() {
					$(this).addClass("hover");
					$(this).parent().parent().siblings().children('label')
							.children('img').removeClass('hover');
					$("#count_bar .okPay").show("3000");
				});
	</script>
	<script type="text/javascript">
		function payment() {
			$("#pay_form").submit();
			// document.getElementById('pay_form').submit();
			alert(11);
		}
	</script>
	<script>
		var canvas = document.getElementById("canvas_gray");
		var cxt = canvas.getContext("2d");
		var gray = cxt.createLinearGradient(10, 0, 10, 38);
		gray.addColorStop(0, '#f5f4f5');
		gray.addColorStop(1, '#e6e6e5');
		cxt.beginPath();
		cxt.fillStyle = gray;
		cxt.moveTo(20, 19);
		cxt.lineTo(0, 38);
		cxt.lineTo(0, 0);
		cxt.fill();
		cxt.closePath();
	</script>
	<script>
		var canvas = document.getElementById("canvas_blue");
		var cxt = canvas.getContext("2d");
		var blue = cxt.createLinearGradient(10, 0, 10, 38);
		blue.addColorStop(0, '#27b0f6');
		blue.addColorStop(1, '#0aa1ed');
		cxt.beginPath();
		cxt.fillStyle = blue;
		cxt.moveTo(20, 19);
		cxt.lineTo(0, 38);
		cxt.lineTo(0, 0);
		cxt.fill();
		cxt.closePath();
	</script>
	<script>
	var totleSecond = initTimer();  
	startTime(totleSecond);   //开始倒计时  
	function initTimer(){  
		var totleSecond = Number($("#remainingTime").val())  //获取上图的input的剩余时间  
		return totleSecond;  
	}  
	function startTime(totleSecond){  
		$("#time").text(formatTime(totleSecond));  
		var timer = setInterval(function(){  
		totleSecond -= 1 ;  
		$("#remainingTime").val(totleSecond);   //给上图的input更新剩余时间  
		if(totleSecond >=0 ){  
		$("#time").text(formatTime(totleSecond));  
		}else{    
		alert("时间到，订单失效！")  
		clearInterval(timer);  
		$("#remainingTime").val("");  
		$("#dnBank>ul>li img").click(
				function() {
					$(this).addClass("hover");
					$(this).parent().parent().siblings().children('label')
							.children('img').removeClass('hover');
					$("#count_bar .okPay").hide();
					alert("订单已经失效，请重新选取购买");
				});
		}  
		},1000)  
		}  
		function formatTime(totleSecond){  
		var hour = Math.floor(totleSecond/3600);  
		var minute = Math.floor((totleSecond%3600)/60);  
		var second = Math.floor(totleSecond%60);  
		hour = formatTimeNumber(hour);  
		minute  = formatTimeNumber(minute)  
		second  = formatTimeNumber(second);  
		return (hour +":"+minute+":"+second)  
		}  
		function formatTimeNumber(number){  
		if(number<10){  
		return "0"+number;  
		}else{  
		return number;  
		}  
		}
	</script>
</body>
</html>

