<%@ page import="java.util.List" %>
<%@ page import="model.javabeans.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="./css/styles.css">
  <link rel="stylesheet" href="./css/product.css">

  <title>Prodotti Filtrati</title>

</head>
<body>
  <jsp:include page="header.jsp" />

  <div class="page-container">
    <jsp:include page="sidebar.jsp" />
    <div class="mainpage">
      <h2>Prodotti: <%= request.getAttribute("tipo") %> - Condizione: <%= request.getAttribute("condizione") %></h2>
      <div class="Product-list">
        <ul>
          <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products == null) {
              out.println("<p>Non sono stati passati i prodotti.</p>");
            } else if(products.isEmpty()){
              out.println("<p>Non ci sono risultati.</p>");

            }else{
              for (Product product : products) {
          %>
          <li>
            <a href="Prodotto?id=<%= product.getId() %>">
              <img src="<%= (product.getImg() == null || product.getImg().trim().isEmpty()) ? 
                           "assets/images/pictureplaceholder.jpg" : product.getImg() %>" alt="<%= product.getNomeVnl() %>">
            </a>
            <a href="Prodotto?id=<%= product.getId() %>">
              <strong><%= product.getNomeVnl() %></strong>
            </a>
            - &euro;<%= product.getPrezzo() %>
          </li>
          <%
              }
            }
          %>
        </ul>
      </div>
    </div>
  </div>

  <jsp:include page="footer.jsp" />
</body>
</html>