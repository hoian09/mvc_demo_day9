<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page contentType = "text/html;charset = UTF-8" language = "java" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
<script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<jsp:include page= "header.jsp"/>
<body>
<div class= "container" style = "margin-top: 60px;">
    </div>
    <div class = "col-xs-12 col-sm-12 col-md-10">
    <c:if test = "${not empty products}">
    <table class= "table table-bordered">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Unit Price</th>
        <th></th>
        <th></th>

    </tr>
    </thead>
    <tbody>
        <c:forEach var = "product" items = "${cart}" varStatus = "index">

    <tr>
         <td>${product.id}</td>
         <td>${product.productName}</td>
         <td>${product.productDescription}</td>
         <td>${product.unitPrice}$</td>
         <td>${product.Quantity}$</td>
         <td>/
         <button class = "btn btn-sm btn-primary" onclick = "location.href = 'edit/${product.id}'">Remove from cart</button>
         </td>
    </tr>
         </c:forEach>
         </tbody>
         </table>
         </c:if>
         <c:if test = "${cart.size() == 0}">
         <br>
         <div class = "alert alert-warning">
         There is no data
         </div>
         </c:if>
         </div>
         </div>
         </div>
         <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
         <script src = "/wedjars/bootstrap/5.1.3/bootstrap.min.js"></script>
         </body>
         </html>














<c:forEach var="item" items="${cartList}">
    <div>
        <h3>${item.product.name}</h3>
        <p>Price: ${item.product.price}</p>
        <p>Quantity: ${item.quantity}</p>

    </div>
</c:forEach>
<form action="checkout" method="get">
    <button type="submit">Checkout</button>
</form>