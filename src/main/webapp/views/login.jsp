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
<!-- sign up form -->
<div id="sign-up-container">

    <!-- left side: sign up -->
    <div id="sign-up-left" class="col-size">
        <div class="logo flex-row">
            <img src="images/uni-dwell-tmp-logo.png">
<%--            <p>Uni Dwell</p>--%>
        </div>
        <div class="flex-col">
            <p>Welcome to</p>
            <h2>Uni Dwell</h2>
        </div>
        <form autocomplete="off" class="flex-col" action="AccountServlet" method="POST">
            <div class="flex-col">
                <p class="label">Email</p>
                <input type="email" name="sign-up-email" required>
            </div>
            <div class="flex-col">
                <p class="label">Password</p>
                <input type="password" name="sign-up-password" required>
            </div>
            <div class="remember-forget flex-row">
                <label>
                    <input type="checkbox">
                    <span class="c1"></span>
                    Remember me
                </label>
                <a href="#">Forgot Password?</a>
            </div>
            <input type="submit" value="SIGN UP">
        </form>
        <p class="center">Already have an account? <a href="#">Log in</a></p>
        <div class="flex-row help-links">
            <p class="center"><a href="#">FAQ</a> | <a href="#">Features</a> | <a href="#">Support</a></p>
        </div>
    </div>

    <!-- right side: about blurb -->
    <div id="sign-up-right" class="col-size">
        <h4>About Uni Dwell</h4>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
            enim ad minim veniam, quis nostrud exercitation ullamco laboris
            nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
            reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
            pariatur.</p>
        <p class="about-link">Want to learn more? Visit our <a href="about.jsp">about</a> page.</p>
        <h4 class="second">Features</h4>
        <ul>
            <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit</li>
            <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit</li>
            <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit</li>
        </ul>
    </div>
</div>

<div id="theme-container"
     onmouseenter="themeHover()"
     onmouseleave="themeLeft()"
     onclick="changeTheme()">
    <i class="fa-solid fa-lightbulb" id="light"></i>
    <i class="fa-solid fa-moon" id="dark"></i>
</div>


<script>
    function changeTheme() {

    }

    function themeHover() {
        let lightEle = document.getElementById("light");
        let darkEle = document.getElementById("dark");
        let color = "#003e9f";

        lightEle.style.display !== "none" ? lightEle.style.color = color : darkEle.style.color = color;
    }

    function themeLeft() {
        let lightEle = document.getElementById("light");
        let darkEle = document.getElementById("dark");
        let color = "black";

        lightEle.style.display !== "none" ? lightEle.style.color = color : darkEle.style.color = color;
    }
</script>
</body>
</html>
