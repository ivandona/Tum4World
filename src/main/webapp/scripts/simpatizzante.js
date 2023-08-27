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

    getActivities(context);
});

async function getActivities(context) {
    let url = context + "/activitiesServlet"
    fetch(url)
        .then(response => response.json())
        .then(activities => {
            console.log(activities);
            for (let activity in activities) {
                console.log(activity);
                console.log(activities[activity]);
                let checkbox = document.getElementById(activity);
                if (activities[activity]) {
                    console.log("Iscritto a: " + activity)
                    checkbox.checked = true;
                } else {
                    console.log("Non iscritto a: " + activity)
                    checkbox.checked = false;
                }
            }
        })
        .catch(error => console.error("Errore fetch di getActivities: ", error))
}


/*  function setActivities(context) {
    const form = document.getElementById("activities");
    let url = context + "/activitiesServlet";
    form.onsubmit = async (e) => {
        const formData = new FormData(form);
        for(let [name, value] of formData) {
            alert(`${name} = ${value}`); // key1 = value1, then key2 = value2
        }
        e.preventDefault();
        let response = await fetch(url, {
            method: "POST",
            body: formData
        });

        let result = response.status;


    }
}*/
