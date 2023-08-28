<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Tum4World</title>
    <link rel="shortcut icon" type="image/png" href="materiale/logo.png">
    <link rel="stylesheet" href="styles/contatti.css">
    <link rel="stylesheet" href="styles/format.css">
    <script src="scripts/form-validation.js"></script>
    <script src="scripts/admin-functions.js"></script>
</head>
<body>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            updatePageCounter("CONTATTI");
        });
    </script>
    <jsp:include page="Header.jsp"></jsp:include>

    <div class="pagina">
        <h1>Contatti</h1>
        <div class="contact-info">
            <p>Email: tum4world@nessunonoluogonoesiste.com</p>
            <p>Telefono: +39 1234567890</p>
        </div>
        <div class="contact-form">
            <form onsubmit="return validateContactsForm();" action="${pageContext.request.contextPath}/sendEmailServlet"
                  method="post">
                <label class="etichetta" for="name_surname">Nome e Cognome: </label>
                <input type="text" id="name_surname" name="name_surname" required><br>
                <label class="etichetta" for="email">Indirizzo email: </label>
                <input type="text" id="email" name="email" required><br>
                <label class="etichetta" for="reason">Motivo di contatto:</label>
                <select class="menu" id="reason" name="reason" required>
                    <option value="Suggerimento attività">Vorrei suggerire una nuova attività</option>
                    <option value="Report bug">Segnalare un bug</option>
                    <option value="Altro">Altro</option>
                </select><br>
                <textarea name="message" rows="10" cols="60" required></textarea> <br>
                <div class="tasti">
                    <input class="button" type="reset" value="Reset">
                    <input class="button" type="submit" value="Invia">
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
