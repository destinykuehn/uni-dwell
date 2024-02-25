<%@ page import="static models.utils.SessionUtils.isAttributeValid" %>
<link rel="stylesheet" href="styles/header.css">
<!-- icons -->
<script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
<header>
    <div><a href="home.jsp"><img src="images/uni-dwell-tmp-logo.png"></a></div>
    <% if (isAttributeValid(session, "college")) { %>
        <a href="#">View Listings</a>
        <a href="#">Post Listing</a>
        <a href="about.jsp">About Us</a>
    <% } %>
    <a href="login.jsp"><i class="fa-solid fa-user"></i></a>
</header>