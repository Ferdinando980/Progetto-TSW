<!DOCTYPE html>
<head> 
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="registration.css">
        <link rel="stylesheet" href="styles.css">
</head>
<body> 


<div class="registration-container">
  
        <form action="/registration.jsp" method="POST" class="registration-form">
            <fieldset>
                 <div class="biglabel">
                <legend>Registrazione</legend>
                 </div>
                <div class="form-group">
                    <label for="Email">Email:</label><br>
                    <input type="text" id="Email" name="Email" required placeholder="Inserisci Email. ."class="input"><br>
                    <label for="DataDinascita">Data di nascita:</label><br>
                    <input type="date" id="DataDinascita" name="DataDinascita" class="input"><br>
                       <label for="NumerodiTelefono">Numero di telefono:</label><br>
                    <input type="tel" id="NumerodiTelefono" name="NumerodiTelefono" class="input"><br>

                    <label for="Password">Password:</label><br>
                    <input type="password" id="Password" name="Password" required placeholder="Inserisci Password. ."class="input"><br>
                    <label for="ConfermaPassword">Conferma Password:</label><br>
                    <input type="password" id="Password" name="Password" required placeholder="Conferma Password. ." class="input"><br>
             

                </div>

                <div class="form-actions">
        
                    <input type="submit" value="Registrati" class="button">
                </div>

            </fieldset>
        </form>
   </div>


</body>