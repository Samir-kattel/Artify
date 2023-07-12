<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="stylesheet" href="css/loginRegister.css" />
<link href="https://fonts.cdnfonts.com/css/sansation" rel="stylesheet">
<style>
.form-input {
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 1rem;
}

#file-ip-1-preview {
	width: 5rem;
	height: 5rem;
}

.center {
	margin-top: 0.5rem;
	margin-bottom: 0.3rem;
}

.form-input label {
	height: 45px;
	line-height: 50px;
	text-align: center;
	font-size: 15px;
	font-family: "Open Sans", sans-serif;
	color: #b838b8;
}
</style>
<title>Sign in - Sign up</title>
</head>
<body>
	<div class="container">
		<div class="signin-signup">
			<form action="${pageContext.request.contextPath}/login" class="sign-in-form">
				<h2 class="title">Sign in</h2>
				<div class="input-field">
					<i class="fas fa-envelope"></i> <input type="email"
						placeholder="Email" autocomplete="off" name="email" />
				</div>
				<div class="input-field">
					<i class="fas fa-lock"></i> <input type="password"
						placeholder="Password" autocomplete="off" name="password" />
				</div>
				<input type="submit" value="Login" class="btn" />
				<p class="account-text">
					Don't have an account? <a href="#" id="sign-up-btn2">Sign up</a>
				</p>
			</form>
			<form action="${pageContext.request.contextPath}/adduser"
				class="sign-up-form" method="post" enctype="multipart/form-data">
				<h2 class="title">Sign up</h2>
				<div class="input-field">
					<i class="fas fa-user"></i> <input type="text" name="username"
						placeholder="Username" autocomplete="false" required />
				</div>
				<div class="input-field">
					<i class="fas fa-envelope"></i> <input type="email" name="email"
						placeholder="Email" required autocomplete="false" />
				</div>
				<div class="input-field">
					<i class="fas fa-lock"></i> <input type="password" name="password"
						placeholder="Password" required />
				</div>

				<!-- image uplaod start  -->
				<div class="center">
					<div class="form-input">
						<div class="preview">
							<img id="file-ip-1-preview" />
						</div>
						<div class="file-input-button">
							<label for="file-ip-1" style="margin-bottom: 10px">Upload
								Image</label> <input type="file" id="file-ip-1" accept="image/*"
								onchange="showPreview(event);" name="profile_pic" required />
						</div>
					</div>
				</div>
				<!-- image uplaod end  -->
				<input type="submit" value="Sign up" class="btn" />
				<p class="account-text">
					Already have an account? <a href="#" id="sign-in-btn2">Sign in</a>
				</p>
			</form>
			<!-- 	registration message  -->
			<c:if test="${not empty registeredmessage}">
				<script>
        alert("${registeredmessage}");
    </script>
				<c:remove var="registeredmessage" scope="session" />
			</c:if>
			<!-- registration message end  -->
		</div>
		<!-- -- panel description --  -->
		<div class="panels-container">
			<div class="panel left-panel">
				<div class="content">
					<h3>Member of Brand?</h3>
					<p>Welcome back to our fashion family, get ready for more
						exclusive deals and styles!</p>
					<button class="btn" id="sign-in-btn">Sign in</button>
				</div>
				<img src="images/signup1.svg" alt="" class="image" />
			</div>
			<div class="panel right-panel">
				<div class="content">
					<h3>New to Brand?</h3>
					<p>Join our fashion-forward community and express your unique
						style with us!</p>
					<button class="btn" id="sign-up-btn">Sign up</button>
				</div>
				<img src="images/signin1.svg" alt="" class="image" />
			</div>
		</div>
	</div>
	<script type="text/javascript">
      /* query selector  */
      const sign_in_btn = document.querySelector("#sign-in-btn");
      const sign_up_btn = document.querySelector("#sign-up-btn");
      const container = document.querySelector(".container");
      const sign_in_btn2 = document.querySelector("#sign-in-btn2");
      const sign_up_btn2 = document.querySelector("#sign-up-btn2");

      /* onclick function handler  */
      sign_up_btn.addEventListener("click", () => {
        container.classList.add("sign-up-mode");
      });
      sign_in_btn.addEventListener("click", () => {
        container.classList.remove("sign-up-mode");
      });
      sign_up_btn2.addEventListener("click", () => {
        container.classList.add("sign-up-mode2");
      });
      sign_in_btn2.addEventListener("click", () => {
        container.classList.remove("sign-up-mode2");
      });

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
