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
    // chiama updatePageCounter appena la pagina si è caricata completamente
    document.addEventListener("DOMContentLoaded", function() {
        updatePageCounter("CHI_SIAMO"   );
    });
</script>

    <jsp:include page="Header.jsp"></jsp:include>

    <div class="storia">
        <h1>Chi siamo</h1>
        <p>
            Fondata con passione e impegno, Tum4World è un'organizzazione benefica dedicata a portare positivi
            cambiamenti in Italia. Dal 2001, abbiamo lavorato instancabilmente per affrontare le sfide interne del
            nostro amato paese. La nostra missione è volta al miglioramento delle condizioni di vita dei nostri
            concittadini più bisognosi attraverso programmi che coprono una vasta gamma di aree, dall'educazione alla
            salute e oltre.<br>

            In collaborazione con volontari appassionati e partner locali, Tum4World si impegna a migliorare
            l'accesso all'istruzione di qualità, fornire assistenza medica essenziale, promuovere lo sviluppo
            sostenibile, sensibilizzare su temi attuali quali la salute mentale e l'educazione di genere.
            Attraverso questi progetti ci sforziamo di costruire un futuro migliore per le prossime generazioni.<br>

            La nostra presenza è radicata nelle comunità che serviamo. Dalle zone rurali alle periferie urbane,
            Tum4World è presente per ascoltare, supportare e collaborare con coloro che hanno bisogno.
            Ogni bambino istruito, ogni persona curata e ogni impatto positivo che realizziamo sono mattoni nella
            strada verso un'Italia più giusta e inclusiva. <br>
        </p>
        <div class="paragrafo">
            <h2>Da chi è stata fondata?</h2>
            <div class="risposta">
                <p>
                    L'organizzazione è stata fondata da Giuliano Mario Bonomi Todeschini: filantropo e luminare.
                    Guidato dalla visione di creare un luogo in cui nessuno debba soffrire a causa della povertà, delle
                    disuguaglianze o delle catastrofi naturali, Giuliano decise di fondare questa associazione per
                    conseguire questi obiettivi.<br>

                    La sua passione e la sua  dedizione sono seconde solo all'energia che impiega per inseguire il
                    suo sogno: creare un mondo privo di qualsiasi ingiustizia. "L'Italia è solo il primo passo"
                    dice Giuliano in un'intervista "presto la nostra associazione sarà conosciuta come un faro
                    di speranza non solo per i nostri compatrioti, ma per l'intera umanità!".
                </p>
                <img src="materiale/chi_siamo-fondatore.jpg" class="side_img" alt="Fondatore">
            </div>
        </div>
        <div class="paragrafo">
            <h2>Storia dell'associazione</h2>
            <div class="risposta">
                <p>
                    All'inizio, Tum4World si concentrava principalmente sull'aiuto in situazioni di emergenza,
                    fornendo cibo, acqua, rifugio e cure mediche nelle aree colpite da disastri naturali.<br>

                    Nel corso degli anni, l'organizzazione ha ampliato la propria portata, avviando progetti a
                    lungo termine per affrontare le radici strutturali della povertà. Abbiamo lavorato fianco a fianco
                    con le comunità locali per migliorare l'istruzione, la sanità e lo sviluppo economico sostenibile.<br>
                </p>
                <img src="materiale/chi_siamo-scritte.png" class="side_img" alt="Parole">
            </div>
        </div>
        <div class="paragrafo">
            <h2>Sedi</h2>
            <div class="risposta">
                <p>
                    Le principali sedi di Tum4World si trovano nelle seguenti città:<br><br>

                    -Trento, Trentino Alto Adige: Qui è situata la sede centrale dell'organizzazione, dove si
                    pianificano strategie e si coordinano i progetti in tutta Italia.<br><br>

                    -Roma, Lazio: Questi uffici regionali sono responsabili della gestione e dell'attuazione
                    dei progetti in collaborazione con i vari Ministeri della Repubblica Italiana.<br><br>

                    -Milano, Lombardia: Questi uffici sono situati nel cuore commerciale del nostro Paese. I nostri
                    dipendenti e affiliati qui si concentrano sul raccogliere fondi per indire progetti di
                    sensibilizzazione e cooperazione con partner locali e internazionali per sostenere
                    le iniziative umanitarie.<br><br>

                    -Bologna, Emilia-Romagna: In questa città, rinomata per il suo ateneo e la sua vitalità,
                    i nostri dipendenti si occupano di creare progetti con l'università il cui fulcro
                    principale è rappresentato proprio dai giovani, futuro della nostra nazione.<br>
                </p>
                <img src="materiale/chi_siamo-grattacielo.jpg" class="side_img" alt="Grattacielo">
            </div>
        </div>
        <div class="paragrafo">
            <h2>Riconoscimenti ottenuti</h2>
            <div class="risposta">
                <p>
                    Negli anni, Tum4World ha ricevuto numerosi riconoscimenti per il suo impegno e il suo impatto:<br><br>

                    -Premio Umanitario Nazionale: Conferitoci direttamente dal nostro presidente della Repubblica
                    per il nostro contributo eccezionale nel fornire assistenza umanitaria dopo il terremoto che
                    colpì l'Aquila nel 2009.<br><br>

                    -Premio Sviluppo Sostenibile: Concesso da un'agenzia governativa per i risultati significativi
                    ottenuti nell'ideazione e nella creazione di un villagio in mezzo ai boschi del Trentino completamente
                    autosostenibile e ad impatto zero.<br>
                </p>
                <img src="materiale/chi_siamo-trofeo.jpg" class="side_img" alt="Trofeo">
            </div>
        </div>
    </div>

    <jsp:include page="informativa-cookies.jsp"></jsp:include>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
