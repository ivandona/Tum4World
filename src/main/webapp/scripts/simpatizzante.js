const datiBtn = document.getElementById("datiBtn");
const attivitaBtn = document.getElementById("attivitaBtn");
const deleteUserBtn = document.getElementById("deleteUserBtn");

const dati = document.getElementById("dati");
const attivita = document.getElementById("attivita");

datiBtn.addEventListener("click", () => {
    dati.classList.toggle("hidden");
    attivita.classList.add("hidden");
});

attivitaBtn.addEventListener("click", () => {
    attivita.classList.toggle("hidden");
    dati.classList.add("hidden");
});

deleteUserBtn.addEventListener("click", () => {
    let url = "http://localhost:8080/progetto_war_exploded/deleteUserServlet";
    fetch(url, {
        method: "POST"
    })
        .then(response => {
            // Check response status and handle accordingly
            if (response.ok) {
                console.log("User deleted.");
            } else {
                console.error("Request failed with status:", response.status);
            }
        })
        .catch(error => {
            console.error("Error:", error);
        });
});
function setActivities(context) {
    const form = document.getElementById("activities");
    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Blocco l'invio del form

        const formData = new FormData(form); // Prendo dati dal form
        for(let [name, value] of formData) {
            alert(`${name} = ${value}`); // key1 = value1, then key2 = value2
        }
        let url = context + "/activitiesServlet";
        // Costruisco e mando fetch
        fetch(url, {
            method: "POST",
            body: formData
        })
            .then(response => {
                // Check response status and handle accordingly
                if (response.ok) {
                    console.log("Data received and processed successfully.");
                } else {
                    console.error("Request failed with status:", response.status);
                }
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });
}
