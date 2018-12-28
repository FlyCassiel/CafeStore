<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>FlyCafe商城-订单详情页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderInfo.css"/>
</head>
<body>
<!-- 头部信息 -->
<%@include file="header.jsp" %>
<!--详细信息-->
<div id="container">
        <!-- 导航 -->
        <div class="container_nav">
            首页&gt;订单管理&gt;订单<span>${orderid}</span>
        </div>
        <div class="orderInfo_icon">
            <p>订单<span class="order-num">${orderid}</span>&nbsp;&nbsp;&nbsp;当前状态：
            <c:forEach items="${orderItemVos}" var="order">
            <c:if test="${order.orderstatus==null||order.orderstatus==0}">
            <span class="state">等待发货</span>
            </c:if>
            <c:if test="${order.orderstatus==1}">
            <span class="state">正在发货</span>
            </c:if>
            <c:if test="${order.orderstatus==2}">
            <span class="state">收货完成</span>
            </c:if>
            </c:forEach>
            </p>
        </div>
        <!-- 订单状态流程图-->
        <div id="orderStatusChart">
              <dl>
                  <dt><img src="${pageContext.request.contextPath}/img/orderinfo/orderinfo_img1_2.png" alt=""/></dt>
                  <dd>
                      <p>提交订单</p>
                      <span>2016.01.01 13:00</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="${pageContext.request.contextPath}/img/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>

              <dl>
                  <dt><img src="${pageContext.request.contextPath}/img/orderinfo/orderinfo_img2_1.png" alt=""/></dt>
                  <dd>
                      <p>付款成功</p>
                      <span>2016.01.01 13:00</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="${pageContext.request.contextPath}/img/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>

              <dl>
                  <dt><img src="${pageContext.request.contextPath}/img/orderinfo/orderinfo_img3.png" alt=""/></dt>
                  <dd>
                      <p style="display: none">配送中</p>
                      <span style="display: none">2016.01.01 13:00</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="${pageContext.request.contextPath}/img/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>

              <dl>
                  <dt><img src="${pageContext.request.contextPath}/img/orderinfo/orderinfo_img4.png" alt=""/></dt>
                  <dd >
                      <p style="display: none">确认收货</p>
                      <span style="display: none">2016.01.01 13:00</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="${pageContext.request.contextPath}/images/orderinfo/orderinfo_img6.png" alt=""/></dt>
              </dl>

            <dl>
                  <dt><img src="${pageContext.request.contextPath}/img/orderinfo/orderinfo_img5.png" alt=""/></dt>
                  <dd >
                      <p style="display: none">评价</p>
                      <span style="display: none">2016.01.01 13:00</span>
                  </dd>
              </dl>

        </div>
        <div class="clear">

        <!-- 详细信息-->
        <c:forEach items="${addresses}" var="address">
        <c:if test="${address.isDefault==1}">
       
            <h1>详细信息</h1>
            	收货人：<span class="consignee">${address.recvName}</span>&nbsp;&nbsp;&nbsp;&nbsp;
            	邮编：<span class="postcode">${address.recvZip}</span>&nbsp;&nbsp;&nbsp;&nbsp;
            	联系电话：<span class="tel">${address.recvPhone}</span>
            <br/>
            <p>收货地址：<span>${address.recvDistrict}${address.recvAddr}</span></p>
        </div>
 		</c:if>
        </c:forEach>
        <!-- 物流信息-->
        <div style="width: 1000px; margin:0px auto" class="logistics">
            <h1>物流信息</h1>
            <p>发货时间：<span>2011.11.11 11:11</span></p>
            <p>物流公司：<span class="express">顺丰快递</span><a href="#">顺丰官网</a></p>
            <p>快递单号：<span>301111303203048</span></p>
            <div><span>物流信息：</span>
                <div>
                    <p>2016.11.11 12:11 您的快递在【北京马驹桥镇分拣中心】分拣完毕</p>
                    <p>2016.11.11 12:11 您的快递在【北京马驹桥镇分拣中心】准备装车</p>
                    <p>2016.11.11 12:11 您的快递到达【北京昌平分拣中心】</p>
                    <p>2016.11.11 12:11 您的快递到达【北京昌平沙河分拣中心】</p>
                </div>
            </div>
        </div>
		
        <!-- 商品信息-->
        <div style="width: 1000px; margin:0px auto">
            <h1 class="commodity">商品信息</h1>
            <div class="product_confirm">
                <ul class="item_title">
                    <li class="p_info">商品信息</li>
                    <li class="p_price">单价(元)</li>
                    <li class="p_count">数量</li>
                    <li class="p_tPrice">实付款</li>
                </ul>
                
                <div>订单编号：<span>${orderid}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成交时间：${order.tradetime}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系客服：<img src="${pageContext.request.contextPath}/img/orderinfo/kefuf.gif" alt=""/></div>
               <c:forEach items="${orderItemVos}" var="order">
                <ul class="item_detail lf">
                    <li class="p_info">
                        <b><img src="${pageContext.request.contextPath}${order.image}" width="100px"/></b>
                        <p class="product_name lf" >
                       ${order.title}
                        </p>
                        <br/>
                <span class="product_color ">
                 口味：浓
                </span>
                    </li>
                    <li class="p_price">
                        <i>专属价</i>
                        <br/>
                        <span class="pro_price">￥${order.price}</span>
                    </li>
                    <li class="p_count">${order.count}件</li>
                    <li class="p_tPrice">￥${order.price*order.count}</li>
                    <!--<li class="remark">备注</li>-->
                    <li></li>
                </ul></br>
                </c:forEach>
            </div>
        </div>
		
    </div>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script>
    //搜索下拉
    $('.seek').focus(function(){

        if($(this).hasClass('clickhover')){

            $(this).removeClass('clickhover');
            $(this).find('.seek_content').hide();
            $(this).find('img').attr('src','${pageContext.request.contextPath}/images/header/header_normal.png');

        }else{
            $(this).addClass('clickhover');
            $(this).find('.seek_content').show();
            $(this).find('img').attr('src','${pageContext.request.contextPath}/images/header/header_true.png');
        }
    })
    $('.seek_content>div').click(function(){
        $('.seek').removeClass('clickhover');
        var text=$(this).html();
        $('.seek span').html(text);
        $(this).parent().hide();
        $('.seek').find('img').attr('src','${pageContext.request.contextPath}/images/header/header_normal.png');
        $('.seek').blur();

    })

    $('.seek').blur(function(){

        $('.seek').removeClass('clickhover');
        $('.seek_content').hide();

        $('.seek').find('img').attr('src','${pageContext.request.contextPath}/images/header/header_normal.png');
        console.log(1);
    })
    //头部hover
    $(".care").hover(function(){
        $(this).attr('src',"${pageContext.request.contextPath}/images/header/care1.png");
    },function(){
        $(this).attr('src',"${pageContext.request.contextPath}/images/header/care.png");
    });
    $(".order").hover(function(){
        $(this).attr('src',"${pageContext.request.contextPath}/images/header/order1.png");
    },function(){
        $(this).attr('src',"${pageContext.request.contextPath}/images/header/order.png");
    });
    $(".shopcar").hover(function(){
        $(this).attr('src',"${pageContext.request.contextPath}/images/header/shop_car1.png");
    },function(){
        $(this).attr('src',"${pageContext.request.contextPath}/images/header/shop_car.png");
    });
</script>
</html>