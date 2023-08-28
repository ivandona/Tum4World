<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Tum4World</title>
    <link rel="shortcut icon" type="image/png" href="materiale/logo.png">
    <link rel="stylesheet" type="text/css" href="styles/amministratore.css">
    <link rel="stylesheet" type="text/css" href="styles/format.css">

    <script src="Libraries/highcharts.src.js"></script>
    <script src="Libraries/highcharts.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="scripts/admin-functions.js"></script>
</head>
<body>
    <jsp:include page="Header-privato.jsp"></jsp:include>

    <div class="pagina">
        <h1>Amministratore</h1>

        <div class="dashboard">
            <button class="button" id="users">Mostra utenti</button>
            <button class="button" id="simpatizzanti">Mostra simpatizzanti</button>
            <button class="button" id="aderenti">Mostra aderenti</button>
            <button class="button" id="visits">Mostra visite</button>
            <button class="button" id="donations">Mostra donazioni</button>
        </div>

        <div class="table-container" id="tableContainer" style="display: none;">
            <div id="tableContent"></div>
        </div>
        <div class="graph_container" id="graphContainer" style="display: none;">
            <div id="graphContent"></div>
        </div>
    </div>


<script>
    var resetButtonAdded = false;
    const servletButton = document.createElement("button");
    const users = document.getElementById("users");
    const simpatizzanti = document.getElementById("simpatizzanti");
    const aderenti = document.getElementById("aderenti");
    const visits = document.getElementById("visits");
    const donations = document.getElementById("donations");
    const tableContainer = document.getElementById("tableContainer");
    const table = document.querySelector("table");

    users.addEventListener("click", function() {
        removeResetButton();
        redirectToAdminFunctions("users");
    });
    simpatizzanti.addEventListener("click", function() {
        removeResetButton();
        redirectToAdminFunctions("simpatizzanti");
    });
    aderenti.addEventListener("click", function() {
        removeResetButton();
        redirectToAdminFunctions("aderenti");
    });
    visits.addEventListener("click", function() {
        redirectToAdminFunctionsGraph("visits");
        resetButtonCreation();
    });
    donations.addEventListener("click", function() {
        removeResetButton();
        redirectToAdminFunctionsGraph("donations");
    });
</script>

    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
