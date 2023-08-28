const datiBtn = document.getElementById("datiBtn");
const attivitaBtn = document.getElementById("attivitaBtn");
const donazioneBtn = document.getElementById("donazioneBtn");
const deleteUserBtn = document.getElementById("deleteUserBtn");

const dati = document.getElementById("dati");
const attivita = document.getElementById("attivita");
const donazione = document.getElementById("donazione");

datiBtn.addEventListener("click", () => {
    showPersonalInfo(context, "personal-info");
    dati.classList.toggle("hidden");
    attivita.classList.add("hidden");

    if(donazione != null)
        donazione.classList.add("hidden");
});
attivitaBtn.addEventListener("click", () => {
    getActivities(context);
    attivita.classList.toggle("hidden");
    dati.classList.add("hidden");
    if(donazione != null)
        donazione.classList.add("hidden");
});
if (donazione != null) {
    donazioneBtn.addEventListener("click", () => {
        donazione.classList.toggle("hidden");
        dati.classList.add("hidden");
        attivita.classList.add("hidden");
    });
}
deleteUserBtn.addEventListener("click", () => {
    let url = context + "/deleteUserServlet";
    fetch(url, {
        method: "POST"
    })
        .then(response => {
            // Check response status and handle accordingly
            if (response.ok) {
                console.log("User deleted.");
                location.reload();
            } else {
                console.error("Request failed with status:", response.status);
            }
        })
        .catch(error => {
            console.error("Error:", error);
        });
});

async function getActivities(context) {
    let url = context + "/activitiesServlet";
    fetch(url)
        .then(response => response.json())
        .then(activities => {
            for (let activity in activities) {
                let checkbox = document.getElementById(activity);
                if (activities[activity]) {
                    checkbox.checked = true;
                } else {
                    checkbox.checked = false;
                }
            }
        })
        .catch(error => console.error("Errore fetch di getActivities: ", error))
}
