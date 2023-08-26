<%--
  Created by IntelliJ IDEA.
  User: eeve1
  Date: 07/08/2023
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/simpatizzante.css">
    <title>Tum4World</title>
</head>
<body>
    <jsp:include page="Header-privato.jsp"></jsp:include>
    <h1>Simpatizzante</h1>
    <div>
        <button id="datiBtn" onclick="showPersonalInfo(context, 'personal-info')">Informazioni personali</button>
        <button id="attivitaBtn">Mostra Attività</button>

        <ul  id="personal-info"></ul>

        <div id="attivita" class="hidden">
            <h2>Attività Disponibili</h2>
            <form id="activities" action="${pageContext.request.contextPath}/activitiesServlet" method="post">
                <p>attività 1</p>
                <label>
                    <input type="checkbox" id="activity_1" name="activity_1" value="true">
                    <img src="materiale/mani.jpg" alt="Attività 1" width="210" height="140">
                </label><br>
                <p>attività 2</p>
                <label>
                    <input type="checkbox" id="activity_2" name="activity_2" value="true">
                    <img src="materiale/mani.jpg" alt="Attività 2" width="210" height="140">
                </label><br>
                <p>attività 3</p>
                <label>
                    <input type="checkbox" id="activity_3" name="activity_3" value="true">
                    <img src="materiale/mani.jpg" alt="Attività 3" width="210" height="140">
                </label><br>
                <input type="submit" value="Conferma">
            </form>
        </div>
    </div>
    <script>
        const context = "${pageContext.request.contextPath}";
    </script>
    <script src="scripts/show-personal-info.js"></script>
    <script src="scripts/simpatizzante.js"></script>

    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
