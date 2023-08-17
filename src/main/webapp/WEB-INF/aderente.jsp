<%--
  Created by IntelliJ IDEA.
  User: eeve1
  Date: 07/08/2023
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/style.css">
    <title>Tum4World</title>
</head>
<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container">
        <h1>Dashboard del Simpatizzante</h1>
        <div class="dashboard">
            <div class="operation">
                <h2>Visualizza Dati Personali</h2>
                <button>Visualizza</button>
            </div>
            <div class="operation">
                <h2>Iscriviti alle Attività</h2>
                <img src="activity.jpg" alt="Attività" onclick="subscribeToActivity()">
                <div class="checkbox-label">
                    <input type="checkbox" id="subscribeCheckbox">
                    <label for="subscribeCheckbox">Iscriviti</label>
                </div>
            </div>
            <div class="operation">
                <h2>Cancella Iscrizione</h2>
                <button onclick="cancelSubscription()">Cancella Iscrizione</button>
            </div>
        </div>
    </div>
    <script>
        function subscribeToActivity() {
            const checkbox = document.getElementById('subscribeCheckbox');
            checkbox.checked = !checkbox.checked;
        }

        function cancelSubscription() {
            alert('Hai cancellato la tua iscrizione.');
        }
    </script>
</body>
</html>
