<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Profile</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/profile.css" />
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
</head>
<body>
	<div class="container">
		<div class="main">
		   <a href="${pageContext.request.contextPath}/view/home.jsp"
					style="text-decoration: none;">Back</a>
			<h2 class="title">Profile</h2>
			<div class="data" style="color:white;">
				<img
					src="${pageContext.request.contextPath}/backendImages/${loggedUserDetails.image_path}"
					class="data-img" /> <span>Username:
					${loggedUserDetails.username}</span> <span>Email: ${loggedInEmail}</span>
			</div>
			<span class="edit-profile" style="cursor:pointer;"
				onclick="location.href='${pageContext.request.contextPath}/edituser?email=${loggedInEmail}'">Edit
				Profile</span> <span class="edit-profile"
				style="background-color: rgb(45, 76, 211); color: white; cursor: pointer;"
				onclick="location.href='${pageContext.request.contextPath}/userlogout'">Log
				Out</span>
		</div>
	</div>
</body>
</html>
