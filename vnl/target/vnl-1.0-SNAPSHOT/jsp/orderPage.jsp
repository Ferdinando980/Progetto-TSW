<%@ page import="model.javabeans.Order" %>
<%@ page import="java.sql.Date" %>
<%@ page import="model.javabeans.OrderItems" %>
<%@ page import="model.javabeans.Product" %>
<%@ page import="model.dao.ProductDao" %>
<%@ page import="java.util.List" %>
<%@ page import="model.dao.OrderDao" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ordine</title>
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/orderPage.css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container_cart">

    <h1>Carrello</h1>

    <ul>
        <%
            List<OrderItems> orderItems = (List<OrderItems>) session.getAttribute("orderItems");
            if (orderItems != null && !orderItems.isEmpty()) {
                for (OrderItems orderItem : orderItems) {
                    ProductDao productDao = new ProductDao();
                    Product product=productDao.doRetrieveById(Integer.parseInt(orderItem.getProdotto()));
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
                <p>Prezzo: </p>&euro;<%= orderItem.getPrezzo() %>
                <p>Quantit&agrave;: <%= orderItem.getQuantita() %></p>
            </div>

        </li>
        <%}%>
    </ul>

    <div class="noProduct">

        <% } else %>  <p>Ordine Vuoto</p>

    </div>

</div>



<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
