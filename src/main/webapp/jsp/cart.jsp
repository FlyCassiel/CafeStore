<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>购物车</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/gouwucar.js"
	type="text/javascript" charset="utf-8"></script>
<!--bootstap-->
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<!--bootstap完-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/gouwucar.css" />
</head>
<body>
	<!--我是头部-->
	<%@include file="header.jsp"%>
	<!--我是头部   完-->
	<!--内容-->
	<c:if test="${user!=null}">
		<div class="content">
			<!--主要内容上面-->
			<div class="up">
				<!--上面左边-->
				<div class="left">
					<span>我的购物车</span>
				</div>
				<!--上面左边  完-->
				<!--上面右边-->
				<div class="right">
					<img
						src="${pageContext.request.contextPath}/img/gouwucar/fguocheng.png" />
				</div>
				<!--上面右边  完-->
			</div>
			<!--主要内容上面 完-->
			<!--表格-->

			<div class="main">
				<!--第一个表格  删除不了-->
				<table class="first">
					<tr>
						<td width="70px">
							<!--所有商品全选--> <input type="checkbox" id="all" class="whole_check"
							style="display: none" /> <label for="all"></label> <span
							class="xuan">全选</span>
						</td>
						<td width="554px">商品</td>
						<td width="218px">单价(元)</td>
						<td width="142px">数量</td>
						<td width="140px">小计(元)</td>
						<td width="100px">操作</td>
					</tr>
				</table>
				<!--第一个表格  删除不了  完-->

				<!--购物车里面的产品表格-->
				<table class="chanpin">
					<c:forEach items="${cartVoList}" var="cartVo">
						<div class="imfor">
							<tr class="FirstDelect cc">
								<td width="46px" id="${cartVo.id}"><input type="hidden"
									value="${cartVo.id}" class="id"> <input type="checkbox"
									id="checkbox" class="son_check"></td>
								<td width="554px">
									<div class="tupian">
										<img src="${pageContext.request.contextPath}${cartVo.image}" />
									</div>
									<div class="wenzi">
										<p>
											<a target="_blank">${cartVo.title}</a>
										</p>
										<p class="yanse">口味：${cartVo.taste}</p>
									</div>
								</td>
								<td width="218px" class="xian"><span class="span">现价：￥</span>
									<span class="price">${cartVo.price} </span></td>
								<td width="142px" class="xian"><input type="button"
									id="reduce" class="bb reduce reSty" value="-" /> <input
									type="text" id="num" class="bb sum" value="${cartVo.count}"
									readonly="readonly" /> <input type="button" id="add"
									class="bb plus" value="+" /></td>
								<td width="140px" class="xian"><span class="span">￥</span>
									<span id="span1" class="span sum_price">${cartVo.price*cartVo.count}</span>
								</td>
								<td width="100px" class="xian"><a href="javascript:;"
									class="delete">删除</a></td>
							</tr>
						</div>
					</c:forEach>
				</table>

				<!--购物车里面的产品表格   完-->
				<!--------          最下面的固定定位的结算 狂特点   用的bootstrap的栅格系统-->
				<div class="row last">
					<div class="col-md-1">
						<input type="checkbox" id="all1" class="whole_check"
							style="display: none;" /> <label for="all1"></label> <span
							class="xuan">全选</span>
					</div>
					<div class="col-md-2">
						<a href="javascript:;" id="clear" class="foot_del piliang">批量删除</a>
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-2"></div>

					<div class="col-md-4">
						合计 <span class="piece_num">0</span>件（不含运费）： <span
							class="span total_text">￥0</span>
					</div>
					<div class="col-md-2 calBtn">
						<a href="javascript:;" id="submit" class="submit">结算</a>
					</div>
				</div>
				<!--最下面的固定定位的结算框  完-->
			</div>
			<!--表格  完-->
			<!--删除商品的时候的弹出框-->
			<section class="model_bg"></section>
			<section class="my_model">
				<p class="title">
					删除宝贝<span class="closeModel">X</span>
				</p>
				<p>您确认要删除该宝贝吗？</p>
				<div class="opBtn">
					<!--dialog  对话-->
					<a href="javascript:;" class="dialog-sure">确定</a> <input
						type="hidden" id="model_id" value=""> <a
						href="javascript:;" class="dialog-close">关闭</a>
				</div>
			</section>
			<!--删除商品的时候的弹出框   完-->
		</div>
		<!--内容  完-->
		<div class="span24" style="display: none;">
			<div class="step step1">
				<img
					src="${ pageContext.request.contextPath}/img/gouwucar/nogouwucar.png" />
			</div>
		</div>
	</c:if>
	<c:if test="${user==null}">
		<div class="content">
			<!--主要内容上面-->
			<div class="up">
				<!--上面左边-->
				<div class="left">
					<span>我的购物车</span>
				</div>
				<!--上面左边  完-->
				<!--上面右边-->
				<div class="right">
					<img
						src="${pageContext.request.contextPath}/img/gouwucar/fguocheng.png" />
				</div>
				<!--上面右边  完-->
			</div>
			<!--主要内容上面 完-->
			<div class="span24">
				<div class="step step1">
					<img
						src="${ pageContext.request.contextPath}/img/gouwucar/nogouwucar.png" />
				</div>
			</div>
		</div>
	</c:if>
</body>
<script type="text/javascript">
<!-- 显示空购物车页面-->
	$(function() {
		if ($(".imfor").length == 0) {
			$('.main').hide();
			$('.none').show();
		}
	})
</script>
</html>