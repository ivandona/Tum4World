<%@ page contentType="text/html;charset=UTF-8"%>
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
