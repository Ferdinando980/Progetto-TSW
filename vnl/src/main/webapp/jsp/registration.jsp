<!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/registration.css">
    <link rel="stylesheet" href="./css/styles.css">
    <title>Registrazione</title>
</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>

    <main>
        <div class="registration-container">

     
        
            <form action="Registrazione" method="POST" class="registration-form">
                <fieldset>
                    <div class="biglabel">
                        <legend>Registrazione</legend>
                    </div>

                    <div class="form-group">
                        <label for="Username">Username:</label><br>
                        <input type="text" id="Username" name="Username" required placeholder="Inserisci Username..." class="input"><br>
                    
                        <label for="Email">Email:</label><br>
                        <input type="email" id="Email" name="Email" required placeholder="Inserisci Email..." class="input"><br>
                    
                        <label for="DataDiNascita">Data di nascita:</label><br>
                        <input type="date" id="DataDiNascita" name="DataDiNascita" class="input"><br>
                    
                        <div class="phoneGroup">
                             <div class="nazione">
                                <label for="Nazione">Nazione:</label><br>
                                <select id="Nazione" name="Nazione" required>
                                </select>
                            </div>
                                  <div class="labelAndInputPhone">
                            <label for="NumeroDiTelefono">Numero di telefono:</label><br>
                            <input type="tel" id="NumeroDiTelefono" name="NumeroDiTelefono" class="input" minlength="10" maxlength="15" required><br>
                            </div>
                        </div>
                    
                        <label for="Password">Password:</label><br>
                        <input type="password" id="Password" name="Password" required placeholder="Inserisci Password..." class="input"><br>
                    
                        <label for="CPassword">Conferma Password:</label><br>
                        <input type="password" id="CPassword" name="CPassword" required placeholder="Conferma Password..." class="input"><br>
                    
                        <input type="submit" value="Registrati" class="button">
                    </div>
                    
                </fieldset>
            </form>
            
        </div>
    </main>

    <jsp:include page="footer.jsp"></jsp:include>
    <script src="script/regioni.js"></script>
</body>

</html>