<%@ page import="java.util.List" %>
<%@ page import="model.javabeans.Product" %>
<%@ page import="model.javabeans.OrderItems" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Procedi all'acquisto</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
  <h2>Conferma Acquisto</h2>

  <form action="ConfermaAcquistoServlet" method="post">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>

    <label for="cognome">Cognome:</label>
    <input type="text" id="cognome" name="cognome" required>

    <label for="indirizzo">Indirizzo:</label>
    <input type="text" id="indirizzo" name="indirizzo" placeholder="Via e numero civico" required>

    <label for="cap">CAP:</label>
    <input type="text" id="cap" name="cap" required pattern="[0-9]{5}" title="Inserisci un CAP valido">

    <label for="paese">Paese:</label>
    <input type="text" id="paese" name="paese" required>


    <button type="submit">Conferma Acquisto</button>
  </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
