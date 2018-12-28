<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>确认订单</title>
<link href="${pageContext.request.contextPath}/css/header.css"
	rel="Stylesheet" />
<link href="${pageContext.request.contextPath}/css/address.css"
	rel="Stylesheet" />
<link href="${pageContext.request.contextPath}/css/orderConfirm.css"
	rel="Stylesheet" />
</head>
<body>
	<!-- 头部信息 -->
	<%@include file="header.jsp"%>
	<div id="navlist">
		<ul>
			<li class="navlist_blue_left"></li>
			<li class="navlist_blue">确认订单信息</li>
			<li class="navlist_blue_arro"><canvas id="canvas_blue"
					width="20" height="38"></canvas></li>
			<li class="navlist_gray">支付订单<b></b></li>
			<li class="navlist_gray_arro"><canvas id="canvas_gray"
					width="20" height="38"></canvas></li>
			<li class="navlist_gray">支付完成<b></b></li>
			<li class="navlist_gray_right"></li>
		</ul>
	</div>
	<!--订单确认-->
	<div id="container" class="clear">
		<!--收货地址-->
		<div class="adress_choice">
			<p>
				收货人信息<span class="rt" id="choose">新增收货地址</span>
			</p>
			<c:forEach items="${addressList}" var="address">
				<c:if test="${address.isDefault==1}">
					<div id="addresId1" class="base_select">
						<i class="address_name"> ${address.recvName} </i> 
						<i class="user_address">
							${address.recvDistrict}${address.recvAddr}${address.recvPhone} 
						</i>
						<i class="user_site rt"></i>
					</div>
				</c:if>
				<c:if test="${address.isDefault==0}">
					<div id="addresId2" class="base">
						<i class="address_name"> ${address.recvName} </i> 
						<i class="user_address">
							${address.recvDistrict}${address.recvAddr}${address.recvPhone} 
						</i> 
						<i class="user_site rt" onclick="setDefault1(${address.id})">设为默认地址 </i>
					</div>
				</c:if>
			</c:forEach>
		</div>
		<a id="more" href="javascript:void(0);"> 更多地址 &gt;&gt; </a>
	<!-- 商品信息-->
	<form name="" method="post" action="#">
		<div class="product_confirm">
			<p>确认商品信息</p>
			<ul class="item_title">
				<li class="p_info">商品信息</li>
				<li class="p_price">单价(元)</li>
				<li class="p_count">数量</li>
				<li class="p_tPrice">金额</li>
			</ul>
			<c:forEach items="${cartVoList}" var="cartVo">
				<ul class="item_detail">
					<li class="p_info"><b><img
							src="${pageContext.request.contextPath}${cartVo.image}"
							width="84px" height="84px" /></b> <b class="product_name lf">
							${cartVo.title} </b> <br /> <span class="product_color ">
							口味:${cartVo.taste}</span></li>
					<li class="p_price"><i>专属价</i> <br /> <span
						class="pro_price">￥<span class="ppp_price">${cartVo.price}</span></span>
					</li>
					<li class="p_count">X<span>${cartVo.count}</span></li>
					<li class="p_tPrice">￥<span></span></li>
				</ul>
			</c:forEach>
		</div>
	</form>
	<!-- 结算条-->
	<div id="count_bar">
		<span class="go_cart"><a href="${pageContext.request.contextPath}/cart/showCart.do">&lt;&lt;返回购物车</a></span> <span
			class="count_bar_info">已选<b id="count"> 0 </b>件商品&nbsp;&nbsp;合计(不含运费):<b
			class="zj"></b> <input type="hidden" name="Payment" value="" />元
		</span> <span class="go_pay">确认并付款</span>
	</div>
	</div>
	<!--标题栏-->
	<div class="modal" style="display: none">
		<!--收货人信息填写栏-->
		<div class="rs_content rs_content_1">
			<p class="cha">×</p>
			<form method="post" action="${pageContext.request.contextPath}/address/addOrder.do">
				<!--收货人姓名-->
				<div class="recipients">
					<span class="red">*</span><span class="kuan">收货人：</span><input
						type="text" name="receiverName" id="receiverName" />
				</div>
				<!--收货人所在城市等信息-->
				<div class="address_content">
						<span class="red">*</span> 
						<span class="kuan" style="width: 70px;">
						省&nbsp;&nbsp;份：</span>
						<select data-province="---- 选择省 ----" id="receiverState"
							name="receiverState" onchange="getCity(this.value,-1,-1)"></select>
						城市：<select data-city="---- 选择市 ----" id="receiverCity"
							name="receiverCity" onchange="getArea(this.value,-1)"></select>
						区/县：<select data-district="---- 选择区 ----" id="receiverDistrict"
							name="receiverDistrict">
						</select>
				</div>
				<!--收货人详细地址-->
				<div class="address_particular">
					<span class="red">*</span><span class="kuan">详细地址：</span>
					<textarea name="receiverAddress" id="receiverAddress" cols="60"
						rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
				</div>
				<!--收货人地址-->
				<div class="address_tel">
					<span class="red">*</span><span class="kuan">手机号码：</span><input
						type="tel" id="receiverMobile" name="receiverMobile" />固定电话：<input
						type="text" name="receiverPhone" id="receiverPhone" />
				</div>
				<!--邮政编码-->
				<div class="address_postcode">
					<span class="red">&nbsp;<span class="kuan"></span>邮政编码：
					</span>&nbsp;<input type="text" name="receiverZip" />
				</div>
				<!--地址名称-->
				<div class="address_name">
					<span class="red">&nbsp;<span class="kuan"></span>地址名称：
					</span>&nbsp;
					<input type="text" id="addressName" name="addressName" />如：
					<span class="sp">家</span>
					<span class="sp">公司</span>
					<span class="sp">宿舍</span>
				</div>
				<!--保存收货人信息-->
				<div class="save_recipient">保存收货人信息</div>
			</form>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
	<!-- js验证 -->
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/personal.js"></script>
	<script type="text/javascript">
	//定义函数，设置地址默认值
	function setDefault1(id){
		location.href="${pageContext.request.contextPath}/address/setDefault1.do?id="+id;
	}
	</script>
	<script>
		var html = 0;
		var total = 0;
		$(function() {
			$(".item_detail")
					.each(
							function() {
								html += 1;
								var p = parseFloat($(this).children('.p_price')
										.children('.pro_price').children(
												'.ppp_price').html());
								console.log(p);
								var sl = parseFloat($(this)
										.children('.p_count').children('span')
										.html());
								var xj = parseFloat(p * sl).toFixed(2);
								console.log("xiaoji" + xj);
								$(this).children('.p_tPrice').children('span')
										.html(xj);
								total += xj - 0;
							})
			console.log("zongji" + total);
			$("#count").html(html) - 0;
			$('.zj').html(total.toFixed(2)) - 0;
			var input_zj = parseFloat($('.zj').html()).toFixed(2);
			$('#payment').val(input_zj);
		})
	</script>
	<script>
		$(".go_pay")
				.click(
						function() {
							location.href = "${pageContext.request.contextPath}/order/payment.do";
						})
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
	<script src="${pageContext.request.contextPath}/js/distpicker.data.js"></script>
	<script src="${pageContext.request.contextPath}/js/distpicker.js"></script>
	<script>
		$("#choose").click(function() {
			$(".modal").show();
		})
		$(".cha").click(function() {
			$(".modal").hide();
		})
		$(".save_recipient").click(function() {
			$(".modal").hide();
		})
		

		$("#more").click(function() {
			if ($(this).hasClass("upup")) {
				$("#addresId2").hide();
				$("#addresId3").hide();
				$("#more").html("更多地址>>");
				$(this).removeClass("upup");
			} else {
				$("#addresId2").show();
				$("#addresId3").show();
				$("#more").html("收起地址>>");
				$("#more").addClass("upup");
			}
		})
	</script>
	<script>
		$(document).on("mouseover", ".base", function() {
			$(this).find("i:eq(2)").show();
		})
		$(document).on("mouseout", ".base", function() {
			$(this).find("i:eq(2)").hide();
		})
		$(".user_site").click(function() {
			$(this).parent().attr("class", "base_select");
			$(this).parent().siblings().attr("class", "base");
			$(this).hide();
		})
	</script>
	<script type="text/javascript">
	/*三级联动*/
	//三级联动的触发事件  加载就触发
	$(function() {
		getProvince(-1, -1, -1);
	})
	//加载页面完成，就调用${pageContext.request.contextPath}/dict/showProvince.do
	function getProvince(provinceCode, cityCode, areaCode) {
		$.ajax({
			"url" : "${pageContext.request.contextPath}/dict/showProvince.do",
			"data" : "",
			"type" : "GET",
			"dateType" : "json",
			"success" : function(obj) {
				$("#receiverState").html("<option>----请选择省----</option>");
				for (var i = 0; i < obj.data.length; i++) {
					var str = "<option value="+obj.data[i].provinceCode+">"
							+ obj.data[i].provinceName + "</option>";
					$("#receiverState").append(str);
				}
				if(provinceCode!=-1){
					$("#receiverState").val(provinceCode);
				}
			}
		});
		getCity(provinceCode, cityCode, areaCode);
	}
	//当省列表发生改变时，我们需要调用函数来完成城市信息
	function getCity(provinceCode, cityCode, areaCode) {
		$.ajax({
			"url" : "${pageContext.request.contextPath}/dict/showCity.do",
			"data" : "provinceCode=" + provinceCode,
			"type" : "GET",
			"dataType" : "json",
			"success" : function(obj) {
				$("#receiverCity").html("<option>----请选择市----</option>")
				for (var i = 0; i < obj.data.length; i++) {
					var str = "<option value="+obj.data[i].cityCode+">"
							+ obj.data[i].cityName + "</option>";
					$("#receiverCity").append(str);
				}
				if(cityCode!=-1){
					$("#receiverCity").val(cityCode);
				}
			}
		});
		getArea(cityCode, areaCode);
	}
	//当城市列表发生改变时，我们需要调用函数来完成区信息
	function getArea(cityCode, areaCode) {
		$.ajax({
			"url" : "${pageContext.request.contextPath}/dict/showArea.do",
			"data" : "cityCode=" + cityCode,
			"type" : "GET",
			"dataType" : "json",
			"success" : function(obj) {
				$("#receiverDistrict").html("<option>----请选择区----</option>")
				for (var i = 0; i < obj.data.length; i++) {
					var str = "<option value="+obj.data[i].areaCode+">"
							+ obj.data[i].areaName + "</option>";
					$("#receiverDistrict").append(str);
				}
				if(areaCode!=-1){
					$("#receiverDistrict").val(areaCode);
				}
			}
		});
	}
	</script>
</body>
</html>

