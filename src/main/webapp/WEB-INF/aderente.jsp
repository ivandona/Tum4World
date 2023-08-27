<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>Tum4World</title>
        <link rel="stylesheet" href="styles/style.css">
        <link rel="stylesheet" type="text/css" href="styles/aderente.css">
        <script>const context = "${pageContext.request.contextPath}"</script>
        <script src="scripts/admin-functions.js"></script>
    </head>
    <body>
    <script>
        // chiama updatePageCounte appena la pagina si è caricata completamente
        document.addEventListener("DOMContentLoaded", function() {
            updatePageCounter("ADERENTE");
        });
    </script>
        <jsp:include page="Header-privato.jsp"></jsp:include>
    <div>
        <div class="container">
            <button class="button" id="datiBtn" onclick="showPersonalInfo(context, 'personal-info')">Informazioni personali</button>
            <button class="button" id="attivitaBtn">Mostra Attività</button>
            <button class="button" id="donazioneBtn">Donazione</button>
        </div>
        <div id="dati" class="hidden">
            <h3>I tuoi dati personali</h3>
            <div class="container">
                <ul id="personal-info"></ul>
            </div>
            <div class="container">
                <button class="button" id="deleteUserBtn">Elimina L'account</button>
            </div>
        </div>
        <div id="attivita" class="hidden">
            <form id="activities" action="${pageContext.request.contextPath}/activitiesServlet" method="post">
                <h3>Seleziona le attività a cui vuoi iscriverti</h3>
                <div class="container">
                    <div class="activity">
                        <p>Sangue Solidale</p>
                        <label for="activity_1">
                            <img src="materiale/attività1-donazione.png" height="200">
                            <input type="checkbox" id="activity_1" name="activity_1" value="true">
                        </label>
                    </div>

                    <div class="activity">
                        <p>Il Benessere a Portata di Mano</p>
                        <label for="activity_2">
                            <img src="materiale/attività2-seduta.jpg" height="200">
                            <input type="checkbox" id="activity_2" name="activity_2" value="true">
                        </label>
                    </div>

                    <div class="activity">
                        <p>Cuore Nutriente</p>
                        <label for="activity_3">
                            <img src="materiale/attività3-mensa.jpg" height="200">
                            <input type="checkbox" id="activity_3" name="activity_3" value="true">
                        </label>
                    </div>
                </div>
                <div class="container">
                    <input class="button" type="submit" value="Conferma">
                </div>
            </form>
        </div>
        <div id="donazione" class="hidden">
                <h3>Fai una donazione per sostenere le nostre attività</h3>
                <form action="${pageContext.request.contextPath}/donationServlet" method="post">
                    <div class="container">
                        <label for="importo">Importo:</label>
                        <input type="number" id="importo" name="importo" step="1" min="1" required>
                    </div>
                    <div class="container">
                        <input class="button" type="submit" value="Dona">
                    </div>
                </form>
        </div>
    </div>
        <script src="scripts/show-personal-info.js"></script>
        <script src="scripts/userpage.js"></script>
        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>
