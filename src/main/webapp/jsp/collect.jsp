<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="cn">
<meta charset="UTF-8">
<title>学子商城收藏夹</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/favorites.css" />
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<%@include file="header.jsp"%>
	<!--删除提醒  -->
	<div class="modal" style="display: none">
		<div class="modal_dialog">
			<div class="modal_header">删除提醒</div>
			<div class="modal_information">
				<img
					src="${pageContext.request.contextPath}/img/collect/model_img2.png"
					alt="" /> <span>确定删除您的这个宝贝吗？</span>
			</div>
			<div class="yes">
				<span>删除</span>
			</div>
			<div class="no">
				<span>不删除</span>
			</div>
		</div>
	</div>
	<!-- 操作 -->
	<div class="modalYi" style="display: none">
		<div class="modal_dialog">
			<div class="modal_header">操作提醒</div>
			<div class="modal_information">
				<img
					src="${pageContext.request.contextPath}/img/collect/model_img2.png"
					alt="" /> <span>将您的宝贝移入购物车？</span>

			</div>
			<div class="yes">
				<span>确定</span>
			</div>
			<div class="no">
				<span>取消</span>
			</div>
		</div>
	</div>
	<div class="modalNo" style="display: none">
		<div class="modal_dialog">
			<div class="modal_header">
				删除提示 <img
					src="${pageContext.request.contextPath}/img/collect/model_img1.png"
					alt="" class="rt close" />
			</div>
			<div class="modal_information">
				<img
					src="${pageContext.request.contextPath}/img/collect/model_img2.png"
					alt="" /> <span>请选择商品</span>

			</div>
		</div>
	</div>

	<div class="modalAdd" style="display: none">
		<div class="modal_dialog">
			<div class="modal_header">
				添加提示 <img
					src="${pageContext.request.contextPath}/img/collect/model_img1.png"
					alt="" class="rt close" />
			</div>
			<div class="modal_information">
				<img
					src="${pageContext.request.contextPath}/img/collect/model_img2.png"
					alt="" /> <span>请选择商品</span>

			</div>

		</div>
	</div>

	<div class="big">
		<form name="" action="" method="post">
			<section id="section">
				<div id="title">
					<b>收藏商品</b>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div id="box">
					<div class="imfor_top">
						<div class="manage">
							<span class="normal">管理收藏夹</span>
						</div>
			           <!--全选  删除 加入购物车  -->
						<div class="check_top">
							<div class="all">
								<span class="normal"> 
								<img src="${pageContext.request.contextPath}/img/collect/product_normal.png"
									alt="" /></span>全选
							</div>
							<div class="del">删除</div>
							<div class="allAdd">加入购物车</div>
							<div class="sure" style="display: none">
								<img
									src="${pageContext.request.contextPath}/img/collect/product_true.png"
									alt="" /> <span>已移入购物车</span>
							</div>
						</div>
						<div class="foot_qk">清空失效商品</div>
					</div>
					<div id="content_box">
					<c:forEach items="${collectList}" var="collect">
						<div class="lf" id="${collect.goodsid}">
							<div class="img">
								<img
									src="${pageContext.request.contextPath}${collect.image}"
									alt="" width="180px;"/>
							</div>
							<div class="describe">
								<p>${collect.title}</p>
								<span class="price">
									<b>￥</b><span class="priceContent">${collect.price}</span>
								</span>
								<span class="addCart">加入购物车</span> 
								<!--加入购物车的时候的显示  -->
								<span class="succee" style="display: none"> 
									<img src="${pageContext.request.contextPath}/img/collect/product_true.png" alt="" /> 
									<span>已移入购物车</span>
								</span>
							</div>
							<div class="mask" style="display: none;">
								<div class="maskNormal">
									<img src="${pageContext.request.contextPath}/img/collect/product_normal_big.png"
										alt="" />
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</section>
		</form>
		<!--空收藏夹显示页面  -->
		<div class="none" style="display: none">
			<div class="none_content">
				<img
					src="${pageContext.request.contextPath}/img/collect/model_img3.png"
					alt="" class="lf" />
				<p class="lf">您的收藏夹竟然还是空哒( ⊙ o ⊙ )</p>
				<span class="lf">赶快去收藏商品吧！</span> <a href="#" class="lf">去购物>></a>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/favorites.js"></script>
	<script>
		$(function() {
			if (!$(".imfor")) {
				$('#section').hide();
				$('.none').show();
			}
		})
	</script>
</body>
</html>