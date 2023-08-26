const datiBtn = document.getElementById("datiBtn");
const attivitaBtn = document.getElementById("attivitaBtn");

const dati = document.getElementById("personal-info");
const attivita = document.getElementById("attivita");

datiBtn.addEventListener("click", () => {
    dati.classList.toggle("hidden");
    attivita.classList.add("hidden");
});


attivitaBtn.addEventListener("click", () => {
    attivita.classList.toggle("hidden");
    dati.classList.add("hidden");
});

function getActivities(context) {

}
