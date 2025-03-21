<%@ page import="model.javabeans.Product" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/styles.css">
     <link rel="stylesheet" href="./css/modifyproduct.css">
    <title>Modifica Prodotto</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


    <div class="mainpage">
    <h2>Modifica Prodotto</h2>

    <form action="UpdateProduct" method="POST">

        <%
        Product product = (Product) request.getAttribute("product");
        %>

        <input type="hidden" name="id" value="<%= product.getId() %>">

        <div class="product-container">

          <div class="product-image">
                        <%
                            String imgPath = product.getImg();
                            String imgSrc = (imgPath == null || imgPath.trim().isEmpty()) ? "assets/images/pictureplaceholder.jpg" : imgPath;
                        %>
                            
                        <img src="<%= imgSrc %>">
            </div>
        <div class="product-details">

        <div>
        <label for="nomeVnl">Nome:</label>
        <input type="text" id="nomeVnl" name="nomeVnl" value="<%= product.getNomeVnl() %>" required />
        </div>
        
        <div name="prezzoclass">
        <label for="prezzo">Prezzo:</label>
        <input type="number" id="prezzo" name="prezzo" value="<%= product.getPrezzo() %>" required />
        </div>


        <div>
        <label for="descrizione">Descrizione:</label>
        <textarea id="descrizione" name="descrizione" required><%= product.getDescrizione() %></textarea>
        </div>

        <% 
            if(product.getTipo().equals("giradischi")){

                %>
                    <div>
                 <label for="marca">Marca:</label>
                 <textarea id="marca" name="marca" required><%= product.getMarca() %></textarea>
                 </div>

                <%
            }
            %>

        <div name="condizioneclass">
        <label for="condizione">Condizione:</label>
            <select id="condizione" name="condizione" required>
            <option value="<%= product.getCondizione() %>"><%= product.getCondizione() %></option>
            <option value="Nuovo">Nuovo</option>
            <option value="Usato">Usato</option>
            </select>
        </div>

        <button type="submit">Aggiorna Prodotto</button>
        </div>
        </div>
    </form>
    </div>
   <jsp:include page="footer.jsp"></jsp:include>
 
</body>
</html>