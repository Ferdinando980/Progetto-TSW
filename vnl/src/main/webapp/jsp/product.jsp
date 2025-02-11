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
