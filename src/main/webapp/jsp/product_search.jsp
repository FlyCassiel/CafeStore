<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Fly Cafe 商城</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/des.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/list.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/cont.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/des.js"
	type="text/javascript" charset="utf-8"></script>
<style type="text/css">
.footer {
	margin: 0 auto;
	font-size: 14px;
	width: 400px;
	margin-right: 30%;
}

.footer ul {
	list-style: none;
}

.footer ul li {
	float: left;
	width: 28px;
	height: 28px;
	line-height: 28px;
	font-size: 14px;
	border: 1px solid black;
	background-color: #7e422c;
	text-align: center;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="continer">
		<!--头部开始-->
		<%@ include file="header.jsp"%>
		<!--内容开始-->
		<div class="content">
			<div class="hr1"></div>
			<div class="main">
				<!-- showGoods下的有分类 -->
				<c:if test="${categoryId!=null}">
					<div class="one1 layout">
						<a href="#">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp; &nbsp;&nbsp; <a
							href="#">${goodsCategory.name}</a>
					</div>
					<div class="two2 layout">
						<div class="two2_list">
							<div class="two2_title">分类：</div>
							<div id="two2_zong">${goodsCategory.name}</div>
						</div>
						<div class="two2_list">
							<div class="two2_title">排序：</div>
							<div class="two2_zong">默认</div>
							<div class="two2_ul">
								<ul>
									<li><a href="#">价格</a></li>
									<li><a href="#">评价数</a></li>
									<li><a href="#">上架时间</a></li>
								</ul>
							</div>
						</div>
					</div>
				</c:if>
				<form action="" style="margin-top: 20px;">
					<div class="layout" id="three3">
						<ul id="three_3">
							<c:forEach items="${listGoods}" var="goods">
								<li class="changxiang">
									<div class="three3_div">
										<div class="three3_img">
											<a
												href="${ pageContext.request.contextPath }/goods/showGoodsInfo.do?id=${goods.id}&categoryId=${goods.categoryId}">
												<img src="${pageContext.request.contextPath}${goods.image}" />
											</a>
										</div>
										<div class="three3_name">
											<a href="#">${goods.title}</a>
										</div>

										<div class="three3_price">
											<b>¥${goods.price}</b>
										</div>
										<div class="three3_pinjia">
											<div class="pinjia_left">
												<a href="#" style="height: 36px">选购</a>
											</div>
											<div class="pinjia_right">3830人评价</div>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 分页的按钮跳转问题 -->
	<%-- <c:if test="${categoryId!=null}">
		<c:set var="path"
			value="../goods/showGoods.do?categoryId=${categoryId}&page=${i}" />
	</c:if>
	<c:if test="${categoryId==null}">
		<c:set var="path" value="../goods/showGoodsByTitle.do?title=${title}" />
	</c:if> --%>
	<%-- <%@include file="paging.jsp"%> --%>
	<!--展示showGoods的时候分页功能  -->
	<c:if test="${categoryId!=null}">
		<div class="footer">
			<div style="height: 35px;">
				<c:forEach begin="1" end="${pageCount}" var="i">
					<c:if test="${currentPage==i}">
						<ul>
							<li><font color="red">${i}</font></li>
						</ul>
					</c:if>
					<c:if test="${currentPage!=i}">
						<ul>
							<li onclick="fenye(${i})" style="color: skyblue">${i}</li>
						</ul>
					</c:if>
				</c:forEach>
				<span style="margin-left: 20px;"> 跳转到： <select
					onchange="fenye(this.value)" style="height: 30px; width: 50px;">
						<c:forEach begin="1" end="${pageCount}" var="i">
							<option style="color: black"
								${currentPage==i?"selected='selected'":""} value="${i}">${i}</option>
						</c:forEach>
				</select>
				</span>
			</div>
			共${count}条记录|共${pageCount}页
		</div>
		<script type="text/javascript">
		/* 分页 */
		function fenye(curPage) {
			location.href = "${pageContext.request.contextPath}/goods/showGoods.do?categoryId=${categoryId}&page="
					+ curPage;
		}
		</script>
	</c:if>
	<!-- 根据关键字搜索的时候的分页 -->
	<c:if test="${categoryId==null}">
		<div class="footer">
			<div style="height: 35px;">
				<c:forEach begin="1" end="${pageCount}" var="i">
					<c:if test="${currentPage==i}">
						<ul>
							<li><font color="red">${i}</font></li>
						</ul>
					</c:if>
					<c:if test="${currentPage!=i}">
						<ul>
							<li onclick="fenye(${i})" style="color: skyblue">${i}</li>
						</ul>
					</c:if>
				</c:forEach>
				<span style="margin-left: 20px;"> 跳转到： <select
					onchange="fenye(this.value)" style="height: 30px; width: 50px;">
						<c:forEach begin="1" end="${pageCount}" var="i">
							<option style="color: black"
								${currentPage==i?"selected='selected'":""} value="${i}">${i}</option>
						</c:forEach>
				</select>
				</span>
			</div>
			共${count}条记录|共${pageCount}页
		</div>
		<script type="text/javascript">
		/* 分页 */
		function fenye(curPage) {
			location.href = "${pageContext.request.contextPath}/goods/showGoodsByTitle.do?title=${title}&page="
					+ curPage;
		}
		</script>
	</c:if>
</body>
</html>
