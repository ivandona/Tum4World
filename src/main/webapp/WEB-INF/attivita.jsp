<%--
  Created by IntelliJ IDEA.
  User: lucin
  Date: 23/08/2023
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World</title>
    <link rel="shortcut icon" type="image/png" href="materiale/logo.png">
    <link rel="stylesheet" type="text/css" href="styles/attivita.css">
    <link rel="stylesheet" type="text/css" href="styles/format.css">

    <script src="scripts/admin-functions.js"></script>
</head>
<body>
    <jsp:include page="Header.jsp"></jsp:include>

    <script>
        // chiama updatePageCounte appena la pagina si è caricata completamente
        document.addEventListener("DOMContentLoaded", function() {
            updatePageCounter("ATTIVITA");
        });
    </script>

    <div class="page">
        <h1>Riepilogo attività</h1>

        <div class="row">
            <div class="column">
                <h1>Progetto Verde Catanzaro</h1>

                <a href="${pageContext.request.contextPath}/publicPageController?page=attivita1">
                    <img src="materiale/attività-foresta.jpg" class="activity_img" alt="Immagine">
                </a>

                <p>"Progetto Verde Catanzaro" è un'iniziativa ambiziosa volta a trasformare un'area della provincia
                    di Catanzaro in una lussureggiante foresta. Attraverso una collaborazione tra comunità locali,
                    organizzazioni  ambientaliste e autorità locali, l'obiettivo è rigenerare un terreno
                    precedentemente degradato in un'eco-oasi rigogliosa.
                </p>
            </div>

            <div class="column">
                <h1>Il Benessere a Portata di Mano</h1>

                <a href="${pageContext.request.contextPath}/publicPageController?page=attivita2">
                    <img src="materiale/attività-psicologo.jpg" class="activity_img" alt="Immagine">
                </a>

                <p>"Il Benessere a Portata di Mano" è un'iniziativa preziosa che offre l'accesso a servizi
                    psicologici gratuiti per coloro che ne hanno bisogno. L'attività mira a rimuovere le
                    barriere finanziarie e sociali che spesso impediscono alle persone di accedere a supporto psicologico
                    di qualità.
                </p>
            </div>

            <div class="column">
                <h1>Cuore Nutriente</h1>

                <a href="${pageContext.request.contextPath}/publicPageController?page=attivita3">
                    <img src="materiale/attività-cucina.jpg" class="activity_img" alt="Immagine">
                </a>

                <p>
                    "Cuore Nutriente" è un'iniziativa altruista che mira a portare sollievo alle persone in situazioni
                    di difficoltà economica, offrendo servizi di consegna di cibo ai bisognosi. Attraverso una rete
                    di volontari dedicati e donazioni generose dalla comunità, l'attività si impegna a fornire pasti
                    nutrienti e sostentamento a coloro che lottano per avere abbastanza cibo sulla loro tavola.
                </p>
            </div>
        </div>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
