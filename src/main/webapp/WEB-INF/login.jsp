<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Tum4World</title>
    <link rel="shortcut icon" type="image/png" href="materiale/logo.png">
    <link rel="stylesheet" href="styles/login.css">
    <link rel="stylesheet" href="styles/format.css">
    <script src="scripts/form-validation.js"></script>
    <script src="scripts/admin-functions.js"></script>
</head>
<body>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            updatePageCounter("LOGIN");
        });
    </script>
    <jsp:include page="Header.jsp"></jsp:include>

    <div class="container">
        <h1>Accedi al tuo account</h1>
        <form onsubmit="return validateSignIn()" action="${pageContext.request.contextPath}/loginServlet" method="post">
            <label for="username">Username</label>
            <input class="input" id="username" class="username" type="text" name="username" required>

            <label for="password">Password</label>
            <input class="input" id="password" class="password" type="password" name="password" required>

            <input class="button" type="submit" value="Accedi">

            <br>

            <%= request.getSession().getAttribute("errorMessage") != null ? request.getSession().getAttribute("errorMessage") : "" %>
        </form>
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
