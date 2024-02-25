<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- styles -->
    <link rel="stylesheet" href="../stylesheets/global.css">
    <link rel="stylesheet" href="../stylesheets/listings.css">
    <!-- icons -->
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
    <!-- google maps -->
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <title>MinerDwellings: models.Listings</title>
</head>
<body>
    <header></header>
    <div class="filters-container"></div>

    <div class="map-listings-container">
        <div class="map-listings-grid">
            <!-- google maps with listings -->
            <div id="map"></div>
            <script>(g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})
            ({key: "AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg", v: "weekly"});</script>

            <!-- listings -->
            <div class="listings-container">
                <a><div class="listing">
                    <i class="fa-regular fa-heart" onclick="addToFavorites(this)"></i>
                    <img alt="house-pic" class="listing-picture" src="../images/temp-house-pic.jpeg">
                    <div class="house-info">
                        <h4 class="rent">$1,200/mo</h4>
                        <div class="room-size-container">
                            <p>3 bed</p>
                            <div class="line"></div>
                            <p>3 bath</p>
                            <div class="line"></div>
                            <p>1,254 sqft</p>
                        </div>
                        <p>801 Leroy Pl, Socorro, NM 87801</p>
                    </div>
                </div></a>
                <div class="listing">
                    <img alt="house-pic" class="listing-picture" src="../images/temp-house-pic.jpeg">
                    <div class="house-info">
                        <h4 class="rent">$1,200/mo</h4>
                        <div class="room-size-container">
                            <p>3 bed</p>
                            <div class="line"></div>
                            <p>3 bath</p>
                            <div class="line"></div>
                            <p>1,254 sqft</p>
                        </div>
                        <p>801 Leroy Pl, Socorro, NM 87801</p>
                    </div>
                </div>
                <div class="listing">
                    <img alt="house-pic" class="listing-picture" src="../images/temp-house-pic.jpeg">
                    <div class="house-info">
                        <h4 class="rent">$1,200/mo</h4>
                        <div class="room-size-container">
                            <p>3 bed</p>
                            <div class="line"></div>
                            <p>3 bath</p>
                            <div class="line"></div>
                            <p>1,254 sqft</p>
                        </div>
                        <p>801 Leroy Pl, Socorro, NM 87801</p>
                    </div>
                </div>
                <div class="listing">
                    <img alt="house-pic" class="listing-picture" src="../images/temp-house-pic.jpeg">
                    <div class="house-info">
                        <h4 class="rent">$1,200/mo</h4>
                        <div class="room-size-container">
                            <p>3 bed</p>
                            <div class="line"></div>
                            <p>3 bath</p>
                            <div class="line"></div>
                            <p>1,254 sqft</p>
                        </div>
                        <p>801 Leroy Pl, Socorro, NM 87801</p>
                    </div>
                </div>
                <div class="listing">
                    <img alt="house-pic" class="listing-picture" src="../images/temp-house-pic.jpeg">
                    <div class="house-info">
                        <h4 class="rent">$1,200/mo</h4>
                        <div class="room-size-container">
                            <p>3 bed</p>
                            <div class="line"></div>
                            <p>3 bath</p>
                            <div class="line"></div>
                            <p>1,254 sqft</p>
                        </div>
                        <p>801 Leroy Pl, Socorro, NM 87801</p>
                    </div>
                </div>
                <div class="listing">
                    <img alt="house-pic" class="listing-picture" src="../images/temp-house-pic.jpeg">
                    <div class="house-info">
                        <h4 class="rent">$1,200/mo</h4>
                        <div class="room-size-container">
                            <p>3 bed</p>
                            <div class="line"></div>
                            <p>3 bath</p>
                            <div class="line"></div>
                            <p>1,254 sqft</p>
                        </div>
                        <p>801 Leroy Pl, Socorro, NM 87801</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        function addToFavorites(icon) {
            if (icon.classList.contains('fa-regular')){
                icon.classList.replace('fa-regular', 'fa-solid');
                icon.style.color = "red";
                return;
            }
            icon.classList.replace('fa-solid', 'fa-regular');
            icon.style.color = "";
        }

        // Initialize and add the map
        let map;
        async function initMap() {
            // NMT coordinates
            const position = {lat: 34.068978220312005, lng: -106.90560937652961};
            // Request needed libraries.
            const {Map} = await google.maps.importLibrary("maps");
            const {AdvancedMarkerElement} = await google.maps.importLibrary("marker");
            var mapStyle = [
                {
                    featureType: 'poi',
                    elementType: 'labels',
                    stylers: [{ visibility: 'off' }]
                }
            ];
            let bounds = new google.maps.LatLngBounds(
                new google.maps.LatLng(34.02276502506655, -106.94102989126084), // Southwest corner
                new google.maps.LatLng(34.09955905027666, -106.86601387666968)  // Northeast corner
            );
            // let bounds =
            // The map, centered at NMT
            map = new Map(document.getElementById("map"), {
                zoom: 14,
                center: position,
                mapId: "AIzaSyCYXy3eg3Y4y-dl9nkv9pEdz6UBuqo2Ds0",
                styles: mapStyle,
                // disableDefaultUI: true,
                streetViewControl: false,
                restriction: {
                    latLngBounds: bounds,
                    strictBounds: true
                },
            });

            // The marker, positioned at NMT
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
