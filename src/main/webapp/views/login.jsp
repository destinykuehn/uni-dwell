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

<script>
    function switchForm(to) {
        const logIn = document.getElementById("log-in-form")
        const signUp = document.getElementById("sign-up-form");
        if (to === "sign-up") {
            logIn.style.transform = "translate(-50%, -200%)";
            signUp.style.transform = "translate(-50%, -50%)";
        }
        else {
            logIn.style.transform = "";
            signUp.style.transform = "";
        }
        clearInputs(document.getElementById("main-container"))
    }

    function clearInputs(container) {
        const children = container.children;
        for (let i = 0; i < children.length; i++) {
            const child = children[i];
            if (child.tagName === 'INPUT' && child.type !== 'submit') {
                child.value = '';
            }
            if (child.children.length > 0) {
                clearInputs(child);
            }
        }
    }

    function showPasswordHelp() {
        const pswdHelp = document.getElementById("password-help");
        pswdHelp.style.display = "block";
    }

    function hidePasswordHelp() {
        const pswdHelp = document.getElementById("password-help");
        pswdHelp.style.display = "";
    }

    function showPassword(which) {
        let id = (which === "sign-up-") ? "sign-up-password" : "log-in-password";
        const pswdEle = document.getElementById(id);
        pswdEle.type = 'text';

        document.getElementById(which + "eye-open").style.display = "none";
        document.getElementById(which + "eye-closed").style.display = "block";
    }

    function hidePassword(which) {
        let id = (which === "sign-up-") ? "sign-up-password" : "log-in-password";
        const pswdEle = document.getElementById(id);
        pswdEle.type = 'password';

        document.getElementById(which + "eye-open").style.display = "";
        document.getElementById(which + "eye-closed").style.display = "";
    }
</script>

</body>
</html>
