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
  <title>Admin</title>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">

  <h1>Admin</h1>

  <div class="gestione">
    <a href="AggiuntaArticolo">Add Product</a>
    <a href="ModificaArticolo">Update Product</a>
    <a href="GestisciOrdini">Manage Orders</a>
  </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
