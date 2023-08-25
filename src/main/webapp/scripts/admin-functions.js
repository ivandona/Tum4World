function showAllUsers() {
    // Effettua una richiesta AJAX alla servlet per ottenere i dati della tabella
    // role=all fa capire alla servlet di stampare tutti gli utenti registrati
    fetch("http://localhost:8085/progetto_war_exploded/adminStuff?role=all")
        .then(response => response.text())
        .then(data => {
            updateTableContent(data)
        })
        .catch(error => console.error("Errore:", error));
}

function showAllSimpatizzanti() {
    // Effettua una richiesta AJAX alla servlet per ottenere i dati della tabella
    // role=all fa capire alla servlet di stampare tutti i simpatizzanti registrati
    fetch("http://localhost:8085/progetto_war_exploded/adminStuff?role=simpatizzante")
        .then(response => response.text())
        .then(data => {
            updateTableContent(data)
        })
        .catch(error => console.error("Errore:", error));
}

function showAllAderenti() {
    // Effettua una richiesta AJAX alla servlet per ottenere i dati della tabella
    // role=all fa capire alla servlet di stampare tutti gli aderenti registrati
    fetch("http://localhost:8085/progetto_war_exploded/adminStuff?role=aderente")
        .then(response => response.text())
        .then(data => {
            updateTableContent(data)
        })
        .catch(error => console.error("Errore:", error));
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