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
    // chiama updatePageCounte appena la pagina si è caricata completamente
    document.addEventListener("DOMContentLoaded", function() {
        updatePageCounter("ATTIVITA1");
    });
</script>
    <jsp:include page="Header.jsp"></jsp:include>

    <div class="page">
        <h1>Prima attività</h1>

        <div class="row">
            <img src="materiale/mani.jpg" class="text_img" alt="Immagine">
            <p>
                L'attività coinvolge la piantumazione di una vasta varietà di alberi autoctoni, adattati
                alle condizioni del suolo e del clima locale. Questa iniziativa non solo mira a migliorare l'ecosistema
                locale, ma anche a mitigare i cambiamenti climatici attraverso la cattura di carbonio e la creazione di microclimi più freschi.

                Il progetto coinvolge attivamente la comunità locale, organizzando giornate di piantumazione partecipativa,
                laboratori educativi sul valore delle foreste e sulla biodiversità, nonché la promozione di una maggiore consapevolezza ambientale.
                Con il tempo, ci si aspetta che l'area trasformata diventi un rifugio
                per la fauna locale, un luogo di ricreazione per i cittadini e un modello di successo per la rigenerazione ambientale.
            </p>
            <img src="materiale/mani.jpg" class="text_img" alt="Immagine">
        </div>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
