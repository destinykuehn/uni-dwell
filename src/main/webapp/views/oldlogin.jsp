<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- styles -->
    <link rel="stylesheet" href="../stylesheets/global.css">
    <link rel="stylesheet" href="../stylesheets/login.css">
    <!-- icons -->
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
    <title>MinerDwellings: Log In</title>
</head>
<body>

    <div class="wrapper">
        <!-- user tabs -->
        <div class="tab-container">
            <button onclick="switchUser('student')"
                    id="student-button">Student</button>
            <button onclick="switchUser('host')"
                    id="host-button">Host</button>
        </div>
        <div class="container">
            <!-- student content -->
            <div id="student-container">
                <!-- student sign in -->
                <div class="student-sign-in-container">
                    <h3>Welcome back,<br>Miner!</br></h3>
                    <p>Please sign in with your banweb credentials.</p>
                    <input type="text" placeholder="900#" maxlength="10" required>
                    <input type="password" placeholder="Password" required>
                    <a href="#">Forgot your password?</a>
                    <button class="submit-btn">Sign In</button>
                </div>
                <!-- student sign up -->
                <div class="student-sign-up-container">
                    <div>
                        <h3>First time here?</h3>
                        <p>Don't worry &mdash; sign up and find your oasis</p><a onclick="switchDivs('student', 'to-left')">now.</a>
                    </div>
                </div>
                <!-- switch if on mobile -->
                <div id="student-mobile-switch"></div>
            </div>
            <!-- host content -->
            <div id="host-container">
                <!-- host sign up -->
                <div class="host-sign-up-container">
                    <div>
                        <h3>Not a host with<br>us yet?</br></h3>
                        <p>Gain visibility and attract the right tenants by signing up</p><a onclick="switchDivs('host', 'to-right')">here.</a>
                    </div>
                </div>
                <!-- host sign in -->
                <div class="host-sign-in-container">
                    <h3>Sign In</h3>
                    <div class="sign-in-with">
                        <i class="fa-brands fa-google"></i>
                        <i class="fa-brands fa-meta"></i>
                        <i class="fa-brands fa-linkedin"></i>
                    </div>
                    <div class="or">
                        <div class="line"></div>
                        <p>Or</p>
                    </div>
                    <input type="email" placeholder="Email" maxlength="20" required>
                    <input type="password" placeholder="Password" maxlength="10" required>
                    <a href="#">Forgot your password?</a>
                    <button class="submit-btn">Sign In</button>
                </div>
                <!-- switch if on mobile -->
                <div id="host-mobile-switch"></div>
            </div>
        </div>
    </div>




<%--<h2>Hello World!</h2>--%>
<%--<form action="MyServlet" method="get">--%>
<%--    <input type="submit" value="Enter">--%>
<%--</form>--%>

    <script src="../js/login.js"></script>
</body>
</html>
