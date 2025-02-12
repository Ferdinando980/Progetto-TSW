<%--
  Created by IntelliJ IDEA.
  User: cerus
  Date: 11/02/2025
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/sidebar.css">
  <link rel="stylesheet" href="./css/styles.css">
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
                        <h1>Product Details</h1>
                        
                        <p><strong>ID:</strong> <%= product.getId() %></p>
                        <p><strong>Price:</strong> $<%= product.getPrezzo() %></p>
                        <p><strong>Description:</strong> <%= product.getDescrizione() %></p>
                        <p><strong>Condition:</strong> <%= product.getCondizione() %></p>
            
                        <%
                            // Handle different product types
                            String tipo = product.getTipo();
                            if ("vinile".equals(tipo)||"cd".equals(tipo)) {
                        %>
                            <p><strong>Nome Album:</strong> <%= product.getNomeVnl() %></p>
                            <p><strong>Artista:</strong> <%= product.getArtista() %></p>
                            <p><strong>Genere:</strong> <%= product.getGenere() %></p>
                        <%
                            } else if ("giradischi".equals(tipo)) { 
                        %>
                            <p><strong>Marca:</strong> <%= product.getMarca() %></p>
                            <p><strong>Modello:</strong> <%= product.getModello() %></p>
            
                    <%
                        } else {
                    %>
                        <p>Prodotto non trovato.</p>
                    <%
                        }
                    %>
                    </div>
    
                </div>
        </div>
    
        
        <jsp:include page="footer.jsp"></jsp:include>
    
<script>
    const prodotti = document.getElementById("prodotti");

    const container = document.getElementById("product-container");
    const cartItems = document.getElementById("cart-items");
    let cart = [];

    function renderProducts(products) {
        container.innerHTML = "";
        products.forEach(prodotto => {
            const div = document.createElement("div");
            div.classList.add("product");
            div.innerHTML = `
                    <img src="${prodotto.immagine}" alt="${prodotto.nome}">
                    <h3>${prodotto.nome}</h3>
                    <p>Prezzo: ${prodotto.prezzo}</p>
                    <button onclick="addToCart('${prodotto.nome}', '${prodotto.prezzo}')">Aggiungi al carrello</button>
                `;
            container.appendChild(div);
        });
    }

    function filterProducts() {
        const search = document.getElementById("filter").value.toLowerCase();
        const filtered = prodotti.filter(p => p.nome.toLowerCase().includes(search));
        renderProducts(filtered);
    }

    function addToCart(nome, prezzo) {
        cart.push({ nome, prezzo });
        updateCart();
    }

    function updateCart() {
        cartItems.innerHTML = "";
        cart.forEach(item => {
            const li = document.createElement("li");
            li.textContent = `${item.nome} - ${item.prezzo}`;
            cartItems.appendChild(li);
        });
    }

    renderProducts(prodotti);
</script>
</body>
</html>
