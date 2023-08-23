<%--
  Created by IntelliJ IDEA.
  User: eeve1
  Date: 23/08/2023
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World</title>
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>
    Contatti
</h1>
<form action="mailto:tum4world@nessunonoluogonoesiste.com">
    <label for="name_surname">Nome e Cognome: </label>
    <input type="text" id="name_surname" name="name_surname"><br>
    <label for="email">Indirizzo email: </label>
    <input type="text" id="email" name="email"><br>
    <label for="reason">Motivo di contatto:</label>
    <select id="reason" name="reason">
        <option value="activity_suggestion">Vorrei suggerire una nuova attività</option>
        <option value="bug_report">Segnalare un bug</option>
        <option value="other">Altro</option>
    </select><br>
    <textarea name="message" rows="10" cols="60"></textarea> <br>
    <input class="button" type="submit" value="Invia">
    <input class="button" type="reset" value="Reset">
</form>
</body>
</html>
