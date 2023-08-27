<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Tum4World</title>
    <link rel="shortcut icon" type="image/png" href="materiale/logo.png">
    <link rel="stylesheet" href="styles/sign-in.css">
    <link rel="stylesheet" href="styles/format.css">
    <script src="scripts/form-validation.js"></script>
    <script src="scripts/admin-functions.js"></script>
</head>
<body>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            updatePageCounter("SIGN_IN");
        });
    </script>
    <jsp:include page="Header.jsp"></jsp:include>
    <div class="container">
        <h1>Registrazione</h1>
        <form onsubmit="return validateSignIn();" action="${pageContext.request.contextPath}/signInServlet" method="post">
            <div class="row">
                <div class="col">
                    <label class="etichetta" for="name">Nome:</label><br>
                    <input class="input" type="text" id="name" name="name" required><br>

                    <label class="etichetta for="surname">Cognome:</label><br>
                    <input class="input" type="text" id="surname" name="surname" required><br>

                    <label class="etichetta for="birthdate">Data di Nascita:</label><br>
                    <input class="input" type="date" id="birthdate" name="birthdate" required><br>

                    <label class="etichetta for="phoneNumber">Numero di Telefono:</label><br>
                    <input class="input" type="text" id="phoneNumber" name="phoneNumber" required><br>
                </div>
                <div class="col">
                    <label class="etichetta for="email">Indirizzo Email:</label><br>
                    <input class="input" type="email" id="email" name="email" required><br>

                    <label class="etichetta for="username">Username:</label><br>
                    <input class="input" type="text" id="username" name="username" required><br>

                    <label class="etichetta for="password">Password:</label><br>
                    <input class="input" type="password" id="password" name="password" required><br>

                    <label class="etichetta for="confirm_password">Conferma Password:</label><br>
                    <input class="input" type="password" id="confirm_password" name="confirm_password" required><br>
                </div>
            </div>
            <div class="row">
                <label>Registrarsi come:</label><br>
                <input type="radio" id="simpatizzante" name="userRole" value="SIMPATIZZANTE" checked="checked" required>
                <label for="simpatizzante">Simpatizzante</label>
                <input type="radio" id="aderente" name="userRole" value="ADERENTE" required>
                <label for="aderente">Aderente</label><br>
            </div>
            <div class="row">
                <input class="button" type="reset" value="Reset">
                <input class="button" type="submit" value="Invia">
            </div>
        </form>

        <br><br><br><br>
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>