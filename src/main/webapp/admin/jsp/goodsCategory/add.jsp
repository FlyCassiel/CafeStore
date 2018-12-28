<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/Style1.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
<script type="text/javascript">
</script>
<style type="text/css">
tr{
height:40px;
line-height: 40px;
}

</style>
</head>

<body>
	<form id="userAction_save_do" action="" method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" colSpan="4" height="26">
					<font>添加分类信息</font>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" class="ta_01">
					<font>分类信息名称：</font>
				</td>
				<td class="ta_01" colspan="3">
					<input type="text" id="name" name="name" value="${name}" class="bg" />
				</td>
			</tr>
			<tr>
			<td width="18%" align="center" class="ta_01">
					所属的分类：
				</td>
				<td class="ta_01">
				<select name="parentId">
						<option value="0">咖啡</option>
				</select>
				</td>
			</tr>

			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" colSpan="4">
					<button value="确定" class="button_ok">&#30830;&#23450;</button> 
					<font face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>
					<font face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> 
					<input class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
var name=$("#name").val();
$(".button_ok").click(function(){
	$.ajax({
		"url":"${pageContext.request.contextPath}/goodsCategory/insertAdmin.do",
		"data":$("#userAction_save_do").serialize(),
		"type":"POST",
		"dataType":"json",
		"success":function(obj){
			if(obj.state==1){
				alert("添加成功");
				location.href = "${pageContext.request.contextPath}/goodsCategory/showQuery.do?name="+name;
			}else{
				alert("添加失败");
			}
		}
	})
})
</script>
</HTML>