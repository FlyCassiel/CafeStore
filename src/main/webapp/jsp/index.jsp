<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slider.css" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico" />
<!--批量换轮播-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/caroue.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/vticker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.vticker-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!--登录成功显示session-->
<!--topbanner的顶部按钮-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/btn-close.js"></script>
<script src="${pageContext.request.contextPath}/js/slider.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/carouse.js"></script>
<title>Fly Cafe 商城</title>
</head>
<body class="body-width">
		<!--头部-->
		<%@include file="header.jsp" %>
		<!--slider部分-->
		<div class="slider">
			<!--轮播图样式部分-->
			<div id="ban1">
				<div class="banner">
					<ul class="img">
						<li>
							<a href="#"><img src="${pageContext.request.contextPath}/img/index_img/slider-img1.jpg"></a>
						</li>
						<li>
							<a href="#"><img src="${pageContext.request.contextPath}/img/index_img/slider-img2.jpg"></a>
						</li>
						<li>
							<a href="#"><img src="${pageContext.request.contextPath}/img/index_img/slider-img3.jpg"></a>
						</li>
						<li>
							<a href="#"><img src="${pageContext.request.contextPath}/img/index_img/slider-img4.jpg"></a>
						</li>
					</ul>
					<ul class="num">
					</ul>
				</div>
			</div>
			<!--侧面导航-->
			<div class="sidenav">
				<div class="sidenav-out">
					<ul>
						<li>
							<div class="sidenav-list">
								<h3>
		    						<a href="#">咖啡</a>
		    					</h3>
		    					<div class="sidenav-text">
		    					<!--分类信息 -->
		    					<c:forEach items="${list1}" var="list1">
									<a href="${pageContext.request.contextPath}/goods/showGoods.do?categoryId=${list1.id}"><span>${list1.name}</span></a>
								</c:forEach>
								<!--分类信息完 -->
								</div>
								<i></i>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--container部分-->
		<div id="container">
			<!--中间内容部分-->
			<div class="con">
				<!--图文介绍部分-->
				<div class="hot-info hotinfo-width">
					<div class="hr-12"></div>
					<div class="pic-box">
						<c:forEach items="${goodsquechaoList}" var="quechao">
							<div class="pic-con-list">
								<a href="#" style="padding-left:65px;">
								<img src="${pageContext.request.contextPath}${quechao.image}" height="160px;"/>
								</a>
							</div>
						</c:forEach>	
					</div>
				</div>
				<!-----热销产品------->
				<div class="mobile  conblock-width  con-layout">
					<div class="h">
							<div class="title-h2-nav">热销产品</div>
							<div class="more">更多&gt;</div>
					</div>
					<div class="two-con box-con">
						    <ul>
							<!-----从数据库里面调取的                        goodshotList     -------------------->
							  <c:forEach items="${goodshotList}" var="hot">
						       <li>
									<a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=${hot.id}&categoryId=${hot.categoryId}" target="_blank" class="list-con" >
										<p class="list-con-img"><img src="${pageContext.request.contextPath}${hot.image}"/></p>
										<h3 class="list-con-title" style="font-size:12px">${hot.title}</h3>
										<p class="list-con-desc">${hot.sellPoint}</p>
										<p class="list-con-price">¥${hot.price}</p>
										<p class="list-con-tip"><img src="${pageContext.request.contextPath}/img/index_img/circle-limit.png" /></p>
									</a>
								</li>
							</c:forEach>
							</ul>
						</div>
				</div>
				<!--促销推荐-->
				<div class="recommend-goods conblock-width">
					<h2 class="title-h2">促销推荐</h2>
					<section>
						<div class="container-con">
							<div id="full" class="carousel slide" data-ride="carousel">
								<div class="carousel-inner">
									<ul class="row item active">
									<c:forEach items="${goodssaleList}" var="sale">
										<li class="col-xs-2">
											<div class="img-con">
												<img src="${pageContext.request.contextPath}${sale.image}" />
											</div>
											<h3 class="change-con-title">${sale.title}</h3>
											<p class="change-con-desc">${sale.sellPoint} </p>
											<p class="change-con-price">¥${sale.price}</p>
										</li>
									</c:forEach>
									</ul>
									<ul class="row item">
									<c:forEach items="${goodssaleList2}" var="sale2">
										<li class="col-xs-2">
											<div class="img-con">
												<img src="${pageContext.request.contextPath}${sale2.image}" />
											</div>
											<h3 class="change-con-title">${sale2.title}</h3>
											<p class="change-con-desc">${sale2.sellPoint} </p>
											<p class="change-con-price">¥${sale2.price}</p>
										</li>
									</c:forEach>
									</ul>
								</div>

								<a class="carousel-control left" href="#full" data-slide="prev">Previous</a>
								<a class="carousel-control right" href="#full" data-slide="next">Next</a>
							</div>
						</div>
					</section>
				</div>
				<!--咖啡豆内容部分-->
				<div class="mobile  conblock-width  con-layout">
					<div class="h">
						<div class="title-h2-nav">咖啡豆</div>
						<div class="more">更多&gt;</div>
					</div>
					<div class="two-con box-con">
						<ul>
                           <!--------  beanlist --------->
						    <c:forEach items="${goodsbeanList}" var="bean">
						       <li>
									<a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=${bean.id}&categoryId=${bean.categoryId}" target="_blank" class="list-con">
										<p class="list-con-img"><img src="${pageContext.request.contextPath}${bean.image}"/></p>
										<h3 class="list-con-title">${bean.title}</h3>
										<p class="list-con-desc">${bean.sellPoint}</p>
										<p class="list-con-price">¥${bean.price}</p>
										<p class="list-con-tip"><img src="${pageContext.request.contextPath}/img/index_img/circle-limit.png" /></p>
									</a>
								</li>
							</c:forEach>	
						</ul>
					</div>
				</div>
				<!--咖啡粉部分-->
				<div class="goodpad  conblock-width con-layout">
					<div class="h">
						<div class="title-h2-nav">咖啡粉</div>
						<div class="more">更多&gt;</div>
					</div>
					<div class="two-con box-con">
						<ul>
							<!----------从数据库里面调取的       goodsfenList  --------->
							<c:forEach items="${goodsfenList}" var="fen">
							 	<li>
									<a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=${fen.id}&categoryId=${fen.categoryId}" target="_blank" class="list-con">
										<p class="list-con-img"><img src="${pageContext.request.contextPath}${fen.image}"/></p>
										<h3 class="list-con-title">${fen.title}</h3>
										<p class="list-con-desc">${fen.sellPoint}</p>
										<p class="list-con-price">¥${fen.price}</p>
										<p class="list-con-tip"><img src="${pageContext.request.contextPath}/img/index_img/circle-limit.png" /></p>
									</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<!--现磨咖啡部分-->
				<div class="home conblock-width con-layout">
					<div class="h">
						<div class="title-h2-nav">现磨咖啡</div>
						<div class="more">更多&gt;</div>
					</div>
					<div class="two-con box-con">
						<ul>
                        <!-----------从数据库里面调取的       goodsmoList  ------->
							<c:forEach items="${goodsmoList}" var="mo">
						       <li>
									<a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=${mo.id}&categoryId=${mo.categoryId}" target="_blank" class="list-con">
										<p class="list-con-img"><img src="${pageContext.request.contextPath}${mo.image}"/></p>
										<h3 class="list-con-title">${mo.title}</h3>
										<p class="list-con-desc">${mo.sellPoint}</p>
										<p class="list-con-price">¥${mo.price}</p>
										<p class="list-con-tip"><img src="${pageContext.request.contextPath}/img/index_img/circle-limit.png" /></p>
									</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<!-- 雀巢咖啡展示 -->
				<!--sliderbanner内容部分-->
				<div class="sliderbanner conblock-width">
					<div class="h">
						<div class="title-h2-nav">雀巢咖啡部分展示</div>
						<div class="more">更多&gt;</div>
					</div>
					<!--轮播图样式部分-->
					<div id="ban2">
						<div class="banner">
							<ul class="img">
								<c:forEach items="${goodsquechaoList}" var="quechao">
								<li>
									<a href="#"><img src="${pageContext.request.contextPath}${quechao.image}" /></a>
								</li>
								</c:forEach>
							</ul>
							<ul class="num">
							</ul>
						</div>
					</div>
				</div>
				<!--冲调咖啡部分-->
				<div class="parts conblock-width box-con con-layout">
					<div class="h">
						<div class="title-h2-nav">冲调咖啡</div>
						<div class="more">更多&gt;</div>
					</div>
					<div class="two-con">
						<ul>
						<!--------  goodschongList --------->
						    <c:forEach items="${goodschongList}" var="chong">
						       <li id="li-2">
									<a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=${chong.id}&categoryId=${chong.categoryId}" target="_blank" class="list-con">
										<p class="list-con-img"><img src="${pageContext.request.contextPath}${chong.image}"/></p>
										<h3 class="list-con-title">${chong.title}</h3>
										<p class="list-con-desc">${chong.sellPoint}</p>
										<p class="list-con-price">¥${chong.price}</p>
										<p class="list-con-tip"><img src="${pageContext.request.contextPath}/img/index_img/circle-limit.png" /></p>
									</a>
								</li>
							</c:forEach>	
						</ul>
					</div>
				</div>
				<!--速溶咖啡部分-->
				<div class="parts conblock-width box-con con-layout">
					<h2 class="title-h2">速溶咖啡</h2>
					<div class="two-con">
						<ul>
						<!--------  goodschongList --------->
						    <c:forEach items="${goodssuList}" var="su">
						       <li id="li-2">
									<a href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id=${su.id}&categoryId=${su.categoryId}" target="_blank" class="list-con">
										<p class="list-con-img"><img src="${pageContext.request.contextPath}${su.image}"/></p>
										<h3 class="list-con-title">${su.title}</h3>
										<p class="list-con-desc">${su.sellPoint}</p>
										<p class="list-con-price">¥${su.price}</p>
										<p class="list-con-tip"><img src="${pageContext.request.contextPath}/img/index_img/circle-limit.png" /></p>
									</a>
								</li>
							</c:forEach>	
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--悬浮框部分-->
		<!-- <div class="fixbars">
			<a href="#" class="return"><span class="glyphicon glyphicon-chevron-up"></span></a>
			<a href="#" class="contact"><span class="glyphicon glyphicon-phone-alt"></span></a>	
		</div> -->
	</body>
</html>