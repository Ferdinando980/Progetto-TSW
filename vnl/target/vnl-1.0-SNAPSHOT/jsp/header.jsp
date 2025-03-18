<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.HashMap" %>
<%
  HashMap<String, String> userData = null;
  String Tipo = "default"; 

  if (session != null) {
      userData = (HashMap<String, String>) session.getAttribute("UserData");
      if (userData != null) {
          Tipo = userData.get("tipo"); 
  }
  }
  boolean isLoggedIn = (userData != null && "true".equals(userData.get("IsLogged")));
  boolean isAdmin = "admin".equals(Tipo); 
  
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <title>Header</title>
</head>

<body>
    <header class="header">
        <div class="logo">
            <img src="assets/images/Logo.png" alt="Logo">
        </div>

        <div class="search-container">
            <form action="">
                <input class="textbox" type="text" placeholder="Cerca.." name="search">
            </form>
        </div>

        <div class="RightSection">
            <div class="headerlinks">
                <a class="active" href="Homepage">Home</a>
                <a href="Homepage#info-grid">About</a>
                <a href="Contact">Contact Us</a>
            </div>
            <div class="profile-cart-section">
                <div class="HeaderCart">
                    <a href="Cart">
                        <img src="assets/images/cart.png" alt="Carrello">
                    </a>
                </div>
                     <div class="admin-check">
                    <% if (isAdmin) { %>
                        <button onclick="window.location.href='PageAdmin'">Pannello Admin</button>
                    <% } %>
                </div>
                     </div>
                <div class="profile" id="profile-section"></div>
            </div>
       
        </div>
    </header>

    <script>
        var isLoggedIn = <%= isLoggedIn ? "true" : "false" %>;
              var Tipo = "<%= Tipo %>";
    </script>

    <script type="text/javascript" src="script/ProfileChanger.js"></script>
</body>

</html>
