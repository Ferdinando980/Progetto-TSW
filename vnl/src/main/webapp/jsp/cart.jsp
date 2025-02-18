<%@ page import="java.util.List" %>
<%@ page import="model.javabeans.OrderItems" %>
<%@ page import="model.javabeans.Product" %>
<%@ page import="model.dao.ProductDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Carrello</title>
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

                    if (product.getTipo().equalsIgnoreCase("vinili") || product.getTipo().equalsIgnoreCase("cd")){
                        out.println("<li>" + product.getNomeVnl() + "</li>");
                        out.println("<li>" + orderItems.getQuantita() + "</li>");
                        out.println("<li>" + orderItems.getPrezzo() + "</li>");
                    }
                    else if(product.getTipo().equalsIgnoreCase("giradischi")){
                        out.println("<li>" + product.getMarca() + "</li>");
                        out.println("<li>" + orderItems.getQuantita() + "</li>");
                        out.println("<li>" + orderItems.getPrezzo() + "</li>");
                    }

                }
                out.println("<a href=\"CartOrder\">Procedi con l'acquito</a>");

            } else {
                out.println("<p>Il carrello è vuoto</p>");
            }
        %>
    </ul>
    </div>

    <div class="continua">
        <a href="Homepage">Continua lo shopping</a>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>