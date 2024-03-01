<form autocomplete="off" id="sign-up-form" action="AccountServlet" method="POST">
    <% if (request.getAttribute("invalidPassword") != null) { %>
        <p class="error span-3">The password did not meet the necessary standards. Please try again.</p>
    <%}%>
    <input type="hidden" name="userAction" value="signUp">
    <div class="span-3 message">
        <p>Welcome to</p>
        <h2>Uni Dwell</h2>
    </div>
    <div>
        <label>First Name</label>
        <input type="text" name="firstName" maxlength="20" required>
    </div>
    <div>
        <label>Last Name</label>
        <input type="text" name="lastName" maxlength="20" required>
    </div>
    <div class="role">
        <label>Role</label>
        <select name="role">
            <option value="host">Host</option>
            <option value="student">Student</option>
        </select>
    </div>
    <div class="span-3">
        <label>Email</label>
        <input type="email" name="email" maxlength="30" required>
    </div>
    <div class="span-3 password">
        <div id="password-help">
            <p> Passwords must have at least:</p>
            <ul>
                <li>1 uppercase</li>
                <li>1 digit</li>
                <li>1 special character</li>
                <li>8-20 characters long</li>
            </ul>
        </div>
        <label>Password
            <i onmouseenter="showPasswordHelp()"
               onmouseleave="hidePasswordHelp()"
               class="fa-regular fa-circle-question"></i></label>
        <input id="sign-up-password" type="password" name="password" maxlength="20" required>
        <i id="sign-up-eye-closed"
           onclick="hidePassword('sign-up-')"
           class="fa-solid fa-eye"></i>
        <i id="sign-up-eye-open"
           onclick="showPassword('sign-up-')"
           class="fa-solid fa-eye-slash"></i>
    </div>
    <label class="span-3 check"><input type="checkbox">Remember me</label>
    <input class="span-3" type="submit" value="SIGN UP">
    <label class="span-3 switch">Already have an account? <a onclick="switchForm('log-in')">Log in</a></label>
</form>