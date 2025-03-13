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
          for (Order order : ordini) {

      %>
      <li>

        <div class="description">
          <a href="OrderPage?id=<%= order.getId() %>">
            <strong>Ordine: <%= order.getDataOrdine() %></strong>

          </a>
          <p>Prezzo: </p>&euro;<%= order.getTotAmount() %>
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
