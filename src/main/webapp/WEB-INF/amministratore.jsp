<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard with Dynamic Table</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .dashboard {
            display: flex;
            flex-wrap: wrap;
            margin-top: 20px;
        }

        .button {
            background-color: #3498db;
            color: #fff;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            flex-grow: 1;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
        }

        .button:hover {
            background-color: #2980b9;
        }

        .table-container {
            width: 100%;
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>

    <script src="scripts/admin-functions.js"></script>
</head>
<body>
<jsp:include page="Header-privato.jsp"></jsp:include>

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

<script>
    //robe che non riesco a spostare nel js (wtf??)
    const users = document.getElementById("users");
    const simpatizzanti = document.getElementById("simpatizzanti");
    const aderenti = document.getElementById("aderenti");
    const visits = document.getElementById("visits");
    const donations = document.getElementById("donations");
    const tableContainer = document.getElementById("tableContainer");
    const table = document.querySelector("table");

    users.addEventListener("click", showAllUsers);
    simpatizzanti.addEventListener("click", showAllSimpatizzanti);
    aderenti.addEventListener("click", showAllAderenti);
    visits.addEventListener("click", deleteTable);
    donations.addEventListener("click", deleteTable);
</script>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
