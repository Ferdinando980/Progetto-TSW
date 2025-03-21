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

        <div id="NomeAlbumModello" name="nome">
        <label>Nome Album/Modello Giradischi:</label>
            <input type="text" name="nomeVnl">
        </div>

        <label>Artista:</label>
        <input type="text" name="artista">

        <label>Genere:</label>
        <input type="text" name="genere">


        <label>Tipo di Prodotto:</label>
        <select id="tipo" name="tipo" required>
            <option value="">Seleziona Tipo</option>
            <option value="giradischi">Giradischi</option>
            <option value="vinile">Vinile</option>
            <option value="cd">CD</option>
        </select>
        
        <label>Prezzo:</label>
        <input type="number" name="prezzo" step="0.01" required>

        <label>Descrizione:</label>
        <textarea name="descrizione" required></textarea>

        <label>Condizione:</label>
            <select id="condizione" name="condizione" required>
            <option value="">Seleziona Condizione</option>
            <option value="Nuovo">Nuovo</option>
            <option value="Usato">Usato</option>
         
        </select>

        <label>Marca:</label>
        <input type="text" name="marca">
        
        <div id="drop-area">
        <p>Trascina un immagine qui</p>
        <label for="fileElem">browse</label>
        <input type="file" id="fileElem" name="img" accept="image/*" onchange="handleFiles(this.files)">
        <div id="preview" name="img-preview"></div>
        </div>



    

        <button type="submit">Aggiungi Prodotto</button>
    </form>
    </div>

        <script src="script/drag&drop.js"></script>

       <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
