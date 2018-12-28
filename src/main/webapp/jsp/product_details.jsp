<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>flycafe 商城详情页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css"/>
    <link rel="Stylesheet" href="${pageContext.request.contextPath}/css/pro_details.css" />
    <link rel="Stylesheet" href="${pageContext.request.contextPath}/css/animate.css" />
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"></jsp:include>

<!-- 内容-->
<!--细节导航-->
<div id="nav_detail">
    <h5>首页 >${goods.itemType}></h5>
</div>
<!--产品预览-->
<div id="shop_detail">
    <!-- 左侧-->
    <div id="preview" class="lf">
        <div id="mediumDiv">
            <img id="mImg" width="" src="${pageContext.request.contextPath}${goods.image}"/>
        </div>
        <div id="icon_all">
            <ul id="icon_list">
            <c:forEach items="${imagesList}" var="images">
                <li class="i1"><img src="${pageContext.request.contextPath}${images.image}"/></li>
            </c:forEach>
            </ul>
        </div>
    </div>
    <!-- 右侧-->
    <div class="right_detail lf">
        <!-- 商品名称-->
        <h1>${goods.itemType}</h1>
        <!-- 商品全称-->
        <h3>${goods.title}</h3>
        <!-- 价格部分-->
        <div class="price">
            <div id="pro_price"><b>官方售价：</b><span>￥${goods.price}</span></div>
            <div class="promise">
                <b>服务承诺：</b>
                <span>*退货补运费</span>
                <span>*30天无忧退货</span>
                <span>*48小时快速退款</span>
                <span>*72小时发货</span>
            </div>
        </div>
        <!-- 参数部分 客服-->
        <p class="parameter">
            <b>客服：</b>
            <span class="connect">联系客服</span><img class="gif" src="${pageContext.request.contextPath}/img/product_detail/kefuf.gif">
        </p>
        <!-- 颜色-->
        <p class="style" id="choose_color">
            <b>口味：</b>
           <script>
           		var str='${goods.taste}';//这是一字符串 
           		console.log(str);
				var strs= new Array(); //定义一数组 
				strs=str.split(","); //字符分割 
				for (i=0;i<strs.length ;i++ ) 
				{
				document.write("<input type='button' class='i1'  value="+strs[i]+" title="+strs[i]+"/>"); 
				} 
			</script> 
            
        </p>
        <!-- 规格-->
        <p>
            <b>分期：</b>
            <span class="avenge">不分期</span>
            <span class="avenge">6期</span>
            <span class="avenge">12期</span>
        </p>
        <!-- 未选择规格，颜色时状态-->
        <div class="message"></div>
        <!-- 数量-->
        <p class="accountChose">
            <b>数量：</b>
            <button class="numberMinus">-</button>
            <input type="text" value="1" class="number" id="buy-num">
            <button class="numberAdd">+</button>
        </p>
        <!-- 购买部分-->
        <div class="shops">
            <a href="#" class="buy lf" id="buy_now">立即购买</a>
            <a href="#" class="shop lf" id="add_cart"><img src="${pageContext.request.contextPath}/img/product_detail/product_detail_img7.png" alt=""/>加入购物车</a>
            <a href="#" class="collection lf" id="collect"><span>收藏</span></a><b><img src="${pageContext.request.contextPath}/img/product_detail/product_detail_img6.png"                                                                       alt=""/></b>
        </div>
    </div>
</div>
<!--为你推荐-->
<div id="recommended">
    <p>为你推荐<span>大家都在看</span></p>
    <div id="demo" style="width:1000px;overflow:hidden;">
        <div id="indemo" style="float:left;width:200%;">
            <div id="demo1" style="float:left"><!-- 第一个宽度显示 -->
            <c:forEach items="${goodsList}" var="goods">
                 <div class="detail_1 lf">
                    <div class="detail_img1">
                       <a href="#"  onclick="toItemInfo(${goods.id})"><img src="..${goods.image}" border="0" width="150px;"></a>
                    </div>
                    <p>${goods.title}</p>
                </div>
           </c:forEach>
            </div>
            <div id="demo2" style="float:left">
            </div>
        </div>
        <!-- 宽度超大 -->
    </div>
    <!-- 外面大框 -->
</div>
<div class="modal" style="display:none">
    <div class="modal_dialog">
        <div class="modal_header">
              操作提醒
        </div>
        <div class="modal_information">
            <img src="${pageContext.request.contextPath}/img/product_detail/model_img2.png" alt=""/>
            <span>是否将您的宝贝加入收藏夹</span>

        </div>
        <div class="yes"><span>确定</span></div>
        <div class="no"><span>取消</span></div>
    </div>
</div>

<script type="text/javascript">
    /* 大家都在看的商品的商品详情页  */
	function toItemInfo(id) {
		window.location.href="${pageContext.request.contextPath}/goods/showGoodsInfo.do?id="+id;
	} 
</script>

