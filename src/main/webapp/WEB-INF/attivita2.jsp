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
        <h1>Il Benessere a Portata di Mano</h1>

        <div class="row">
            <img src="materiale/attività2-seduta.jpg" class="text_img" alt="Immagine">
            <p>
                Attraverso la collaborazione con professionisti dedicati, vengono fornite sessioni di consulenza
                individuali e di gruppo, consentendo ai partecipanti di affrontare sfide emotive e mentali
                in un ambiente accogliente.<br>

                Le sessioni includono strategie di gestione dello stress, consulenza emotiva e sviluppo personale.
                L'iniziativa promuove attivamente la consapevolezza sulla salute mentale, abbattendo lo stigma
                associato alle difficoltà psicologiche. Con una combinazione di incontri in persona e risorse
                online accessibili, "Il Benessere a Portata di Mano" offre un prezioso supporto alla
                comunità, contribuendo a migliorare il benessere mentale e a costruire una rete di sostegno solida.
            </p>
            <img src="materiale/attività2-cartoon.jpg" class="text_img" alt="Immagine">
        </div>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
