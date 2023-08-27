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
    // chiama updatePageCounter appena la pagina si è caricata completamente
    document.addEventListener("DOMContentLoaded", function() {
        updatePageCounter("ATTIVITA3");
    });
</script>

    <jsp:include page="Header.jsp"></jsp:include>

    <div class="page">
        <h1>Cuore Nutriente</h1>

        <div class="row">
            <img src="materiale/attività3-mani.jpg" class="text_img" alt="Immagine">
            <p>
                I volontari di "Cuore Nutriente" preparano con cura pasti equilibrati e variegati, tenendo conto
                delle esigenze dietetiche individuali. La consegna avviene in modo rispettoso e discreto, garantendo la
                dignità dei destinatari. L'iniziativa non si limita solo a nutrire i corpi, ma anche a nutrire l'animo,
                poiché il calore umano e l'empatia dimostrati dai volontari offrono un supporto emotivo significativo.<br>

                Attraverso il suo impegno a creare un impatto positivo nella vita di coloro che lottano per
                soddisfare le necessità fondamentali, "Cuore Nutriente" agisce come una luce di speranza nella comunità,
                dimostrando che un atto di gentilezza può avere un effetto duraturo.
            </p>
            <img src="materiale/attività3-mensa.jpg" class="text_img" alt="Immagine">
        </div>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
