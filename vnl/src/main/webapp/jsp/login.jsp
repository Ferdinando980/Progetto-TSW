<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/login.css">
    <link rel="stylesheet" href="./css/styles.css">
    <title>Login</title>
</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>

    
    <div class="login-container">
        <form action="Login" method="POST" class="login-form" onsubmit= "return validateForm()">
            <fieldset>
                <legend>Login</legend>

                <div class="form-container">

                    <div class="form-group">
                      <span id="usernameError" class="error-message"></span>
                        <label for="Username">Username:</label>
                        <input type="text" id="Username" name="Username" required placeholder="Inserisci Username"
                            class="input">
                    </div>


                    <div class="form-group">
                            <span id="passwordError" class="error-message"></span>
                        <label for="Password">Password:</label>
                        <input type="password" id="Password" name="Password" required placeholder="Inserisci Password"
                            class="input">

                                    <span id="loginError" class="login-message"></span>
                    </div>
                </div>


                <div class="form-actions">
                    <input type="button" id="button" value="Registrati" onclick="location.href='Registrazione'"
                        class="button">
                    <input type="submit" value="Login" class="button">
                </div>

            </fieldset>
        </form>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
<script>

    var errorMessagesJson = '${errorMessagesJson}';

    if (errorMessagesJson && errorMessagesJson.trim() !== "") {
        try {
            var errorMessages = JSON.parse(errorMessagesJson);

            if (errorMessages.error) { 
                if (errorMessages.error.includes("Login")) {
                    document.getElementById("Password").style.border = "3px solid red";
                    document.getElementById("loginError").textContent = "Login Fallito!!";
                }
            }
        } catch (e) {
            console.error("Errore nel parsing del JSON:", e, "Dati ricevuti:", errorMessagesJson);
        }
    }
</script>

     <script type="text/javascript" src="script/loginValidate.js"></script>
</body>


</html>