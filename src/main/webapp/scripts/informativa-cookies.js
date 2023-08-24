document.addEventListener("DOMContentLoaded", function() {
    const popup = document.getElementById("popup"); //prendo il "div" cookiesinfo_popup da mostrare se necessario
    const tastoAccetta = document.getElementById("accetta");
    const tastoRifiuta = document.getElementById("rifiuta");


    //localStorage.removeItem("cookiesAccettati"); // utile per resettare il valore di cookiesConsentiti e visualizzare la finestra
    // Controlla se l'utente ha già accettato i cookie
    const cookiesConsentiti = localStorage.getItem("cookiesAccettati"); //probabilmente poi la toglierai perché se l'utente accetta li mandi alla registrazione?


    if (!cookiesConsentiti) {
        popup.style.display = "block"; //se l'utente non ha accettato i cookies mostro il popup dell'informativa cambiandone il display:none
    } //poi andrà mostrato solo al primo accesso?

    tastoAccetta.addEventListener("click", function() { //in caso si scelga "Accetta"
        popup.style.display = "none"; //il popup scompare
        localStorage.setItem("cookiesAccettati", "true"); //questo salva che i cookie sono stati accettati e la finestra dell'informativa non ricomparirà
    });

    tastoRifiuta.addEventListener("click", function () {
        popup.style.display = "none"; //rifiutare i cookies fa solo sì che la finestra scompaia momentaneamente ma a nuovo accesso si ripresenterà
        localStorage.removeItem("cookiesAccettati"); //questo rimuove "cookiesAccettati" da local storage permettendo, ad un nuovo accesso, di visualizzare nuovamente la finestra
    }) ;
});