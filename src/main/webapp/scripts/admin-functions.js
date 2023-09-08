function redirectToAdminFunctions(button_pressed) {
    var url = "adminFunctions?button_pressed="+encodeURIComponent(button_pressed);
    fetch(url)
        .then(response => response.text())
        .then(data => {
            updateTableContent(data)
        })
        .catch(error => console.error("Errore nella funzione 'redirectToAdminFunctions':", error));
}

/**
 * Funzione utilizzata per impostare a 0 tutte le visite al sito e aggiornare il grafico con i nuovi dati
 */
function resetVisits() {
    const data = new URLSearchParams();
    data.append("page_name", "set_to_0");
    data.append("timestamp", new Date().getTime()); // Aggiungo un timestamp casuale per evitare la memorizzazione nella cache
    fetch("adminFunctions", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: data
    })
        .then(response => {
            // Aggiorno il grafico
            redirectToAdminFunctionsGraph("visits");
        })
        .catch(error => console.error("Errore nella funzione 'resetVisits':", error));
}

/**
 * Funzione utilizzata per creare i due grafici nella pagina amministratore
 * @param button_pressed fa in modo che, a seconda del pulsante premuto, venga visualizzato o il grafico delle donazioni
 *          o il grafico delle visite
 */
function redirectToAdminFunctionsGraph(button_pressed) {
    var url = "adminFunctions?button_pressed="+encodeURIComponent(button_pressed);
    fetch(url)
        .then(response => response.json())
        .then(graphData => {
            var graphCategories, graphtext, graphColumns, graphTitle;
            if (button_pressed === "donations") {
                graphTitle = "Donazioni"
                graphColumns = "Mesi";
                graphtext = "Totale donazioni in euro";
                graphCategories = ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto',
                    'Settembre', 'Ottobre', 'Novembre', 'Dicembre'];
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
                colors: ['#8B0000'],
                series: [{
                    name: graphColumns,
                    data: graphData
                }]
            });
            graphContainer.style.display = "block";
        })
        .catch(error => console.error("Errore nella funzione 'redirectToAdminFunctionsGraph':", error));
}

/**
 * Funzione utilizzata per aumentare il conteggio delle visite di una determinata pagina nel database
 * @param page_name passa il nome della pagina
 */
function updatePageCounter(page_name) {
    const data = new URLSearchParams();
    data.append("page_name", page_name);
    data.append("timestamp", new Date().getTime()); // Aggiungo un timestamp casuale per evitare la memorizzazione nella cache
    fetch("adminFunctions", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: data
    });
}

/**
 * Funzione utilizzata nei primi tre pulsanti: consente di eliminare la tabella o il grafico già esistenti (se presenti)
 * e di mostrare a schermo i dati raccolti
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
 * Funzione utilizzata per eliminare la tabella o il grafico (se già presenti) una volta che viene premuto un pulsante
 */
function deleteTable() {
    var tableContent = document.getElementById("tableContent");
    var graphContainer = document.getElementById("graphContainer");

    graphContainer.style.display = "none";
    tableContent.innerHTML = "";
}

/**
 * Funzione utilizzata per creare un pulsante che resetta le visite alla pagina
 */
function resetButtonCreation() {
    if (!resetButtonAdded) {
        servletButton.className = "button";
        servletButton.textContent = "Reset delle visite";
        servletButton.addEventListener("click", function() {
            resetVisits();
        });

        // Aggiungo il bottone alla pagina
        tableContainer.appendChild(servletButton);
        tableContainer.style.display = "block";
        resetButtonAdded = true;
    }
}

/**
 * Funzione utilizzata per rimuover il pulsante "Reset delle viiste" ogni volta che si clicca su un altro pulsante
 * (eccetto "mostra visite")
 */
function removeResetButton() {
    if (resetButtonAdded) {
        servletButton.remove();
        resetButtonAdded = false;
    }
}