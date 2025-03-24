<%@ page import="java.util.List" %>
<%@ page import="model.javabeans.Product" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/product.css">
  
    <title>ListaProdotti</title>
</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>

    <div class="page-container">
            <jsp:include page="sidebar.jsp"></jsp:include>
            <div class="mainpage">

                <div class="Product-list">
                    <ul>
                        <%
                            List<Product> products = (List<Product>) request.getAttribute("products");
                            if (products == null) {
                                     out.println("<p>Product list is null.</p>");
                            } else if (products.isEmpty()) {
                                     out.println("<p>Product list is empty.</p>");
                             } else {
                          for (Product product : products) {
                 %>
                <li>
                    <%
                    String imgPath = product.getImg();
                    String imgSrc = (imgPath == null || imgPath.trim().isEmpty()) ? "assets/images/pictureplaceholder.jpg" : imgPath;
                %>
                <a href="Prodotto?id=<%= product.getId() %>">
                    <img src="<%= imgSrc %>" alt="<%= product.getNomeVnl()%>">
                </a>
                <a href="Prodotto?id=<%= product.getId() %>">
                    <strong><%= product.getNomeVnl() %></strong>
                </a>- &euro;<%= product.getPrezzo() %>
                </li>
    <%
            }
        }
    %>
                            
                    </ul>
                </div>


            </div>
    </div>

    
    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
