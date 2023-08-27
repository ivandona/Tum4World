<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Tum4World</title>
    <link rel="shortcut icon" type="image/png" href="materiale/logo.png">
    <link rel="stylesheet" type="text/css" href="styles/homepage_pubblica.css">
    <link rel="stylesheet" type="text/css" href="styles/format.css">

    <script src="scripts/admin-functions.js"></script>
</head>
<body>
<script>
    // chiama updatePageCounter appena la pagina si è caricata completamente
    document.addEventListener("DOMContentLoaded", function() {
        updatePageCounter("HOME");
    });
</script>
    <jsp:include page="Header.jsp"></jsp:include>

    <img src="materiale/home-labirinto.jpg" class="img_principale" alt="Labirinto parole">
    <div class="lower_container">
        <img src="materiale/logo.png" class="logo" alt="Logo">
        <p>
            Fondata con passione e impegno, Tum4World è un'organizzazione benefica dedicata a portare positivi
            cambiamenti in Italia. Dal 2001, abbiamo lavorato instancabilmente per affrontare le sfide interne del
            nostro amato paese. La nostra missione è volta al miglioramento delle condizioni di vita dei nostri
            concittadini più bisognosi attraverso programmi che coprono una vasta gamma di aree, dall'educazione alla
            salute e oltre. <br>

            In collaborazione con volontari appassionati e partner locali, Tum4World si impegna a migliorare
            l'accesso all'istruzione di qualità, fornire assistenza medica essenziale, promuovere lo sviluppo
            sostenibile, sensibilizzare su temi attuali quali la salute mentale e l'educazione di genere.
            Attraverso questi progetti ci sforziamo di costruire un futuro migliore per le prossime generazioni.<br>

            La nostra presenza è radicata nelle comunità che serviamo. Dalle zone rurali alle periferie urbane,
            Tum4World è presente per ascoltare, supportare e collaborare con coloro che hanno bisogno.
            Ogni bambino istruito, ogni persona curata e ogni impatto positivo che realizziamo sono mattoni nella
            strada verso un'Italia più giusta e inclusiva. <br>
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
