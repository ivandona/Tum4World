function redirectToAdminStuff(button_pressed) {
    var url = "http://localhost:8080/progetto_war_exploded/adminStuff?button_pressed="+encodeURIComponent(button_pressed);
    fetch(url)
        .then(response => response.text())
        .then(data => {
            updateTableContent(data)
        })
        .catch(error => console.error("Errore:", error));
}

function redirectToAdminStuffGraph(button_pressed) {
    var url = "http://localhost:8080/Tum4World_war_exploded/adminStuff?button_pressed="+encodeURIComponent(button_pressed);
    fetch(url)
        .then(response => response.json())
        .then(dati => {
            var categorie;
            var testo;
            var colonne;
            if (button_pressed === "Donazioni") {
                colonne = "Mesi";
                testo = "Totale donazioni in euro";
                categorie = ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre'];
            } else {
                colonne = "";
                testo = "";
                categorie = [];
            }
            deleteTable();
            var graphContainer = document.getElementById("graphContainer");
            var graphContent = document.getElementById("graphContent");

            Highcharts.chart(graphContent, {
                chart: {
                    type: 'column'
                },
                title: {
                    text: button_pressed
                },
                xAxis: {
                    categories: categorie
                },
                yAxis: {
                    title: {
                        text: testo
                    }
                },
                colors: ['black'], // Colori personalizzati
                series: [{
                    name: colonne,
                    data: dati
                }]
            });

            graphContainer.style.display = "block";
        })
        .catch(error => console.error('Errore nella richiesta fetch:', error));
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