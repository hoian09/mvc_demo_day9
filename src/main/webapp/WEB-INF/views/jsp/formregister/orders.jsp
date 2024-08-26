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
<div class="container" style="margin-top: 20px;">
        <h2>My Orders List</h2>
        <c:if test="${empty orderList}">
            <p>Your order is empty.</p>
        </c:if>
        <c:if test="${not empty orderList}">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Customer Name</th>
                    <th>Customer Address</th>
                    <th>Orders Detail</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orderList}">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.customerName}</td>
                        <td>${order.customerAddress}</td>
                        <td>
                        <button class="btn btn-success" onclick="location.href='/orderDetails/${order.id}'">View Details</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
         </body>
         </html>