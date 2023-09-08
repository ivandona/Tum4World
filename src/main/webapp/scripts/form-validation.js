function validateEmail(email) {
    let emailPattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;
    if (!emailPattern.test(email)) {
        alert("Indirizzo email non valido");
        return false;
    }
    return true;
}

function validatePhoneNumber(phoneNumber) {
    let phoneNumberPattern = /^[0-9]+$/;
    if (!phoneNumberPattern.test(phoneNumber)) {
        alert("Numero di telefono non valido");
        return false;
    }
    return true;
}

function validateBirthdate(birthdate) {
    // Controllo che l'utente sia maggiorenne
    let date = new Date(birthdate);
    let today = new Date();

    // Calcola la data con una differenza di 18 anni dalla data attuale
    let eighteenYearsAgo = new Date(today.getFullYear() - 18, today.getMonth(), today.getDate());

    // Verifica se la data di nascita è maggiore o uguale a 18 anni fa
    if (date > eighteenYearsAgo) {
        alert("Devi essere maggiorenne per registrarti.");
        return false;
    }
    return true;
}

function validatePassword(password, confirm_password) {
    // Controllo complessità password
    let complexityPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$!?])(?=.*[ilmvILMV])[A-Za-z\d$!?]{8}$/;
    if (!complexityPattern.test(password)) {
        alert("La password essere lunga esattamente 8 caratteri e deve contenere almeno una i, v, l e m.\n" +
            "Deve contenere anche almeno un carattere numerico, un carattere maiuscolo e un carattere tra $, ! e ?");
        return false;
    }

    // Controllo che le password combacino
    if (password !== confirm_password) {
        alert("Le password non coincidono");
        return false;
    }
    return true;
}

/**
 * Funzione di controllo finale
 * @returns {boolean}
 */
function validateSignIn() {
    let email = document.getElementById("email").value; // Prendo il value nel campo email
    let birthdate = document.getElementById("birthdate").value;
    let phoneNumber = document.getElementById("phoneNumber").value;
    let password = document.getElementById("password").value;
    let confirm_password = document.getElementById("confirm_password").value;

    return (validateEmail(email) && validateBirthdate(birthdate)
        && validatePhoneNumber(phoneNumber) && validatePassword(password, confirm_password));
}

function validateContactsForm() {
    let email = document.getElementById("email").value;

    return validateEmail(email);
}