<!--图片轮播悬停进入详情页效果-->
<script>
    var speed = 20;
    var tab = document.getElementById("demo");
    var tab1 = document.getElementById("demo1");
    var tab2 = document.getElementById("demo2");
    tab2.innerHTML = tab1.innerHTML;
    function Marquee() {
        if (tab2.offsetWidth - tab.scrollLeft <= 0)
            tab.scrollLeft -= tab1.offsetWidth
        else {
            tab.scrollLeft++;
        }
    }
    var MyMar = setInterval(Marquee, speed);
    tab.onmouseover = function () {
        clearInterval(MyMar)
    };
    tab.onmouseout = function () {
        MyMar = setInterval(Marquee, speed)
    };
</script>
<!--添加到购物车 立即购买 收藏部分-->
<script type="text/javascript">
    //加入购物车操作
    var taste;//口味
    var buyAccount;//购买数量
    function getPro(){
    	//口味取值
        $("#choose_color input").each(function (i, item) {
            if ($(this).hasClass("borderChange")) {
            	taste = $(this).val();
            }
        })
        console.log(taste);
        //数量取值
        buyAccount = $("#buy-num").val();
        console.log(buyAccount);
    }
    $("#add_cart").click(function (e) {
    	//口味取值
        $("#choose_color input").each(function (i, item) {
            if ($(this).hasClass("borderChange")) {
            	taste = $(this).val();
            }
        })
         console.log(taste);
		//异步提交
		$.ajax({
			"url":"${pageContext.request.contextPath}/cart/addCart.do",
			"data":"goodsid=${goods.id}&count="+$("#buy-num").val()+"&taste="+taste,
			"type":"GET",
			"dataType":"json",
			"success":function(obj){
				if(obj.state==1){
					alert(obj.message);
					location="${pageContext.request.contextPath}/cart/showCart.do";
				}
			},
			"error":function(obj){
				location="${pageContext.request.contextPath}/user/showLogin.do";
			}
		});	
    })
    /**添加到收藏**/
    $("#collect").click(function (e){
        e.preventDefault();
        getPro();
          //如果未选择，请选择商品信息
		$(".modal").show();
        $(".modal_information span").html("是否将您的宝贝加入收藏夹");
       
    })
    $('.yes').click(function(){
    	//异步提交
		$.ajax({
			"url":"${pageContext.request.contextPath}/collect/addCollect.do",
			"data":"goodsid=${goods.id}&title=${goods.title}&price=${goods.price}&image=${goods.image}",
			"type":"GET",
			"dataType":"json",
			"success":function(obj){
				if(obj.state==1){
					alert(obj.message);
					location="${pageContext.request.contextPath}/collect/showCollect.do";
				}else{
					alert(obj.message);
					$('.modal').hide();
				}
			},
			"error":function(obj){
				location="${pageContext.request.contextPath}/user/showLogin.do";
			}
		});	
    })
    $('.no').click(function(){
        $('.modal').hide();
    })
</script>
<script>
    $(function () {
        /**选择商品进行添加 悬停效果**/
        $(".avenge").mouseover(function () {
            $(this).css({"border": "1px solid #0AA1ED", "color": "#0AA1ED"});
        }).mouseout(function () {
            $(this).css({"border": "1px solid #666", "color": "#666"})
        })
        /**数量添加**/
        var n = $("#buy-num").val() * 1;
        $(".numberMinus").click(function () {
            if (n >= 1) {
                $("#buy-num").val(n -= 1);
            }
        })
        $(".numberAdd").click(function () {
            $("#buy-num").val(n += 1);
        })

        //规格选择
        $(".avenge").each(function (i, item) {
            $(this).click(function (norms) {
                $(this).addClass("borderChange")
                if ($(this).siblings().addClass("borderChange")) {
                    $(this).siblings().removeClass("borderChange")
                }
                //规格选择
                var norms = $(this).html();
                console.log(norms)
            })
        })
        //颜色选择
        $("#choose_color input").each(function (i, item) {
            $(this).click(function () {
                $(this).addClass("borderChange")
                if ($(this).siblings().addClass("borderChange")) {
                    $(this).siblings().removeClass("borderChange")
                }
                var color = $(this).val();
                console.log(color)
            })
        })
        //数量选择
        $(".accountChose").click(function () {
            var buyAccount = $("#buy-num").val();
            console.log(buyAccount);
        })

        /*立即购买*/
        $("#buy_now").click(function (e) {
        var num = $("#buy-num").val();
        var url = "${pageContext.request.contextPath}/order/paymentGoods.do?id=${goods.id}&count="+num;
        window.location.href = url;
        })
    })
</script>
<script>
<!--图片效果-->
    $("#mImg").hover(function (){
        $(this).addClass("animated pulse");
    }, function (){
        $(this).removeClass("animated pulse");
    });
</script>
<script>
	/**
	 * 点击小图片的js效果
	 */
    $('#icon_list>li').click(function(){
        $(this).children('img').css('border','2px solid skyblue');
        var address=$(this).children().attr('src');
        console.log(address);
        var newaddress=address.slice(0,-4);
        console.log(newaddress);
        var bigaddress=newaddress+'big.jpg';
        $('#mImg').attr('src',bigaddress);
        $(this).siblings().children('img').css('border','');
    })
</script>
</body>
</html>