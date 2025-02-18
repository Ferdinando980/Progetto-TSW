<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.HashMap" %>
<%
  HashMap<String, String> userData = (HashMap<String, String>) session.getAttribute("UserData");
    boolean isLoggedIn = (userData != null && "true".equals(userData.get("IsLogged")));
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
</head>

<body>
    <header class="header">


        <div class="logo">
            <img src="assets/images/Logo.png" alt="Logo">
        </div>
        <div class="headerlinks">
            <a class="active" href="Homepage">Home</a>
            <a href="Homepage#info-grid" >About</a>
            <a href="Contact">Contact Us</a>
        </div>

        <div class="RightSection">
            <div class="search-container">
                <form action="">
                    <input class="textbox" type="text" placeholder="Cerca.." name="search">
                </form>
            </div>
            <div class="HeaderCart">
                <a href="Cart">
                    <img src="assets/images/cart.png"  alt="Carrello">
                </a>
            </div>
            <div class="profile" id= "profile-section">

            </div>
        </div>

    </header>

    <script>
    var isLoggedIn = <%= isLoggedIn %>;
    </script>

        <script type="text/javascript" src="script/ProfileChanger.js"></script>
</body>


</html>