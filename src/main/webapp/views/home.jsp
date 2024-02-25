<%@ page import="static models.utils.SessionUtils.isAttributeValid" %>

<% if (!isAttributeValid(session, "college")) { %>
<% response.sendRedirect("index.jsp");%>
<% } %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uni Dwell: Home</title>
</head>
<body>
<jsp:include page="components/header.jsp"/>

<form autocomplete="off" action="ListingServlet" method="GET">
    <div>
        <input type="text" name="location" placeholder="Enter address...">
    </div>
    <input type="submit" value="Submit">
</form>

</body>
</html>
