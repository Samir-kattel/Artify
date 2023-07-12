<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.model.ProductDao, com.model.Product"%>
<%@ page import="com.model.ProductDao"%>
<%@ page import="com.model.Product"%>

<c:set var="productDao" value="<%=new ProductDao()%>" />

<c:set var="productList" value="${productDao.fetchAllProduct()}" />

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/home.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;900&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;900&family=Josefin+Sans&display=swap"
	rel="stylesheet" />
<link href="https://fonts.cdnfonts.com/css/sansation" rel="stylesheet" />
<script src="https://kit.fontawesome.com/af13f6ac9a.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- nav-bar start  -->
	<nav>
		<div class="main-container">
			<div class="nav-container">
				<div class="logo">
					<img src="${pageContext.request.contextPath}/images/logo.png"
						alt="logo" class="logo-img" />
				</div>
				<div class="search">
					<i class="fa-solid fa-magnifying-glass" onclick="searchFunc()"
						style="position: absolute; left: 18px; top: 18px"></i> <input
						type="text" id="search-bar" placeholder="search for anything"
						autocomplete="off" onkeyup="searchFunc()" style="outline: none" />
				</div>

				<div class="nav-option">
					<!-- a tag  -->
					<a class="active"
						href="${pageContext.request.contextPath}/view/home.jsp">Home</a> <a
						href="${pageContext.request.contextPath}/view/product.jsp">Product</a>
					<a href="./product.html">About</a> <a href="./blog.html">Support</a>
					<a class="cart-count"
						href="${pageContext.request.contextPath}/view/cart.jsp"> <i
						class="fa fa-shopping-cart"></i> <span id="cart-count"> <c:if
								test="${not empty loggedInEmail}">
                                  3
						      </c:if> <c:if test="${empty loggedInEmail}">
                                  0
						      </c:if>
					</span>
					</a>

				</div>

				<div class="login-user">
					<c:if test="${not empty loggedInEmail}">

						<div style="width: 3.5rem; height: 3.5rem;">
							<a
								href="${pageContext.request.contextPath}/singleuser?email=${loggedInEmail}"
								style="text-decoration: none"> <img
								src="${pageContext.request.contextPath}/images/male-avatar.png"
								alt="profile"
								style="width: 100%; height: 100%; object-fit: cover; border-radius: 50%; border: 2.5px solid black; box-sizing: border-box;" />
							</a>
						</div>


					</c:if>
					<c:if test="${empty loggedInEmail}">
						<a href="/EcommerceWebApp/index.jsp" style="text-decoration: none">
							<span class="nav-login-signup">Login/Signup</span>
						</a>
					</c:if>
				</div>

			</div>
		</div>
	</nav>
	<!-- nav-bar end -->
	<!-- home start  -->
	<div class="home-container">
		<div class="home-sub-container">
			<div class="home-background">
				<img src="${pageContext.request.contextPath}/images/background.jpg"
					alt="background" class="background-img" />
				<div class="img-text">
					<h1>40% OFF</h1>
					<span class="description">Best Deals And Offers During This
						Festive Season</span> <span class="shop-now-btn">Shop Now</span>
				</div>
			</div>
			<!-- featured product start  -->
			<div class="feature-product-main-container">
				<h2>Featured Products</h2>
				<div class="feature-container">
					<c:forEach items="${productList}" var="product">
						<!-- one card start  -->
						<div class="card"
							onclick="location.href='${pageContext.request.contextPath}/singleproduct?id=${product.id}'">
							<img
								src="${pageContext.request.contextPath}/backendImages/${product.img_path}"
								alt="Avatar" class="card-image" />
							<div class="card-container">
								<h4>
									<b>${product.name}</b>
								</h4>
								<p>Rs.${product.price}</p>
							</div>
						</div>
						<!-- <one card end  -->
					</c:forEach>

				</div>
				<div class="view-all-container">
					<span class="view-all">View All</span>
				</div>
			</div>
			<!-- feature product end  -->

			<!-- specieal offer start  -->
			<div class="feature-product-main-container">
				<h2>Special Offers</h2>
				<div class="feature-container">
					<c:forEach items="${productList}" var="product">
						<!-- one card start  -->
						<div class="card"
							onclick="location.href='${pageContext.request.contextPath}/singleproduct?id=${product.id}'">
							<img
								src="${pageContext.request.contextPath}/backendImages/${product.img_path}"
								alt="Avatar" class="card-image" />
							<div class="card-container">
								<h4>
									<b>${product.name}</b>
								</h4>
								<p>Rs.${product.price}</p>
							</div>
						</div>
						<!--  one card end  -->
					</c:forEach>
				</div>
				<div class="view-all-container">
					<span class="view-all">View All</span>
				</div>
			</div>
			<!-- special offer end  -->
		</div>
	</div>
	<!-- home end  -->
	<!-- <footer start  -->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="footer-col">
					<h4>Contact us</h4>
					<div class="social-links">
						<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
							class="fab fa-twitter"></i></a> <a href="#"><i
							class="fab fa-instagram"></i></a> <a href="#"><i
							class="fab fa-linkedin-in"></i></a>
					</div>

				</div>
				<div class="footer-col">
					<h4>company</h4>
					<ul>
						<li><a href="#">about us</a></li>
						<li><a href="#">our services</a></li>
						<li><a href="#">privacy policy</a></li>
						<li><a href="#">affiliate program</a></li>
					</ul>
				</div>
				<div class="footer-col">
					<h4>get help</h4>
					<ul>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">shipping</a></li>
						<li><a href="#">returns</a></li>
						<li><a href="#">order status</a></li>
						<li><a href="#">payment options</a></li>
					</ul>
				</div>
				<div class="footer-col">
					<h4>online shop</h4>
					<ul>
						<li><a href="#">watch</a></li>
						<li><a href="#">bag</a></li>
						<li><a href="#">shoes</a></li>
						<li><a href="#">dress</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<!-- <footer end  -->
</body>
</html>
