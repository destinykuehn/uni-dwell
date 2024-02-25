package controllers;

/* Handle Listing information */

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@WebServlet("/ListingServlet")
public class ListingServlet extends HttpServlet {
    /* Exception logger */
    private static final Logger logger = Logger.getLogger(IndexServlet.class.getName());

    public ListingServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.printf("Hello from %s%n", this.getClass().getName());

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

}
