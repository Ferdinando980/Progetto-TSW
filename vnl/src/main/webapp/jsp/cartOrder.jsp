<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Procedi all'acquisto</title>
    <link rel="stylesheet" href="./css/cartOrder.css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">

  <div class="fieldset">

    <div class="biglabel">
      <legend>Conferma Aquisto</legend>
    </div>

    <form action="CartOrder" method="post">

      <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" required>
        <br><br>

        <label for="Via">Via:</label>
        <input type="text" id="via" name="via" required>

        <label for="civico">Civico:</label>
        <input type="text" id="civico" name="civico" required>

        <label for="cap">CAP:</label>
        <input type="text" id="cap" name="cap" required pattern="[0-9]{5}" title="Inserisci un CAP valido">

        <label for="paese">Paese:</label>
        <input type="text" id="paese" name="paese" required>
        <br><br>

      </div>

      <button type="submit">Conferma Acquisto</button>

    </form>

  </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
