<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/prodotti.css">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <title>Giradischi</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="product_container">
    <h1>Catalogo Giradischi</h1>
    <jsp:include page="product.jsp"></jsp:include>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
