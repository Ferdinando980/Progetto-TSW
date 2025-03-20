<%@ page import="java.util.HashMap" %>
<%
    HashMap<String, String> userData = (HashMap<String, String>) session.getAttribute("UserData");
%>
<!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/editProfile.css">
    <title>Modifica Profilo</title>
</head>

<body>
    <jsp:include page="header.jsp"></jsp:include>

    <main>
        <div class="page-container">
            <fieldset>
                <div class="biglabel">
                    <legend>Modifica Profilo</legend>
                </div>

                <div class="Containers">
                    <div class="Visual-container">
                        <h2>Dati Attuali</h2>
                        <p><b>Username:</b> <%= userData != null ? userData.get("Username") : "Non disponibile" %></p>
                        <p><b>Email:</b> <%= userData != null ? userData.get("Email") : "Non disponibile" %></p>
                        <p><b>Data di Nascita:</b> <%= userData != null ? userData.get("DataNascita") : "Non disponibile" %></p>
                        <p><b>Telefono:</b> <%= userData != null ? userData.get("nTelefono") : "Non disponibile" %></p>
                        <div class="visualizza-ordini">
                            <a href="ViewOrder">Storico ordini</a>
                        </div>
                    </div>

                    <div class="Modifica-container">
                        <form id="editProfileForm" action="EditProfile" method="POST" class="edit-form" onsubmit="return validateAndSubmitForm()">
                            <div class="form-group">
                                <span id="usernameError" class="error-message"></span>
                                <label for="Username">Username:</label>
                                <input type="text" id="Username" name="Username" value="<%= userData != null ? userData.get("Username") : "" %>" required placeholder="Inserisci Username..." class="input">

                                <span id="emailError" class="error-message"></span>
                                <label for="Email">Email:</label>
                                <input type="email" id="Email" name="Email" value="<%= userData != null ? userData.get("Email") : "" %>" required placeholder="Inserisci Email..." class="input">

                                <span id="birthDateError" class="error-message"></span>
                                <label for="DataDiNascita">Data di nascita:</label>
                                <input type="date" id="DataDiNascita" name="DataDiNascita" value="<%= userData != null ? userData.get("DataNascita") : "" %>" class="input">

                                <div class="phoneGroup">
                                    <div class="nazione">
                                        <label for="Nazione">Nazione:</label>
                                        <select id="Nazione" name="Nazione" required></select>
                                    </div>
                                    <div class="labelAndInputPhone">
                                        <span id="phoneError" class="error-message"></span>
                                        <label for="NumeroDiTelefono">Numero di telefono:</label>
                                        <input type="tel" id="NumeroDiTelefono" name="NumeroDiTelefono" value="" class="input" minlength="10" maxlength="15" required>
                                    </div>
                                </div>

                                <span id="passwordError" class="error-message"></span>
                                <label for="Password">Password:</label>
                                <input type="password" id="Password" name="Password" required placeholder="Inserisci Password..." class="input">

                                <span id="cpasswordError" class="error-message"></span>
                                <label for="CPassword">Conferma Password:</label>
                                <input type="password" id="CPassword" name="CPassword" required placeholder="Conferma Password..." class="input">

                                <input type="submit" value="Modifica Profilo" class="button">

                                <span id="SubmitSuccess" class="success-message">
                                    ${not empty successMessage ? successMessage : ''}
                                </span>
                            </div>
                        </form>
                    </div>
                </div>
            </fieldset>
        </div>
    </main>

    <jsp:include page="footer.jsp"></jsp:include>

    <script>
        var errorMessagesJson = '${errorMessagesJson}';
        try {
            if (errorMessagesJson && errorMessagesJson.trim() !== "") {
                var errorMessages = JSON.parse(errorMessagesJson);
                if (Array.isArray(errorMessages) && errorMessages.length > 0) {
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
            }
        } catch (e) {
            console.error("Errore nel parsing di errorMessagesJson:", e);
        }
    </script>

    <script type="text/javascript" src="script/editValidate.js"></script>
    <script type="text/javascript" src="script/regioni.js"></script>
</body>

</html>