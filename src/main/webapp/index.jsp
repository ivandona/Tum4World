<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles/style.css">
    <title>Tum4World</title>
</head>
<body>
    <script src="${pageContext.request.contextPath}/scripts/info-cookie.js">
        document.addEventListener("DOMContentLoaded", openCookieWindow);
    </script>
    <jsp:include page="/WEB-INF/home.jsp"></jsp:include>
</body>
</html>