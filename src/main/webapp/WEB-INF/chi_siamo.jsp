<%--
  Created by IntelliJ IDEA.
  User: lucin
  Date: 23/08/2023
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tum4World</title>
    <link rel="shortcut icon" type="image/png" href="materiale/logo.png">
    <link rel="stylesheet" type="text/css" href="styles/chi_siamo.css">
    <link rel="stylesheet" type="text/css" href="styles/format.css">

    <script src="scripts/admin-functions.js"></script>
</head>
<body>
<script>
    // chiama updatePageCounte appena la pagina si è caricata completamente
    document.addEventListener("DOMContentLoaded", function() {
        updatePageCounter("CHI_SIAMO");
    });
</script>

    <jsp:include page="Header.jsp"></jsp:include>

    <div class="storia">
        <h1>CHI SIAMO</h1>
        <p>
            Testo descrittivo dell'associazione aaaaaaaaaaaaaaaa aaaaaaa aaaaaaaaaaa aaaaaa aaaaa
            aaaa aaaaaaaaaaa aaaaaaaaa aaaaaaaaaaaaaa aaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaa aaaaaaaaaa
            aaaaa aaaaaaaa aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaa aaaaaaaaaaaaaa aaaaaaaaaaaaa
            aaaaa aaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaa aaaa
            aaaaaaaaaa aaaaaaaa aaaaaaa aaaaaaaaaaaaa aaaaaaaaa aaaaaaaa aaaaaaa aaaaaaaaa aaaaaaaaaa
            aaaaaaaaaaaaaaaaa aaaaa aaaaaaaaaa aaaaaaaaa aaaaaaaaa aaaaaaaaa aaaaaaa aa aaaa aaaaaaa
            aaa aaaaa aaaaaaaa aaaaaaaaaaa aaaaaaa aaaaaaa aaaaaaaaaa aaaaaaaaaaa  aaaaaaaa aaaaaaaaaaa
            aaa aaaaaaaaa aaaaaa aaaaaaaaaaa aaaaaaa aaaaa aaaaaaaaaa aaaaaaaaaaaaa  aaaaaaaaaaaaa aaaa
        </p>
        <div class="paragrafo">
            <h2>Quando è stata fondata Tum4World?</h2>
            <div class="risposta">
                <img src="materiale/mani.jpg" class="side_img" alt="Immagine">
                <p>
                    bbbbbbbbbbbbbbbbbbbbb bbbbbbbbbbb bbbbbbbbbb bbbbbbbbbbbb bbbbbbb bbbbbbb bbbbbbbb bbbbbbbbbbbbbbbb bbbbbbbbbbbbbbbbbbbbbbbbbb bbbbbbbbbbbb bbbbbbbbbbbbbbbbb bbbbbbbbbbbbb bbbbbbbbbbbbbbbbbb
                </p>
            </div>
        </div>
        <div class="paragrafo">
            <h2>Da chi è stata fondata?</h2>
            <div class="risposta">
                <p>
                    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
                </p>
                <img src="" class="side_img" alt="Immagine">
            </div>
        </div>
        <div class="paragrafo">
            <h2>Storia dell'associazione</h2>
            <div class="risposta">
                <p>
                    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
                </p>
                <img src="" class="side_img" alt="Immagine">
            </div>
        </div>
        <div class="paragrafo">
            <h2>Sedi</h2>
            <div class="risposta">
                <p>
                    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb bbbbbbbbbbbbbbbbbbbbbb
                </p>
                <img src="" class="side_img" alt="Immagine">
            </div>
        </div>
        <div class="paragrafo">
            <h2>Riconoscimenti ottenuti</h2>
            <div class="risposta">
                <p>
                    bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb bbbbbbbbbbbbbbbbbbbbbbbbbbbbb bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
                </p>
                <img src="" class="side_img" alt="Immagine">
            </div>
        </div>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
