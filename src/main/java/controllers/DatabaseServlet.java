package controllers;

/* This servlet handles database access */

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Logger;
import java.sql.Connection;

@WebServlet("/DatabaseServlet")
public abstract class DatabaseServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ExampleServlet.class.getName());

    public static int accessDatabase(String user, String table, String colName, String value, String action){
        try {
            String url = ("jdbc:mysql://uni-dwell-db.cpysmemiu2q3.us-east-2.rds.amazonaws.com:3306/uni-dwell");
            String ps = switch(user) {
                case "selectcollege" -> "selectCollege";
                case "admin" -> "cse3026uni-dwell";
                case "gen_user" -> "genPassword";
                default -> "";
            };

            /* Establish the connection */
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection(url, user, ps);

            int result = switch (action) {
                case "find" -> findInfo(con, table, colName, value);
                case "add" -> retrieveInfo(con, table, colName);
                case "modify" -> modifyInfo(con, table, colName);
                case "delete" -> deleteInfo(con, table, colName);
                default -> 1;
            };

            con.close();
            return result;
        }
        catch (Exception e) {
            handleException(e);
            return 1;
        }
    }

    private static int findInfo(Connection con, String table, String colName, String value) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE %s = ?", table, colName);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            boolean valFound = resultSet.next();

            resultSet.close();
            statement.close();
            return valFound ? 0 : 1;
        }
        catch (Exception e) {
            handleException(e);
            return 1;
        }
    }

    private static int retrieveInfo(Connection con, String table, String colName) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE column_name = %s", table, colName);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

            }

            rs.close();
            statement.close();
            return 0;

        }
        catch (Exception e) {
            handleException(e);
            return 1;
        }
    }

    private static int modifyInfo(Connection con, String table, String colName) {
        try {

            return 0;

        }
        catch (Exception e) {
            handleException(e);
            return 1;
        }
    }

    private static int deleteInfo(Connection con, String table, String colName) {
        try {
            return 0;

        }
        catch (Exception e) {
            handleException(e);
            return 1;
        }
    }


    private static void handleException(Exception e) {
        /* Log the error message. */
        logger.severe("An error occurred: " + e.getMessage());
        /* Log the stack trace. */
        logger.throwing(ExampleServlet.class.getName(), "methodName", e);
    }

}
