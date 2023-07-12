<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Login Panel</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
</head>
<body>
  
  <div class="container">
    <div class="myform">
      <form action="${pageContext.request.contextPath}/adminlogin">
        <h2>ADMIN LOGIN</h2>
        <input type="text" placeholder="Admin Name" name="name">
        <input type="password" placeholder="Password" name="password">
        <button type="submit">LOGIN</button>
      </form>
    </div>
    <div class="image">
      <img src="images/logo.png">
    </div>
  </div>

</body>
</html>