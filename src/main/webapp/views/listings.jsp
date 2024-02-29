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

<div class="container">
    <div class="filters-container">
        <div class="filter-header">
            <h3>Filters</h3>
            <i class="fa-solid fa-chevron-left"></i>
        </div>
        <div class="property-type">
            <label>Property Type</label>
            <div>
                <i class="fa-solid fa-house"></i>
                <i class="fa-solid fa-bed"></i>
            </div>
        </div>
        <div class="rental-period">
            <label>Rental period</label>
            <div>
                <div>
                    <button>All</button>
                    <button>Semester</button>
                    <button>Year</button>
                </div>
            </div>
        </div>
        <div class="price-range">
            <label>Price Range</label>
            <input type="range">
        </div>
        <div class="price-range">
            <label>Bedrooms</label>
            <input type="range">
        </div>
        <div class="price-range">
            <label>Bathrooms</label>
            <input type="range">
        </div>
        <div class="price-range">
            <label>Square Feet</label>
            <input type="range">
        </div>
        <div class="price-range">
            <label>Additional Tags</label>
            <input type="text">
        </div>
        <button>Apply Filters</button>

    </div>

    <div class="map-container">
        <div id="map"></div>
        <jsp:include page="components/map-listings-div.jsp"/>
    </div>

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
        var mapStyle = [
            {
                featureType: 'poi',
                elementType: 'labels',
                stylers: [{ visibility: 'off' }]
            }
        ];

            // The map, centered at Uluru
        map = new Map(document.getElementById("map"), {
            zoom: 13,
            center: position,
            mapId: "b615488547e0b44a",
            styles: mapStyle,
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
