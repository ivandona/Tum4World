<%--
  Created by IntelliJ IDEA.
  User: eeve1
  Date: 21/08/2023
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>

  <link rel="stylesheet" href="styles/login.css">

  <script src="scripts/form-validation.js"></script>
</head>
<body>
<div class="container">
  <jsp:include page="navbar.jsp"></jsp:include>
  <h1>Accedi al tuo account</h1>
  <form onsubmit="return validateSignIn()" action="${pageContext.request.contextPath}/loginServlet" method="post">
    <label for="username">Username</label>
    <input id="username" class="username" type="text" name="username" required>

    <label for="password">Password</label>
    <input id="password" class="password" type="password" name="password" required>

    <input class="button" type="submit" value="Accedi">

    <br>

    <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
  </form>
</div>
</body>
</html>
