package controllers;

import BCrypt_Hasher.Hasher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
            if (req.getParameter("sign-up-email") == null || req.getParameter("sign-up-password") == null){

            } else if (req.getParameter("sign-in-email") == null || req.getParameter("sign-in-password") == null) {
                String sign_up_email = req.getParameter("sign-up-email");
                String sign_up_pass = req.getParameter("sign-up-password");
                System.out.printf("%s\n", sign_up_email);
                System.out.printf("%s\n", Hasher.hash(sign_up_pass));
                checkPasswordValid(sign_up_pass);
            }
        }
        catch (Exception e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        /* Log the error message */
        logger.severe("An error occurred: " + e.getMessage());
        /* Log the stack trace */
        logger.throwing(ExampleServlet.class.getName(), "methodName", e);
    }

    private boolean checkPasswordValid(String password){
        Pattern pattern = Pattern.compile("0123456789");

        // Matcher to find matches in the input string
        Matcher matcher = pattern.matcher(password);

        // Check if the input string contains any digit
        if (matcher.find()) {
            System.out.println("The string contains a number.");
        } else {
            System.out.println("The string does not contain a number.");
        }
        return true;
    }
}
