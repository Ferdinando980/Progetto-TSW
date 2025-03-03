<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/editProfile.css">
    <link rel="stylesheet" href="./css/styles.css">
    <title>Login</title>
</head>

 <main>
 
<jsp:include page="header.jsp"></jsp:include>

        <div class="Modifica-container">



            <form action="EditProfile" method="POST" class="registration-form" onsubmit="return validateForm()">
                <fieldset>
                    <div class="biglabel">
                        <legend>Modifica Profilo</legend>
                    </div>

                    <div class="form-group">
                                <span id="usernameError" class="error-message"></span>
                        <label for="Username">Username:</label><br>
                        <input type="text" id="Username" name="Username" value="${sessionScope.userData.Username}" required
                            placeholder="Inserisci Username..." class="input"><br>
                   
                        <span id="emailError" class="error-message"></span>
                        <label for="Email">Email:</label><br>
                        <input type="email" id="Email" value="${sessionScope.userData.Email}" name="Email" required
                            placeholder="Inserisci Email..." class="input"><br>
               
                       <span id="birthDateError" class="error-message"></span>
                        <label for="DataDiNascita">Data di nascita:</label><br>
                        <input type="date" id="DataDiNascita" value="${sessionScope.userData.DataDiNascita}" name="DataDiNascita"
                            class="input"><br>
                

                        <div class="phoneGroup">
                            <div class="nazione">
                                <label for="Nazione">Nazione:</label><br>
                                <select id="Nazione" name="Nazione" required>
                                </select>
                            </div>
                            <div class="labelAndInputPhone">
                                             <span id="phoneError" class="error-message"></span>
                                <label for="NumeroDiTelefono">Numero di telefono:</label><br>
                                <input type="tel" id="NumeroDiTelefono" name="NumeroDiTelefono" class="input"
                                    minlength="10" maxlength="15" required><br>
               
                            </div>
                        </div>
                        <span id="passwordError" class="error-message"></span>
                        <label for="Password">Password:</label><br>
                        <input type="password" id="Password" name="Password" required
                            placeholder="Inserisci Password..." class="input"><br>
                                  <span id="cpasswordError" class="error-message"></span>
                        <label for="CPassword">Conferma Password:</label><br>
                        <input type="password" id="CPassword" name="CPassword" required
                            placeholder="Conferma Password..." class="input"><br>
      

                        <input type="submit" value="Modifica Profilo" class="button">
                        <span id="SubmitSuccess" class= "success-message"></span>
                    </div>

                </fieldset>
            </form>

        </div>
    </main>

    <jsp:include page="footer.jsp"></jsp:include>
    <script>

    var errorMessages = JSON.parse('${errorMessagesJson}');
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
        });
    }   
    </script>




    <script type="text/javascript" src="script/regValidate.js"></script>
    <script type="text/javascript" src="script/regioni.js"></script>

</body>

</html>