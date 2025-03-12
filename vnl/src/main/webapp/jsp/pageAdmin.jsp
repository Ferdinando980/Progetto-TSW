<%--
  Created by IntelliJ IDEA.
  User: cerus
  Date: 07/03/2025
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="./css/styles.css">
  <link rel="stylesheet" href="./css/pageAdmin.css">
  <title>Admin</title>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">

  <div class="gestione">
    <h1>Admin</h1>
    <a href="AggiuntaArticolo">Add Product</a>
    <a href="ModificaArticolo">Update Product</a>
    <a href="GestisciOrdini">Manage Orders</a>
  </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
