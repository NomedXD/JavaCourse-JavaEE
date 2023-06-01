<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="category.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="fontawesome/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="header.css">
</head>
<body class="body">
<jsp:include page="header.jsp"/>
<c:forEach items="${requestScope.products}" var="product">
    <div class="row p-2 bg-white border rounded mt-2">
        <div class="col-md-3 mt-1"><img class="img-fluid img-responsive rounded product-image"
                                        src="${product.getImagepath()}"></div>
        <div class="col-md-6 mt-1">
            <h5>${product.getName()}</h5>
            <div class="d-flex flex-row">
                <div class="ratings mr-2"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i
                        class="fa fa-star"></i></div>
                <span>310</span>
            </div>
            <p class="text-justify text-truncate para mb-0">${product.getDescription()}<br><br></p>
        </div>
        <div class="align-items-center align-content-center col-md-3 border-left mt-1">
            <div class="d-flex flex-row align-items-center">
                <h4 class="mr-1">$14.99</h4>
            </div>
            <h6 class="text-success">Available</h6>
            <div class="d-flex flex-column mt-4">
                <button class="btn btn-primary btn-sm" type="button">More info</button>
                <button class="btn btn-outline-primary btn-sm mt-2" type="button">Add to wishlist</button>
            </div>
        </div>
    </div>
</c:forEach>

</body>
</html>
