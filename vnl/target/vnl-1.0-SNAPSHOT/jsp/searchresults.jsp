<%@ page import="java.util.List" %>
<%@ page import="model.javabeans.Product" %>
<%@ page import="model.javabeans.Users" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/product.css">
  
  
    <title>Risultati Ricerca</title>
</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>

    <div class="page-container">
        <jsp:include page="sidebar.jsp"></jsp:include>

        <div class="mainpage">
            <% 
                String keyword = (String) request.getAttribute("keyword");

                if (keyword == null || keyword.trim().isEmpty()) {
                    out.println("<h2>Inserisci una parola chiave</h2>");
                } else {
            %>

            <h2>Risultati per: "<%= keyword %>"</h2>

            <div class="Product-list">
                <ul>
                    <%
                        List<Product> searchResults = (List<Product>) request.getAttribute("searchResults");
                        if (searchResults == null) {
                            out.println("<p>Search results are null.</p>");
                        } else if (searchResults.isEmpty()) {
                            out.println("<p>Non ci sono risultati.</p>");
                        } else {
                            for (Product product : searchResults) {
                    %>
                    <li>
                        <%
                            String imgPath = product.getImg();
                            String imgSrc = (imgPath == null || imgPath.trim().isEmpty()) ? "assets/images/pictureplaceholder.jpg" : imgPath;
                        %>
                        <a href="Prodotto?id=<%= product.getId() %>">
                            <img src="<%= imgSrc %>" alt="<%=product.getNomeVnl()%>">
                        </a>
                        <a href="Prodotto?id=<%= product.getId() %>" aria-label="Visualizza dettagli di <%= product.getNomeVnl() %>">
                            <strong><%= product.getNomeVnl() %></strong>
                        </a> - &euro;<%= product.getPrezzo() %>
                    </li>
                    <%
                            }
                        }
                    %>
                </ul>
            </div>

            <% } %>

        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
