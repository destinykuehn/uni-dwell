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

    // Takes all the needed information and calls the needed functions
    public static int accessDatabase(String user, String table, String action, String value,
                                     String colName, int id, String[] values) {
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

            // I haven't actually made add yet.
            int result = switch (action) {
                case "find" -> findInfo(con, table, colName, value);
                case "get" -> retrieveInfo(con, table, colName, id);
                case "modify" -> modifyInfo(con, table, colName, id, value);
                case "delete" -> deleteInfo(con, table, id);
                case "add" -> addRow(con, table, values);
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

    // Returns 0 or 1 depending on whether the value exists in the given column
    public static int findInfo(Connection con, String table, String colName, String value) {
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

    // Prints out the string at the given row and column
    public static int retrieveInfo(Connection con, String table, String colName, int id) {
        try {
            // The idea is to get only the needed values from the database
            // It is probably wrong as is
            String sql = String.format("SELECT * FROM %s WHERE id = %d", table, id);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // I think this is all it needs. Will find out in testing.
            while (rs.next()) {
                System.out.println(rs.getString(colName));
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

    // Changes the location specified by the row and column to value
    public static int modifyInfo(Connection con, String table, String colName, int id, String value) {
        try {
            String sql = String.format("UPDATE %s SET %s='%s' WHERE id=%d;", table, colName, value, id);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            return 0;
        }
        catch (Exception e) {
            handleException(e);
            return 1;
        }
    }

    // Deletes every row whose first element matches the row name
    public static int deleteInfo(Connection con, String table, int id) {
        try {
            String sql = String.format("DELETE FROM %s WHERE id=%d", table, id);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            return 0;
        }
        catch (Exception e) {
            handleException(e);
            return 1;
        }
    }

    // Should create a new row with all the needed info, and generate an id
    public static int addRow(Connection con, String table, String[] values) {
        try {
            // Check that we have all the values
            String sql = String.format("SELECT count(*) FROM information_schema.columns WHERE table_name = '%s'", table);
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int num_columns = rs.getInt(1);
                if (values.length != num_columns-1) {
                    return 1;
                }
            }

            // Make the string listing the values
            StringBuilder value_string = new StringBuilder();

            // Having an index of 0 seems to actually give it the next index. Dunno why exactly.
            value_string.append("0, ");

            for (int i = 0; i < values.length - 1; i++) {
                value_string.append("'").append(values[i]).append("', ");
            }
            value_string.append("'").append(values[values.length - 1]).append("'");

            // Make the row
            sql = String.format("INSERT INTO %s VALUES (%s)", table, value_string);
            statement = con.prepareStatement(sql);
            statement.executeUpdate();

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
