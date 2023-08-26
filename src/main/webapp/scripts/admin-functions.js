function redirectToAdminStuff(button_pressed) {
    var url = "http://localhost:8085/progetto_war_exploded/adminStuff?button_pressed="+encodeURIComponent(button_pressed);
    fetch(url)
        .then(response => response.text())
        .then(data => {
            updateTableContent(data)
        })
        .catch(error => console.error("Errore 'redirectToAdminStuff':", error));
}

/**
 * Funzione utilizzata per impostare a 0 tutte le visite al sito
 */
function resetVisits() {
    const data = new URLSearchParams();
    data.append("page_name", "set_to_0");
    data.append("timestamp", new Date().getTime()); // Aggiungo un timestamp casuale per evitare la memorizzazione nella cache
    fetch("http://localhost:8085/progetto_war_exploded/adminStuff", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: data
    })
        .then(response => {
            // Gestisci la risposta qui, se necessario
        })
        .catch(error => console.error("Errore 'updatePageCounter':", error));
}


function redirectToAdminStuffGraph(button_pressed) {
    var url = "http://localhost:8085/progetto_war_exploded/adminStuff?button_pressed="+encodeURIComponent(button_pressed);
    fetch(url)
        .then(response => response.json())
        .then(graphData => {
            var graphCategories, graphtext, graphColumns, graphTitle;
            if (button_pressed === "donations") {
                graphTitle = "Donazioni"
                graphColumns = "Mesi";
                graphtext = "Totale donazioni in euro";
                graphCategories = ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre'];
            } else {
                graphTitle = "Visite"
                graphColumns = "Visite";
                graphtext = "Totale visite per pagina";
                graphCategories = ['Totale', 'Home', 'Chi siamo', 'Attività', 'Attività 1', 'Attività 2', 'Attività 3',
                    'Contatti', 'Sign in', 'Login', 'Simpatizzante', 'Aderente'];
            }
            deleteTable();
            var graphContainer = document.getElementById("graphContainer");
            var graphContent = document.getElementById("graphContent");

            Highcharts.chart(graphContent, {
                chart: {
                    type: 'column'
                },
                title: {
                    text: graphTitle
                },
                xAxis: {
                    categories: graphCategories
                },
                yAxis: {
                    title: {
                        text: graphtext
                    }
                },
                colors: ['black'], // Colori personalizzati
                series: [{
                    name: graphColumns,
                    data: graphData
                }]
            });

            graphContainer.style.display = "block";
        })
        .catch(error => console.error('Errore nella richiesta fetch:', error));
}

/**
 * Funzione utilizzata per aumentare il conteggio delle visite di una determinata pagina nel database
 * @param page_name passa il nome della pagina
 */
function updatePageCounter(page_name) {
    const data = new URLSearchParams();
    data.append("page_name", page_name);
    data.append("timestamp", new Date().getTime()); // Aggiungo un timestamp casuale per evitare la memorizzazione nella cache
    fetch("http://localhost:8085/progetto_war_exploded/adminStuff", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: data
    })
        .then(response => {
            // Gestisci la risposta qui, se necessario
        })
        .catch(error => console.error("Errore 'updatePageCounter':", error));
}


/**
 * Funzione utilizzata nei primi tre pulsanti: consente di eliminare la tabelle già esistente (se presente) e di mostrare
 * a schermo i dati raccolti
 * @param content sono i dati della tabella che verranno mostrati a schermo
 */
function updateTableContent(content) {
    var tableContainer = document.getElementById("tableContainer");
    var tableContent = document.getElementById("tableContent");

    deleteTable();

    // Aggiorna il contenuto della tabella
    tableContent.innerHTML = content;
    tableContainer.style.display = "block";
}

/**
 * Funzione utilizzata per eliminare la tabella (se già presente)
 */
function deleteTable() {
    var tableContent = document.getElementById("tableContent");
    var graphContainer = document.getElementById("graphContainer");
    graphContainer.style.display = "none";
    // Nascondi la tabella esistente (se presente)
    tableContent.innerHTML = "";
}