<%@ page contentType="text/html;charset=UTF-8"%>
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
        // chiama updatePageCounter appena la pagina si è caricata completamente
        document.addEventListener("DOMContentLoaded", function() {
            updatePageCounter("ATTIVITA");
        });
    </script>

    <div class="page">
        <h1>Riepilogo attività</h1>

        <div class="row">
            <div class="column">
                <h1>Sangue Solidale</h1>

                <a href="${pageContext.request.contextPath}/publicPageController?page=attivita1">
                    <img src="materiale/attività-sangue.png" class="activity_img" alt="Sangue">
                </a>

                <p>
                    "Sangue Solidale" è un progetto di donazione del sangue che mira a creare un impatto tangibile
                    nelle vite delle persone. Attraverso eventi di consapevolezza, campagne di informazione e
                    sessioni di donazione, puntiamo a coinvolgere la comunità nella preziosa causa della donazione del
                    sangue.
                </p>
            </div>

            <div class="column">
                <h1>Il Benessere a Portata di Mano</h1>

                <a href="${pageContext.request.contextPath}/publicPageController?page=attivita2">
                    <img src="materiale/attività-psicologo.jpg" class="activity_img" alt="Psicologo">
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
                    <img src="materiale/attività-cucina.jpg" class="activity_img" alt="Cucina">
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
