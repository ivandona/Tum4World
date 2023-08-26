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
    <title>Tum4World</title>
    <script>var context = "${pageContext.request.contextPath}"</script>
    <script src="scripts/show-personal-info.js"></script>
</head>
<body>
    <jsp:include page="Header-privato.jsp"></jsp:include>
    <h1>Simpatizzante</h1>
    <div>
        <button onclick="showPersonalInfo(context, 'personal-info')">Informazioni personali</button>
        <ul id="personal-info"></ul>
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
