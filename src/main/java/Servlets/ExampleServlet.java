package Servlets;

/*
    This is an example servlet to showcase the general format
    of servlets and what they can do. Namely, accessing the
    database, creating cookies/http sessions, redirecting or
    calling other servlets/java classes, and returning relevant
    information to html/jsp pages.
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.util.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/*
    The @WebServlet is necessary to label the file as a servlet.
    The string parameter is the name of the servlet, and is used
    to reference it in the html/jsp pages. The beginning "/"
    is necessary.
*/
@WebServlet("/ExampleServlet")
public class ExampleServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ExampleServlet.class.getName());

    public ExampleServlet(){
        super();
    }

    /*
        doGet is used for the retrieval/sending of NON-CONFIDENTIAL information, as
        the parameters passed to it through the HttpServletRequest are shown
        in the url.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String text = req.getParameter("messageContent");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<div class=\"message\">" + text + "<p></p></div>");
        }
    }

    /*
        doPost is used for the retrieval/sending of CONFIDENTIAL information, as
        the parameters passed to it through the HttpServletRequest are NOT shown
        in the url.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Go to this method to see how to access a database. */
        accessDatabase();

        /*
            Both methods below are used to maintain stateful information between
            HTTP requests, but they serve different purposes and operate at different levels.
        */
        /* Go to this method to see how to create cookies */
        createCookies(resp);

        /* Go to this method to see how to crate HTTP sessions */
        createSession(req);

        /*
            To call another servlet, use the following method. It will invoke
            either doGet or doPost, whichever the calling servlet is using.
         */
        RequestDispatcher dispatcher = req.getRequestDispatcher("MyServlet");
        dispatcher.forward(req, resp);

        /*
            To redirect to a html/jsp page, do the following.
         */
        resp.sendRedirect("home.jsp");
    }

    /* This method shows how to access information in the database. */
    protected void accessDatabase(){
        /*
            First, need the credentials necessary to gain access to the database.
            On MySQL Workbench, you can go to the home page, right-click on the database
            connection, and click "Copy JDBC Connection String to Clipboard". This is the url.
            Or just copy it from here.
        */
        String url = "jdbc:mysql://uni-dwell-db.cpysmemiu2q3.us-east-2.rds.amazonaws.com:3306/uni-dwell?user=admin";
        String usn = "admin";
        String ps = "cse3026uni-dwell";

        /* Establishing the connection must be inside a try/except statement. */
        try {
            /* Establish the connection. */
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, usn, ps);
            /* The Statement object is used to execute SQL queries. */
            Statement statement = con.createStatement();

            /*
                The following methods show different ways
                to retrieve/update database information.
            */
            retrieveDatabaseInfo(statement);
            updateDatabaseInfo(statement);
            deleteDatabaseInfo(statement);

            /*
                Remember to close the connection and statement when done.
                Forgetting can cause memory leaks.
            */
            statement.close();
            con.close();
        }
        catch (Exception e) {
            handleException(e);
        }
    }

    protected void retrieveDatabaseInfo(Statement statement) {
        try {
            /*
                SQL queries are not case-sensitive, but it's generally good
                practice to make SQL commands uppercase, so it's easier to distinguish
                table/column names from the commands.

                The following command is collecting all data from a table called Users
                where the column header is 'email'.
                Format: SELECT column_name, column_name... (or * for all columns) WHERE
                        column_name = value;
            */
            String email = "testemail@gmail.com";
            String sql = String.format("SELECT * FROM Users WHERE email = '%s';", email);
            /*
                ResultSet contains all the rows of data from the table after
                executing our query. It must be parsed using a while loop.
                Think of it as a 2D array, and the while loop lets us look
                at one array at a time.
            */
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                /*
                    Each column in the current row of data can be
                    accessed with getString(col number), where the
                    starting index is 1, or getString(col name).
                */
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
            }
            /* Remember to close the ResultSet when done. */
            resultSet.close();
        }
        catch (Exception e) {
            handleException(e);
        }
    }

    protected void updateDatabaseInfo(Statement statement) {
        try {
            /*
                The following command updates an existing row of data in the table Users.
                Because there is no return value, the execution is slightly different compared
                to retrieving info from the table.
                Format:
                UPDATE table_name SET column_name = new_value WHERE column_name = value;
            */
            String sql = String.format("UPDATE Users SET lastName = '%s' WHERE firstName = '%s';", "Doe", "John");
            statement.executeUpdate(sql);

            /*
                Another way to update a table is by adding a new row. The command below
                illustrates how to do this.
                Format:
                INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);
             */
            String email = "newEmail@yahoo.com";
            String password = "newPassword";
            String firstName = "Jane";
            String lastName = "Johnson";
            sql = String.format("INSERT INTO Users (email, password, firstName, lastName) VALUES ('%s', '%s', '%s', '%s');",
                    email, password, firstName, lastName);
            statement.executeUpdate(sql);
        }
        catch (Exception e) {
            handleException(e);
        }
    }

    protected void deleteDatabaseInfo(Statement statement) {
        try {
            /*
                The command below demonstrates how to delete a row in a table.
                Format:
                DELETE FROM table_name WHERE column_name = value;
             */
            String sql = String.format("DELETE FROM Users WHERE firstName = '%s'", "Bella");
            statement.executeUpdate(sql);
        }
        catch (Exception e) {
            handleException(e);
        }
    }

    protected void createCookies(HttpServletResponse resp) {
        /*
            Cookies
            -- Data is stored on the client-side, within the client's browser. Can be less secure when it comes to
               sensitive data.
            -- Can only store string key-value pairs.
            -- Used for remembering user preferences, tracking user behavior, etc.
         */
        Cookie cookie = new Cookie("cookieName", "cookieValue");
        /*
            Example:
            Cookie Name: themePreference
            Cookie Value: dark
         */

        /* Set additional parameters/attributes */
        cookie.setMaxAge(3600); /* Cookie will expire in 1 hour (in seconds) */
        cookie.setPath("/"); /* Cookie is valid for the entire application context */
        cookie.setSecure(true); /* Cookie will only be sent over HTTPS */
        cookie.setHttpOnly(true); /* Cookie is accessible only through HTTP (not JavaScript) */

        /* Add the cookie to the response. */
        resp.addCookie(cookie);
    }

    protected void createSession(HttpServletRequest req) {
        /*
            HTTP Sessions
            -- Data is stored on the server-side, so more secure.
            -- Can store any Java object as session attributes.
            -- Used for managing user authentication,
               maintaining user-specific settings, shopping cart contents, etc.
        */
        HttpSession session = req.getSession(true);
        /*
            When given the parameter 'true', either the current session
            associated with the HttpRequest will be returned, or if one
            doesn't exist, a new one will be created.

            When given the parameter 'false', it will try to return
            the current session, and if no session exists, it will
            return null, and won't create a new session.

            Can also leave the parameter blank, as the default value is true.

            To set something like the current user's first name, assuming they just
            tried to log in, access the HTTP request's name parameter, then set it
            as a session attribute.
         */
        String firstName = req.getParameter("firstName");
        session.setAttribute("firstName", firstName);

        /* To end a session, do the following. */
        session.invalidate();
    }

    private void handleException(Exception e) {
        /* Log the error message. */
        logger.severe("An error occurred: " + e.getMessage());
        /* Log the stack trace. */
        logger.throwing(ExampleServlet.class.getName(), "methodName", e);
    }
}
