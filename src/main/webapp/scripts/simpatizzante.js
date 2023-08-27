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

    getActivities(context);
});

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

    /*url = context + "/logoutServlet";
    fetch(url)
        .then(response => {
            if (response.ok) {
                console.log("User logged out");
            } else {
                console.error("Request failed with status:", response.status);
            }
        })
        .catch(error => {
            console.error("Error:", error);
        });*/
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
