<%@ page import="model.javabeans.Order" %>
<%@ page import="model.javabeans.OrderItems" %>
<%@ page import="model.javabeans.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/orderdetails.css">
    <title>Order Details</title>
</head>
<body>

   <jsp:include page="header.jsp"></jsp:include>

   

    <div class="orderdetails">
     <h2>Dettagli Ordine</h2>
    <%
        Order order = (Order) request.getAttribute("order");
    %>
    <p><strong>ID:</strong> <%= order.getId() %></p>
    <p><strong>ID Utente:</strong> <%= order.getUsers() %></p>
    <p><strong>Stato:</strong> <%= order.getStato() %></p>
    <p><strong>Totale:</strong> <%= order.getTotAmount() %></p>
    <p><strong>Date:</strong> <%= order.getDataOrdine() %></p>
    
    <div class="update">
    <form action="UpdateStatus" method="post">
        <input type="hidden" name="id" value="<%= order.getId() %>">
        <select name="status">
            <option value="Elaborando">Elaborando</option>
            <option value="Spedito">Spedito</option>
            <option value="Consegnato">Consegnato</option>
        </select>
        <input type="submit" value="Update Status">
    </form>
    </div>
    <div class="Product-list">
    <h3>Prodotti nell'ordine</h3>
    <ul>
        <%
            ArrayList<OrderItems> orderItems = (ArrayList<OrderItems>) request.getAttribute("orderItems");
            ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");

            if (orderItems == null || orderItems.isEmpty()) {
                out.println("<p>Nessun prodotto trovato per questo ordine.</p>");
            } else {
                for (int i = 0; i < orderItems.size(); i++) {
                    OrderItems item = orderItems.get(i);
                    Product product = products.get(i);
        %>
        <li class="product-item">
            <img src="<%= product.getImg() %>" alt="<%= product.getNomeVnl() != null ? product.getNomeVnl() : "Prodotto" %>" class="product-image">
            <p><strong>Nome:</strong> <%= product.getNomeVnl() != null ? product.getNomeVnl() : "N/A" %></p>
            <p><strong>Quantità:</strong> <%= item.getQuantita() %></p>
            <p><strong>Prezzo:</strong> €<%= item.getPrezzo() %></p>
        </li>
        <%
                }
            }
        %>
    </ul>
</div>
    </div>

         <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>