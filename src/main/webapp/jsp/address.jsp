<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Fly Cafe 收货地址信息页面</title>
<link href="${pageContext.request.contextPath}/css/header.css"
	rel="stylesheet" />
	
<link href="${pageContext.request.contextPath}/css/address.css"
	rel="stylesheet" />
</head>
<body>
	<!-- 页面顶部-->
	<%@include file="header.jsp"%>
	<!-- 账号中心 -->
	<div id="center_top">
		<div id="center_top_l">
			<div id="childlogo">
				<img src="${pageContext.request.contextPath}/img/childlogo.png" />
			</div>
			<span class="logo_text">帐号中心</span>
		</div>
		<div id="center_top_r">
			<ul class="ul">
				<li><a href="${pageContext.request.contextPath}/user/showPassword.do">账号与安全</a></li>
				<li><a href="${pageContext.request.contextPath}/user/showPerson.do">个人信息</a></li>
				<li><a href="#" class="active">收货地址</a></li>
			</ul>
		</div>
	</div>
	<!--我的订单内容区域 #container-->
	<div id="container" class="clearfix">
		<!-- 右边栏-->
		<div class="rightsidebar_box">
			<!--标题栏-->
			<div class="rs_header">
				<span class="address_title">收获地址管理</span>
			</div>
			<!--收货人信息填写栏-->
			<div class="rs_content">
				<form method="post" action="${pageContext.request.contextPath}/address/add.do" id="update_form">
					<input type="hidden" name="id" id="id">
					<!--收货人姓名-->
					<div class="recipients">
						<span class="red">*</span><span class="kuan">收货人：</span>
						<input type="text" name="receiverName" id="receiverName" />
					</div>
					<!--收货人所在城市等信息-->
					<div class="address_content">
						<span class="red">*</span> 
						<span class="kuan" style="width: 70px;">
						省&nbsp;&nbsp;份：</span>
						<select data-province="---- 选择省 ----" id="receiverState"
							name="receiverState" onchange="getCity(this.value,-1,-1)">
						</select>
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
						<span class="red">*</span><span class="kuan">手机号码：</span> <input
							type="tel" id="receiverMobile" name="receiverMobile" />固定电话： <input
							type="text" name="receiverPhone" id="receiverPhone" />
					</div>
					<!--邮政编码-->
					<div class="address_postcode">
						<span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp; <input
							type="text" name="receiverZip" />
					</div>
					<!--地址名称-->
					<div class="address_name">
						<span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp; <input
							type="text" id="addressName" name="addressName" />如：
							<span class="sp">家</span>
							<span class="sp">公司</span>
							<span class="sp">宿舍</span>
					</div>
					<!--保存收货人信息-->
					<div class="save_recipient">保存收货人信息</div>
				</form>
				<!--已有地址栏-->
				<div class="address_information_manage">
					<div class="aim_title">
						<span class="dzmc dzmc_title">地址名称</span><span
							class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span
							class="lxdh lxdh_title">联系电话</span><span
							class="operation operation_title">操作</span>
					</div>
					<c:forEach items="${listAddress}" var="list">
						<c:if test="${list.isDefault==1 }">
							<div class="aim_content_one aim_active">
								<span class="dzmc dzmc_active">${list.recvTag}</span> <span
									class="dzxm dzxm_normal">${list.recvName}</span> <span
									class="dzxq dzxq_normal">${list.recvDistrict}${list.recvAddr}</span>
								<span class="lxdh lxdh_normal">${list.recvPhone}</span> <span
									class="operation operation_normal"> 
									<span class="aco_change" onclick="getAddress(${list.id})">修改</span>|
									<span class="aco_delete" onclick="deleteAddress(${list.id})">删除</span>
								</span> <span class="swmr swmr_normal"></span>
							</div>
						</c:if>
						<c:if test="${list.isDefault==0}">
							<div class="aim_content_two">
								<span class="dzmc dzmc_normal">${list.recvTag}</span> <span
									class="dzxm dzxm_normal">${list.recvName }</span> <span
									class="dzxq dzxq_normal">${list.recvDistrict}${list.recvAddr}</span>
								<span class="lxdh lxdh_normal">${list.recvPhone }</span> <span
									class="operation operation_normal"> <span
									class="aco_change" onclick="getAddress(${list.id})">修改</span>|
									<span class="aco_delete" onclick="deleteAddress(${list.id})">删除</span>
								</span> <span class="swmr swmr_normal"> <a href="#"
									onclick="setDefault1(${list.id})">设为默认</a></span>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<!--分页js  -->
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<!--三级联动数据js-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/distpicker.data.js"></script>
<!--三级联动js-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/distpicker.js"></script>
<!-- js验证 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/personal.js"></script>
<script type="text/javascript">
//删除的时候的提交
function deleteAddress(id){
	if(confirm("确定要删除吗?")){
		location.href="${pageContext.request.contextPath}/address/deleteAddress.do?id="+id;
	}
}
//修改的时候的ajax提交
function getAddress(id){
	$.ajax({
		"url":"${pageContext.request.contextPath}/address/getAddress.do",
		"data":"id="+id,
		"type":"GET",
		"dataType":"json",
		"success":function(obj){
			if(obj.state==1){
				$("#receiverName").val(obj.data.recvName);
				$("#receiverMobile").val(obj.data.recvPhone);
	      		$("#receiverPhone").val(obj.data.recvTel);
	      		$("#receiverZip").val(obj.data.recvZip);
	      		$("#addressName").val(obj.data.recvTag);
	      		$("#receiverAddress").val(obj.data.recvAddr);
        		getProvince(obj.data.recvProvince,obj.data.recvCity,obj.data.recvArea);
        		$("#id").val(obj.data.id);              
        		$(".save_recipient").html("修改收货人信息");
        		$("#update_form").attr("action","${pageContext.request.contextPath}/address/updateAddress.do");
			}
		}
	})
}

//定义函数，设置默认值
function setDefault1(id){
	location.href="${pageContext.request.contextPath}/address/setDefault.do?id="+id;
}

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
<script type="text/javascript">
	$(".lxdh_normal").each(function(i, e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
</script>
</html>