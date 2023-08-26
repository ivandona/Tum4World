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
    <title>Tum4World</title>
    <link rel="stylesheet" href="styles/style.css">
    <script>var context = "${pageContext.request.contextPath}"</script>
    <script src="scripts/show-personal-info.js"></script>
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
    <div class="container">
        <button onclick="showPersonalInfo(context, 'personal-info')">Informazioni personali</button>
        <ul id="personal-info"></ul>
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
