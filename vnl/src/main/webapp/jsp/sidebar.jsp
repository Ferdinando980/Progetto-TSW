<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/sidebar.css">
  <link rel="stylesheet" href="./css/styles.css">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
  <title>SideBar</title>
</head>

<body>

  <div class="sidenav">
    <button class="dropdown-btn">Vinili
    </button>
    <div class="dropdown-container">
    <a href="FilterProduct?tipo=vinile&condizione=nuovo">Nuovo</a>
    <a href="FilterProduct?tipo=vinile&condizione=usato">Usato</a>
    </div>
    <button class="dropdown-btn">Giradischi
    </button>
    <div class="dropdown-container">
    <a href="FilterProduct?tipo=giradischi&condizione=nuovo">Nuovo</a>
    <a href="FilterProduct?tipo=giradischi&condizione=usato">Usato</a>
    </div>
    <button class="dropdown-btn">Compact Disc
    </button>
    <div class="dropdown-container">
    <a href="FilterProduct?tipo=cd&condizione=nuovo">Nuovo</a>
    <a href="FilterProduct?tipo=cd&condizione=usato">Usato</a>
    </div>


  </div>
  <script src="script/sidebar.js"></script>


</body>
</html>