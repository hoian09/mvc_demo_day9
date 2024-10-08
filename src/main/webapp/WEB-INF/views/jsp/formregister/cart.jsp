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
    <c:if test = "${not empty cartList}">
    <table class= "table table-bordered">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Unit Price</th>
        <th>Quantity</th>
        <th></th>

    </tr>
    </thead>
    <tbody>
        <c:forEach var = "item" items = "${cartList}" varStatus = "index">

    <tr>
         <td>${item.product.id}</td>
         <td>${item.product.productName}</td>
         <td>${item.product.productDescription}</td>
         <td>${item.product.unitPrice}$</td>
         <td>${item.quantity}</td>
         <td>
         <button class = "btn btn-sm btn-danger" onclick = "location.href = '/removeItem/${item.product.id}'">Remove from cart</button>
         </td>
    </tr>
         </c:forEach>
         </tbody>
         </table>
         </c:if>
        <div class="text-center my-3">
           <button class="btn btn-sm btn-primary" onclick="location.href='/checkOut'">Check out</button>
        </div>
         <c:if test = "${cartList.size() == 0}">
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