<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uni Dwell: Login</title>
</head>
<body>
<p>Log In</p>
<form autocomplete="off" action="AccountServlet" method="POST">
    <div>
        <input type="hidden" name="which" value="log-in">
        <input type="text" name="email" placeholder="Enter email...">
        <input type="text" name="password" placeholder="Enter password...">
    </div>
    <input type="submit" value="Login">
</form>

<p>Sign Up</p>
<form autocomplete="off" action="AccountServlet" method="POST">
    <div>
        <input type="hidden" name="which" value="sign-up">
        <input type="text" name="email" placeholder="Enter email...">
        <input type="text" name="password" placeholder="Enter password...">
    </div>
    <input type="submit" value="Sign Up">
</form>

</body>
</html>
