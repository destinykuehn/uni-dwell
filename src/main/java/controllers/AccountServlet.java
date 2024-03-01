package controllers;

import utilities.Hasher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Users.User;
import utilities.Serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {

    /* Exception logger */
    private static final Logger logger = Logger.getLogger(IndexServlet.class.getName());

    private static final boolean verbose = true;

    public AccountServlet() {
        super();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.printf("Hello from %s%n", this.getClass().getName());
            if (Objects.equals(req.getParameter("action"), "logIn")) {
                handleSignIn(req, resp);
            } else if (Objects.equals(req.getParameter("userAction"), "signUp")) {
                handleSignUp(req, resp);
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

    private int handleSignIn(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ClassNotFoundException {
        User user = retrieveUserFromDB(req);
        if (checkCredentials(req)) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid username or password");
        }
        System.out.println(user.getFirstName());
        return 0;
    }

    private int handleSignUp(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        if (verbose) printParameters(req.getParameterMap());
        String sign_up_email = req.getParameter("email");
        String sign_up_pass = req.getParameter("password");
        if (!checkPasswordValid(sign_up_pass)) {
            if (verbose) System.out.println("Invalid password. Rejecting sign up...");
            return 1;
        }
        if (!checkEmailValid(sign_up_email)) {
            if (verbose) System.out.println("Invalid email. Rejecting sign up...");
            return 1;
        }
        if (verbose) System.out.println("Valid email and password. Proceeding with sign in...");
        if (isUserInDB(sign_up_email) == 0) {
            System.out.println("User in database");
        } else {
            System.out.println("User not in database");
        }
        User user = createUser(req);
        if (user == null) {System.out.println("Error in user creation"); return 1;}
        String hashPW = Hasher.hash(sign_up_pass);
        insertUserIntoDB(user, hashPW);
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
                && containsUpper(password) && password.length() <= 20 && password.length() >= 8);
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

    private int insertUserIntoDB(User user, String pw) throws IOException, SQLException {
        Serializer<User> serializer = new Serializer<>();
        ByteArrayOutputStream bytes = serializer.Serialize(user);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes.toByteArray());
        String sql = "INSERT INTO Users (email, password, firstName, lastName, userObj) VALUES (?, ?, ?, ?, ?)";
        String url = ("jdbc:mysql://uni-dwell-db.cpysmemiu2q3.us-east-2.rds.amazonaws.com:3306/uni-dwell");
        String ps = "cse3026uni-dwell";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, "admin", ps);
        PreparedStatement update = con.prepareStatement(sql);
        update.setString(1, user.getEmail());
        update.setString(2, pw);
        update.setString(3, user.getFirstName());
        update.setString(4, user.getLastName());
        update.setBlob(5, inputStream);
        update.executeUpdate();
        bytes.close();
        inputStream.close();
        con.close();
        return 0;
    }

    private void createSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("email", "placeholder");
        // placeholder
        resp.sendRedirect("account.jsp");
    }

    private boolean checkCredentials(HttpServletRequest req) throws SQLException {
        String hash = retrievePasswordFromDB(req);
        String pass = req.getParameter("password");
        return Hasher.verify_hash(pass, hash);
    }

    private User createUser(HttpServletRequest req) {
        User new_user = null;
        String sign_up_email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String role = req.getParameter("role");
        if (Objects.equals(role, "host")) new_user = new User(sign_up_email, firstName, lastName, User.Role.HOST);
        if (Objects.equals(role, "student")) new_user = new User(sign_up_email, firstName, lastName, User.Role.STUDENT);
        return new_user;
    }

    private void printParameters(Map<String, String[]> paraMap) {
        for (String s : paraMap.keySet()) {
            String[] vals = paraMap.get(s);
            System.out.print(s + ": ");
            for (String inner_s : vals) {
                System.out.print(inner_s + " ");
            }
            System.out.println();
        }
    }

    private User retrieveUserFromDB(HttpServletRequest req) throws SQLException, IOException, ClassNotFoundException {
        Serializer<User> serializer = new Serializer<>();
        String sql = "SELECT userObj FROM Users WHERE email = ?";
        String url = ("jdbc:mysql://uni-dwell-db.cpysmemiu2q3.us-east-2.rds.amazonaws.com:3306/uni-dwell");
        String ps = "cse3026uni-dwell";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, "admin", ps);
        PreparedStatement query = con.prepareStatement(sql);
        query.setString(1, req.getParameter("email"));
        ResultSet res = query.executeQuery();
        Blob bytes = null;
        if (res.next()) {bytes = res.getBlob("userObj");}
        User retrievedUser = serializer.Deserialize((ByteArrayInputStream) bytes.getBinaryStream());
        con.close();
        return retrievedUser;
    }

    private String retrievePasswordFromDB(HttpServletRequest req) throws SQLException {
        String sql = "SELECT password FROM Users WHERE email = ?";
        String url = ("jdbc:mysql://uni-dwell-db.cpysmemiu2q3.us-east-2.rds.amazonaws.com:3306/uni-dwell");
        String ps = "cse3026uni-dwell";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, "admin", ps);
        PreparedStatement query = con.prepareStatement(sql);
        query.setString(1, req.getParameter("email"));
        ResultSet res = query.executeQuery();
        String pw = "";
        if (res.next()) {pw = res.getString("password");}
        con.close();
        return pw;
    }
}
