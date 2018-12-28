<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>订单</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/我的订单.js"
	type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/order.css" />
<!--bootstap-->
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap-3.2.0-dist/css/bootstrap.min.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<!--bootstap完-->
</head>
<body>
	<%@include file="header.jsp"%>
	<!--我的中间部分-->
	<div class="main">
		<div class="main-header">
			<a href="#" title="首页">首页</a> <span class="aa">\</span> <a href="#"
				title="我的商城">我的商城</a> <span class="aa">\</span> <span>我的订单</span>
		</div>
		<div class="main-left">
			<div class="main-l-up">
				<span> <a href="#" title="我的商城">我的商城</a>
				</span>
			</div>
			<div class="main-l-ding">
				<p>
					<span>------订单中心------</span>
				</p>
				<ul>
					<li><a href="#" title="我的订单" class="first">我的订单</a></li>
					<li><a href="#" title="我的退订单">我的退订货</a></li>
					<li><a href="#" title="我的回收单">我的回收单</a></li>
				</ul>
			</div>
			<div class="main-l-ge">
				<p>
					<span>------订单中心------</span>
				</p>
				<ul>
					<li><a href="#" title="我要预定">我要预约</a></li>
					<li><a href="#" title="到货通知">到货通知</a></li>
					<li><a href="#" title="等级与特权">等级与特权</a></li>
					<li><a href="#" title="我的积分">我的积分</a></li>
					<li><a href="#" title="芝麻信用">芝麻信用</a></li>
					<li><a href="#" title="实名认证">实名认证</a></li>
					<li><a href="#" title="代金券">代金券</a></li>
					<li><a href="#" title="我的花瓣">我的花瓣</a></li>
					<li><a href="#" title="我的优惠券">我的优惠券</a></li>
					<li><a href="#" title="收货地址管理">收货地址管理</a></li>
				</ul>
			</div>
			<div class="main-l-she">
				<p>
					<span>------社团中心------</span>
				</p>
				<ul>
					<li><a href="#" title="商品评价">商品评价</a></li>
					<li><a href="#" title="站内信">站内信</a></li>

				</ul>
			</div>
		</div>
		<div class="main-right">
			<div class="main-r-up">
				<span>我的订单</span>
				<div>
					<a href="#" class="bb show1"><span>最近六月内订单1</span></a> <a href="#"
						class="show"><span>六月前订单</span></a>
				</div>
			</div>
			<div class="main-r-botton">
				<ul>
					<li class="a66"><a href="#" class="cc dd">全部有效订单</a></li>
					<li class="a11"><a href="#">待支付<span>2</span></a></li>
					<li class="a22"><a href="#">待评价<span>1</span></a></li>
					<li class="a33"><a href="#">待收货<span>1</span></a></li>
					<li class="a44"><a href="#">已完成<span>1</span></a></li>
					<li class="a55"><a href="#">已取消<span>1</span></a></li>
				</ul>
			</div>
			<div class="main-r-quan">
				<span><input type="checkbox" class="AllCk" name="AllCk" />&nbsp;&nbsp;全选</span>
				<span class="ee"><a
					href="${pageContext.request.contextPath}/jsp/orderconfirm.jsp">合并结算</a></span>
			</div>
			<div class="main-r-title">
				<table>
					<tr>
						<td width="590px">商品</td>
						<td width="114px">单价/元</td>
						<td width="75px">数量</td>
						<td width="114px">实付款/元</td>
						<td width="169px" class="last1">订单状态及操作</td>
					</tr>
				</table>
			</div>
			<!--六月内的订单-->
			<!--第一个产品-->
			<c:forEach items="${orders}" var="orders">
				<div class="chanpin  a111">
					<div class="o-info">
						<div class="o-l">
							<input type="checkbox" name="ck" /> 
							<span class="date">
								${orders.tradetime} 
							</span> 
							<span class="no"> 订单号 : 
								<a href="#">${orders.id}</a>
							</span>
						</div>
					</div>
					<div class="c">
						<table style="text-align:center">
						<c:forEach items="${listItems}" var="order">
						<c:if test="${orders.id==order.orderid}">
							<tr>
								<td width="540px">
									<div class="tt">
										<img src="${pageContext.request.contextPath}${order.image}" />
									</div>
									<div class="zizi">
										<span><a href="#">${order.title}</a></span>
									</div>
								</td>
								<td width="114px">¥ ${order.price}</td>
								<td width="75px">${order.count}</td>
								<td width="114px">¥ ${order.price*order.count}</td>
								<td width="169px">
								<c:if test="${order.paymentstatus==1}">
										<ul>
											<li class="first"><a href="#">已支付</a></li>
											<li><a href="${pageContext.request.contextPath}/order/delete.do?orderid=${orders.id}">取消订单</a></li>
											<li><a href="${pageContext.request.contextPath}/order/showOrderInfo.do?orderid=${orders.id}">订单详情</a></li>
										</ul>
								</c:if> 
								<c:if test="${order.paymentstatus==0||order.paymentstatus==null&&order.orderstatus!=2}">
										<ul>
											<li class="first"><a href="${pageContext.request.contextPath}/order/paymentOrder.do?orderid=${orders.id}">立即支付</a></li>
											<li><a href="${pageContext.request.contextPath}/order/delete.do?orderid=${orders.id}">取消订单</a></li>
											<li><a href="${pageContext.request.contextPath}/order/showOrderInfo.do?orderid=${orders.id}">订单详情</a></li>
										</ul>
								</c:if>
								<c:if test="${order.paymentstatus==0||order.paymentstatus==null&&order.orderstatus==2}">
										<ul>
											<li class="first"><a href="#">订单失效</a></li>
											<li><a href="${pageContext.request.contextPath}/order/delete.do?orderid=${orders.id}">取消订单</a></li>
											<li><a href="${pageContext.request.contextPath}/order/showOrderInfo.do?orderid=${orders.id}">订单详情</a></li>
										</ul>
								</c:if>
								</td>
							</tr>
							</c:if>
							</c:forEach>
						</table>
					</div>
				</div>
			</c:forEach>
			<!--六月前假的div   达到六月前是空订单的情况-->
			<div class="a777">你暂时没有相关记录，请先结算！！！</div>
			<!--六月前假的div   达到六月前是空订单的情况完-->
			<!-- <div class="main-r-quan">
					<span><input type="checkbox" class="AllCk" name="AllCk"/>&nbsp;&nbsp;全选</span>
					<span class="ee"><a href="#">合并结算</a></span>
				</div>	 -->
		</div>
	</div>
	<%@include file="paging.jsp"%>
	<!--中间部分做完了-->
	<script type="text/javascript">
		/*分页*/
		/* 分页 */
		function fenye(curPage) {
			location.href = "${pageContext.request.contextPath}/order/showOrderItem.do?page="
					+ curPage;
		}
	</script>
</body>
</html>