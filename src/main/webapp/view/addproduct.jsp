<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addproduct.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminpage.css" />
    <link
    rel="stylesheet"
    href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
    integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
    crossorigin="anonymous"
  />
  <link
    href="https://fonts.googleapis.com/css2?family=Inter:wght@400;900&display=swap"
    rel="stylesheet"
  />
  <link
    href="https://fonts.googleapis.com/css2?family=Inter:wght@400;900&family=Josefin+Sans&display=swap"
    rel="stylesheet"
  />
  <link href="https://fonts.cdnfonts.com/css/sansation" rel="stylesheet" />
  <script
    src="https://kit.fontawesome.com/af13f6ac9a.js"
    crossorigin="anonymous"
  ></script>
  </head>
  <body>
    <div class="container">
      <div class="sidebar">
        <ul>
          <li>
            <a href="#">
              <i class="fas fa-clinic-medical"></i>
              <div class="title">Artify</div>
            </a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/view/adminpage.jsp">
              <i class="fas fa-th-large"></i>
              <div class="title">Dashboard</div>
            </a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/view/addproduct.jsp">
              <i class="fa fa-plus"></i>
              <div class="title">Add Product</div>
            </a>
          </li>
        </ul>
      </div>
      <div class="main">
        <div class="add-product">
          <form action="${pageContext.request.contextPath}/addproduct" class="sign-up-form" method="post" enctype="multipart/form-data">
            <h2 class="title" style="color:black;">Add Product</h2>
            <div class="input-field">
              <input type="text" placeholder="Product Name" name="name" required />
            </div>
            <div class="input-field">
              <input type="number" placeholder="Price" name="price" required />
            </div>

            <!-- image uplaod start  -->
            <div class="center">
              <div class="form-input">
                <div class="preview">
                  <img id="file-ip-1-preview" />
                </div>
                <div class="file-input-button">
                  <label for="file-ip-1" style="margin-bottom: 10px"
                    >Upload Image</label
                  >
                  <input
                    type="file"
                    id="file-ip-1"
                    accept="image/*"
                    onchange="showPreview(event);"
                    name="image"
                    required
                  />
                </div>
              </div>
            </div>
            <!-- image uplaod end  -->
            <input type="submit" value="Add" class="btn" />
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
