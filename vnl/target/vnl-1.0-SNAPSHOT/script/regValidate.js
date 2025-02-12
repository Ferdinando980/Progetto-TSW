function validateForm() {
    var errors = [];

    // Reset messaggi di errore e bordi
    document.querySelectorAll('.error-message').forEach(function (error) {
        error.textContent = '';
        error.style.color = 'red';
    });

    document.querySelectorAll('input').forEach(function (input) {
        input.style.removeProperty("border"); // Rimuove il bordo rosso
    });

    var password = document.getElementById("Password").value;
    var cpassword = document.getElementById("CPassword").value;
    if (password !== cpassword) {
        document.getElementById("Password").style.border = "2px solid red";
        document.getElementById("CPassword").style.border = "2px solid red";
        document.getElementById("passwordError").textContent = "Le password non corrispondono";
        document.getElementById("cpasswordError").textContent = "Le password non corrispondono";
        errors.push("Le password non corrispondono");
    }

    var email = document.getElementById("Email").value;
    var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!email || !email.match(emailRegex)) {
        document.getElementById("Email").style.border = "2px solid red";
        document.getElementById("emailError").textContent = "Email inserita in modo errato";
        errors.push("Email inserita in modo errato");
    }

    var birthDate = document.getElementById("DataDiNascita").value;
    if (!birthDate) {
        document.getElementById("DataDiNascita").style.border = "2px solid red";
        document.getElementById("birthDateError").textContent = "Data di nascita non valida";
        errors.push("Data di nascita non valida");
    }

    var phone = document.getElementById("NumeroDiTelefono").value;
    var phoneRegex = /^(\+?[0-9]{0,3})?[0-9]{3}[0-9]{3}[0-9]{4}$/;
    if (!phone || !phone.match(phoneRegex)) {
        document.getElementById("NumeroDiTelefono").style.border = "2px solid red";
        document.getElementById("phoneError").textContent = "Numero di telefono inserito in modo errato";
        errors.push("Numero di telefono inserito in modo errato");
    }

    var passwordRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()]).{6,15}$/;
    if (!password || !password.match(passwordRegex)) {
        document.getElementById("Password").style.border = "2px solid red";
        document.getElementById("passwordError").textContent = "La password non soddisfa i criteri di validità";
        errors.push("La password non soddisfa i criteri di validità");
    }

    var username = document.getElementById("Username").value;
    var usernameRegex = /^[a-zA-Z0-9 ]{6,12}$/;
    if (!username || !username.match(usernameRegex)) {
        document.getElementById("Username").style.border = "2px solid red";
        document.getElementById("usernameError").textContent = "Username non valido, deve contenere minimo 6 e massimo 12 caratteri";
        errors.push("Username non valido");
    }

    if (errors.length > 0) {
        return false;
    }

    return true;
}


document.querySelectorAll("input").forEach(function (input) {
    input.addEventListener("input", function () {
        this.style.removeProperty("border"); 
        var errorId = this.id + "Error";
        var errorElement = document.getElementById(errorId);
        if (errorElement) {
            errorElement.textContent = ""; 
        }
    });
});
