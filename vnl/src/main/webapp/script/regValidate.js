function validateForm() {
    var errors = [];

    // Resetting previous errors
    document.querySelectorAll('.error-message').forEach(function(error) {
        error.textContent = '';
        error.style.color = 'red';
    });

    var email = document.getElementById("Email").value;
    var emailRegex = /^[A-Za-z0-9+_.-]+@(.+)$/;
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

    var password = document.getElementById("Password").value;
    var passwordRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()]).{6,15}$/;
    if (!password || !password.match(passwordRegex)) {
        document.getElementById("Password").style.border = "2px solid red";
        document.getElementById("passwordError").textContent = "Le password non corrispondono o non soddisfano i criteri di validità";
        errors.push("Le password non corrispondono o non soddisfano i criteri di validità");
    }

    var passwordCheck = document.getElementById("CPassword").value;
    if (password !== passwordCheck) {
        document.getElementById("CPassword").style.border = "2px solid red";
        document.getElementById("cpasswordError").textContent = "Le password non corrispondono";
        errors.push("Le password non corrispondono");
    }

    var username = document.getElementById("Username").value;
    var usernameRegex = /^[a-zA-Z0-9 ]{6,12}$/;
    if (!username || !username.match(usernameRegex)) {
        document.getElementById("Username").style.border = "2px solid red";
        document.getElementById("usernameError").textContent = "Username non valido";
        errors.push("Username non valido");
    }

    if (errors.length > 0) {
        return false;  
    }

    return true;  
}

window.onload = function () {
    if (errorMessages.length > 0) {
        errorMessages.forEach(function (error) {
            if (error.includes("Username")) {
                document.getElementById("Username").style.border = "2px solid red";
                document.getElementById("usernameError").textContent = error;
            }
            if (error.includes("Email")) {
                document.getElementById("Email").style.border = "2px solid red";
                document.getElementById("emailError").textContent = error;
            }
            if (error.includes("Data di nascita")) {
                document.getElementById("DataDiNascita").style.border = "2px solid red";
                document.getElementById("birthDateError").textContent = error;
            }
            if (error.includes("Numero di telefono")) {
                document.getElementById("NumeroDiTelefono").style.border = "2px solid red";
                document.getElementById("phoneError").textContent = error;
            }
            if (error.includes("Password")) {
                document.getElementById("Password").style.border = "2px solid red";
                document.getElementById("passwordError").textContent = error;
            }
            if (error.includes("Le password non corrispondono")) {
                document.getElementById("CPassword").style.border = "2px solid red";
                document.getElementById("cpasswordError").textContent = error;
            }
        });
    }
};