<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="shop.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="fontawesome/css/all.css">
    <link rel="stylesheet" href="header.css">
</head>
<body class="body">
<jsp:include page="header.jsp"/>
<div class="gallery">
    <c:forEach items="${requestScope.categories}" var="item">
        <div class="content">
            <img class="shopImg" src="${item.getImagepath()}">
            <h3>${item.getName()}</h3>
            <p>${item.getSometext()}</p>
            <form action="${pageContext.request.contextPath}/shop">
                <input type="hidden" name="command" value="category_redirect"/>
                <button class="buy-1" name="categoryid" value="${item.getId()}">Buy now</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>