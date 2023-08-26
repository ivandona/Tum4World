document.addEventListener("DOMContentLoaded", function () {
    const testo = document.getElementById("quote"); //prendo l'elemento "quote" che contiene la mia frase da cambiare
    const frasi = [" La vita è per il 10% cosa ti accade e per il 90% come reagisci. (Charles R. Swindoll)",
        "Ci sono due regole nella vita: 1. Non mollare mai; 2. Non dimenticare mai la regola n° 1. (Duke Ellington)",
        "Se qualcosa non ti piace, cambiala. Se non puoi cambiarla, cambia il tuo atteggiamento. Non lamentarti. (Maya Angelou)",
        "Se vuoi qualcosa che non hai mai avuto, devi fare qualcosa che non hai mai fatto. (Thomas Jefferson)",
        "Niente è davvero difficile se lo si divide in tanti piccoli pezzettini. (Henry Ford)",
        "Il mio scopo nella vita? Fare solo cose positive. (Zendaya)",
        "Prima ti ignorano, poi ti deridono, poi ti combattono. Poi vinci. (Mahatma Gandhi)",
        "Non è mai troppo tardi per essere ciò che avresti voluto essere (George Eliot)"];

    var min = 1;
    var max = frasi.length;

    var number = 0;
    var pastn = 0;
    function cambiaTesto() {
        do {
            number = Math.floor(Math.random()*(max - min +1));
        } while (number === pastn);
        testo.textContent = frasi[number]; //cambio il contenuto dell'elemento "quote"
        pastn = number;
    }

    cambiaTesto(); //lo chiamo subito per caricare la prima frase all'avvio della pagina
    setInterval(cambiaTesto, 20000); //ogni 20 secondi richiamo la funzione che cambia la frase
});