<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Shop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="register.css">
</head>

<body>
<div class="login-dark">
    <form action="shop" method="post" class="js-form">
        <h2 class="sr-only">Login Form</h2>
        <input type="hidden" name="command" value="register"/>
        <div class="illustration"><i class="icon ion-ios-locked-outline"></i></div>
        <div class="form-group">
            <input class="form-control js-input-email" name="mail" placeholder="Enter email">
        </div>
        <div class="form-group">
            <input class="form-control js-input-name" name="name" placeholder="Enter name">
        </div>
        <div class="form-group">
            <input class="form-control js-input-surname" name="surname" placeholder="Enter surname">
        </div>
        <div class="form-group">
            <input class="form-control js-input-password" type="password" name="password" placeholder="Enter password">
        </div>
        <div class="form-group">
            <input class="form-control js-input-repeatPassword" name="repeatPassword" placeholder="Confirm password">
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit">Submit and log in</button>
        </div>
    </form>
</div>
<script src="script.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>

</html>
