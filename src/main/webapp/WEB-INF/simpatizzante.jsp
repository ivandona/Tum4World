<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>Tum4World</title>
        <link rel="shortcut icon" type="image/png" href="materiale/logo.png">
        <link rel="stylesheet" type="text/css" href="styles/simpatizzante.css">
        <script>const context = "${pageContext.request.contextPath}";</script>
        <script src="scripts/admin-functions.js"></script>
    </head>
    <body>
    <script>
        // chiama updatePageCounter appena la pagina si è caricata completamente
        document.addEventListener("DOMContentLoaded", function() {
            updatePageCounter("SIMPATIZZANTE");
        });
    </script>

    <jsp:include page="Header-privato.jsp"></jsp:include>
    <div>
        <div class="container">
            <button class="button" id="datiBtn" onclick="showPersonalInfo(context, 'personal-info')">Informazioni personali</button>
            <button class="button" id="attivitaBtn">Mostra Attività</button>
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
    </div>
    <script src="scripts/show-personal-info.js"></script>
    <script src="scripts/userpage.js"></script>

    <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>

