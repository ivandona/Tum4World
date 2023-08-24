document.addEventListener("DOMContentLoaded", function() {
    const popup = document.getElementById("popup"); //prendo il "div" cookiesinfo_popup da mostrare se necessario
    const tastoOk = document.getElementById("ok");

    document.cookie = "cookies_accepted=false";

    //Controlla se l'utente ha accettato i cookies precedentemente
    if (!(getCookie("cookies_accepted") === "true")) {
        popup.style.display = "block"; //se l'utente non ha accettato i cookies mostro il popup dell'informativa cambiandone il display:none
    }

    tastoOk.addEventListener("click", function () {
        //Potrebbero esserci problemi: se l'utente ha i cookies disabilitati come faccio a sapere se è già entrato?
        popup.style.display = "none"; //il popup scompare
        document.cookie = "cookies_accepted=true";
    })
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