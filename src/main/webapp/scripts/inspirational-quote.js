document.addEventListener("DOMContentLoaded", function () {
    const testo = document.getElementById("quote"); //prendo l'elemento "quote" che contiene la mia frase da cambiare
    const frasi = [" La vita è per il 10% cosa ti accade e per il 90% come reagisci.",
        "Lasciate che vi sveli il segreto che ha portato al mio obiettivo. La mia forza sta solo nella mia tenacia.",
        "Se qualcosa non ti piace, cambiala. Se non puoi cambiarla, cambia il tuo atteggiamento.",
        "Sapevo che se avessi fallito non me ne sarei pentito. L’unica cosa della quale potrei pentirmi è non provare.",
        "Niente è davvero difficile se lo si divide in tanti piccoli pezzettini.",
        "Il mio scopo nella vita? Fare solo cose positive.",
        "Un uomo di successo è colui che può gettare solide fondamenta con i mattoni che gli altri gli hanno gettato addosso.",
        "Non è mai troppo tardi per essere ciò che avresti voluto essere."];

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