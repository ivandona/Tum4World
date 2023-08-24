document.addEventListener("DOMContentLoaded", function () {
    const testo = document.getElementById("quote"); //prendo l'elemento "quote" che contiene la mia frase da cambiare
    const frasi = ["Prova 1", "Prova 2", "Prova 3", "Prova 4", "Prova 5", "Prova 6", "Prova 7", "Prova 8"]; //esempi per provare il cambio frase

    var min = 1;
    var max = frasi.length;

    var number = 0;
    var pastn = 0;
    function cambiaTesto() {
        do {
            number = Math.floor(Math.random()*(max - min +1));
        } while (number == pastn);
        testo.textContent = frasi[number]; //cambio il contenuto dell'elemento "quote"
        pastn = number;
    }

    cambiaTesto(); //lo chiamo subito per caricare la prima frase all'avvio della pagina
    setInterval(cambiaTesto, 20000); //ogni 20 secondi richiamo la funzione che cambia la frase
});