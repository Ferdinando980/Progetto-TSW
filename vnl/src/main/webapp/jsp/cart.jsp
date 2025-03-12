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
                    Product product=productDao.doRetrieveById(Integer.parseInt(orderItems.getProdotto()));
                    %>
                    <li>
                        <%
                            String imgPath = product.getImg();
                            String imgSrc = (imgPath == null || imgPath.trim().isEmpty()) ? "assets/images/pictureplaceholder.jpg" : imgPath;
                        %>
                        <div class="image">
                            <img src="<%= imgSrc %>">
                        </div>
                        <div class="description">
                            <a href="Prodotto?id=<%= product.getId() %>">
                                <strong><%= product.getNomeVnl() %></strong>

                            </a>
                            <p>Prezzo: </p>&euro;<%= orderItems.getPrezzo() %>
                            <p>Quantit&agrave;: </p>
                            <form action="Cart" method="POST">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="productID" value="<%= product.getId() %>">
                                <input type="number" name="quantity" value="<%= orderItems.getQuantita() %>" min="1" max="100">
                                <input type="submit" value="Aggiorna">
                            </form>
                        </div>

                        <div class="remove">
                            <form action="Cart" method="POST">
                                <input type="hidden" name="action" value="remove">
                                <input type="hidden" name="productID" value="<%= product.getId() %>">
                                <input type="image" src="./assets/images/cestino.png" alt="Rimuovi">
                            </form>
                        </div>

                    </li>
                <%}
            }%>
        </ul>

        <div class="acquisti">

            <% if (cart != null && !cart.isEmpty()) { %>

                <div class="procedere">
                    <a href=CartOrder>Procedi con l'acquito</a>
                </div>

            <% } else %>  <p>Carrello Vuoto</p>

            <div class="continua">
                <a href="Homepage">Continua lo shopping</a>
            </div>

        </div>

    </div>



    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>