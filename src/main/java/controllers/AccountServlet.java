package controllers;

import BCrypt_Hasher.Hasher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Users.User;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {

    /* Exception logger */
    private static final Logger logger = Logger.getLogger(IndexServlet.class.getName());

    private static boolean verbose = true;

    public AccountServlet() {
        super();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.printf("Hello from %s%n", this.getClass().getName());
            if (req.getParameter("sign-up-email") != null && req.getParameter("sign-up-password") != null) {
                if (verbose) System.out.println("Sign up attempted");
                int res = handleSignUp(req, resp);
                if (res != 0) System.out.println("Rejected sign up");
            } else if (req.getParameter("sign-in-email") != null && req.getParameter("sign-in-password") != null) {
                if (verbose) System.out.println("Sign in attempted");
                int res = handleSignIn(req, resp);
                if (res != 0) System.out.println("Rejected sign in");
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

    private int handleSignIn(HttpServletRequest req, HttpServletResponse resp) {
        return 0;
    }

    private int handleSignUp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sign_up_email = req.getParameter("sign-up-email");
        String sign_up_pass = req.getParameter("sign-up-password");
        if (verbose) {
            System.out.printf("Email: %s\n", sign_up_email);
            System.out.printf("Pass: %s\n", sign_up_pass);
        }
        if (!checkPasswordValid(sign_up_pass)) {
            if (verbose) System.out.println("Invalid password. Rejecting sign up...");
            return 1;
        }
        if (!checkEmailValid(sign_up_email)) {
            if (verbose) System.out.println("Invalid email. Rejecting sign up...");
            return 1;
        }
        if (verbose) System.out.println("Valid email and password. Proceeding with sign in...");
        String hash_pw = Hasher.hash(sign_up_pass);
        if (isUserInDB(sign_up_email) == 0) {
            System.out.println("User in database");
        } else {
            System.out.println("User not in database");
        }
        createSession(req, resp);
        return 0;
    }

    private boolean checkEmailValid(String email) {
        Pattern pattern_email = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher_email = pattern_email.matcher(email);
        return matcher_email.matches();
    }

    private boolean checkPasswordValid(String password) {
        return (containsDigit(password) && containsSpecial(password)
                && containsUpper(password) && password.length() <= 20);
    }

    private boolean containsDigit(String pw) {
        Pattern pattern_digit = Pattern.compile(".*\\d.*");
        Matcher matcher_digit = pattern_digit.matcher(pw);
        if (!matcher_digit.find()) {
            if (verbose) System.out.println("The string does not contain a number.");
            return false;
        }
        if (verbose) System.out.println("The string does contain a number");
        return true;
    }

    private boolean containsSpecial(String pw) {
        Pattern pattern_special = Pattern.compile("[^a-zA-Z0-9\\s]");
        Matcher matcher_special = pattern_special.matcher(pw);
        if (!matcher_special.find()) {
            if (verbose) System.out.println("The string does not contain special char");
            return false;
        }
        if (verbose) System.out.println("The string contains a special char");
        return true;
    }

    private boolean containsUpper(String pw) {
        boolean upper = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isUpperCase(c)){
                if (verbose) System.out.println("String contains an uppercase");
                upper = true;
                break;
            }
        }
        if (verbose && !upper) System.out.println("String does not contain an uppercase");
        return upper;
    }

    private int isUserInDB(String email) {
        return DatabaseServlet.accessDatabase("admin", "Users", "email", email, "find");
    }

    private int insertUserIntoDB(String email, String pw) {
        return 0;
    }

    private void createSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("email", "placeholder");
        // placeholder
        resp.sendRedirect("account.jsp");
    }

    private boolean checkCredentials(String email, String pw) {
        String pwHash = Hasher.hash(pw);
        //DatabaseServlet.getUser()
        return true;
    }

    private void createUser() {

    }
}
