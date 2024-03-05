<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/index.css">
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>

    <title>Uni Dwell: Index</title>
</head>
<body>

<!-- if college not in db print error message -->
<% if (session.getAttribute("college") != null) {
    if (session.getAttribute("college").equals("N/A")) { %>
        <p>This school is invalid. Please try again.</p>
    <% } %>
<% } %>

<!-- check college is in db -->
<form autocomplete="off" action="IndexServlet" method="POST">
    <input id="school-input"
           type="text"
           placeholder="School name..."
           name="college"
           oninput="filterSchools()">
    <div class="options-container">
        <div id="school-options"></div>
    </div>
    <input type="submit" value="Submit">
</form>

<jsp:include page="components/header.jsp"/>

<script src="js/global.js"></script>
<script src="js/index.js"></script>
</body>
</html>
