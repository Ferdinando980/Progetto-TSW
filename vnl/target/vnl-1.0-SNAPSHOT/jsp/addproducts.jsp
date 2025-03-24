<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.HashMap" %>
<%
  HashMap<String, String> userData = (HashMap<String, String>) session.getAttribute("UserData");
    boolean isLoggedIn = (userData != null && "true".equals(userData.get("IsLogged")));
    boolean isAdmin = isLoggedIn && ("admin").equals(userData.get("tipo"));
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/styles.css">
  <link rel="stylesheet" href="./css/addproduct.css">
 
    <title>Aggiungi Prodotto</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
<div class="mainpage">
    <h2>Aggiungi un nuovo Prodotto</h2>


    <form action="AddProduct" id="addproductform" method="post" enctype="multipart/form-data">

        
        <label for="nomeVnl">Nome Album/Modello Giradischi:</label>
        <input type="text" id="nomeVnl" name="nomeVnl">
        

        <label for="artista">Artista:</label>
        <input type="text" id="artista" name="artista">

        <label for="genere">Genere:</label>
        <input type="text" id="genere" name="genere">


        <label for="tipo">Tipo di Prodotto:</label>
        <select id="tipo" name="tipo" required>
            <option value="">Seleziona Tipo</option>
            <option value="giradischi">Giradischi</option>
            <option value="vinile">Vinile</option>
            <option value="cd">CD</option>
        </select>
        
        <label for="prezzo">Prezzo:</label>
        <input type="number" id="prezzo" name="prezzo" step="0.01" required>

        <label for="descrizione">Descrizione:</label>
        <textarea name="descrizione" id="descrizione" required></textarea>

        <label for="condizione">Condizione:</label>
            <select id="condizione" name="condizione" required>
            <option value="">Seleziona Condizione</option>
            <option value="Nuovo">Nuovo</option>
            <option value="Usato">Usato</option>
         
        </select>

        <label for="marca">Marca:</label>
        <input type="text" id="marca" name="marca">
        
        <div id="drop-area">
        <p>Trascina un immagine qui</p>
        <label for="fileElem" role="button" tabindex="0" aria-label="Carica un'immagine">Carica file</label>
        <input type="file" id="fileElem" name="img" accept="image/*" onchange="handleFiles(this.files)" aria-label="Carica un file immagine" tabindex="0">
        <div id="preview" name="img-preview"></div>
        </div>



    

        <button type="submit">Aggiungi Prodotto</button>
    </form>
    </div>

        <script src="script/drag&drop.js"></script>

       <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
