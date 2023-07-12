<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page
	import="com.model.ProductDao, com.model.Product, com.model.UserDao, com.model.User"%>
<%
ProductDao productDao = new ProductDao();
ArrayList<Product> productList = productDao.fetchAllProduct();
%>
<%
UserDao userDao = new UserDao();
ArrayList<User> UserList = userDao.fetchAllUser();
%>
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
<title>Admin panel</title>
</head>
<body>

	<div class="container">
		<div class="sidebar">
			<ul>
				<li><a href="#"> <i class="fas fa-clinic-medical"></i>
						<div class="title">Artify</div>
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/view/adminpage.jsp"> <i
						class="fas fa-th-large"></i>
						<div class="title">Dashboard</div>
				</a></li>
				<li><a
					href="${pageContext.request.contextPath}/view/addproduct.jsp">
						<i class="fa fa-plus"></i>
						<div class="title">Add Product</div>
				</a></li>
				<li>
					<form action="${pageContext.request.contextPath}/logout">
						<input type="hidden" name="logout" value="true">
						<button type="submit"
							style="padding: 2rem; width: 100%; font-size: 1.5rem; cursor: pointer;">Logout</button>
					</form>
				</li>
			</ul>
		</div>
		<div class="main">
			<div class="top-bar">
				<div class="search">
					<input type="text" name="search" placeholder="search here" /> <label
						for="search"><i class="fas fa-search"></i></label>
				</div>
				<i class="fa-solid fa-user"></i>
			</div>
			<div class="cards">
				<div class="card">
					<div class="card-content">
						<div class="number"><%=productList.size()%></div>
						<div class="card-name">
							<a href="<%=request.getContextPath()%>/viewallproduct"
								style="text-decoration: none;">View Product</a>
						</div>
					</div>
					<div class="icon-box">
						<i class="fa fa-product-hunt" style="color: white"></i>
					</div>
				</div>
				<div class="card">
					<div class="card-content">
						<div class="number"><%=UserList.size()%></div>
						<div class="card-name">
						<a href="<%=request.getContextPath()%>/viewalluser"
								style="text-decoration: none;">View User</a>
						</div>
					</div>
					<div class="icon-box">
						<i class="fa-solid fa-user" style="color: white"></i>
					</div>
				</div>
			</div>
			<!-- all product list  -->
			<div class="tables">
				<div class="last-appointments">
					<c:choose>
						<c:when test="${not empty ptList}">
							<div class="heading">
								<h2>All Products</h2>
							</div>
							<table class="appointments">
								<thead>
									<td>Name</td>
									<td>Price</td>
									<td>Image</td>
								</thead>
								<tbody>

									<c:forEach items="${ptList}" var="pt">
										<tr>
											<td><c:out value="${pt.name}" /></td>
											<td>${pt.price}</td>
											<td><img
												src="${pageContext.request.contextPath}/backendImages/${pt.img_path}"
												class="table-image" /></td>
											<td><i class="far fa-eye"></i> <a
												href="${pageContext.request.contextPath}/editproduct?id=${pt.id}"><i
													class="far fa-edit"></i></a> <a
												href="${pageContext.request.contextPath}/deleteproduct?id=${pt.id}"><i
													class="far fa-trash-alt"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:when>
					</c:choose>

					<c:choose>
						<c:when test="${not empty utList}">
							<div class="heading">
								<h2>All Users</h2>
							</div>
							<table class="appointments">
								<thead>
									<td>Username</td>
									<td>Email</td>
									<td>Image</td>
								</thead>
								<tbody>

									<c:forEach items="${utList}" var="ut">
										<tr>
											<td><c:out value="${ut.username}" /></td>
											<td>${ut.email}</td>
											<td><img
												src="${pageContext.request.contextPath}/backendImages/${ut.image_path}"
												class="table-image" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:when>
					</c:choose>

				</div>
			</div>
		</div>
	</div>
</body>
</html>

