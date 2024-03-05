<form autocomplete="off" id="log-in-form" action="AccountServlet" method="POST">
    <% if (request.getAttribute("loginError") != null) { %>
        <p class="error span-3">The email or password was incorrect.</p>
    <%}%>
    <input type="hidden" name="action" value="logIn">
    <div class="span-3 message">
        <p>Hey there!</p>
        <h2>Welcome Back</h2>
    </div>
    <div class="span-3">
        <label>Email</label>
        <input type="email" name="email" maxlength="30" required>
    </div>
    <div class="span-3 password">
        <label>Password</label>
        <input id="log-in-password" type="password" name="password" maxlength="20" required>
        <i id="log-in-eye-closed"
           onclick="hidePassword('log-in-')"
           class="fa-solid fa-eye"></i>
        <i id="log-in-eye-open"
           onclick="showPassword('log-in-')"
           class="fa-solid fa-eye-slash"></i>
    </div>
    <label class="span-3 check"><input type="checkbox">Remember me</label>
    <input class="span-3" type="submit" value="LOG IN">
    <label class="span-3 switch">Don't have an account? <a onclick="switchForm('sign-up')">Sign up</a></label>
</form>