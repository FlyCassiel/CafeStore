<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>菜单</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	margin: 0px;
	text-align: left;
	background:#D76B00;
	}

td {
	font-size: 12px;
	line-height: 20px;
	color:black;
}

.dtree {
	font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
	font-size: 15px;
	white-space: nowrap;
	line-height: 35px;
	color:black;
}

.dtree img {
	border: 0px;
	vertical-align: middle;
}

.dtree a {
	text-decoration: none;
	color:black;
}

.dtree a.node, .dtree a.nodeSel {
	white-space: nowrap;
	padding: 1px 2px 1px 2px;
}

.dtree a.node:hover, .dtree a.nodeSel:hover {
	text-decoration: underline;
}
.dtree .clip {
	overflow: hidden;
}
</style>
</head>
<body>
	<table width="100" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="12"></td>
		</tr>
	</table>
	<table width="100%" border="0">
		<tr>
			<td>
				<div class="dtree">
					<a href="javascript: d.openAll();">展开所有</a> | 
					<a href="javascript: d.closeAll();">关闭所有</a>
					<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/dtree.js"></script>
					<script type="text/javascript">
						d = new dTree('d');
						d.add('01', -1,
								'&nbsp;&nbsp;FlyCafe &nbsp;&nbsp;&nbsp;  咖啡');
						d.add('0101', '01', '用户管理>', '', '', 'mainFrame');
						d
								.add(
										'010101',
										'0101',
										'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户',
										'${pageContext.request.contextPath}/admin/showUser.do',
										'', 'mainFrame');
						d.add('0102', '01', '分类管理>');
						d
								.add(
										'010201',
										'0102',
										'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分类',
										'${pageContext.request.contextPath}/goodsCategory/showGoodsCategory.do',
										'', 'mainFrame');
						d.add('0103', '01', '商品管理>');
						d
								.add(
										'010301',
										'0103',
										'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品',
										'${pageContext.request.contextPath}/goods/showAdminGoods.do',
										'', 'mainFrame');
						d.add('0104', '01', '订单管理>');
						d
								.add(
										'010401',
										'0104',
										'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单',
										'${pageContext.request.contextPath}/order/showOrderAdmin.do',
										'', 'mainFrame');
						document.write(d);
					</script>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
