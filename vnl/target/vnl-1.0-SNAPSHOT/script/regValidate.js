function validateForm() {
    var errors = [];


    var email = document.getElementById("Email").value;
    var emailRegex = /^[A-Za-z0-9+_.-]+@(.+)$/;
    if (!email || !email.match(emailRegex)) {
        errors.push("Email inserita in modo errato");
        document.getElemenyById("Email").style.border = "2px solid red";
    }


    var birthDate = document.getElementById("DataDiNascita").value;
    
    if (!birthDate) {
        document.getElementById("DataDiNascita").style.border = "2px solid red";
        errors.push("Data di nascita non valida");
    }


    var phone = document.getElementById("NumeroDiTelefono").value;
    var phoneRegex = /^(\+?[0-9]{0,3})?[0-9]{3}[0-9]{3}[0-9]{4}$/;
    if (!phone || !phone.match(phoneRegex)) {
        document.getElementById("NumeroDiTelefono").style.border = "2px solid red";
        errors.push("Numero di telefono inserito in modo errato");
    }

    var password = document.getElementById("Password").value;
    var passwordRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()]).{6,15}$/;
    if (!password || !password.match(passwordRegex)) {
        document.getElementById("Password").style.border = "2px solid red";
        errors.push("Le password non corrispondono o non soddisfano i criteri di validità");
    }

    var passwordCheck = document.getElementById("CPassword").value;
    if (password !== passwordCheck) {
        document.getElementById("CPassword").style.border = "2px solid red";
        errors.push("Le password non corrispondono");
    }

    var username = document.getElementById("Username").value;
    var usernameRegex = /^[a-zA-Z0-9 ]{6,12}$/;
    if (!username || !username.match(usernameRegex)) {
        document.getElementById("Username").style.border = "2px solid red";
        errors.push("Username non valido");
    }

    if (errors.length > 0) {
        var errorMessages = errors.join("\n");
        alert(errorMessages);
        return false;  
    }

    return true;  
}

window.onload = function() {
    if (errorMessages.includes("Username Già In Uso")) {
        alert("L'username inserito è già in uso.");
        document.getElementById("Username").style.border = "2px solid red";
    }
    
    if (errorMessages.includes("Email già in uso")) {
        alert("L'email inserita è già in uso.");
        document.getElementById("Email").style.border = "2px solid red";
    }
}