<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.javabeans.Product" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/sidebar.css">
  <link rel="stylesheet" href="./css/styles.css">
  <link rel="stylesheet" href="./css/productDetails.css">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
</head>

<body>

        <jsp:include page="header.jsp"></jsp:include>
    
        <div class="page-container">
                <jsp:include page="sidebar.jsp"></jsp:include>
                <div class="mainpage">

    
                    <div class="product-container">
                        <%
                        Product product = (Product) request.getAttribute("product");
                        if (product != null) {
                    %>

                        <div class="product-image">
                            <%
                            String imgPath = product.getImg();
                            String imgSrc = (imgPath == null || imgPath.trim().isEmpty()) ? "assets/images/pictureplaceholder.jpg" : imgPath;
                        %>
                            
                        <img src="<%= imgSrc %>">
                        </div>
                        <div class="product-details">
                        <h1> <%= product.getNomeVnl() %></h1>

                        
                        <p><strong>ID:</strong> <%= product.getId() %></p>
                        <p><strong>Price:</strong> $<%= product.getPrezzo() %></p>
                        <p><strong>Description:</strong> <%= product.getDescrizione() %></p>
                        <p><strong>Condition:</strong> <%= product.getCondizione() %></p>
         
            
                        <%
                            String tipo = product.getTipo();
                            if ("vinile".equals(tipo)||"cd".equals(tipo)) {
                        %>
            
                            <p><strong>Artista:</strong> <%= product.getArtista() %></p>
                            <p><strong>Genere:</strong> <%= product.getGenere() %></p>
                        <%
                            } else if ("giradischi".equals(tipo)) { 
                        %>
                            <p><strong>Marca:</strong> <%= product.getMarca() %></p>
                        
            
                    <%
                        } else {
                    %>
                        <p>Prodotto non trovato.</p>
                    <%
                        }
                    }
                    %>
                </div>
                    </div>
    
                </div>
        </div>
    
        <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
