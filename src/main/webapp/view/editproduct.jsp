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
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/addproduct.css" />
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
</head>
<body>
	<div class="container">
		<div class="sidebar">
			<ul>
				<li><a href="#"> <i class="fas fa-clinic-medical"></i>
						<div class="title">Artify</div>
				</a></li>
				<li><a href="view/adminpage.jsp"> <i class="fas fa-th-large"></i>
						<div class="title">Dashboard</div>
				</a></li>
				<li><a href="addproduct.jsp"> <i class="fa fa-plus"></i>
						<div class="title">Add Product</div>
				</a></li>
			</ul>
		</div>
		<div class="main">

			<div class="add-product">
				<form action="${pageContext.request.contextPath}/updateproduct"
					class="sign-up-form" method="post" enctype="multipart/form-data">
					<h2 class="title" style="color: black;">Edit Product</h2>
					   <input type="number" value="${product.id}" style="display:none;" name="id"/>
					<div class="input-field">
						<input type="text" placeholder="Product Name"
							value="${product.name}" name="name" />
					</div>
					<div class="input-field">
						<input type="number" placeholder="Price" value="${product.price}"
							name="price" />
					</div>


					<!-- image uplaod start  -->
					<div class="center">
						<div class="form-input">
							<div class="preview">
								<img id="file-ip-1-preview"
									src="${pageContext.request.contextPath}/backendImages/${product.img_path}" />
							</div>
							<div class="file-input-button">
								<label for="file-ip-1" style="margin-bottom: 10px">Upload
									Image</label> <input type="file" id="file-ip-1" accept="image/*"
									onchange="showPreview(event);" name="image" value="${product.img_path}"/>
							</div>
						</div>
					</div>
					<!-- image uplaod end  -->
					<input type="submit" value="Update" class="btn" />
				</form>
			</div>
		</div>
	</div>
	<script>
		/* for image preview */
		function showPreview(event) {
			if (event.target.files.length > 0) {
				var src = URL.createObjectURL(event.target.files[0]);
				var preview = document.getElementById("file-ip-1-preview");
				preview.src = src;
				preview.style.display = "block";
			}
		}
	</script>
</body>
</html>
