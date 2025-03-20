<%--
  Created by IntelliJ IDEA.
  User: cerus
  Date: 20/03/2025
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/error.css">
    <title>Redirect</title>
</head>
<body>

<jsp:include page="../jsp/header.jsp"></jsp:include>

<div class="container">
    <div class="fieldset">
        <div class="biglabel">
            <h1>Error 404</h1>
        </div>
        <div class="error">
            <h2>La pagina richiesta non è stata trovata</h2>
        </div>
    </div>
</div>

<jsp:include page="../jsp/footer.jsp"></jsp:include>

</body>
</html>
