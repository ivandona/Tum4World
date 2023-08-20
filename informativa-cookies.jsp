<%--
  Created by IntelliJ IDEA.
  User: lucin
  Date: 20/08/2023
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles/informativa-cookies.css">
    </head>
    <body>
        <div class="cookiesinfo_popup" id="popup">
            <div class="content_popup">
                <h2>Informativa sui Cookies</h2>
                <p>Utilizziamo i cookie sul nostro sito Web per offrirti l'esperienza più pertinente ricordando le tue preferenze e le visite ripetute.
                <br>Cliccando su “Accetta” acconsenti all'uso di TUTTI i cookie. Puoi rifiutare TUTTI i cookie cliccando su "Rifiuta".
                </p>
                <button class="tasto" id="accetta">Accetta</button>
                <button class="tasto" id="rifiuta">Rifiuta</button>
            </div>
        </div>

        <script src="scripts/informativa-cookies.js"></script>
    </body>
</html>