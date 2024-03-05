<!-- ensure user has selected a college -->
<% if (session.getAttribute("college") == null) {
        response.sendRedirect("index.jsp");
    }
    else {
        if (session.getAttribute("college").equals("N/A")) {
            response.sendRedirect("index.jsp");
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/global.css">
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
    <title>Uni Dwell: Home</title>
</head>
<body>
    <jsp:include page="components/header.jsp"/>


    <script src="js/global.js"></script>
</body>
</html>
