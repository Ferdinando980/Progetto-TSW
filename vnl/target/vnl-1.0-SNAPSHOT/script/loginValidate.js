
function validateForm() {
    var errors = [];

    document.querySelectorAll('.error-message').forEach(function (error) {
        error.textContent = '';
        error.style.color = 'red';
    });

    document.querySelectorAll('input').forEach(function (input) {
        input.style.removeProperty("border");
    });

    var password = document.getElementById("Password").value;
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