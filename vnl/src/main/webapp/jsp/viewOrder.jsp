<%@ page import="java.util.List" %>
<%@ page import="model.javabeans.Order" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Ordini</title>
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/viewOrder.css">
  </head>
  <body>

  <jsp:include page="header.jsp"></jsp:include>

  <div class="container_cart">

    <h1>Ordini</h1>

    <ul>
      <%
        List<Order> ordini = (List<Order>) session.getAttribute("orders");
        if (ordini != null && !ordini.isEmpty()) {
          for (int i=0; i<ordini.size(); i++) {

      %>
      <li>

        <div class="description">
          <a href="Ordine?id=<%= ordini.get(i).getId() %>">
            <strong>Ordine: <%= ordini.get(i).getDataOrdine() %></strong>

          </a>
          <p>Prezzo: </p>&euro;<%= ordini.get(i).getTotAmount() %>
          <%}%>
        </div>

      </li>

    </ul>

    <div class="noOrder">

      <%}else %>  <p>Nessun Ordine</p>

    </div>

  </div>



  <jsp:include page="footer.jsp"></jsp:include>
  
  </body>
</html>
