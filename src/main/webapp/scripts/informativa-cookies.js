document.addEventListener("DOMContentLoaded", function() {
    const popup = document.getElementById("popup");
    const tastoOk = document.getElementById("ok");

    try {
        // Controlla se l'utente ha accettato i cookie precedentemente
        if (!(sessionStorage.getItem("cookies_accepted") === "true") && !(getCookie("cookies_accepted"))) {
            popup.style.display = "block";
        }
    } catch (error) {
        // Se l'utente ha i cookies disabilitati catturiamo l'errore e non facciamo comparire l'informativa
        // A logica, se l'utente blocca tutti i cookies, noi non ne utilizziamo nessuno quindi non serve farla comparire
        console.error("Errore nell'accesso a sessionStorage:", error);
        console.error("Controlla di aver abilitato i cookies");
        popup.style.display = "none";
    }

    tastoOk.addEventListener("click", function () {
        try {
            popup.style.display = "none";
            sessionStorage.setItem("cookies_accepted", "true");
            document.cookie = "cookies_accepted=true"
        } catch (error) {
            console.error("Errore nell'accesso a sessionStorage:", error);
            console.error("Controlla di aver abilitato i cookies");
        }
    });
});
function getCookie(name) {
    var cookies = document.cookie.split("; ");
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i].split("=");
        if (cookie[0] === name) {
            return decodeURIComponent(cookie[1]);
        }
    }
    return null;
}