<%--
  Created by IntelliJ IDEA.
  User: eeve1
  Date: 21/08/2023
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign-in</title>

  <link rel="stylesheet" href="styles/sign-in.css">
</head>
<body>
<div class="container">
  <h1>Registrazione</h1>
  <form action="${pageContext.request.contextPath}/signInServlet" method="post">
    <div class="row">
      <div class="col">
        <label for="nome">Nome:</label><br>
        <input type="text" id="nome" name="name" required><br>

        <label for="cognome">Cognome:</label><br>
        <input type="text" id="cognome" name="surname" required><br>

        <label for="data_nascita">Data di Nascita:</label><br>
        <input type="text" id="data_nascita" name="birthdate" required><br>

        <label for="telefono">Numero di Telefono:</label><br>
        <input type="text" id="telefono" name="phoneNumber" required><br>
      </div>
      <div class="col">
        <label for="email">Indirizzo Email:</label><br>
        <input type="email" id="email" name="email" required><br>

        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br>

        <!--<label for="conferma_password">Conferma Password:</label><br>
        <input type="password" id="conferma_password" name="password" required><br>-->
      </div>
    </div>
    <label>Registrarsi come:</label>
    <input type="radio" id="simpatizzante" name="userRole" value="SIMPATIZZANTE" checked="checked" required>
    <label for="simpatizzante">Simpatizzante</label>
    <input type="radio" id="aderente" name="userRole" value="ADERENTE" required>
    <label for="aderente">Aderente</label><br>

    <input class="button" type="submit" value="Invia">
    <input class="button" type="reset" value="Reset">
  </form>
</div>
</body>
</html>