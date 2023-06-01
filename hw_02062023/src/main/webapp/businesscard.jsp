<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<!-- служебная часть -->

<head>
    <!-- заголовок страницы -->
    <title>Матошко Иван - просто человек</title>
    <!-- настраиваем служебную информацию для браузеров -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- загружаем Бутстрап -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- закрываем служебную часть страницы -->
    <link rel="stylesheet" href="businesscard.css">
</head>

<body>
<div class="container">
    <div class="col-12">
        <h1>Матошко Иван</h1>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
            <p>${requestScope.info}</p>
            <p>${requestScope.maininfo}</p>
        </div>
        <div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
            <img src="${requestScope.imgpath}"> <!-- pageContext.request.contextPath-->
        </div>
    </div>
</div>
</body>
<!-- конец всей страницы -->

</html>