// Map per tradurre campi da eng a ita
const engToIta = new Map();
engToIta.set("name", "Nome");
engToIta.set("surname", "Cognome");
engToIta.set("email", "Email");
engToIta.set("birthdate", "Data di nascita");
engToIta.set("phoneNumber", "Numero di telefono");
engToIta.set("userRole", "Ruolo");
engToIta.set("username", "Username");

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
    let url = context + "/getSessionAttributesServlet";
    let list = document.getElementById(idList);
    console.log(url);
    // Svuoto la lista per evitare che mi stampi una nuova lista
    // ogni volta che chiamo questo metodo
    list.innerHTML = "";
    fetch(url)
        .then(response => response.json())
        .then(attributes => {
            console.log("fetch getSessionAttributes");
            console.log(attributes);
            for (let attribute in attributes) {
                if (engToIta.has(attribute)) {
                    let value = attributes[attribute];
                    let listItem = document.createElement("li");
                    let field = engToIta.get(attribute);
                    listItem.textContent = `${field}: ${value}`;
                    list.appendChild(listItem);
                }
            }
        })
        .catch(error => console.error("Errore fetch di getSessionAttributes: ", error))
}

function showPersonalInfo(context, idList) {
    const cookies = getAllCookies();
    console.log("showPersonalInfo() called");
    console.log(cookies.size);
    // Se trovo le informazioni nel cookie, uso quelle
    // Altrimenti le prendo dalla sessione
    if (cookies.size === undefined || cookies === null) {
        getSessionAttributes(context, idList);
    } else {
        showCookiesAsList(cookies, idList);
    }
}