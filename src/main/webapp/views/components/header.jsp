<%@ page import="static models.utils.SessionUtils.isAttributeValid" %>
<link rel="stylesheet" href="styles/header.css">
<header>
    <a href="#">Logo</a>
    <% if (isAttributeValid(session, "college")) { %>
        <a href="#">View Listings</a>
        <a href="#">Post Listing</a>
        <a href="about.jsp">About Us</a>
    <% } %>
    <a href="login.jsp">Sign In</a>
</header>