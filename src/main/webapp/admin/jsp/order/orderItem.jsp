<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<br>
	<table cellSpacing="1" cellPadding="0" width="100%" align="center" border="0">
		<tbody>
			<tr>
				<td class="ta_01" align="center"><strong>订单列表</strong></td>
			</tr>
			<tr>
				<td class="ta_01" align="center">
					<table cellspacing="0" cellpadding="1" rules="all"
						bordercolor="gray" border="1" id="DataGrid1"
						style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse;>
							style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px;">
							<td align="center" width="10%">订单详情id</td>
							<td align="center" width="10%">订单id</td>
							<td align="center" width="10%">商品信息</td>
							<td align="center" width="10%">订单金额</td>
							<td align="center" width="10%">图片</td>
							<td align="center" width="10%">订单状态</td>
						</tr>
						<c:forEach items="${orderItemsList}" var="orderItem">
							<tr>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="18%">${orderItem.id}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${orderItem.orderid}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${orderItem.title}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">${orderItem.price*orderItem.count}</td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">
									<img src="${pageContext.request.contextPath}${orderItem.image}" width="50px;"/></td>
								<td style="CURSOR: hand; HEIGHT: 22px" align="center"
									width="17%">
									<c:if test="${orderItem.paymentstatus!=1}">
													未付款
												</c:if> 
											<c:if test="${orderItem.paymentstatus==1}">
											已付款	
										</c:if> 
										||<c:if test="${orderItem.orderstatus!=1}">
													等待确认收货
												</c:if> <c:if test="${orderItem.orderstatus==1}">
													订单完成
												</c:if>
									</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</TBODY>
	</table>
</body>
</HTML>

