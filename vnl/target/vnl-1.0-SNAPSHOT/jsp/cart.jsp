<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            List<String> carrello = (List<String>) session.getAttribute("cart");
            if (carrello != null && !carrello.isEmpty()) {
                for (String prodotto : carrello) {
                    out.println("<li>" + prodotto + "</li>");
                }
                out.println("<a href=\"Acquisto\">Procedi con l'acquito</a>");
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