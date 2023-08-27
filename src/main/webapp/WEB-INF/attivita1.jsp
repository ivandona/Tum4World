<%--
  Created by IntelliJ IDEA.
  User: lucin
  Date: 24/08/2023
  Time: 17:08
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
    // chiama updatePageCounter appena la pagina si è caricata completamente
    document.addEventListener("DOMContentLoaded", function() {
        updatePageCounter("ATTIVITA1");
    });
</script>
    <jsp:include page="Header.jsp"></jsp:include>

    <div class="page">
        <h1>Sangue Solidale</h1>

        <div class="row">
            <img src="materiale/attività1-sangue.jpg" class="text_img" alt="Sangue">
            <p>
                "Sangue Solidale" è un ambizioso progetto che mira a creare un impatto reale attraverso la donazione
                del sangue. Con passione e determinazione, vogliamo diffondere la consapevolezza sull'importanza
                cruciale di questa azione.<br>
                Organizziamo eventi informativi, sessioni di donazione e attività di coinvolgimento per educare
                e mobilitare la comunità. Vogliamo sfatare miti e paure, trasformando la donazione del sangue
                in un gesto naturale di solidarietà. Ogni donatore è un eroe anonimo che dona speranza a
                chi affronta malattie gravi o interventi chirurgici cruciali.<br>
                Con "Sangue Solidale" vogliamo superare sfide e raggiungere obiettivi ambiziosi, costruendo una catena
                di solidarietà che salva vite umane. Ogni goccia di sangue donata è un passo avanti
                verso un futuro più luminoso. Unisciti a noi in questa missione,
                poiché ogni gesto conta e insieme possiamo fare la differenza, una goccia alla volta.
            </p>
            <img src="materiale/attività1-donazione.png" class="text_img" alt="Donazione sangue">
        </div>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
