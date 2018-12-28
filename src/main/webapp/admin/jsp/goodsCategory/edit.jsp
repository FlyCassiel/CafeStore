<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<LINK href="${pageContext.request.contextPath}/css/Style1.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
</head>

<body>
	<form id="userAction_save_do" name="Form1" action="" method="post">
		<input type="hidden" id="inputid" name="id" value="${goodsCategory.id}" /> 
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#555" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#666" colSpan="4"
					height="26"><strong>编辑分类管理</strong></td>
			</tr>
			<tr style="background-color: #666;">
				<td width="18%" align="center" class="ta_01"><font>分类名称：</font>
				</td>
				<td class="ta_01" colspan="3">
				<input type="text" name="name" id="name" value="${goodsCategory.name}" class="bg" /></td>
			</tr>

			<tr style="background-color: #666;">
				<td class="ta_01" style="WIDTH: 100%" align="center" colSpan="4">
					<button class="button_ok">确定</button>
					<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>
					<input class="button_ok" type="button" onclick="history.go(-1)"
					value="返回" /> <span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
/* 确定修改的异步提交 */
$('.button_ok').click(function(){
	var id=$('#inputid').val();
	var name=$('#name').val();
	
	$.ajax({
		"url":"${pageContext.request.contextPath}/goodsCategory/updateGoodsCategory.do",
		"data":"id="+id+"&name="+name,
		"type":"POST",
		"dataType":"json",
		"success":function(obj){
			if (obj.state == 1) {
				alert("修改成功");
				location.href = "${pageContext.request.contextPath}/goodsCategory/showEdit.do?id="+id;
			} else {
				alert(obj.state + "," + obj.message);
			}
		}
	})
})
</script>
</html>