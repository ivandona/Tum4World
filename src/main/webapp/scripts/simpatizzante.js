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

function setActivities(context) {
    const form = document.getElementById("activities");
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Blocco l'invio del form

        const formData = new FormData(form); // Prendo dati dal form
        let url = context + "/activitiesServlet";
        // Costruisco e mando fetch
        fetch(url, {
            method: "POST",
            body: formData
        })
            .then(response => response.text())
            .then(data => {
                // Handle the response data
                console.log(data);
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });
}
