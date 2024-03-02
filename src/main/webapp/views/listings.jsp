<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/listings.css">
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
    <title>MinerDwellings: Listings</title>
</head>
<body>
    <jsp:include page="components/listings-filter-div.jsp"/>
    <jsp:include page="components/map-listings-div.jsp"/>
    <jsp:include page="components/light-dark-theme-div.jsp"/>
    <jsp:include page="components/selected-listing-div.jsp"/>
    <jsp:include page="components/selected-listing-carousel-div.jsp"/>

    <script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBV7tfcU55KcXBpnyNLv7e15vlWM6K2WQE&loading=async&callback=initMap"></script>
    <script src="js/listings.js"></script>
    <script src="js/global.js"></script>
</body>
</html>
