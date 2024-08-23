<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page contentType = "text/html;charset = UTF-8" language = "java" %>
<html>
<head>
<title>Checkout</title>
<link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
<script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<jsp:include page= "header.jsp"/>
<html>
<body>
    <h1>Checkout</h1>
    <form action="processCheckout" method="post">
        <input type="text" name="customerName" placeholder="Your Name" required/>
        <input type="text" name="customerAddress" placeholder="Your Address" required/>
        <button type="submit">Place Order</button>
    </form>
</body>
</html>