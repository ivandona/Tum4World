<%--
  Created by IntelliJ IDEA.
  User: lucin
  Date: 24/08/2023
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World</title>
    <link rel="shortcut icon" type="image/png" href="materiale/logo.png">
    <link rel="stylesheet" type="text/css" href="styles/activities.css">
    <link rel="stylesheet" type="text/css" href="styles/format.css">

    <script src="scripts/admin-functions.js"></script>
</head>
<body>
<script>
    // chiama updatePageCounte appena la pagina si è caricata completamente
    document.addEventListener("DOMContentLoaded", function() {
        updatePageCounter("ATTIVITA2");
    });
</script>

    <jsp:include page="Header.jsp"></jsp:include>

    <div class="page">
        <h1>Terza attività</h1>

        <div class="row">
            <img src="materiale/mani.jpg" class="text_img" alt="Immagine">
            <p>
                testotestotestotestotestotestotestotesto testotestotestotestotestotestotestotesto
                testotestotestotestotestotestotestotestotestotestotestotestotestotestotestotesto
            </p>
            <img src="materiale/mani.jpg" class="text_img" alt="Immagine">
        </div>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
