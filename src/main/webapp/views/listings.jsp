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
    <div class="filters-container">
        <h2>Filters</h2>
        <div>
            <label>Property Type</label>
            <select>
                <option value="house">House</option>
                <option value="room">Room</option>
            </select>
        </div>
        <div>
            <label>Rental Period</label>
            <select>
                <option value="all">All</option>
                <option value="semester">Semester</option>
                <option value="year">Year-Round</option>
            </select>
        </div>
        <div>
            <label>Price Range</label>
            <div class="prices">
                <select>
                    <option value="all">All</option>
                    <option value="semester">Semester</option>
                    <option value="year">Year-Round</option>
                </select>
                <p> to </p>
                <select>
                    <option value="all">All</option>
                    <option value="semester">Semester</option>
                    <option value="year">Year-Round</option>
                </select>
            </div>
        </div>
        <div>
            <label>Bedrooms</label>
            <select>
                <option value=1+">1+</option>
                <option value="2+">2+</option>
                <option value="3+">3+</option>
                <option value="4+">4+</option>
                <option value="5+">5+</option>
            </select>
        </div>
        <div>
            <label>Bathrooms</label>
            <select>
                <option value=1+">1+</option>
                <option value="2+">2+</option>
                <option value="3+">3+</option>
                <option value="4+">4+</option>
                <option value="5+">5+</option>
            </select>
        </div>
        <div>
            <label>Size (sqft)</label>
            <select>
                <option value=500+">500+</option>
                <option value="1000+">1000+</option>
                <option value="1500+">1500+</option>
                <option value="2000+">2000+</option>
                <option value="2500+">2500+</option>
            </select>
        </div>
        <div>
            <label>Additional Tags</label>
            <input type="text">
        </div>
        <button>Apply Filters</button>
    </div>

    <div class="map-container">
        <div id="map"></div>
        <jsp:include page="components/map-listings-div.jsp"/>
    </div>



    <script async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBV7tfcU55KcXBpnyNLv7e15vlWM6K2WQE&loading=async&callback=initMap"></script>
    <script src="js/global.js"></script>
    <script src="js/listings.js"></script>
</body>
</html>
