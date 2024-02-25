package controllers;

/* Set College of session */

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Logger;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    /* Exception logger */
    private static final Logger logger = Logger.getLogger(IndexServlet.class.getName());

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String college = req.getParameter("college");

            /* check college is in database */
            int result = verifyCollege(college);

            /* handle redirect */
            HttpSession session = req.getSession(true);
            String c = (result == 0) ? college : "N/A";
            session.setAttribute("college", c);
            String page = (c.equals(college)) ? "home.jsp" : "index.jsp";
            resp.sendRedirect(page);
        }
        catch (Exception e) {
            handleException(e);
        }
    }

    private int verifyCollege(String college) {
        try {
            return DatabaseServlet.accessDatabase(
                    "selectcollege",
                    "Colleges",
                    "collegeName",
                    college,
                    "find"
            );
        }
        catch (Exception e) {
            handleException(e);
            return 1;
        }
    }

    private void handleException(Exception e) {
        /* Log the error message */
        logger.severe("An error occurred: " + e.getMessage());
        /* Log the stack trace */
        logger.throwing(ExampleServlet.class.getName(), "methodName", e);
    }
}
