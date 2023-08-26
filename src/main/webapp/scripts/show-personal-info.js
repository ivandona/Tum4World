// Map per tradurre campi da eng a ita
const engToIta = new Map();
engToIta.set("name", "Nome");
engToIta.set("surname", "Cognome");
engToIta.set("email", "Email");
engToIta.set("birthdate", "Data di nascita");
engToIta.set("phoneNumber", "Numero di telefono");
engToIta.set("userRole", "Ruolo");
engToIta.set("username", "Username");
engToIta.set("password", "Password");

function getCookie(name) {
    let value = "; " + document.cookie;
    let parts = value.split("; " + name + "=");
    if (parts.length === 2) {
        return parts.pop().split(";").shift();
    }
}

// Prendo i cookies e li metto in una map(chiave, valore)
function getAllCookies() {
    const cookies = document.cookie.split('; ');
    const cookieMap = {};

    cookies.forEach(cookie => {
        const [name, value] = cookie.split('=');
        cookieMap[name] = decodeURIComponent(value);
    });

    return cookieMap;
}


// Funzione a cui passo un json e l'id di una lista
// e genera con i dati nel json i list item per quella lista
function showJsonAsList(jsonData, idList) {
    let list = document.getElementById(idList);
    // Svuoto la lista per evitare che mi stampi una nuova lista
    // ogni volta che chiamo questo metodo
    list.innerHTML = "";

    for (let key in jsonData) {
        // Notare che aggiungo un elemento alla lista solo
        // se è presente anche in engToIta
        if (jsonData.hasOwnProperty(key) && engToIta.has(key)) {
            let value = jsonData[key];
            let listItem = document.createElement("li");
            let field = engToIta.get(key);
            listItem.textContent = `${field}: ${value}`;
            list.appendChild(listItem);
        }
    }
}

// Trasformo i cookies in una lista HTML
function showCookiesAsList(cookies, idList) {
    let list = document.getElementById(idList);
    // Svuoto la lista per evitare che mi stampi una nuova lista
    // ogni volta che chiamo questo metodo
    list.innerHTML = "";
    for (const key in cookies) {
        // Notare che aggiungo un elemento alla lista solo
        // se è presente anche in engToIta
        if (cookies.hasOwnProperty(key) && engToIta.has(key)) {
            const value = cookies[key];
            const listItem = document.createElement("li");
            let field = engToIta.get(key);
            listItem.textContent = `${field}: ${value}`;
            list.appendChild(listItem);
        }
    }
}

function getSessionAttributes(context, idList) {
    let my_JSON_object;
    let url = context + "/getSessionAttributesServlet";
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", url, true);
    xhttp.responseType = "json";
    xhttp.onreadystatechange = function () {
        let done = 4, ok = 200;
        if (this.readyState === done && this.status === ok){
            my_JSON_object = this.response;
            showJsonAsList(my_JSON_object, idList);
        }
    };
    xhttp.send();
    return my_JSON_object;
}

function showPersonalInfo(context, idList) {
    const cookies = getAllCookies();
    // Se trovo le informazioni nel cookie, uso quelle
    // Altrimenti le prendo dalla sessione
    if (cookies.size != 0) {
        showCookiesAsList(cookies, idList);
    } else {
        getSessionAttributes(context, idList);
    }
}