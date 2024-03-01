<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/login.css">
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
    <title>Uni Dwell: Login</title>
</head>
<body>
    <div id="main-container" class="container">
        <div class="form-container">
            <jsp:include page="components/log-in-form.jsp"/>
            <jsp:include page="components/sign-up-form.jsp"/>
            <div class="help-links">
                <a href="#">About</a>
                <a href="#">Features</a>
                <a href="#">Contact</a>
            </div>
        </div>
    </div>
    <jsp:include page="components/light-dark-theme-div.jsp"/>
    <script src="js/global.js"></script>
    <script src="js/login.js"></script>
</body>
</html>
