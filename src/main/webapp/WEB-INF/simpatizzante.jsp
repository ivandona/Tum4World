<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/simpatizzante.css">
    <title>Tum4World</title>
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
    <h1>Simpatizzante</h1>
    <div>
        <button id="datiBtn" onclick="showPersonalInfo(context, 'personal-info')">Informazioni personali</button>
        <button id="attivitaBtn">Mostra Attività</button>
        <div id="dati" class="hidden">
            <ul id="personal-info"></ul>
            <button class="button" id="deleteUserBtn">Elimina L'account</button>
        </div>
        <div id="attivita" class="hidden">
            <h2>Attività Disponibili</h2>
            <form id="activities" action="${pageContext.request.contextPath}/activitiesServlet" method="post">
                <p>attività 1</p>
                <label>
                    <input type="checkbox" id="activity_1" name="activity_1" value="true">
                    <img src="materiale/mani.jpg" alt="Attività 1" width="210" height="140">
                </label><br>
                <p>Attività 2</p>
                <label>
                    <input type="checkbox" id="activity_2" name="activity_2" value="true">
                    <img src="materiale/mani.jpg" alt="Attività 2" width="210" height="140">
                </label><br>
                <p>Attività 3</p>
                <label>
                    <input type="checkbox" id="activity_3" name="activity_3" value="true">
                    <img src="materiale/mani.jpg" alt="Attività 3" width="210" height="140">
                </label><br>
                <input type="submit" value="Conferma">
            </form>
        </div>
    </div>
    <script src="scripts/show-personal-info.js"></script>
    <script src="scripts/simpatizzante.js"></script>

    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
