<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/registration.css">
    <link rel="stylesheet" href="./css/styles.css">
</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>
    <div class="registration-container">

        <form action="/registration.jsp" method="POST" class="registration-form">
            <fieldset>
                <div class="biglabel">
                    <legend>RegistrazioOOOOne</legend>
                </div>
                <div class="form-group">
                    <label for="Email">Email:</label><br>
                    <input type="text" id="Email" name="Email" required placeholder="Inserisci Email. ."
                        class="input"><br>
                    <label for="DataDinascita">Data di nascita:</label><br>
                    <input type="date" id="DataDiNascita" name="DataDiNascita" class="input"><br>
                    <label for="NumerodiTelefono">Numero di telefono:</label><br>
                    <input type="tel" id="NumeroDiTelefono" name="NumeroDiTelefono" class="input"><br>

                    <label for="Password">Password:</label><br>
                    <input type="password" id="Password" name="Password" required placeholder="Inserisci Password. ."
                        class="input"><br>
                    <label for="ConfermaPassword">Conferma Password:</label><br>
                    <input type="password" id="CPassword" name="CPassword" required placeholder="Conferma Password. ."
                        class="input"><br>


                </div>

                <div class="form-actions">
                    <input type="submit" value="Registrati" class="button">
                </div>

            </fieldset>
        </form>
        
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>