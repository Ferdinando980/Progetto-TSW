<%@ page import="model.javabeans.Order" %>
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

    <h2>Order Details</h2>

    <div class="orderdetails">
    <%
        Order order = (Order) request.getAttribute("order");
    %>
    <p><strong>ID:</strong> <%= order.getId() %></p>
    <p><strong>User:</strong> <%= order.getUsers() %></p>
    <p><strong>Status:</strong> <%= order.getStato() %></p>
    <p><strong>Total Amount:</strong> <%= order.getTotAmount() %></p>
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
    </div>

         <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>