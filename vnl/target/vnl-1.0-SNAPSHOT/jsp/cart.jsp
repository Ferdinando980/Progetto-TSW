<%@ page import="java.util.List" %>
<%@ page import="model.javabeans.OrderItems" %>
<%@ page import="model.javabeans.Product" %>
<%@ page import="model.dao.ProductDao" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carrello</title>
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/cart.css">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <div class="container_cart">
    <h1>Carrello</h1>

    <ul>
        <%
            List<OrderItems> cart = (List<OrderItems>) session.getAttribute("cart");
            if (cart != null && !cart.isEmpty()) {
                for (OrderItems orderItems : cart) {
                    ProductDao productDao = new ProductDao();
                    Product product=productDao.doRetrieveById(orderItems.getProdotto());
                    %>
                    <li>
                        <%
                            String imgPath = product.getImg();
                            String imgSrc = (imgPath == null || imgPath.trim().isEmpty()) ? "assets/images/pictureplaceholder.jpg" : imgPath;
                        %>
                        <img src="<%= imgSrc %>">
                        <a href="Prodotto?id=<%= product.getId() %>">
                            <strong><%= product.getNomeVnl() %></strong>
                        </a> - $<%= orderItems.getPrezzo() %>
                        <%= orderItems.getQuantita() %>
                    </li>
                <%}
                %><a href=CartOrder>Procedi con l'acquito</a>

            <% } else %>  <p>Carrello Vuoto</p>

    </ul>
    </div>

    <div class="continua">
        <a href="Homepage">Continua lo shopping</a>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>