<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tum4World</title>

  <link rel="stylesheet" href="styles/sign-in.css">

  <script src="scripts/form-validation.js"></script>
  <script src="scripts/admin-functions.js"></script>
</head>
<body>
<script>
  // chiama updatePageCounte appena la pagina si è caricata completamente
  document.addEventListener("DOMContentLoaded", function() {
    updatePageCounter("SIGN_IN");
  });
</script>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container">
  <h1>Registrazione</h1>
  <form onsubmit="return validateSignIn();" action="${pageContext.request.contextPath}/signInServlet" method="post">
    <div class="row">
      <div class="col">
        <label for="name">Nome:</label><br>
        <input type="text" id="name" name="name" required><br>

        <label for="surname">Cognome:</label><br>
        <input type="text" id="surname" name="surname" required><br>

        <label for="birthdate">Data di Nascita:</label><br>
        <input type="date" id="birthdate" name="birthdate" required><br>

        <label for="phoneNumber">Numero di Telefono:</label><br>
        <input type="text" id="phoneNumber" name="phoneNumber" required><br>
      </div>
      <div class="col">
        <label for="email">Indirizzo Email:</label><br>
        <input type="email" id="email" name="email" required><br>

        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br>

        <label for="confirm_password">Conferma Password:</label><br>
        <input type="password" id="confirm_password" name="confirm_password" required><br>
      </div>
    </div>
    <label>Registrarsi come:</label><br>
    <input type="radio" id="simpatizzante" name="userRole" value="SIMPATIZZANTE" checked="checked" required>
    <label for="simpatizzante">Simpatizzante</label>
    <input type="radio" id="aderente" name="userRole" value="ADERENTE" required>
    <label for="aderente">Aderente</label><br>

    <input class="button" type="submit" value="Invia">
    <input class="button" type="reset" value="Reset">
  </form>

  <br><br><br><br>

  <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
</div>
</body>

<jsp:include page="Footer.jsp"></jsp:include>

</html>