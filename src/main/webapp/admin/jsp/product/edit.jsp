<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate-min.js"></script>
</head>

<body>
	<form id="userAction_save_do" action="" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${goods.id}"> 
		<input type="hidden" name="image" value="${goods.image}"> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center">
			<tr>
				<td class="ta_01" align="center" colSpan="4" height="26">
					<strong>编辑商品</strong>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" class="ta_01">
					商品名称：
				</td>
				<td>
				<input type="text" name="title" id="name" value="${goods.title}"/>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" class="ta_01">
					价格：
				</td>
				<td class="ta_01">
					<input type="text"
					name="price" value="${goods.price}" class="bg" />
				</td>
				<td width="18%" align="center" class="ta_01">
					产地：
				</td>
				<td class="ta_01">
				<input type="text"
					name="place" value="${goods.place}" class="bg" />
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" class="ta_01">
					品牌：
				</td>
				<td class="ta_01">
				<input type="text"
					name="brand" value="${goods.brand}" class="bg" />
				</td>
				<td width="18%" align="center" class="ta_01">
					商品图片：
				</td>
				<td class="ta_01" colspan="3">
					<input type="file"	name="photo" /> 
					<c:if test="${!empty goods.image}">
						<img src="${pageContext.request.contextPath}${goods.image}" width="100px;"/>
					</c:if>
				</td>
					
			</tr>
			<tr>
			<td width="18%" align="center" class="ta_01">
					是否热门：
				</td>
				<td class="ta_01">
					<select name="isHot">
						<option value="1"
							<c:if test="${goods.isHot==1}">selected</c:if>>是</option>
						<option value="0"
							<c:if test="${goods.isHot==0}">selected</c:if>>否</option>
					</select>
				</td>
				<td width="18%" align="center" class="ta_01">
					所属的分类：
				</td>
				<td class="ta_01" colspan="3">
				<select name="categoryId">
						<c:forEach items="${goodsCategoriesList}" var="goodsCategory">
							<option value="${goodsCategory.id}"
								<c:if test="${goodsCategory.id==goods.categoryId}">selected</c:if>>${goodsCategory.name}</option>
						</c:forEach>
				</select>
				</td>
				
			</tr>
			<tr>
				<td width="18%" align="center" class="ta_01">
					商品描述：</td>
				<td class="ta_01" colspan="3">
					<textarea name="sellPoint" rows="5" cols="30">${goods.sellPoint}</textarea>
				</td>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" colSpan="4">
					<button  id="userAction_save_do_submit" class="button_ok">确定</button> 
					<button type="reset" class="button_cancel">&#37325;&#32622;</button>
					<input class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">

$(".button_ok").click(function(){
	$.ajax({
		"url":"${pageContext.request.contextPath}/goods/editAdmin.do",
		"data":$("#userAction_save_do").serialize(),
		"type":"POST",
		"dataType":"json",
		"success":function(obj){
			if(obj.state==1){
				alert(obj.message);
				location.href = "${pageContext.request.contextPath}/goods/showEdit.do?id=${goods.id}";
			}else{
				alert(obj.message);
			}
		}
	})
})
</script>
</html>