<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.model.CartDao, com.model.Cart"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/adminpage.css" />
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;900&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;900&family=Josefin+Sans&display=swap"
	rel="stylesheet" />
<link href="https://fonts.cdnfonts.com/css/sansation" rel="stylesheet" />
<script src="https://kit.fontawesome.com/af13f6ac9a.js"
	crossorigin="anonymous"></script>
<title>Cart</title>
</head>
<body>
	<div class="container">
		<!-- all product list  -->
		<div class="tables">
			<div class="last-appointments">
				<a href="${pageContext.request.contextPath}/view/product.jsp"
					style="text-decoration: none;">Back</a>
				<div class="heading">
					<h2>Cart</h2>
					<a href="<%=request.getContextPath()%>/viewcart"
						style="text-decoration: none;">Refresh Cart</a>
						<a href="${pageContext.request.contextPath}/view/order.jsp"
					style="text-decoration: none; margin-right:5rem;">view Orders</a>			
				</div>
				<table class="appointments">
					<thead>
						<td>Name</td>
						<td>Price</td>
						<td>Image</td>
					</thead>
					<tbody>
						<c:set var="totalPrice" value="0" />
						<c:forEach items="${cartList}" var="item">
							<!-- one product start  -->
							<tr>
								<td>${item.name}</td>
								<td>${item.price}</td>
								<td><img
									src="${pageContext.request.contextPath}/backendImages/${item.img_path}"
									class="table-image" /></td>
								<td><i class="far fa-eye"></i><i class="far fa-edit"></i> <a
									href="${pageContext.request.contextPath}/deletecart?id=${item.cartId}"><i
										class="far fa-trash-alt"></i></a></td>
							</tr>
							<!-- one product end  -->
							<c:set var="totalPrice" value="${totalPrice + item.price}" />
						</c:forEach>
					</tbody>
				</table>
				<span style="margin-top: 3rem;"> Total price: Rs.
					${totalPrice} </span>

			</div>
		</div>
	</div>
</body>
</html>
