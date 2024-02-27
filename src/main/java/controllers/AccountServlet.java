package controllers;

import BCrypt_Hasher.Hasher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {

    /* Exception logger */
    private static final Logger logger = Logger.getLogger(IndexServlet.class.getName());

    public AccountServlet() {
        super();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.printf("Hello from %s%n", this.getClass().getName());
            if (req.getParameter("sign-up-email") != null && req.getParameter("sign-up-password") != null) {
                handleSignUp(req);
            } else if (req.getParameter("sign-in-email") != null && req.getParameter("sign-in-password") != null) {
                handleSignIn(req);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        /* Log the error message */
        logger.severe("An error occurred: " + e.getMessage());
        /* Log the stack trace */
        logger.throwing(ExampleServlet.class.getName(), "methodName", e);
    }

    private void handleSignIn(HttpServletRequest req) {

    }

    private int handleSignUp(HttpServletRequest req) {
        String sign_up_email = req.getParameter("sign-up-email");
        String sign_up_pass = req.getParameter("sign-up-password");
//        System.out.printf("%s\n", sign_up_email);
//        System.out.printf("%s\n", Hasher.hash(sign_up_pass));
        if (!checkPasswordValid(sign_up_pass)) {
            return 1;
        }
        String hash_pw = Hasher.hash(sign_up_pass);
        if (isUserInDB(sign_up_email, sign_up_pass) == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        return 0;
    }

    private boolean checkPasswordValid(String password) {
        return (containsDigit(password) && containsSpecial(password) && containsUpper(password));
    }

    private boolean containsDigit(String pw) {
        Pattern pattern_digit = Pattern.compile(".*\\d.*");
        Matcher matcher_digit = pattern_digit.matcher(pw);
        if (matcher_digit.find()) {
            System.out.println("The string contains a number.");
        } else {
            System.out.println("The string does not contain a number.");
            return false;
        }
        return true;
    }

    private boolean containsSpecial(String pw) {
        Pattern pattern_special = Pattern.compile("[^a-zA-Z0-9\\s]");
        Matcher matcher_special = pattern_special.matcher(pw);
        if (matcher_special.find()) {
            System.out.println("The string contains special char");
        } else {
            System.out.println("The string does not contain special char");
            return false;
        }
        return true;
    }

    private boolean containsUpper(String pw) {
        boolean upper = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isUpperCase(c)){
                System.out.println("Contains uppercase");
                upper = true;
                break;
            }
        }
        return upper;
    }

    private int isUserInDB(String user, String ps) {
        return DatabaseServlet.accessDatabase("admin", "Users", "email", user, "find");
    }
}
