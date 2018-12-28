<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
    	<a href="${pageContext.request.contextPath}/main/showIndex.do">
      	  <img class="animated jello" src="${pageContext.request.contextPath}/img/header/logo.jpg" alt="logo" width="80px;"/>
    	</a>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容" style="width:380px;" value="${title}"/>
        <a href="#" class="rt" onclick="search1()">
        	<img id="search" src="${pageContext.request.contextPath}/img/header/search.png" alt="搜索"/>
        </a>
    </div>
    <div class="rt">
        <ul class="lf">
        	<li><a href="${pageContext.request.contextPath}/user/showPassword.do">${user.username}</a></li>
            <li><a href="${pageContext.request.contextPath}/collect/showCollect.do" title="我的收藏"><img class="care" src="${pageContext.request.contextPath}/img/header/care.png" alt=""/></a><b>|</b></li>
            <li><a href="${pageContext.request.contextPath}/order/showOrderItem.do" title="我的订单"><img class="order" src="${pageContext.request.contextPath}/img/header/order.png" alt=""/></a><b>|</b></li>
            <li><a href="${pageContext.request.contextPath}/cart/showCart.do" title="我的购物车"><img class="shopcar" src="${pageContext.request.contextPath}/img/header/shop_car.png" alt=""/></a><b>|</b></li>
            <li><a href="${pageContext.request.contextPath}/admin/showLogin.do">管理员登录</a><b>|</b></li>
            <c:if test="${user==null}">
            <li><a href="${pageContext.request.contextPath}/user/showLogin.do">登录</a></li>
            </c:if>
            <c:if test="${user!=null}">
            <li><a href="${pageContext.request.contextPath}/user/logout.do">退出</a></li>
            </c:if>
        </ul>
    </div>
    <script type="text/javascript">
  //头部hover
    $(".care").hover(function(){
        $(this).attr('src',"../img/header/care1.png");
    },function(){
        $(this).attr('src',"../img/header/care.png");
    });
    $(".order").hover(function(){
        $(this).attr('src',"../img/header/order1.png");
    },function(){
        $(this).attr('src',"../img/header/order.png");
    });
    $(".shopcar").hover(function(){
        $(this).attr('src',"../img/header/shop_car1.png");
    },function(){
        $(this).attr('src',"../img/header/shop_car.png");
    });
    /* 搜索功能 */
	function search1(){
		location="${pageContext.request.contextPath}/goods/showGoodsByTitle.do?title="+$("#input").val();
	}
    </script>
</header>
