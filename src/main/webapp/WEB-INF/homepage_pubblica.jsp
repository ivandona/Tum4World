<%--
  Created by IntelliJ IDEA.
  User: lucin
  Date: 23/08/2023
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World</title>
    <link rel="stylesheet" type="text/css" href="styles/homepage_pubblica.css">
    <link rel="stylesheet" type="text/css" href="styles/format.css">
</head>
<body>
    <jsp:include page="Header.jsp"></jsp:include>

    <img src="materiale/mani.jpg" class="img_principale" alt="Immagine">
    <div class="lower_container">
        <img src="materiale/logo.png" class="logo" alt="Logo">
        <p>
            Testo descrittivo dell'associazione aaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaa
            aaaaaa aaaaaaaaaaaaa aaaaaaaaaaa aaaaaaaaa aaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaa aaaaaaaaa
            aaaaaaaaaa aa aaaaaaaaaaaaa aaaaaaaaaaaaa aaaaaaaaaaa aaaaaaa aaaaaaaaaaa aaaaaaa aaaaaaa
            aaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaa aaaaaaaaaaa aaaaaaaaaaaa
            aaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaa aaaaaaaaaaa aaaaaaaa aaaaaaaaaaaa aaaaaa aaaaaaaa
            aaaaaaa aaaaaaa aaaaaaa aaaaaaaaaaaaa aaaaaaaaaa  aaaaaaaaaaaa aaaaaaaaaaa aaaaaaaa aaaaaa
            aaaaaaa aaaaaaaaaaaa aaaaaaaaa aaaaaaaaa aaaa aaaaaaaaaaa aaaaaaaaa aaaaaa aaaaaaaa aaaaaa
            aaaa aaaaaaaaaaaa aaaaa aaaaaaaaaaa aaaaaaaa aaaaaaaaaaaaaaa  aaaaaaaa aaaaaaaaaaa aaaaaaa
        </p>
    </div>
    <div class="download_btn">
        <a href="materiale/Tum4World.pdf" download="Tum4World_pamplet.pdf">
            <button>Download Pamplet</button>
        </a>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
