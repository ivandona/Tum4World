function redirectToAdminStuff(button_pressed) {
    var url = "http://localhost:8085/progetto_war_exploded/adminStuff?button_pressed=" +
        encodeURIComponent(button_pressed);
    fetch(url)
        .then(response => response.text())
        .then(data => {
            updateTableContent(data)
        })
        .catch(error => console.error("Errore 'redirectToAdminStuff':", error));
}

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

    // Nascondi la tabella esistente (se presente)
    tableContent.innerHTML = "";
}