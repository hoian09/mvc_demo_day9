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

    <div class="container" style="margin-top: 60px;">
            <h2>Please fill information</h2>
            <form action="Orders" method="post" modelAttribute="orders">
                <div class="mb-3">
                    <label for="customerName" class="form-label">Customer Name (*)</label>
                    <input type="text" class="form-control" id="customerName" name="customerName" required placeholder="Customer Name">
                </div>
                <div class="mb-3">
                    <label for="customerAddress" class="form-label">Customer Address (*)</label>
                    <input type="text" class="form-control" id="customerAddress" name="customerAddress" required placeholder="Customer Address">
                </div>
                <button type="submit" class="btn btn-primary">Continue</button>
            </mvc:form>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>