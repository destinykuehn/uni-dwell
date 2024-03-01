<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/listings.css">
    <!-- icons -->
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



<script async
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBV7tfcU55KcXBpnyNLv7e15vlWM6K2WQE&loading=async&callback=initMap">
</script>
<script>
    (g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})({
        key: "AIzaSyBV7tfcU55KcXBpnyNLv7e15vlWM6K2WQE",
        v: "weekly",
    });
    // Initialize and add the map
    let map;

    async function initMap() {
        // NMT coordinates
        const position = {lat: 34.068978220312005, lng: -106.90560937652961};
        // Request needed libraries.
        const { Map } = await google.maps.importLibrary("maps");
        const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");
        const bounds = new google.maps.LatLngBounds(
            new google.maps.LatLng(34.02276502506655, -106.94102989126084), // Southwest corner
            new google.maps.LatLng(34.09955905027666, -106.86601387666968)  // Northeast corner
        );
        // var mapStyle = [
        //     {
        //         featureType: 'poi',
        //         elementType: 'labels',
        //         stylers: [{ visibility: 'off' }]
        //     }
        // ];

            // The map, centered at Uluru
        map = new Map(document.getElementById("map"), {
            zoom: 13,
            center: position,
            mapId: "ffc8ae760a796c6b",
            // fullscreenControl: false,
            // streetViewControl: false,
            // zoomControlOptions: {
            //     style: google.maps.ZoomControlStyle.SMALL,
            //     position: google.maps.ControlPosition.LEFT_BOTTOM
            // },
            restriction: {
                latLngBounds: bounds,
                strictBounds: false,
            },
            disableDefaultUI: true,
            zoomControl: true,
        });


        // Fit the map to the city bounds
        // map.fitBounds(cityBounds);

        // The marker, positioned at Uluru
        const marker = new AdvancedMarkerElement({
            map: map,
            position: position,
            title: "NMT",
        });
    }
    initMap();
</script>
</body>
</html>
